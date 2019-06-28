package com.papersystem.demo.service;

import com.papersystem.demo.bean.paperNote;
import com.papersystem.demo.repo.paperNoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 11 下午3:44
 * @description
 */
@Service
public class paperNoteService {

    @Autowired
    paperNoteRepo paperNoteRepo;

    public void savenote(paperNote paperNote){
         paperNoteRepo.save(paperNote);
    }

    public List<paperNote> papernote(String stuid){

        List<paperNote> paperNotes=paperNoteRepo.findByStuid(stuid);
        return paperNotes;
    }

    public void delnote(int id){
        paperNoteRepo.delete(id);
    }

    public int numNote(String stuid) {

        return paperNoteRepo.countByStuid(stuid);
    }
}
