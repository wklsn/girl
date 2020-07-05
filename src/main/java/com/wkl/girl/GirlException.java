package com.wkl.girl;

public class GirlException extends  Exception {

    private ResultEnum resultEnum;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
