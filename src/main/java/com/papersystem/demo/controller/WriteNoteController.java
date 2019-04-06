package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.KeyWords;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.KeyWordService;
import com.papersystem.demo.service.paperNoteService;
import com.sun.javafx.collections.MappingChange;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
 * @createTime 20190307 下午3:40
 * @description 学生选择某一篇文献记笔记
 */
@RestController
public class WriteNoteController {

    @Autowired
    KeyWordService keyWordService;

    @Autowired
    paperNoteService paperNoteService;

    @RequestMapping("/writeNote")
    public ModelAndView writeNote(HttpSession session, Model model, @RequestParam int id,@RequestParam String papername){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger writeNote= LogUtils.getBussinessLogger();
        writeNote.info(userid+"点击添加笔记页/"+papername);
        model.addAttribute("papername",papername);
        List<KeyWords> keyWordsList=keyWordService.getKeyWords((String)userid);
        model.addAttribute("rkeyword",keyWordsList);
        ModelAndView mv =new ModelAndView("writeNote");
        return mv;
    }
    @PostMapping("/SubwriteNote")
    public Map subWriteNote(HttpSession session,@RequestParam String papername, @RequestParam String grade,@RequestParam String keywords,@RequestParam String selfhelp,@RequestParam String papernote){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subNote= LogUtils.getBussinessLogger();
        subNote.info(userid+"添加笔记/"+papername);
        System.out.println(keywords.substring(1));
        /*将字符串转换成数组形式，方便在写文章的时候参考
        List<String> list= Arrays.asList(keywords.split(" "));
        for (String s:list
             ) {
            System.out.println(s);
        }*/

        paperNote paperNote=new paperNote((String)userid,papername,grade,keywords,selfhelp,papernote);
        paperNoteService.savenote(paperNote);
        Map req=new HashMap();
        req.put("data","hello");
        return req;
    }
}
