package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019228 下午9:11
 * @description 学生设定的目标实体
 */
@Entity
public class Goal {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //目标设定的学生学号
    @Column(name="stuid")
    private String stuid;

    //设置的日期
    @Column(name="date")
    private String date;

    //完成的章节
    @Column(name="chapter")
    private String chapter;

    //完成字数
    @Column(name="words")
    private String words;

    //编号
    @Column(name = "code")
    private String code;

    public Goal(){

    }

    public Goal(String date, String chapter, String words) {
        this.date = date;
        this.chapter = chapter;
        this.words = words;
    }

    public Goal(String stuid, String date, String chapter, String words) {
        this.stuid = stuid;
        this.date = date;
        this.chapter = chapter;
        this.words = words;
    }
    public Goal(int id,String stuid, String date, String chapter, String words) {
        this.id=id;
        this.stuid = stuid;
        this.date = date;
        this.chapter = chapter;
        this.words = words;
    }

    public Goal(String stuid, String date, String chapter, String words, String code) {
        this.stuid = stuid;
        this.date = date;
        this.chapter = chapter;
        this.words = words;
        this.code = code;
    }
    public Goal( int id,String stuid, String date, String chapter, String words, String code) {
        this.id=id;
        this.stuid = stuid;
        this.date = date;
        this.chapter = chapter;
        this.words = words;
        this.code = code;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
