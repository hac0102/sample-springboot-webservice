package com.sample.board.springboot.web.board;

import com.sample.board.springboot.service.board.BoardService;
import com.sample.board.springboot.web.dto.board.BoardRequestdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ModelAndView getBoardList() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("boardDataList", boardService.getBoardList());
        return mv;
    }

    @PostMapping("/board")
    public ResponseEntity<?> insertBoard(@RequestBody BoardRequestdDto boardRequestdDto) {
        log.info("파람값 :: {}", boardRequestdDto);
        return boardService.insertBoard(boardRequestdDto);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
