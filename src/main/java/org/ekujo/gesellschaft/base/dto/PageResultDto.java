package org.ekujo.gesellschaft.base.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResultDto<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;
}