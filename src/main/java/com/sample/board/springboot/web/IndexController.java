package com.sample.board.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class IndexController {

    @GetMapping("/")
    public ModelAndView main() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }
}
