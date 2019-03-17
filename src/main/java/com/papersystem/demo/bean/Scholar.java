package com.papersystem.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Xiaotong
 * @createTime 2019204 下午8:20
 * @description 学者信息
 */
@Entity
public class Scholar {

    //自增主键id
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    //学生学号
    @Column(name="stuid")
    private String stuid;

    //学者姓名
    @Column(name = "name")
    private String name;

    //学者学校
    @Column(name="school")
    private String school;

    //学者机构
    @Column(name="institution")
    private String institution;

    //学者主页
    @Column(name="url")
    private String url;

    //关键词
    @Column(name="keyword")
    private String keyword;

    public Scholar() {
    }

    public Scholar(String stuid, String name, String school, String institution) {
        this.stuid = stuid;
        this.name = name;
        this.school = school;
        this.institution = institution;
    }

    public Scholar(String stuid, String name, String school, String institution, String url, String keyword) {
        this.stuid = stuid;
        this.name = name;
        this.school = school;
        this.institution = institution;
        this.url = url;
        this.keyword = keyword;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
