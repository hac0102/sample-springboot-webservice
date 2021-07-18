package com.sample.board.springboot.web;

import com.sample.board.springboot.config.auth.LoginUser;
import com.sample.board.springboot.config.auth.dto.SessionUser;
import com.sample.board.springboot.service.board.BoardService;
import com.sample.board.springboot.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@RestController
@Slf4j
public class IndexController {

    private final BoardService boardService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public ModelAndView main(@LoginUser SessionUser user) throws Exception {
//        @LoginUser SessionUser user
        ModelAndView mv = new ModelAndView();
        log.info("여기는 옴?????");


//        UserDto user = (UserDto) httpSession.getAttribute("userSession");

        if(user == null){
            mv.setViewName("login");
            return mv;
        }

        mv.addObject("boardDataList", boardService.getBoardList());
        mv.setViewName("main");
        return mv;
    }
}
