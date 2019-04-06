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

    public int page(String partner,String state) {
        return partneroptRepo.countAllByPartnerAndState(partner,state);
    }
    public List<PartnerOpt> findOptByState(String partner, String state) {
      //  Pageable pageable = new PageRequest(0,page-1,Direction.DESC,"stuid");

        return partneroptRepo.findByPartnerAndState(partner,state);
    }
    public PartnerOpt findByid(int id) {
        return partneroptRepo.findById(id).get(0);
    }
}
