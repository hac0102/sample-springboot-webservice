package com.sample.board.springboot.service.board;

import com.sample.board.springboot.mapper.board.BoardMapper;
import com.sample.board.springboot.web.dto.board.BoardListResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
