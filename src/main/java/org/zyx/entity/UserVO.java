package org.zyx.entity;

import lombok.Data;

/**
 * VO :将前端需要的数据从实体类中单独去出来,成为一个独立的实体类
 */
@Data
public class UserVO {
    private Long userId;
    private String priductName;
    private String userName;
    private Double price;
}
