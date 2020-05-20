package org.zyx.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum AgeEnum implements IEnum<Integer> {

    ONE(1,"一岁"),
    TWO(2,"两岁"),
    THREE(3,"三岁"),
    ;
    Integer age;
    String msg;
    AgeEnum(Integer age, String msg){
        this.age = age;
        this.msg = msg;
    }
    @Override
    public Integer getValue() {
        return this.age;//返回age
    }
}
