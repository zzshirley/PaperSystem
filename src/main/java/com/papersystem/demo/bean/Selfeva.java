package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 20190319 下午2:39
 * @description 自我评价
 */
@Entity
public class Selfeva {


    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name = "stuid")
    private String stuid;

    //章节
    @Column(name = "chapter")
    private String chapter;

    //章节代码
    @Column(name = "cid")
    private String cid;

    //分数
    @Column(name = "score")
    private String score;

    public Selfeva() {

    }

    public Selfeva(String stuid, String chapter, String cid) {
        this.stuid = stuid;
        this.chapter = chapter;
        this.cid = cid;
    }

    public Selfeva(String stuid, String chapter, String cid, String score) {
        this.stuid = stuid;
        this.chapter = chapter;
        this.cid = cid;
        this.score = score;
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
