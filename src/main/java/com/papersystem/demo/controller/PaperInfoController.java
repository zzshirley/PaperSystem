package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperInfo;
import com.papersystem.demo.bean.StuGoals;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.PaperInfoService;
import com.papersystem.demo.service.StuGoalsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019 228 下午3:38
 * @description 查看/选择投稿信息
 */
@RestController
public class PaperInfoController {

    @ Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private StuGoalsService stuGoalsService;

    @RequestMapping("/prepare")
    public ModelAndView paperinfo(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger prepare=LogUtils.getDBLogger();
        List<PaperInfo> paperInfoList=paperInfoService.findAllInfo();
        List<StuGoals> stuGoals=stuGoalsService.getStuGoals((String)userid);
        if(stuGoals.isEmpty()){

        }else {
            model.addAttribute("goals",stuGoals);
        }

        if(paperInfoList.isEmpty()){
            prepare.info(userid+",查看投稿信息/前期准备");
            ModelAndView mv = new ModelAndView("prepare");
            return mv;
        }
        else{
            prepare.info(userid+",查看投稿信息/前期准备");
            model.addAttribute("paperlist",paperInfoList);
            ModelAndView mv = new ModelAndView("prepare");
            return mv;
        }
    }

    @RequestMapping("/setGoals")
    public ModelAndView SetGoals(HttpSession session, @RequestParam String stugoals,@RequestParam String meetingid, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger setGoals=LogUtils.getDBLogger();
        Logger setGoalsB=LogUtils.getBussinessLogger();
        boolean stuGoals=stuGoalsService.StuGoals(stugoals,(String)userid);
        if(stuGoals){
            setGoals.info(userid+"设定目标");
            setGoalsB.info(userid+"设定目标");
            model.addAttribute("havegoals",true);
            ModelAndView mv = new ModelAndView("redirect:prepare");
            return mv;
        }else {
            setGoals.info(userid+"，设定目标，目标id"+meetingid);
            setGoalsB.info(userid+"，设定目标，目标id"+meetingid);
            StuGoals stuGoals1=new StuGoals(meetingid,stugoals,(String)userid);
            stuGoalsService.SetGoals(stuGoals1);
            ModelAndView mv = new ModelAndView("redirect:prepare");
            return mv;
        }
    }
    @RequestMapping("delgoals")
    public ModelAndView DelGoals(HttpSession session,@RequestParam int id){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delgoals=LogUtils.getDBLogger();
        Logger delgoalsB=LogUtils.getBussinessLogger();
        StuGoals stuGoals=new StuGoals(id,(String)userid);
        stuGoalsService.Delgoals(id);
        delgoals.info(userid+"，删除目标"+"，目标ID"+id);
        delgoalsB.info(userid+"，删除目标"+"，目标ID"+id);
        ModelAndView mv = new ModelAndView("redirect:prepare");
        return mv;
    }
    @RequestMapping("readmeeting")
    public ModelAndView ReadMeeting(HttpSession session,@RequestParam String url){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger readmeeting=LogUtils.getDBLogger();
        Logger readmeetingB=LogUtils.getBussinessLogger();
        readmeeting.info(userid+"，查看会议网址，会议url"+url);
        readmeetingB.info(userid+"，查看会议网址，会议url"+url);
        ModelAndView mv= new ModelAndView("redirect:"+url);
        return mv;
    }

}
