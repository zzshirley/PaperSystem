package com.papersystem.demo.repo;

import com.papersystem.demo.bean.paperNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 11 下午3:43
 * @description
 */
@Repository
public interface paperNoteRepo extends JpaRepository<paperNote,String> {

    @Modifying
    @Transactional
    @Query("delete from paperNote where id = ?1")
    void delete(Integer id);

    List<paperNote> findByStuid(String stuid);
    int countByStuid(String stuid);
}
