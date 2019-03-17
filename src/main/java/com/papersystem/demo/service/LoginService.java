package com.papersystem.demo.service;


import com.papersystem.demo.bean.User;
import com.papersystem.demo.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaotong
 * @Date
 */
@Service
public class LoginService {

    @Autowired
    private LoginRepo loginrepo;

    public boolean verifyLogin(User user) {

        List<User> userList = loginrepo.findByStuidAndPassword(user.getStuid(), user.getPassword());

        return userList.size() > 0;
    }
    public boolean RegisterLogin(String usrid) {

        List<User> users = loginrepo.findByStuid(usrid);

        return users.size() > 0;
    }

    public String stuname(String stuid){

        List<User> users=loginrepo.findByStuid(stuid);

        String name=users.get(0).getStuname();

        return name;
    }

    public void register(User user){
        loginrepo.save(user);
    }
}
