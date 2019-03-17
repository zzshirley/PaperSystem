package com.papersystem.demo.controller;

import com.papersystem.demo.config.WebSecurityConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Xiaotong
 * @createTime 2019228 上午10:35
 * @description 首页
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session) {
        Object stuid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
