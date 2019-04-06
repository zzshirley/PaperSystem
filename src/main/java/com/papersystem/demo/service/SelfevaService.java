package com.papersystem.demo.service;

import com.papersystem.demo.bean.Selfeva;
import com.papersystem.demo.repo.SelfevaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190319 下午2:48
 * @description 自我评价
 */
@Service
public class SelfevaService {

    @Autowired
    SelfevaRepo selfevaRepo;

    public void saveEva(Selfeva selfeva){

        selfevaRepo.save(selfeva);
    }

    public String findScore(String stuid,String chapter){

        List<Selfeva> selfevaList=selfevaRepo.findByStuidAndChapter(stuid,chapter);

        if(selfevaList.isEmpty()){
            return "暂无";
        }else {
            return selfevaList.get(selfevaList.size()-1).getScore();
        }
    }
}
