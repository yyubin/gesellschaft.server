package org.ekujo.gesellschaft.skill.service;

import org.ekujo.gesellschaft.skill.dto.request.SinPropertyCreateRequest;
import org.ekujo.gesellschaft.skill.dto.request.SinPropertyUpdateRequest;
import org.ekujo.gesellschaft.skill.dto.response.SinPropertyResponse;

import java.util.List;

public interface SinPropertyService {
    List<SinPropertyResponse> findAll();
    SinPropertyResponse createSinProperty(SinPropertyCreateRequest request);
    SinPropertyResponse updateSinProperty(SinPropertyUpdateRequest request);
}
