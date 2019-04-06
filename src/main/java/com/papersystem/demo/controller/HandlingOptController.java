package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PartnerOpt;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.PartnerOptService;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Xiaotong
 * @createTime 20190403 下午7:22
 * @description 意见处理页，展示处理和未处理的意见
 */
@RestController
public class HandlingOptController {

    @Autowired
    PartnerOptService partnerOptService;

    @RequestMapping("HandlingOpt")
    public ModelAndView HandlingOpt(HttpSession session, Model model,Integer pagenum) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger handlingOpt= LogUtils.getBussinessLogger();
        handlingOpt.info(userid+" 处理意见 ");
        int page = partnerOptService.page((String)userid,"0");
        List<PartnerOpt> partnerOpts0 = partnerOptService.findOptByState((String)userid,"0" );

        model.addAttribute("partnerOpts0",partnerOpts0);

        ModelAndView mv  = new ModelAndView("HandlingOpt");
        return mv;
    }
    @PostMapping("/subhandledOpt")
    public String HandledOpt(HttpSession session,@RequestParam("name[]") List<Integer> name,@RequestParam("handled[]") List<String> handle) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger handledOpt= LogUtils.getBussinessLogger();
        handledOpt.info(userid+" 提交处理意见 ");
        for (int i= 0;i < name.size(); i++) {//0-待修改，1-已修改，2-不修改
            if(handle.get(i).equals("待修改")) {

            }else if(handle.get(i).equals("已修改")) {
                PartnerOpt pot = partnerOptService.findByid(name.get(i));
                pot.setState("1");
                partnerOptService.saveOpt(pot);
            }else if (handle.get(i).equals("不修改")){
                PartnerOpt pot = partnerOptService.findByid(name.get(i));
                pot.setState("2");
                partnerOptService.saveOpt(pot);
            }

        }

        return (String)userid;
    }
}
