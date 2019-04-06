package com.papersystem.demo.repo;

import com.papersystem.demo.bean.WritePaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190318 上午11:00
 * @description
 */
@Repository
public interface WritePaperRepo extends JpaRepository<WritePaper,String> {

    List<WritePaper> findByStuidOrderByChapterid(String stuid);
    List<WritePaper> findByStuidAndChapter(String stuid,String chapter);
    List<WritePaper> findByStuidAndChapterid(String stuid,String chapterid);

}
