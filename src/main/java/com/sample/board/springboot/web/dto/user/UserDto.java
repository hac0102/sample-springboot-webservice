package com.sample.board.springboot.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
public class UserDto {

    private int userNo;
    private String name;
    private String emailAddr;
    private String joinType;
    private String phoneNo;
    private Role userRole;
    private String picture;

    @Builder
    public UserDto(String name, String emailAddr, String joinType, String phoneNo, Role userRole, String picture, LocalDateTime frstRegDate, LocalDateTime lastChgDate) {
        this.name = name;
        this.emailAddr = emailAddr;
        this.joinType = joinType;
        this.phoneNo = phoneNo;
        this.userRole = userRole;
        this.picture = picture;
    }

    public UserDto userInfoUpdate(String name, String picture){
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.userRole.getKey();
    }

}
