package com.papersystem.demo.service;

import com.papersystem.demo.bean.StuGoals;
import com.papersystem.demo.repo.StuGoalsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019201 下午5:44
 * @description 获取学生选择的目标
 */
@Service
public class StuGoalsService {

    @Autowired
    private StuGoalsRepo stuGoalsRepo;

    public List<StuGoals> getStuGoals(String usrid){

        List<StuGoals> stuGoals=stuGoalsRepo.findByStuid(usrid);

        return stuGoals;
    }
    public boolean StuGoals(String name,String usrid){

        List<StuGoals> stuGoals=stuGoalsRepo.findByMeetingnameAndAndStuid(name,usrid);

        return stuGoals.size()>0;
    }

    public void SetGoals(StuGoals stuGoals){

        stuGoalsRepo.save(stuGoals);

    }
    public void Delgoals(int id){

        stuGoalsRepo.delete(id);
    }
}
