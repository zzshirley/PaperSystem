package com.papersystem.demo.bean;

import javax.persistence.Column;

/**
 * @author Xiaotong
 * @createTime 20190406 下午3:55
 * @description 检查学生
 */
public class Inspection {

    //目标设定的学生学号
    private String stuid;

    //目标设定的学生学号
    private String stuname;

    //摘要
    private String chp0;

    //引言
    private String chp1;

    //相关研究
    private String chp2;

    //研究主体
    private String chp3;

    //研究方法
    private String chp4;

    //研究结果
    private String chp5;

    //结论
    private String chp6;

    //讨论
    private String chp7;

    //笔记
    public String ntnum;

    public Inspection() {
    }

    public Inspection(String stuid, String chp0, String chp1, String chp2, String chp3, String chp4, String chp5, String chp6, String chp7, String notesnum) {
        this.stuid = stuid;
        this.chp0 = chp0;
        this.chp1 = chp1;
        this.chp2 = chp2;
        this.chp3 = chp3;
        this.chp4 = chp4;
        this.chp5 = chp5;
        this.chp6 = chp6;
        this.chp7 = chp7;
        this.ntnum = notesnum;
    }

    public Inspection(String stuid, String stuname, String chp0, String chp1, String chp2, String chp3, String chp4, String chp5, String chp6, String chp7, String ntnum) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.chp0 = chp0;
        this.chp1 = chp1;
        this.chp2 = chp2;
        this.chp3 = chp3;
        this.chp4 = chp4;
        this.chp5 = chp5;
        this.chp6 = chp6;
        this.chp7 = chp7;
        this.ntnum = ntnum;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getChp0() {
        return chp0;
    }

    public void setChp0(String chp0) {
        this.chp0 = chp0;
    }

    public String getChp1() {
        return chp1;
    }

    public void setChp1(String chp1) {
        this.chp1 = chp1;
    }

    public String getChp2() {
        return chp2;
    }

    public void setChp2(String chp2) {
        this.chp2 = chp2;
    }

    public String getChp3() {
        return chp3;
    }

    public void setChp3(String chp3) {
        this.chp3 = chp3;
    }

    public String getChp4() {
        return chp4;
    }

    public void setChp4(String chp4) {
        this.chp4 = chp4;
    }

    public String getChp5() {
        return chp5;
    }

    public void setChp5(String chp5) {
        this.chp5 = chp5;
    }

    public String getChp6() {
        return chp6;
    }

    public void setChp6(String chp6) {
        this.chp6 = chp6;
    }

    public String getChp7() {
        return chp7;
    }

    public void setChp7(String chp7) {
        this.chp7 = chp7;
    }

    public String getNtnum() {
        return ntnum;
    }

    public void setNtnum(String ntnum) {
        this.ntnum = ntnum;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
}
