package com.papersystem.demo.repo;

import com.papersystem.demo.bean.PartnerOpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190324 上午9:58
 * @description 同伴评论
 */
@Repository
public interface PartneroptRepo extends JpaRepository<PartnerOpt,Integer> , JpaSpecificationExecutor<PartnerOpt> ,Serializable{

    @Modifying
    @Transactional
    @Query("delete from PartnerOpt where id = ?1")
    void delete(Integer id);
    List<PartnerOpt> findByStuid(String stuid);
    List<PartnerOpt> findByPartnerAndChapter(String partner,String chapter);

    List<PartnerOpt> findById(int id);
    List<PartnerOpt> findByPartnerAndState(String partner,String state);
    List<PartnerOpt> findByPartnerAndStateAndChapter(String partner,String state,String chapter);

    int countByStuid(String stuid);
    int countByPartner(String pid);
}
