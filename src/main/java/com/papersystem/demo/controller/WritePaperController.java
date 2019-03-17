package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.config.WebSecurityConfig;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Xiaotong
 * @createTime 20190316 下午5:28
 * @description 写论文
 */
@RestController
public class WritePaperController {

    @RequestMapping("/writePaper")
    public ModelAndView writePaper(HttpSession session, Model model,@RequestParam String chapter){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subNote= LogUtils.getBussinessLogger();
        model.addAttribute("chapter",chapter);
        subNote.info(userid+"撰写论文 ");
        ModelAndView mv = new ModelAndView("writePaper");
        return mv;
    }
}
