package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019306 下午12:04
 * @description 学生搜集的论文信息
 */
@Entity
public class PaperCollection {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name = "stuid")
    private String stuid;

    //论文名称
    @Column(name="papername")
    private String papername;

    //论文作者
    @Column(name="author")
    private String author;

    //出版品
    @Column(name = "publication")
    private String  publication;

    //年份
    @Column(name = "year")
    private String year;

    //语言
    @Column(name="lang")
    private String lang;

    //百度学术被引量
    @Column(name = "cited")
    private String cited;

    //网址
    @Column(name = "paperurl")
    private String paperurl;

    public PaperCollection() {
    }

    public PaperCollection(String stuid, String papername, String author, String publication, String year, String lang, String cited, String paperurl) {
        this.stuid = stuid;
        this.papername = papername;
        this.author = author;
        this.publication = publication;
        this.year = year;
        this.lang = lang;
        this.cited = cited;
        this.paperurl = paperurl;
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

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCited() {
        return cited;
    }

    public void setCited(String cited) {
        this.cited = cited;
    }

    public String getPaperurl() {
        return paperurl;
    }

    public void setPaperurl(String paperurl) {
        this.paperurl = paperurl;
    }

    @Override
    public String toString() {
        return "PaperCollection{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", papername='" + papername + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", year='" + year + '\'' +
                ", lang='" + lang + '\'' +
                ", cited='" + cited + '\'' +
                ", paperurl='" + paperurl + '\'' +
                '}';
    }
}
