package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.paperNoteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190311 下午4:08
 * @description
 */
@RestController
public class MyNoteController {

    @Autowired
    paperNoteService paperNoteService;

    @RequestMapping("/myNote")
    public ModelAndView myNote(HttpSession session, Model model){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getpapercollection= LogUtils.getDBLogger();
        getpapercollection.info(userid+",查看我的笔记");
        Logger getpapercollectionb= LogUtils.getBussinessLogger();
        getpapercollectionb.info(userid+",查看我的笔记");
        List<paperNote> paperNoteList=paperNoteService.papernote((String)userid);
        if (paperNoteList.isEmpty()){
            model.addAttribute("nolist",true);
        }else{
            model.addAttribute("list",true);
            model.addAttribute("papernote",paperNoteList);
        }

        ModelAndView mv = new ModelAndView("myNote");
        return mv;

    }

    @RequestMapping("/delNote")
    public ModelAndView delNote(HttpSession session, Model model,@RequestParam int id,@RequestParam String name){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delnote= LogUtils.getBussinessLogger();
        delnote.info(userid+",删除笔记"+name);
        paperNoteService.delnote(id);
        ModelAndView mv = new ModelAndView("redirect:myNote");
        return mv;

    }

}
