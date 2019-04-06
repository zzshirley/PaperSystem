package com.papersystem.demo.service;

import com.papersystem.demo.bean.Papertitle;
import com.papersystem.demo.repo.paperTitleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190318 下午8:55
 * @description 文章标题
 */
@Service
public class paperTitleService {

    @Autowired
    paperTitleRepo paperTitleRepo;

    public void saveTitle(Papertitle papertitle){
        paperTitleRepo.save(papertitle);
    }

    public String findTitle(String stuid){

        List<Papertitle> pt=paperTitleRepo.findByStuid(stuid);
        if(pt.isEmpty()){
            return "nooooo";
        }else {
            return pt.get(pt.size()-1).getTitle();
        }
    }
}
