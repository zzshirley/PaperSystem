package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Companion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190323 下午3:07
 * @description 伙伴
 */
@Repository
public interface CompanionRepo extends JpaRepository<Companion,String> {

    @Modifying
    @Transactional
    @Query("delete from Companion where id = ?1")
    void delete(Integer id);

    List<Companion> findByStuidAndPartner(String stuid,String partner);
    List<Companion> findByStuid(String stuid);
    List<Companion> findByPartner(String partner);
}
