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
    private String delYn;
    private int userNo;

    @Builder
    public BoardRequestdDto(int brNo, String title, String content, String delYn, int userNo) {
        this.brNo = brNo;
        this.title = title;
        this.content = content;
        this.delYn = delYn;
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
