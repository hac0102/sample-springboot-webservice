package com.sample.board.springboot.web.dto.board;

import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Board {

    private int brNo;
    private UserDto userDto;
    private String title;
    private String content;
    private String delYn;
    private LocalDateTime frstRegDate;
    private LocalDateTime lastChgDate;

    @Builder
    public Board(int brNo, UserDto userDto, String title, String content, String delYn, LocalDateTime frstRegDate, LocalDateTime lastChgDate) {
        this.brNo = brNo;
        this.userDto = userDto;
        this.title = title;
        this.content = content;
        this.frstRegDate = frstRegDate;
        this.lastChgDate = lastChgDate;
    }
}
