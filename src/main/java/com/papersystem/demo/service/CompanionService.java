package com.papersystem.demo.service;

import com.papersystem.demo.bean.Companion;
import com.papersystem.demo.bean.User;
import com.papersystem.demo.repo.CompanionRepo;
import com.papersystem.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190323 上午10:21
 * @description 伙伴选择
 */
@Service
public class CompanionService {

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    CompanionRepo companionRepo;

    public List<User> stulist(){

        List<User> users=loginRepo.findAllByOrderById();
        return users;
    }

    public boolean havePartner(String stuid,String partner){

        List<Companion> cp=companionRepo.findByStuidAndPartner(stuid,partner);

        return cp.size()>0;
    }

    public void savepartner(Companion cp){

        companionRepo.save(cp);
    }

    public String findName(String stuid){

        List<User> users=loginRepo.findByStuid(stuid);

        return users.get(0).getStuname();
    }

    public List findPartner(String stuid){
        return companionRepo.findByPartner(stuid);
    }

    public void delCompanion(int id){
        companionRepo.delete(id);
    }
}
