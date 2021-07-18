package com.sample.board.springboot.config.auth.dto;

import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmailAddr();
        this.picture = userDto.getPicture();
    }
}