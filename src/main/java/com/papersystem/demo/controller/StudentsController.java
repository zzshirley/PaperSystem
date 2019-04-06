package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Companion;
import com.papersystem.demo.bean.User;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.CompanionService;
import com.papersystem.demo.service.LoginService;
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
import java.util.Arrays;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190325 上午10:25
 * @description 伙伴选择
 */
@RestController
public class StudentsController {

    @Autowired
    CompanionService companionService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    com.papersystem.demo.service.paperTitleService paperTitleService;

    @Autowired
    LoginService loginService;

    @RequestMapping("students")
    public ModelAndView findcompanion(HttpSession session, Model model){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger companion= LogUtils.getBussinessLogger();
        companion.info(userid+" 选择伙伴 ");
        List<User> users=companionService.stulist();

        model.addAttribute("length",users.size());
        model.addAttribute("usrlist",users);
        ModelAndView mv = new ModelAndView("students");
        return mv;
    }
    @PostMapping("substudents")
    public String subCompanion(HttpSession session,String stuid){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);

        Logger subcompanion= LogUtils.getBussinessLogger();
        subcompanion.info(userid+" 提交选择伙伴");

        //将字符串转换成数组形式，方便在写文章的时候参考
        List<String> list= Arrays.asList(stuid.split(" "));
        SimpleDateFormat af = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String endtime=af.format(System.currentTimeMillis());
        for (int i=1;i<list.size();i++) {//（String）userid表示的是学生自己，list.get(i)表示的是可以看自己文章的学生学号
            if(companionService.havePartner((String)userid,list.get(i))){

            }else {
                Companion cp=new Companion((String)userid,list.get(i),companionService.findName((String)userid),endtime);
                companionService.savepartner(cp);
            }
        }
        return (String)userid;
    }
}
