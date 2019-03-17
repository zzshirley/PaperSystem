package com.papersystem.demo.repo;

import com.papersystem.demo.bean.PaperInfo;
import com.papersystem.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 下午2:36
 * @description 会议信息仓库
 */
@Repository
public interface PaperInfoRepo extends JpaRepository<PaperInfo, String> {

    List<PaperInfo> findByStuid(String stuid);

    List<PaperInfo> findAll();

    List<PaperInfo> findByName(String meetingname);

}
