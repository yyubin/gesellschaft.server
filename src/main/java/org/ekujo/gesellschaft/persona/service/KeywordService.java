package org.ekujo.gesellschaft.persona.service;

import org.ekujo.gesellschaft.persona.dto.response.KeywordResponse;

import java.util.List;

public interface KeywordService {
    List<KeywordResponse> findAll();
    KeywordResponse createKeyword(String keywordName);
    KeywordResponse updateKeyword(Long keywordId, String updatedKeywordName);
}
