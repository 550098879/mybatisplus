package org.zyx.entity;

import lombok.Data;

@Data
public class ProductVO {

    private Long id;
    private Integer count;
    private String description;
    private Long userId;
    private String userName;

}
