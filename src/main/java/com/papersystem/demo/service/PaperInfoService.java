package com.papersystem.demo.service;

import com.papersystem.demo.bean.Goal;
import com.papersystem.demo.bean.PaperInfo;
import com.papersystem.demo.repo.PaperInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019228 下午2:41
 * @description 获取会议信息
 */

@Service
public class PaperInfoService {

    @Autowired
    private PaperInfoRepo paperInfoRepo;

    public List<PaperInfo> findPaperIfo(String stuid){

        List<PaperInfo> paperInfos=paperInfoRepo.findByStuid(stuid);

        return paperInfos;
    }

    public List<PaperInfo> findAllInfo(){

        List<PaperInfo> paperInfoList=paperInfoRepo.findAll();

        return paperInfoList;
    }

    public void addinfo(PaperInfo paperInfo){
        paperInfoRepo.save(paperInfo);
    }

    public boolean judgemeeting(String name){

        List<PaperInfo>  paperInfos=paperInfoRepo.findByName(name);

        return paperInfos.size()>0;
    }

}
