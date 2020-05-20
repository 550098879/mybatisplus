package org.zyx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {

    WORK(1,"上班"),
    REST(2,"下班"),
    ;

    @EnumValue
    Integer status;

    String msg;
    StatusEnum(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
