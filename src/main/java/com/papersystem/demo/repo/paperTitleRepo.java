package com.papersystem.demo.repo;

import com.papersystem.demo.bean.Papertitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190318 下午8:53
 * @description 文章标题
 */
@Repository
public interface paperTitleRepo extends JpaRepository<Papertitle,String> {

    List<Papertitle> findByStuid(String stuid);
}
