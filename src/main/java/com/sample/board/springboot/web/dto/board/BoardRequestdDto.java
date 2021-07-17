package com.sample.board.springboot.web.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class BoardRequestdDto {

    private int brNo;
    private String title;
    private String content;
    private int userNo;

    @Builder
    public BoardRequestdDto(int brNo, String title, String content, int userNo) {
        this.brNo = brNo;
        this.title = title;
        this.content = content;
        this.userNo = userNo;
    }

//    public Board toEntity() {
//        return Board.builder()
//                .brNo(brNo)
//                .title(title)
//                .content(content)
//                .build();
//    }

}
