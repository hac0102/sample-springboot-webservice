package com.sample.board.springboot.web.board;

import com.sample.board.springboot.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ModelAndView getBoardList() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("boardDataList", boardService.getBoardList());
        return mv;
    }

}
