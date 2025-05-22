package org.ekujo.gesellschaft.persona.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.persona.domain.Keyword;
import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;
import org.ekujo.gesellschaft.persona.mapper.KeywordMapper;
import org.ekujo.gesellschaft.persona.respository.KeywordRepository;
import org.ekujo.gesellschaft.persona.service.KeywordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class KeywordsServiceImpl implements KeywordService {
    private final KeywordRepository keywordRepository;
    private final KeywordMapper keywordMapper;

    public List<KeywordResponse> findAll() {
        List<Keyword> keywords = keywordRepository.findAll();
        return keywords.stream().map(keywordMapper::toKeywordResponse).collect(Collectors.toList());
    }

    @Transactional
    public KeywordResponse createKeyword(String keywordName) {
        Keyword save = keywordRepository.save(Keyword.builder().name(keywordName).build());
        return keywordMapper.toKeywordResponse(save);
    }

    @Transactional
    public KeywordResponse updateKeyword(Long keywordId, String updatedKeywordName) {
        Keyword save = keywordRepository.findById(keywordId).orElseThrow(() -> new NoSuchElementException("Keyword not found"));
        save.setName(updatedKeywordName);
        return keywordMapper.toKeywordResponse(keywordRepository.save(save));
    }
}
