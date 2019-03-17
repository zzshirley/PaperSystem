package com.papersystem.demo.service;

import com.papersystem.demo.bean.Scholar;
import com.papersystem.demo.repo.ScholarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019204 下午8:32
 * @description 相关学者
 */
@Service
public class ScholarService {

    @Autowired
    ScholarRepo scholarRepo;

    public List<Scholar> getScholar(String stuid){

        List<Scholar> scholars=scholarRepo.findByStuid(stuid);
        return scholars;
    }

    public void saveScholar(Scholar scholar){

        scholarRepo.save(scholar);
    }

    public void delScholar(int id){
        scholarRepo.delete(id);
    }
}
