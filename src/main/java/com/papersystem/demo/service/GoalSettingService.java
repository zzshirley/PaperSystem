package com.papersystem.demo.service;

import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.repo.GoalSettingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019201 上午9:52
 * @description 目标设定/查询目标
 */
@Service
public class GoalSettingService {

    @Autowired
    private GoalSettingRepo goalSettingRepo;

    public List<Goal> findGoals(String stuid){

        List<Goal> goals=goalSettingRepo.findAllByStuidOrderByCode(stuid);
        return goals;
    }

    public void saveGoals(Goal goal){

        goalSettingRepo.save(goal);
    }

    public void delGoals(int id){

        goalSettingRepo.delete(id);
    }


}
