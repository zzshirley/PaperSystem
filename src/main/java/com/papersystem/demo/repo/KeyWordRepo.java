package com.papersystem.demo.repo;

import com.papersystem.demo.bean.KeyWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019203 下午7:45
 * @description 关键词仓库
 */
@Repository
public interface KeyWordRepo extends JpaRepository<KeyWords,String> {

    @Modifying
    @Transactional
    @Query("delete from KeyWords where id = ?1")
    void delete(Integer id);

    List<KeyWords> findByStuidAndLang(String stuid,String lang);
    List<KeyWords> findByStuidAndWord1(String stuid,String word);
    List<KeyWords> findByStuid(String stuid);


}
