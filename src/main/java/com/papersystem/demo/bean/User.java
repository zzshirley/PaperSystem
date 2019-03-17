package com.papersystem.demo.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Xiaotong
 * @createTime 2019227 下午7:02
 * @description 学生用户实体
 */

@Entity
public class User {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "stuid")
    private String stuid;

    @Column(name = "stuname")
    private String stuname;

    @Column(name = "password")
    private String password;

    //学生的性别 0是女孩，1是男孩
    @Column(name = "gender")
    private String gender;

    //专业 0-计算机应用技术，1-教育技术学，2-现代教育技术，3-软件工程，4-数据科学与大数据技术 5-教育信息技术
    @Column(name = "major")
    private int major;

    //注册日期
    @Column(name = "regdate")
    private String regdate;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", stuid='" + stuid + '\'' +
                ", stuname='" + stuname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", major=" + major +
                ", regdate=" + regdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getStuid() {
        return stuid;
    }

    public void setStuid(@NotNull String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
