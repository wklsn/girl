package com.wkl.girl;

public enum  ResultEnum {
    GirAgeMiddle("101", "未满25周岁"),
    GirAgeOld("102", "大于60周岁"),
    ;
    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
