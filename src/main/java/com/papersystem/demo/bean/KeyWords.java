package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019203 下午4:49
 * @description 关键词实体
 */
@Entity
public class KeyWords {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name="stuid")
    private String stuid;

    //关键词1
    @Column(name="word1")
    private String word1;

    //语言
    @Column(name = "lang")
    private String lang;

    public KeyWords() {
    }

    public KeyWords(String stuid, String word1, String lang) {
        this.stuid = stuid;
        this.word1 = word1;
        this.lang = lang;
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

    public String getWord1() {
        return word1;
    }

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
