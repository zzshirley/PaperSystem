package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 20190318 上午9:30
 * @description 按章节写论文
 */
@Entity
public class WritePaper {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name="stuid")
    private String stuid;

    //章节
    @Column(name="chapter")
    private String chapter;

    //时间
    @Column(name="time")
    private String time;

    //内容
    @Column(name="content")
    private String content;

    //章节编号
    @Column(name="chapterid")
    private String chapterid;

    //版本次数
    @Column(name="changetimes")
    private int changetimes;

    //字数
    @Column(name="wordnum")
    private String wordnum;

    //带格式文本
    @Column(name="fomatcontent")
    private String fcontent;

    //状态 0-表示看笔记写的论文 1-表示看别人意见修改的论文
    @Column(name = "state")
    private String state;

    public WritePaper() {
    }

    public WritePaper(String stuid, String chapter, String time, String content, String chapterid, int changetimes) {
        this.stuid = stuid;
        this.chapter = chapter;
        this.time = time;
        this.content = content;
        this.chapterid = chapterid;
        this.changetimes = changetimes;
    }

    public WritePaper(String stuid, String chapter, String time, String content, String chapterid, int changetimes, String wordnum, String state) {
        this.stuid = stuid;
        this.chapter = chapter;
        this.time = time;
        this.content = content;
        this.chapterid = chapterid;
        this.changetimes = changetimes;
        this.wordnum = wordnum;
        this.state = state;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }

    public int getChangetimes() {
        return changetimes;
    }

    public void setChangetimes(int changetimes) {
        this.changetimes = changetimes;
    }

    public void setWordnum(String wordnum) {
        this.wordnum = wordnum;
    }

    public String getWordnum() {
        return wordnum;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
