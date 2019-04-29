package com.papersystem.demo.controller;

import com.papersystem.demo.Util.Function;
import com.papersystem.demo.Util.LogUtils;
import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.config.WebSecurityConfig;
import com.papersystem.demo.service.GoalSettingService;
import com.papersystem.demo.service.PaperCollectionService;
import com.papersystem.demo.service.WritePaperService;
import com.papersystem.demo.service.paperNoteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Xiaotong
 * @createTime 20190316 下午5:28
 * @description 写论文
 */
@RestController
public class WritePaperController {

    @Autowired
    paperNoteService paperNoteService;

    @Autowired
    PaperCollectionService paperCollectionService;

    @Autowired
    WritePaperService writePaperService;



    @RequestMapping("/writePaper")
    public ModelAndView writePaper(HttpSession session, Model model,@RequestParam String chapter){

        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        Logger subNote= LogUtils.getBussinessLogger();
        subNote.info(userid+" 撰写论文 "+chapter);
        List<paperNote> paperNotes=paperNoteService.papernote((String)userid);
        List<paperNote> paperNoteList=new ArrayList<>();
        List<Map> mapList=new ArrayList<>();
        List<WritePaper> papercontent=writePaperService.findStusNote((String)userid,chapter);
        if(paperNotes.isEmpty()){
            model.addAttribute("nonenote",true);
        }else{
            for(paperNote p:paperNotes){
                if(p.getSelfhelp() == ""){
                    paperNoteList.add(p);
                }else {
                    List<String> list= Arrays.asList(p.getSelfhelp().split(" "));
                    for (String s:list
                    ) {
                        if (s.equals(chapter)){
                            System.out.println("s:"+s);
                            paperNoteList.add(p);
                        }
                    }
                }
            }
            for (paperNote p:paperNoteList){
                List<PaperCollection> paperCollections=paperCollectionService.findpapersauthor(p.getPaperid());
                if (!paperCollections.isEmpty()) {
                    Map pl=new HashMap();
                    pl.put("author",paperCollections.get(0).getAuthor());
                    pl.put("year",paperCollections.get(0).getYear());
                    pl.put("note",p.getNotetext());
                    mapList.add(pl);
                }

            }
        }
        model.addAttribute("chapter",chapter);
        model.addAttribute("donenotes",mapList);
        if(papercontent.isEmpty()){

        }else {
            model.addAttribute("content",papercontent.get(papercontent.size()-1).getContent());
        }
        ModelAndView mv = new ModelAndView("writePaper");
        return mv;
    }

    @PostMapping("/submyPaper")
    public String saveMypapers(HttpSession session,Model model,String chapter,String papercontent,String wordnum,String state){
        Object userid;
        userid=session.getAttribute(WebSecurityConfig.SESSION_KEY);
        WritePaper writePaper=new WritePaper();
        Logger subpaper= LogUtils.getBussinessLogger();
        subpaper.info(userid+" 提交论文 "+chapter);
        System.out.println(chapter);
        System.out.println(papercontent);
        System.out.println(wordnum);
        Function f=new Function();
        List<WritePaper> contents=writePaperService.findStusNote((String)userid,chapter);
        if(contents.isEmpty()){
            writePaper.setChangetimes(0);
        }else {
            writePaper.setChangetimes(contents.get(contents.size()-1).getChangetimes()+1);
        }
        SimpleDateFormat af = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String endtime=af.format(System.currentTimeMillis());
        writePaper.setChapter(chapter);
        writePaper.setChapterid(f.map.get(chapter));
        writePaper.setContent(papercontent);
        writePaper.setStuid((String)userid);
        writePaper.setTime(endtime);
        writePaper.setWordnum(wordnum);
        writePaper.setState(state);
        writePaperService.savecontent(writePaper);
        return (String)userid;
    }
}
