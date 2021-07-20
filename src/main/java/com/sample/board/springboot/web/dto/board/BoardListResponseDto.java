package com.sample.board.springboot.web.dto.board;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardListResponseDto {

    private int brNo;
    private String name;
    private String title;
    private String delYn;
    private int reviewCount;
    private LocalDateTime frstRegDate;
    private LocalDateTime lastChgDate;
}