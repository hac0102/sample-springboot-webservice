package com.sample.board.springboot.web.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDto {

    private int userNo;
    private String name;
    private String emailAddr;
    private String joinType;
    private String phoneNo;
    private String userRole;
    private LocalDateTime frstRegDate;
    private LocalDateTime lastChgDate;

}
