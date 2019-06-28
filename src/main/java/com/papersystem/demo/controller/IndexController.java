package com.papersystem.demo.controller;

import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    KeyWordService keyWordService;

    @Autowired
    ScholarService scholarService;

    @Autowired
    paperNoteService paperNoteService;

    @Autowired
    SelfevaService selfevaService;

    @Autowired
    GoalSettingService goalSettingService;
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session, Model model) {
        Object stuid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        ModelAndView mv = new ModelAndView("index");
        if (((String)stuid).equals("admin")){
            model.addAttribute("admin",true);
        }
        //计算日期差
        int temp = 0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fDate=sdf.parse("2019-05-27");
            String now=sdf.format(System.currentTimeMillis());
            Date nDate = sdf.parse(now);
            Calendar calendar1 = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar1.setTime(fDate);
            calendar2.setTime(nDate);
            int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
            int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
            int days = day1 - day2;
            model.addAttribute("remainingdays",String.valueOf(days).trim());
            double rday = 0.00;
            rday = days / 7.00;
            System.out.println(rday);
            if ( rday > 0 &&rday <= 1) {
                temp = 1;
            }else if(rday > 1 && rday <=2){
                temp = 2;
            }else if(rday > 2 && rday <= 3) {
                temp = 3;
            }else if (rday > 3 && rday <= 4) {
                temp = 4;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("temp",temp);
        //查找关键词数量
        int keywordnum = keyWordService.Keywordsnum((String)stuid);
        model.addAttribute("keyword",keywordnum);

        //查找学生数量
        int scholarnum = scholarService.numScholar((String)stuid);
        model.addAttribute("scholar",scholarnum);

        //文献笔记数量
        int notenum = paperNoteService.numNote((String)stuid);
        model.addAttribute("tnote",12-temp);
        model.addAttribute("notenum",notenum);

        //目标进度
        double papernum = writePaperService.npapernum((String)stuid);
        model.addAttribute("papernum",(int)papernum);

        //论文进度
        int goalsnum = goalSettingService.goalsnum((String)stuid);
        if (goalsnum != 0) {
            double nplan = papernum / goalsnum;
            model.addAttribute("nplan",String.format("%.2f",nplan*100));
        }else {
            double nplan = 0.00;
            model.addAttribute("nplan",String.valueOf(nplan));
        }


        double plan = 10 - (temp+1);
        model.addAttribute("plan",plan*10);


        //自我评价
        double selfevanum = selfevaService.selfeva((String)stuid);
        model.addAttribute("selfevanum",String.format("%.2f",selfevanum));

        //提出意见
        int givenoptnum = partnerOptService.optnum((String)stuid);
        model.addAttribute("goptnum",givenoptnum);

        //收到的意见
        int reciveoptnum = partnerOptService.roptnum((String)stuid);
        model.addAttribute("roptnum",reciveoptnum);

        model.addAttribute("toptnum",24-(temp+1)*3);

        //待处理意见
        int uncheckoptnum = partnerOptService.uncheckopt((String)stuid);
        model.addAttribute("ucopt",uncheckoptnum);
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
