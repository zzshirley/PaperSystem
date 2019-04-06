package com.papersystem.demo.controller;

import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.bean.PartnerOpt;
import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Xiaotong
 * @createTime 20190303 下午4:37
 * @description 看意见修改文章
 */
@RestController
public class RevisePaperController {

    @Autowired
    paperNoteService paperNoteService;

    @Autowired
    PaperCollectionService paperCollectionService;

    @Autowired
    WritePaperService writePaperService;

    @Autowired
    PartnerOptService partnerOptService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/RevisePaper")
    public ModelAndView revisePaper(HttpSession session,Model model,String chapter) {

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subNote = LogUtils.getBussinessLogger();
        subNote.info(userid+"看意见修改论文 " + chapter);

        List<Map> mapList = new ArrayList<>();
        List<WritePaper> papercontent = writePaperService.findStusNote((String)userid,chapter);
        List<PartnerOpt> partnerOpts = partnerOptService.findMyACopt((String)userid,chapter);
        if(partnerOpts.isEmpty()){
            model.addAttribute("OptEmpty",true);
        }else{
            for (PartnerOpt p:partnerOpts){
                Map pl = new HashMap();
                pl.put("partner",loginService.stuname(p.getStuid()));
                pl.put("opt",p.getOpt());
                pl.put("Optcontent",p.getOptcontent());
                mapList.add(pl);
            }
        }
        model.addAttribute("chapter",chapter);
        model.addAttribute("doneOpt",mapList);
        if(papercontent.isEmpty()){

        }else {
            model.addAttribute("content",papercontent.get(papercontent.size()-1).getContent());
        }
        ModelAndView mv = new ModelAndView("RevisePaper");
        return mv;
    }
}
