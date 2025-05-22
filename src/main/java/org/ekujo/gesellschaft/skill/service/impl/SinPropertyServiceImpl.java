package org.ekujo.gesellschaft.skill.service.impl;

import lombok.RequiredArgsConstructor;
import org.ekujo.gesellschaft.skill.domain.SinProperty;
import org.ekujo.gesellschaft.skill.dto.request.SinPropertyCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.SinPropertyUpdateRequest;
import org.ekujo.gesellschaft.skill.dto.response.SinPropertyResponse;
import org.ekujo.gesellschaft.skill.mapper.SinPropertyMapper;
import org.ekujo.gesellschaft.skill.repository.SinPropertyRepository;
import org.ekujo.gesellschaft.skill.service.SinPropertyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SinPropertyServiceImpl implements SinPropertyService {

    private final SinPropertyRepository sinPropertyRepository;
    private final SinPropertyMapper sinPropertyMapper;

    public SinProperty findById(Long id) {
        return sinPropertyRepository.findById(id).orElse(null);
    }

    public List<SinPropertyResponse> findAll() {
        List<SinProperty> sinPropertyList = sinPropertyRepository.findAll();
        return sinPropertyList.stream().map(sinPropertyMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public SinPropertyResponse createSinProperty(SinPropertyCreateRequest request) {
        SinProperty sinProperty = SinProperty.builder().name(request.getName()).build();
        return sinPropertyMapper.toResponse(sinPropertyRepository.save(sinProperty));
    }

    @Transactional
    public SinPropertyResponse updateSinProperty(SinPropertyUpdateRequest request) {
        SinProperty sinProperty = sinPropertyRepository.findById(request.getId()).orElseThrow(() -> new NoSuchElementException("Id " + request.getId() + " not found"));
        sinProperty.setName(request.getName());
        return sinPropertyMapper.toResponse(sinPropertyRepository.save(sinProperty));
    }
}
