package com.papersystem.demo.controller;

import com.papersystem.demo.Util.Function;
import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.bean.Selfeva;
import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.SelfevaService;
import com.papersystem.demo.service.WritePaperService;
import com.papersystem.demo.service.paperNoteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Xiaotong
 * @createTime 20190318 下午1:57
 * @description 自评
 */
@RestController
public class SelfevaController {
    @Autowired
    WritePaperService writePaperService;

    @Autowired
    SelfevaService selfevaService;

    @RequestMapping("/Selfeva")
    public ModelAndView Selfeva(HttpSession session, Model model, @RequestParam String chapter){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subNote= LogUtils.getBussinessLogger();
        subNote.info(userid+"自评论文 "+chapter);
        List<WritePaper> papercontent=writePaperService.findStusNote((String)userid,chapter);
        if(papercontent.isEmpty()){
            model.addAttribute("something","0");
        }else {
            model.addAttribute("something","1");
            model.addAttribute("content",papercontent.get(papercontent.size()-1).getContent());
        }
        model.addAttribute("chapter",chapter);
        ModelAndView mv = new ModelAndView("Selfeva");
        return mv;
    }

    @PostMapping("/subSelfeva")
    public ModelAndView subSelfeva(HttpSession session, Model model, String chapter,String score){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subSeleva= LogUtils.getBussinessLogger();
        subSeleva.info(userid+"提交自评 "+chapter+" "+score);
        Function f=new Function();
        Selfeva selfeva=new Selfeva((String)userid,chapter,f.map.get(chapter),score);
        selfevaService.saveEva(selfeva);
        ModelAndView mv = new ModelAndView("redirect:MyPaper");
        return mv;
    }

}
