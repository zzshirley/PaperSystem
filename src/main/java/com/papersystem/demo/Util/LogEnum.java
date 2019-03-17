package com.papersystem.demo.Util;

/**
 * @author Xiaotong
 * @createTime 20181013 下午9:53
 * @description 本地日志枚举
 */
public enum LogEnum {

    BUSSINESS("bussiness"),

    PLATFORM("platform"),

    DB("db"),

    EXCEPTION("exception"),

    ;

    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
