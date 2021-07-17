package com.sample.board.springboot.service.board;

import com.sample.board.springboot.mapper.board.BoardMapper;
import com.sample.board.springboot.web.dto.board.Board;
import com.sample.board.springboot.web.dto.board.BoardListResponseDto;
import com.sample.board.springboot.web.dto.board.BoardRequestdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    private final BoardMapper boardMapper;


    public Object getBoardList() {
        //일단 그냥 단순 리스트
        // 나중에 로그인까지되면 내가쓴글or전체글
        List<BoardListResponseDto> boardListResponseDto = boardMapper.selectBoardList()
                .stream()
                .filter(list -> "N".equals(list.getDelYn()))
                .collect(Collectors.toList());
        log.info("boardListResponseDto :: ", boardListResponseDto);
        return boardListResponseDto;
    }

    @Transactional
    public ResponseEntity<?> insertBoard(BoardRequestdDto boardRequestdDto) {
        boardRequestdDto = BoardRequestdDto.builder()
                .title(boardRequestdDto.getTitle())
                .content(boardRequestdDto.getContent())
                .userNo(1)
                .build();

        int affectRow = boardMapper.insertBoard(boardRequestdDto);
        boardMapper.insertBoardHistory(boardRequestdDto);

        return affectRow > 0 ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ModelAndView getBoardDetailData(int brNo) {
        return new ModelAndView("board/board_detail_modal :: #testDiv",
                "boardDetailData", boardMapper.selectBoardDetailData(brNo));
    }
}
