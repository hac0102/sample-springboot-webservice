package com.sample.board.springboot.config.auth.dto;

import com.sample.board.springboot.web.dto.user.Role;
import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private int userNo;
    private String name;
    private String email;
    private String picture;
    private String joinType;
    private Role role;

    public SessionUser(UserDto userDto) {
        this.userNo = userDto.getUserNo();
        this.name = userDto.getName();
        this.email = userDto.getEmailAddr();
        this.picture = userDto.getPicture();
        this.joinType = userDto.getJoinType();
        this.role = userDto.getUserRole();
    }
}