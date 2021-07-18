package com.sample.board.springboot.web.board;

import com.sample.board.springboot.config.auth.LoginUser;
import com.sample.board.springboot.config.auth.dto.SessionUser;
import com.sample.board.springboot.service.board.BoardService;
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

    @GetMapping("/api/v1/board")
    public ModelAndView getBoardList() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("boardDataList", boardService.getBoardList());
        return mv;
    }

    @PostMapping("/api/v1/board")
    public ResponseEntity<?> insertBoard(@RequestBody BoardRequestdDto boardRequestdDto, @LoginUser SessionUser userInfo) {
        return boardService.insertBoard(boardRequestdDto, userInfo);
    }

    @GetMapping("/api/v1/board/{brNo}")
    public ModelAndView getBoadrdDetailData(@PathVariable int brNo) {
        return boardService.getBoardDetailData(brNo);
    }

    @PutMapping("/api/v1/board")
    public ResponseEntity<?> updateBoard(@RequestBody BoardRequestdDto boardRequestdDto, @LoginUser SessionUser userInfo) {
        return boardService.updateBoard(boardRequestdDto, userInfo);
    }

    @DeleteMapping("/api/v1/board")
    public ResponseEntity<?> deleteBoard(@RequestBody BoardRequestdDto boardRequestdDto, @LoginUser SessionUser userInfo) {
        return boardService.deleteBoard(boardRequestdDto, userInfo);
    }

}
