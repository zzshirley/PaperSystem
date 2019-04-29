package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.*;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.*;
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
 * @createTime 20190324 上午10:02
 * @description 伙伴评价
 */
@RestController
public class PartnerTextController {


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

    //选择全文查看
    @RequestMapping("/Partnerfulltext")
    public ModelAndView pFulltext(HttpSession session, Model model, String partnerid, String partnername){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger checkcompanion= LogUtils.getBussinessLogger();
        checkcompanion.info(userid+" 查看伙伴全文 "+partnerid);
        List<WritePaper> wps=writePaperService.fulltext(partnerid);
        String papername=paperTitleService.findTitle(partnerid);
        if (papername.equals("nooooo")){

        }else {
            model.addAttribute("ptitle",papername);
        }
        model.addAttribute("pname",companionService.findName(partnerid));//伙伴的名字
        model.addAttribute("pid",partnerid);//伙伴的学号，下同
        if(wps.isEmpty()){
            model.addAttribute("nothing",true);
        }else {
            model.addAttribute("paper",wps);

        }
        ModelAndView mv = new ModelAndView("Partnerfulltext");
        return mv;
    }

    //提交全文的评价
    @PostMapping("subfullopt")//表示当前学生给他的伙伴的评价
    public ModelAndView subFullopt(HttpSession session,String pid,String pname,String chapter,String opt,String optcontent){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger checkcompanion= LogUtils.getBussinessLogger();
        checkcompanion.info(userid+" 提交查看伙伴全文意见 "+pid);
        PartnerOpt pot=new PartnerOpt((String)userid,pid,pname,chapter,opt,optcontent,"0",loginService.stuname((String)userid));

        partnerOptService.saveOpt(pot);
        ModelAndView mv = new ModelAndView("redirect:companion");
        return mv;
    }
    /**
     * 按章节查看伙伴的文章
     * @Param partnerid 伙伴的学号
     * */
    @RequestMapping("/Partnerpaper")
    public ModelAndView parnterPaper(HttpSession session, Model model, String partnerid, String partnername,String chapter){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger checkcompanion= LogUtils.getBussinessLogger();
        checkcompanion.info(userid+" 按章节查看论文 "+partnerid);

        List<WritePaper> wps=writePaperService.fulltext(partnerid);
        String papername=paperTitleService.findTitle(partnerid);
        model.addAttribute("pname",partnername);
        model.addAttribute("pid",partnerid);
        if (papername.equals("nooooo")){
            model.addAttribute("title","暂无题目");
        }else {
            model.addAttribute("title",papername);
        }
        model.addAttribute("wps",wps);
        if(!chapter.equals("9")){
            List<WritePaper> papercontent=writePaperService.findStusNote(partnerid,chapter);
            model.addAttribute("chapter",chapter);
            if(papercontent.isEmpty()){
                model.addAttribute("nothing","true");
            }else {
                model.addAttribute("content",papercontent.get(papercontent.size()-1).getContent());
            }
        }
        ModelAndView mv = new ModelAndView("Partnerpaper");
        return mv;
    }

    @RequestMapping("/delopt")
    public ModelAndView delOpt(HttpSession session,int id,String pname,String chapter){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger delopt= LogUtils.getBussinessLogger();
        delopt.info(userid+" 删除意见 "+pname+" "+chapter);

        partnerOptService.delOpt(id);

        ModelAndView mv = new ModelAndView("redirect:companion");
        return mv;
    }
}
