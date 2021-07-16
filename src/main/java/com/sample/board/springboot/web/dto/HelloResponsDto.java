package com.sample.board.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponsDto {

    private final String name;
    private final int amount;
}
