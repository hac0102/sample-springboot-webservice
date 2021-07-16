package com.sample.board.springboot.web;

import com.sample.board.springboot.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class IndexController {

    private final BoardService boardService;

    @GetMapping("/")
    public ModelAndView main() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("boardDataList", boardService.getBoardList());
        mv.setViewName("main");
        return mv;
    }
}
