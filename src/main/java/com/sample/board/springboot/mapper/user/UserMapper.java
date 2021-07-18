package com.sample.board.springboot.mapper.user;

import com.sample.board.springboot.web.dto.user.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insertUserJoin(UserDto toEntity);

    void insertUserJoinHistory(UserDto toEntity);
}
