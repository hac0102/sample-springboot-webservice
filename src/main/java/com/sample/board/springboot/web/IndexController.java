package com.sample.board.springboot.web;

import com.sample.board.springboot.config.auth.LoginUser;
import com.sample.board.springboot.config.auth.dto.SessionUser;
import com.sample.board.springboot.service.board.BoardService;
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
        ModelAndView mv = new ModelAndView();

        if(user == null){
            mv.setViewName("login");
            return mv;
        }

        mv.addObject("boardDataList", boardService.getBoardList());
        mv.addObject("userInfo", user);
        mv.setViewName("main");
        return mv;
    }

    @GetMapping("/login2")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/logout2")
    public ModelAndView logout(ModelAndView mv, @LoginUser SessionUser user){
        log.info("로그아웃 name :: {}", user == null ? "null" : user.getName());
        log.info("로그아웃 email :: {}", user == null ? "null" : user.getEmail());

        httpSession.removeAttribute("userSession");
        httpSession.invalidate();
        user = null;
        mv.setViewName("login");
        return mv;
    }
}
