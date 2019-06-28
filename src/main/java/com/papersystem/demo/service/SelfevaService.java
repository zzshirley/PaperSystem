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
    public double selfeva(String stuid) {

        double score = 0.00;
        int num = 0;
        List<Selfeva> selfevaList  = selfevaRepo.findByStuid(stuid);
        if (!selfevaList.isEmpty()) {
            for (Selfeva s:selfevaList) {
                if (s.getScore()!= null) {
                    score = score + Integer.valueOf(s.getScore());
                    num ++;
                }
            }
            score = score / num;
        }
        return score;
        /*String[] s={"0","1","2","3","4","5","6","7"};
        int num = 0;
        int score = 0;
        for (int i = 0; i < s.length;i++) {
            List<Selfeva> sv = selfevaRepo.findByStuidAndCid(stuid,s[i]);
            if (!sv.isEmpty()) {
                num++;
                score = score
            }
        }*/
    }
}
