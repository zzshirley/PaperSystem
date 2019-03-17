package com.papersystem.demo.repo;

import com.papersystem.demo.bean.StuGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019201 下午5:41
 * @description 学生选择的目标
 */

@Repository
public interface StuGoalsRepo extends JpaRepository<StuGoals,String> {

    @Modifying
    @Transactional
    @Query("delete from StuGoals where id = ?1")
    void delete(Integer id);

    List<StuGoals> findByStuid(String usrid);
    List<StuGoals> findByMeetingnameAndAndStuid(String name,String usrid);
}
