package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.GoalSettingService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiaotong
 * @createTime 20190313 下午3:11
 * @description 我的论文
 */
@RestController
public class MypaperController {

    @Autowired
    GoalSettingService goalSettingService;

    @RequestMapping("/MyPaper")
    public ModelAndView myPaper(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getgoals = LogUtils.getDBLogger();
        Logger getgoalsB = LogUtils.getBussinessLogger();
        List<Goal> goalList=goalSettingService.findGoals((String)userid);
        Map<String,Goal> map=new HashMap<>();
        for (Goal s:goalList
             ) {
            map.put("chp"+s.getCode(),s);
        }
        model.addAllAttributes(map);
        getgoals.info(userid+" 点击我的论文");
        getgoalsB.info(userid+" 点击我的论文");
        ModelAndView mv = new ModelAndView("MyPaper");
        return mv;
    }
}
