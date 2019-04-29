package com.papersystem.demo.controller;

import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.CompanionService;
import com.papersystem.demo.service.LoginService;
import com.papersystem.demo.service.PartnerOptService;
import com.papersystem.demo.service.WritePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 上午10:35
 * @description 首页
 */
@RestController
public class IndexController {

    @Autowired
    CompanionService companionService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    com.papersystem.demo.service.paperTitleService paperTitleService;

    @Autowired
    private PartnerOptService partnerOptService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/index")
    public ModelAndView index(HttpSession session, Model model) {
        Object stuid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        ModelAndView mv = new ModelAndView("index");
        if (((String)stuid).equals("admin")){
            model.addAttribute("admin",true);
        }

        //查找学生本人的论文全文
        List<WritePaper> wps=writePaperService.fulltext((String)stuid);
        String papername=paperTitleService.findTitle((String)stuid);
        if (papername.equals("nooooo")){

        }else {
            model.addAttribute("ptitle",papername);
        }
        model.addAttribute("pname",companionService.findName((String)stuid));//伙伴的名字
        model.addAttribute("pid",(String)stuid);//伙伴的学号，下同
        if(wps.isEmpty()){
            model.addAttribute("nothing",true);
        }else {
            model.addAttribute("paper",wps);

        }
        return mv;
    }
}
