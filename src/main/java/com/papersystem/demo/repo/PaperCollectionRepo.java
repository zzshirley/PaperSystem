package com.papersystem.demo.repo;

import com.papersystem.demo.bean.PaperCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019306 下午3:27
 * @description 文献收集
 */
@Repository
public interface PaperCollectionRepo extends JpaRepository<PaperCollection,String> {

    List<PaperCollection> findAll();
}
