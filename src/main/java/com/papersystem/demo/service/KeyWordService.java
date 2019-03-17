package com.papersystem.demo.service;

import com.papersystem.demo.bean.KeyWords;
import com.papersystem.demo.repo.KeyWordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaotong
 * @createTime 2019203 下午7:47
 * @description 关键词
 */
@Service
public class KeyWordService {

    @Autowired
    KeyWordRepo keyWordRepo;

    public void saveKeyWords(KeyWords keyWords){

        keyWordRepo.save(keyWords);
    }

    public List<KeyWords> getKeyWordsBylang(String usrid,String lang){

        List<KeyWords> keyWords=keyWordRepo.findByStuidAndLang(usrid,lang);

        return keyWords;
    }

    public boolean getKeyWordsByword(String usrid,String word){

        List<KeyWords> keyWords=keyWordRepo.findByStuidAndWord1(usrid,word);

        return keyWords.size()>0;
    }
    public List<KeyWords> getKeyWords(String usrid){

        List<KeyWords> keyWords=keyWordRepo.findByStuid(usrid);

        return keyWords;
    }

    public void delKeywords(int id) {

        keyWordRepo.delete(id);
    }
}
