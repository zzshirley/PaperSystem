package com.papersystem.demo.service;

import com.papersystem.demo.bean.WritePaper;
import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.repo.PaperCollectionRepo;
import com.papersystem.demo.repo.WritePaperRepo;
import com.papersystem.demo.repo.paperNoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190318 上午11:22
 * @description 连接学生笔记
 */
@Service
public class WritePaperService {


    @Autowired
    private WritePaperRepo writePaperRepo;


    public List findStusNote(String stuid,String chapter){

       List<WritePaper> wp= writePaperRepo.findByStuidAndChapter(stuid,chapter);

       return wp;
    }
    public void savecontent(WritePaper writePaper){
        writePaperRepo.save(writePaper);
    }

    public List<WritePaper> fulltext(String stuid){

        List<WritePaper> wps=new ArrayList<>();
        String[] s={"0","1","2","3","4","5","6","7","8"};
        for(int i=0;i<s.length;i++){
            List<WritePaper> wp=writePaperRepo.findByStuidAndChapterid(stuid,s[i]);
            if (wp.isEmpty()){
            }
            else {
                wps.add(wp.get(wp.size()-1));

            }
        }
        return wps;
    }

}
