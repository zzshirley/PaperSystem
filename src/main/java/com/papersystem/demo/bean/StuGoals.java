package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019201 下午5:37
 * @description 学生选择某一会议作为目标
 */
@Entity
public class StuGoals {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //选择的会议
    @Column(name = "meetingid")
    private String meetingid;

    //会议的名称
    @Column(name = "meetingname")
    private String meetingname;

    //学生的学号
    @Column(name="stuid")
    private String stuid;

    public StuGoals() {
    }

    public StuGoals(String meetingid, String meetingname, String stuid) {
        this.meetingid = meetingid;
        this.meetingname = meetingname;
        this.stuid = stuid;
    }
    public StuGoals( int id, String stuid) {
        this.id = id;
        this.stuid = stuid;
    }
    public StuGoals( String meetingname, String stuid) {
        this.meetingname = meetingname;
        this.stuid = stuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid;
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
}
