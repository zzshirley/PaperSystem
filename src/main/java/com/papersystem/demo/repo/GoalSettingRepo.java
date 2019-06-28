package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 下午9:38
 * @description 目标设定
 */
@Repository
public interface GoalSettingRepo extends JpaRepository<Goal,String> {

    @Modifying
    @Transactional
    @Query("delete from Goal where id = ?1")
    void delete(Integer id);

    List<Goal> findAllByStuidOrderByCode(String stuid);
    List<Goal> findByStuidAndCode(String stuid,String code);
}
