package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019204 下午8:29
 * @description 相关学者
 */
@Repository
public interface ScholarRepo extends JpaRepository<Scholar,String> {

    @Modifying
    @Transactional
    @Query("delete from Scholar where id = ?1")
    void delete(Integer id);

    List<Scholar> findByStuid(String stuid);
}
