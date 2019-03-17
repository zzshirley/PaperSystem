package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Scholar;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.ScholarService;
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
import java.util.Map;

/**
 * @author Xiaotong
 * @createTime 2019204 下午8:36
 * @description 学者信息
 */
@RestController
public class ScholarController {

    @Autowired
    ScholarService scholarService;

    @RequestMapping("/scholar")//学者信息页
    public ModelAndView scholars(HttpSession session, Model model){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getscholar= LogUtils.getBussinessLogger();
        getscholar.info(userid+"查看学者信息");
        List<Scholar> scholarList= scholarService.getScholar((String)userid);
        if(scholarList.isEmpty()){
            model.addAttribute("scholars",true);
        }else{
            model.addAttribute("s",true);
            model.addAttribute("scholar",scholarList);
        }
        ModelAndView mv = new ModelAndView("scholar");
        return mv;

    }

    @PostMapping("/addscholar")//添加学者信息
    public ModelAndView addScholar(HttpSession session,Model model,String sname,String school,String institution,String url,String keyword){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger addkeyword= LogUtils.getBussinessLogger();
        addkeyword.info(userid+",添加相关学者,"+sname);
        Scholar scholar=new Scholar((String)userid,sname,school,institution,url,keyword);
        scholarService.saveScholar(scholar);
        ModelAndView  mv = new ModelAndView("redirect:scholar");
        return mv;

    }
    @RequestMapping("/delscholar")//删除学者信息
    public ModelAndView DelScholar(HttpSession session,Model model,@RequestParam int id,@RequestParam String name){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delkeyword= LogUtils.getBussinessLogger();
        delkeyword.info(userid+",删除相关学者,"+name);
        scholarService.delScholar(id);
        ModelAndView  mv = new ModelAndView("redirect:scholar");
        return mv;
    }

    @RequestMapping("readscholar")
    public ModelAndView ReadMeeting(HttpSession session,@RequestParam String url){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger readscholar=LogUtils.getDBLogger();
        Logger readscholarB=LogUtils.getBussinessLogger();
        readscholar.info(userid+"，查看学者网址，会议url"+url);
        readscholarB.info(userid+"，查看学者网址，会议url"+url);
        ModelAndView mv= new ModelAndView("redirect:"+url);
        return mv;
    }
}
