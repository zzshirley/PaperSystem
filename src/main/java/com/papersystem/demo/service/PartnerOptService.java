package com.papersystem.demo.service;

import com.papersystem.demo.bean.PartnerOpt;
import com.papersystem.demo.repo.PartneroptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort.Direction;
import java.util.List;

/**
 * @author Xiaotong
 * @createTime 20190324 上午9:59
 * @description 伙伴评价
 */
@Service
public class PartnerOptService {

    @Autowired
    PartneroptRepo partneroptRepo;

    public void saveOpt(PartnerOpt partnerOpt){

        partneroptRepo.save(partnerOpt);
    }

    public List findOpt(String stuid){

        return partneroptRepo.findByStuid(stuid);
    }

    public void delOpt(int id){
        partneroptRepo.delete(id);
    }

    public List findMyACopt(String partner,String chapter) {
        return partneroptRepo.findByPartnerAndChapter(partner,chapter);
    }
    public List<PartnerOpt> findOptByState(String partner, String state,String chapter) {
        return partneroptRepo.findByPartnerAndStateAndChapter(partner,state,chapter);
    }
    public PartnerOpt findByid(int id) {

        return partneroptRepo.findById(id).get(0);
    }

    public int optlength( String partner,String state,String chapter) {

        List<PartnerOpt> partnerOptList = partneroptRepo.findByPartnerAndStateAndChapter(partner,state,chapter);
        int len = partnerOptList.isEmpty() ? 0 : partnerOptList.size();
        return len;
    }
}
