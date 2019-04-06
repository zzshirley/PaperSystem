package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 20190324 上午9:43
 * @description 给同伴的意见
 */
@Entity
public class PartnerOpt {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name = "stuid")
    private String stuid;

    //他的伙伴
    @Column(name="partner")
    private String partner;

    //他的伙伴名字
    @Column(name="pname")
    private String pname;

    //章节
    @Column(name = "chapter")
    private String chapter;

    //意见面向
    @Column(name = "opt")
    private String opt;

    //意见内容
    @Column(name = "optcontent")
    private String optcontent;

    //意见状态
    @Column(name = "state")
    private String state;

    //他自己的名字
    @Column(name = "myname")
    private String myname;

    public PartnerOpt() {
    }

    public PartnerOpt(String stuid, String partner, String pname, String chapter, String opt, String optcontent,String state,String myname) {
        this.stuid = stuid;
        this.partner = partner;
        this.pname = pname;
        this.chapter = chapter;
        this.opt = opt;
        this.optcontent = optcontent;
        this.state = state;
        this.myname = myname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getOptcontent() {
        return optcontent;
    }

    public void setOptcontent(String optcontent) {
        this.optcontent = optcontent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }
}
