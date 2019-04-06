package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.bean.PartnerOpt;
import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.*;
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
 * @createTime 20190401 上午11:49
 * @description 意见监控页
 */
@RestController
public class OptMonitorController {

    @Autowired
    GoalSettingService goalSettingService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    paperTitleService papertitleService;

    @Autowired
    PartnerOptService partnerOptService;

    @RequestMapping("/OptMonitor")
    public ModelAndView optMonitor(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger optMonitor = LogUtils.getDBLogger();
        Logger optMonitorB = LogUtils.getBussinessLogger();
        List<Goal> goalList = goalSettingService.findGoals((String)userid);
        Map<String, Map> map=new HashMap<>();
        String title=papertitleService.findTitle((String)userid);
        for (Goal s:goalList
        ) {
            Map<String,String> arrys=new HashMap<>();
            List<PartnerOpt> partnerOpts = partnerOptService.findMyACopt((String)userid,s.getChapter());
            if (!partnerOpts.isEmpty()) {
                arrys.put("opt",String.valueOf(partnerOpts.size()));
            }else {
                arrys.put("opt","0");
            }
            arrys.put("chp",s.getChapter());
            map.put("chp"+s.getCode(),arrys);
        }
        if(title=="nooooo"){
            model.addAttribute("title","暂无题目");
        }else {
            model.addAttribute("title",title);
        }
        model.addAttribute("map",map);
        optMonitor.info(userid+" 意见监控页");
        optMonitorB.info(userid+" 意见监控页");
        ModelAndView mv = new ModelAndView("OptMonitor");
        return mv;
    }

}
