package com.papersystem.demo.repo;


import com.papersystem.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaotong
 */
@Repository
public interface LoginRepo extends JpaRepository<User, String> {

    List<User> findByStuidAndPassword(String stuid, String password);
    List<User> findByStuid(String stuid);

}
