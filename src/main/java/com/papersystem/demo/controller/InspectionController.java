package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.*;
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
 * @createTime 20190406 下午3:31
 * @description 郑老师检查页面
 */
@RestController
public class InspectionController {

    @Autowired
    GoalSettingService goalSettingService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    paperTitleService papertitleService;

    @Autowired
    PartnerOptService partnerOptService;

    @Autowired
    LoginService loginService;

    @Autowired
    CompanionService companionService;

    @Autowired
    paperNoteService paperNoteService;

    @Autowired
    SelfevaService selfevaService;

    @RequestMapping("inspection")
    public ModelAndView inspection(HttpSession session, Model model) {
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        if (((String)userid).equals("admin")){
            model.addAttribute("admin",true);
        }else {
            ModelAndView mv = new ModelAndView("index");
            return mv;
        }
        List<User> users=companionService.stulist();
        users.remove(users.get(1));
        model.addAttribute("length",users.size());
        model.addAttribute("usrlist",users);
        ModelAndView mv = new ModelAndView("inspection");
        return mv;
    }
    @RequestMapping("/check")
    public ModelAndView myPaper(HttpSession session, Model model,String stuid){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getgoals = LogUtils.getDBLogger();
        Logger getgoalsB = LogUtils.getBussinessLogger();
        if (((String)userid).equals("admin")){
            model.addAttribute("admin",true);
        }
        List<Goal> goalList=goalSettingService.findGoals(stuid);
        Map<String,Map> map=new HashMap<>();
        for (Goal s:goalList
        ) {
            Map<String,String> arrys=new HashMap<>();
            arrys.put("chp",s.getChapter());
            arrys.put("words",s.getWords());
            List<WritePaper> golsnum=writePaperService.findStusNote(stuid,s.getChapter());
            String selfevaList=selfevaService.findScore(stuid,s.getChapter());
            if(golsnum.isEmpty()){
                arrys.put("realnum","0");
            }else {
                arrys.put("realnum",golsnum.get(golsnum.size()-1).getWordnum());
            }
            arrys.put("selfeva",selfevaList);
            map.put("chp"+s.getCode(),arrys);
        }
        model.addAttribute("name",loginService.stuname(stuid));
        List<paperNote> paperNotes = paperNoteService.papernote(stuid);
        if (!paperNotes.isEmpty()) {
            model.addAttribute("notes",paperNotes.size());
        }else {
            model.addAttribute("notes",0);
        }
        model.addAttribute("map",map);
        getgoals.info(userid+" 郑老师点击我的论文");
        getgoalsB.info(userid+" 郑老师点击我的论文");
        ModelAndView mv = new ModelAndView("stuPaper");
        return mv;
    }
}
