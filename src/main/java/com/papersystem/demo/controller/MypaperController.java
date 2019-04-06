package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.bean.Papertitle;
import com.papersystem.demo.bean.Selfeva;
import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.GoalSettingService;
import com.papersystem.demo.service.SelfevaService;
import com.papersystem.demo.service.WritePaperService;
import com.papersystem.demo.service.paperTitleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    paperTitleService papertitleService;

    @Autowired
    SelfevaService selfevaService;

    @RequestMapping("/MyPaper")
    public ModelAndView myPaper(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getgoals = LogUtils.getDBLogger();
        Logger getgoalsB = LogUtils.getBussinessLogger();
        List<Goal> goalList=goalSettingService.findGoals((String)userid);
        Map<String,Map> map=new HashMap<>();
        String title=papertitleService.findTitle((String)userid);
        for (Goal s:goalList
             ) {
            Map<String,String> arrys=new HashMap<>();
            arrys.put("chp",s.getChapter());
            arrys.put("words",s.getWords());
            List<WritePaper> golsnum=writePaperService.findStusNote((String)userid,s.getChapter());
            String selfevaList=selfevaService.findScore((String)userid,s.getChapter());
            if(golsnum.isEmpty()){
                arrys.put("realnum","0");
            }else {
                arrys.put("realnum",golsnum.get(golsnum.size()-1).getWordnum());
            }
            arrys.put("selfeva",selfevaList);
            map.put("chp"+s.getCode(),arrys);
        }
        if(title=="nooooo"){
            model.addAttribute("title","点击设置论文题目");
        }else {
            model.addAttribute("title",title);
        }
        model.addAttribute("map",map);
        getgoals.info(userid+" 点击我的论文");
        getgoalsB.info(userid+" 点击我的论文");
        ModelAndView mv = new ModelAndView("MyPaper");
        return mv;
    }

    @PostMapping("/setmypapername")
    public ModelAndView setTitle(HttpSession session,Model model,String mypapername){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger settitle = LogUtils.getDBLogger();
        Logger settitleB = LogUtils.getBussinessLogger();
        SimpleDateFormat af = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String endtime=af.format(System.currentTimeMillis());
        Papertitle pt=new Papertitle((String)userid,mypapername,endtime);
        papertitleService.saveTitle(pt);
        settitle.info(userid+" 设置论文题目");
        settitleB.info(userid+" 设置论文题目");

        ModelAndView mv = new ModelAndView("redirect:MyPaper");
        return mv;

    }
}
