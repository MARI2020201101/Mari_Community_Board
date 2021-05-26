package com.mariworld.bootboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
@Builder
@NoArgsConstructor
public class PageRequestDTO {
    private int page=1;
    private int size=10;

    public PageRequestDTO(int page, int size){
        this.page=page;
        this.size=size;
    }
    public PageRequest makePageRequest(Sort sort){
        return PageRequest.of(page-1,size, sort);
    }
}
