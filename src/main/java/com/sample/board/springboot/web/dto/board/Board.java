package com.sample.board.springboot.web.dto.board;

import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class Board {

    private int brNo;
    private UserDto userDto;
//    private int userNo;
//    private String name;
    private String title;
    private String content;
    private String delYn;
    private int reviewCount;
    private LocalDateTime frstRegDate;
    private LocalDateTime lastChgDate;

    @Builder
    public Board(int brNo, int userNo, String name, UserDto userDto, String title, String content, String delYn, int reviewCount, LocalDateTime frstRegDate, LocalDateTime lastChgDate) {
        this.brNo = brNo;
        this.userDto = userDto;
//        this.userNo = userNo;
//        this.name = name;
        this.title = title;
        this.content = content;
        this.delYn = delYn;
        this.reviewCount = reviewCount;
        this.frstRegDate = frstRegDate;
        this.lastChgDate = lastChgDate;
    }
}
