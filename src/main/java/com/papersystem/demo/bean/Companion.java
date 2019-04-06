package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 20190323 下午1:05
 * @description 伙伴选择
 */
@Entity
public class Companion {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //选择伙伴的同学
    @Column(name="stuid")
    private String stuid;

    //他的伙伴
    @Column(name="partner")
    private String partner;

    //他的伙伴名字
    @Column(name="pname")
    private String pname;

    //时间
    @Column(name = "date")
    private String date;


    public Companion() {
    }

    public Companion(String stuid, String partner, String date) {
        this.stuid = stuid;
        this.partner = partner;
        this.date = date;
    }

    public Companion(String stuid, String partner, String pname, String date) {
        this.stuid = stuid;
        this.partner = partner;
        this.pname = pname;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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


}
