package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperInfo;
import com.papersystem.demo.bean.User;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.repo.PaperInfoRepo;
import com.papersystem.demo.service.LoginService;
import com.papersystem.demo.service.PaperInfoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 下午5:53
 * @description 添加投稿信息
 */
@RestController
public class AddInfoController {

    @Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private LoginService loginService;

    @RequestMapping("/addinfo")
    public ModelAndView addInfo(HttpSession session){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger addinfo= LogUtils.getDBLogger();
        addinfo.info(userid+",企图添加投稿信息");
        Logger addinfoB= LogUtils.getBussinessLogger();
        addinfoB.info(userid+",企图添加投稿信息");
        ModelAndView mv = new ModelAndView("addinfo");
        return mv;
    }

    @PostMapping("/PaperInfoSub")
    public ModelAndView PaperInfoSub(HttpSession session, Model model, String meetingname, String time, String lang, String url,String SCI,String SSCI,String EI,String hexin,String el){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger subinfo=LogUtils.getDBLogger();
        Logger subinfoB=LogUtils.getBussinessLogger();

        boolean judgemeeting=paperInfoService.judgemeeting(meetingname);
        ArrayList<String> meetgrade=new ArrayList<String>();
        meetgrade.add(hexin);
        meetgrade.add(SSCI);
        meetgrade.add(EI);
        meetgrade.add(SCI);
        meetgrade.add(el);
        meetgrade.removeAll(Collections.singleton(null));
        String grade=String.join(",",meetgrade);

        if(judgemeeting){
            model.addAttribute("infojudge",true);
            ModelAndView mv = new ModelAndView("addinfo");
            return mv;
        }else{

            String users=loginService.stuname((String)userid);
            if(url.isEmpty()){
                PaperInfo paperInfo=new PaperInfo(users,meetingname,time,lang,grade.toString());
                paperInfoService.addinfo(paperInfo);
            }else{
                PaperInfo paperInfo=new PaperInfo(users,meetingname,time,lang,grade.toString(),url);
                paperInfoService.addinfo(paperInfo);
            }
            subinfo.info(userid+",学生添加投稿信息");
            subinfoB.info(userid+",学生添加投稿信息");
            ModelAndView mv = new ModelAndView("redirect:prepare");
            return mv;
        }
    }
}
