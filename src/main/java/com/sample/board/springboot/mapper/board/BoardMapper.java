package com.sample.board.springboot.mapper.board;

import com.sample.board.springboot.web.dto.board.BoardListResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardListResponseDto> selectBoardList();
}
