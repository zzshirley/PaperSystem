package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.KeyWords;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.KeyWordService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Xiaotong
 * @createTime 2019203 上午11:42
 * @description 关键词
 */

@RestController
public class KeywordController {

    @Autowired
    KeyWordService keyWordService;

    @RequestMapping("/keyword")
    public ModelAndView getKewords(HttpSession session, Model model){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger keyword= LogUtils.getBussinessLogger();
        keyword.info(userid+"添加关键词/查看关键词");

        List<KeyWords> keyWordsList=keyWordService.getKeyWords((String)userid);
        List<KeyWords> keyWordsList0=new ArrayList<>();//中文关键词
        List<KeyWords> keyWordsList1=new ArrayList<>();//英文关键词
        for(KeyWords k:keyWordsList){
            if(k.getLang().equals("0")){
                keyWordsList0.add(k);
            }else{
                keyWordsList1.add(k);
            }
        }
        model.addAttribute("keyword0",keyWordsList0);//中文
        model.addAttribute("keyword1",keyWordsList1);//英文
        ModelAndView mv = new ModelAndView("keyword");
        return mv;
    }

    @RequestMapping("/addkeyword")//0表示中文，1表示英文
    public ModelAndView addKeyWord(HttpSession session,@RequestParam String lang,String keyword) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger addkeyword= LogUtils.getBussinessLogger();
        addkeyword.info(userid+",添加关键词,"+keyword);

        boolean keyWord=keyWordService.getKeyWordsByword((String)userid,keyword);
        if(keyWord){

        }else{
            KeyWords keyWords=new KeyWords((String)userid,keyword,lang);
            keyWordService.saveKeyWords(keyWords);
        }
        ModelAndView mv = new ModelAndView("redirect:keyword");
        return mv;
    }

    @RequestMapping("/delkeyword")//根据id删除学生的关键词
    public ModelAndView delKeyWord(HttpSession session,@RequestParam int id,@RequestParam String keyword) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delkeyword= LogUtils.getBussinessLogger();
        delkeyword.info(userid+",删除关键词,"+keyword);
        //KeyWords keyWords=new KeyWords((String)userid,keyword,lang);
        keyWordService.delKeywords(id);
        ModelAndView mv = new ModelAndView("redirect:keyword");
        return mv;
    }

    @RequestMapping("/readkeyword")//在百度学术中查询关键词
    public void readkeyword(HttpSession session,@RequestParam String keyword){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger readkeyword= LogUtils.getBussinessLogger();
        readkeyword.info(userid+",百度学术中查询关键词,"+keyword);

    }
}
