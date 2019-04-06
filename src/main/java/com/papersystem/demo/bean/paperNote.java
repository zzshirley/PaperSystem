package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 20190307 上午10:25
 * @description 学生对文献做的笔记实体
 */
@Entity
public class paperNote {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name = "stuid")
    private String stuid;

    //论文编号
    @Column(name = "paperid")
    private String paperid;

    //文献评价 1-10分
    @Column(name = "grade")
    private String grade;

    //相关关键词
    @Column(name = "rkeyword")
    private String rkeyword;

    @Column(name = "selfhelp")
    private String selfhelp;

    @Column(name = "notetext")
    private String notetext;

    @Column(name = "paperauthor")
    private String paperauthor;

    public paperNote() {
    }

    public paperNote(String stuid, String paperid, String grade, String rkeyword, String selfhelp, String notetext) {
        this.stuid = stuid;
        this.paperid = paperid;
        this.grade = grade;
        this.rkeyword = rkeyword;
        this.selfhelp = selfhelp;
        this.notetext = notetext;
    }

    public paperNote(String stuid, String paperid, String grade, String rkeyword, String selfhelp, String notetext, String paperauthor) {
        this.stuid = stuid;
        this.paperid = paperid;
        this.grade = grade;
        this.rkeyword = rkeyword;
        this.selfhelp = selfhelp;
        this.notetext = notetext;
        this.paperauthor = paperauthor;
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

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRkeyword() {
        return rkeyword;
    }

    public void setRkeyword(String rkeyword) {
        this.rkeyword = rkeyword;
    }

    public String getSelfhelp() {
        return selfhelp;
    }

    public void setSelfhelp(String selfhelp) {
        this.selfhelp = selfhelp;
    }

    public String getNotetext() {
        return notetext;
    }

    public void setNotetext(String notetext) {
        this.notetext = notetext;
    }

    public String getPaperauthor() {
        return paperauthor;
    }

    public void setPaperauthor(String paperauthor) {
        this.paperauthor = paperauthor;
    }
}
