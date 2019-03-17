package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.bean.Scholar;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.PaperCollectionService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019306 下午3:45
 * @description 文献信息 添加/记笔记
 */

@RestController
public class PaperCollectionController {

    @Autowired
    PaperCollectionService paperCollectionService;

    @RequestMapping("paperCollection")
    public ModelAndView PaperCollection(HttpSession session, Model model){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger getpapercollection= LogUtils.getDBLogger();
        getpapercollection.info(userid+",查看文献信息/文献搜集");
        Logger getpapercollectionb= LogUtils.getBussinessLogger();
        getpapercollectionb.info(userid+",查看文献信息/文献搜集");
        List<PaperCollection> paperCollectionList=paperCollectionService.paperCollections();
        if (paperCollectionList.isEmpty()){
            model.addAttribute("nolist",true);
        }else{
            model.addAttribute("list",true);
            model.addAttribute("papercollection",paperCollectionList);
        }

        ModelAndView mv = new ModelAndView("paperCollection");
        return mv;

    }

    @PostMapping("/addpapers")//添加文献
    public ModelAndView addScholar(HttpSession session,Model model,String papername,String author,String publication,String year,String lang,String cited,String url){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger papercollection= LogUtils.getDBLogger();
        Logger papercollectionb= LogUtils.getBussinessLogger();
        papercollection.info(userid+"添加文献信息"+papername);
        papercollectionb.info(userid+"添加文献信息"+papername);
        PaperCollection pc =new PaperCollection((String)userid,papername,author,publication,year,lang,cited,url);
        paperCollectionService.saveCollection(pc);
        ModelAndView  mv = new ModelAndView("redirect:scholar");
        return mv;

    }
}
