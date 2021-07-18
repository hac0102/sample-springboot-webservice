package com.sample.board.springboot.mapper.board;

import com.sample.board.springboot.web.dto.board.Board;
import com.sample.board.springboot.web.dto.board.BoardListResponseDto;
import com.sample.board.springboot.web.dto.board.BoardRequestdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardListResponseDto> selectBoardList();

    int insertBoard(BoardRequestdDto boardRequestdDto);

    void insertBoardHistory(BoardRequestdDto boardRequestdDto);

    Board selectBoardDetailData(int brNo);

    int updateBoard(BoardRequestdDto boardRequestdDto);

    int deleteBoard(BoardRequestdDto boardRequestdDto);
}
