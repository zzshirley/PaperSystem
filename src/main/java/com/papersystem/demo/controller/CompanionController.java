package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Companion;
import com.papersystem.demo.bean.PartnerOpt;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.CompanionService;
import com.papersystem.demo.service.PartnerOptService;
import com.papersystem.demo.service.WritePaperService;
import com.papersystem.demo.service.paperTitleService;
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
 * @createTime 20190323 上午10:24
 * @description 伙伴选择/展示伙伴
 */
@RestController
public class CompanionController {

    @Autowired
    CompanionService companionService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    paperTitleService paperTitleService;

    @Autowired
    PartnerOptService partnerOptService;

    @RequestMapping("companion")
    public ModelAndView findcompanion(HttpSession session, Model model){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger companion= LogUtils.getBussinessLogger();
        companion.info(userid+" 选择伙伴/查看伙伴 ");
        List<Companion> cp=companionService.findPartner((String)userid);
        if(cp==null){
            model.addAttribute("nofriends",true);
        }else {
            model.addAttribute("partner",cp);
        }
        List<PartnerOpt> opts=partnerOptService.findOpt((String)userid);
        if (opts.isEmpty()){
            model.addAttribute("noopts",true);
        }else {
            model.addAttribute("opts",opts);
        }
        ModelAndView mv = new ModelAndView("companion");
        return mv;
    }
    @RequestMapping("/delPartner")
    public ModelAndView delPartner(HttpSession session,@RequestParam int id,@RequestParam String partnerid){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger delcompanion= LogUtils.getBussinessLogger();
        delcompanion.info(userid+" 删除伙伴 "+partnerid);
        companionService.delCompanion(id);

        ModelAndView mv = new ModelAndView("redirect:companion");
        return mv;
    }

}
