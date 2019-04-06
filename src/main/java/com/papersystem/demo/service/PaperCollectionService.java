package com.papersystem.demo.service;

import com.papersystem.demo.bean.PaperCollection;
import com.papersystem.demo.repo.PaperCollectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019306 下午3:28
 * @description 文献收集
 */
@Service
public class PaperCollectionService {

    @Autowired
    private PaperCollectionRepo paperCollectionRepo;

    public void saveCollection(PaperCollection paperCollection){

        paperCollectionRepo.save(paperCollection);
    }

    public List<PaperCollection> paperCollections(){

        List<PaperCollection> pc=paperCollectionRepo.findAll();

        return pc;
    }

    public List<PaperCollection> findpapersauthor(String papername){

        List<PaperCollection> pa=paperCollectionRepo.findByPapername(papername);
        return pa;
    }
}
