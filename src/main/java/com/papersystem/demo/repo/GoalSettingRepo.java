package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 下午9:38
 * @description 目标设定
 */
@Repository
public interface GoalSettingRepo extends JpaRepository<Goal,String> {

    List<Goal> findAllByStuidOrderByCode(String stuid);
}
