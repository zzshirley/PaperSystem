package com.papersystem.demo.controller;

import com.papersystem.demo.Util.Function;
import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.bean.PaperInfo;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.GoalSettingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @createTime 2019201 上午10:00
 * @description 目标设定
 */
@RestController
public class GoalSettingController {

    @Autowired
    private GoalSettingService goalSettingService;

    @RequestMapping("/goalSetting")
    public ModelAndView displayGoals(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getgoals = LogUtils.getDBLogger();
        Logger getgoalsB = LogUtils.getBussinessLogger();

        if (((String)userid).equals("admin")){
            model.addAttribute("admin",true);
        }

        List<Goal> goalList=goalSettingService.findGoals((String)userid);
        if(goalList.isEmpty()){
            model.addAttribute("nonegoals",true);
            ModelAndView mv = new ModelAndView("goalSetting");
            return mv;

        }else{
            model.addAttribute("mygoals",true);
            model.addAttribute("stugoals",goalList);
        }
        getgoals.info(userid+" 点击目标设定");
        getgoalsB.info(userid+" 点击目标设定");
        ModelAndView mv = new ModelAndView("goalSetting");
        return mv;
    }

    @PostMapping("/subGoals")
    public ModelAndView subGoals(HttpSession session, Model model,@RequestParam String chapter,@RequestParam String date,@RequestParam String wordnum){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        if (((String)userid).equals("admin")){
            model.addAttribute("admin",true);
        }
        Function f=new Function();
        Logger subgoals=LogUtils.getDBLogger();
        Logger subgoalsB=LogUtils.getBussinessLogger();
        Goal goal=new Goal((String)userid,date,chapter,wordnum,f.map.get(chapter));
        goalSettingService.saveGoals(goal);
        subgoals.info(userid+" 添加目标");
        subgoalsB.info(userid+" 添加目标");
        ModelAndView mv = new ModelAndView("redirect:goalSetting");
        return mv;
    }
    @RequestMapping("/delg")//根据id删除学生的目标
    public ModelAndView delG(HttpSession session,@RequestParam int id,@RequestParam String chapter) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delkeyword= LogUtils.getBussinessLogger();
        delkeyword.info(userid+" 删除目标 "+chapter);
        goalSettingService.delGoals(id);
        ModelAndView mv = new ModelAndView("redirect:goalSetting");
        return mv;
    }
    @PostMapping("/updategoals")
    public Map updateGoals(HttpSession session,Model model,@RequestParam String date,@RequestParam String word,@RequestParam String chapter,int id){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delkeyword= LogUtils.getBussinessLogger();
        delkeyword.info(userid+" 更改目标 "+chapter);
        Function f=new Function();
        Goal goal=new Goal(id,(String)userid,date,chapter,word,f.map.get(chapter));
        goalSettingService.saveGoals(goal);
        Map req=new HashMap();
        req.put("data","hello");
        return req;

    }
}
