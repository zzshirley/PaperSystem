package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Selfeva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190319 下午2:46
 * @description 自我评价
 */
@Repository
public interface SelfevaRepo extends JpaRepository<Selfeva,String> {

    List<Selfeva> findByStuidAndChapter(String stuid,String chapter);
    List<Selfeva> findByStuidAndCid(String stuid,String cid);
    List<Selfeva> findByStuid(String stuid);
}
