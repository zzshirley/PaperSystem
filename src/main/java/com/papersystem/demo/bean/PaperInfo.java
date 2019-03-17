package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019228 下午2:26
 * @description 论文投稿信息，会议/期刊
 */
@Entity
public class PaperInfo {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //发布信息者
    @Column(name = "stuid")
    private String stuid;

    //会议名称
    @Column(name="name")
    private String name;

    //截稿时间
    @Column(name="end_date")
    private String end_date;

    //语言类别 0-中文 1-英文
    @Column(name="language")
    private String language;

    //会议等级 0-SCI,1-SSCI,2-EI,3-国内一般会议，4-国内核心
    @Column(name="grade")
    private String grade;

    @Column(name="url")
    private String url;

    public PaperInfo(){

    }

    public PaperInfo(String stuid, String name, String end_date, String language, String grade,String url) {
        this.stuid = stuid;
        this.name = name;
        this.end_date = end_date;
        this.language = language;
        this.grade = grade;
        this.url=url;
    }
    public PaperInfo(String stuid, String name, String end_date, String language, String grade) {
        this.stuid = stuid;
        this.name = name;
        this.end_date = end_date;
        this.language = language;
        this.grade = grade;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
