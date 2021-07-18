package com.sample.board.springboot.web.board;

import com.sample.board.springboot.service.board.BoardService;
import com.sample.board.springboot.web.dto.board.Board;
import com.sample.board.springboot.web.dto.board.BoardRequestdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return boardService.insertBoard(boardRequestdDto);
    }

    @GetMapping("/board/{brNo}")
    public ModelAndView getBoadrdDetailData(@PathVariable int brNo) {
        log.info("brNobrNo :: {}", brNo);
        return boardService.getBoardDetailData(brNo);
    }

    @PutMapping("/board")
    public ResponseEntity<?> updateBoard(@RequestBody BoardRequestdDto boardRequestdDto) {
        return boardService.updateBoard(boardRequestdDto);
    }

}
