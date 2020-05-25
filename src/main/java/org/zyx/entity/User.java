package org.zyx.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.zyx.enums.AgeEnum;
import org.zyx.enums.StatusEnum;

import java.util.Date;

/**
 * Created by SunShine on 2020/5/19.
 */

@Data
@TableName("user")   //映射数据库表名,推荐表名和字段名与数据库表相同
public class User {
    /**
     * @TableId type:生成策略  IdType枚举类
     *    1.AUTO :数据库自增,不需要赋值
     *    2.NONE(默认):mybatis plus set主键,雪花算法实现,需要保证主键的长度足够(20位以上)
     *    3.INPUT: 需要开发者手动赋值,如果为手动赋值,则数据库会通过对上一个主键值自增的方式赋值
     *    4.ASSIGN_ID:mybatis plus 分配ID,Long,Integer,String  自动赋值,和NONE类似
     *    5.ASSIGN_UUID:分配UUID,String   主键的类型必须是String,自动生成UUID进行赋值
     */
    @TableId(value="id",type = IdType.AUTO)  //映射主键,
    private Long id;

    @TableField("name")  //映射字段
    private String name;

    @TableField(value = "age")
    private AgeEnum age;

    /**@TableField
     *   1.value:映射数据表字段
     *   2.exist :默认是true,表示该字段为数据库字段,false:表示不需要映射该字段
     *   3.select: t/f 表示是否查询该字段
     *   4.fill 表示是否自动填充,将对象存入数据库的时候,由MyBatisPlus自动给某些字段赋值
     *      如创建时间,和更新时间
     *       FieldFill
     *       1)INSERT :插入时填充
     *       2)UPDATE :更新时填充
     *       3)INSERT_UPDATE:插入和更新时填充
     *       4)创建处理器帮助完成填充: MyMetaObjectHandler.java
     */
    @TableField(exist = false)  //忽略该属性
    private Product product;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * @Version 标记乐观锁 :通过version字段,保证数据的安全性,当修改数据时,
     * 会以version作为条件,当条件成立的时候才会修改成功.
     *             例子: version=1
     *  线程一: update  set version=version+1 where version = 1
     *  线程二: update  set version=version+1 where version = 1
     *
     *  多线程同时执行的时候,只要有一条语句执行成功了,那么其他线程就会执行失败
     *  1.需要在表中添加version字段,默认值为1
     *  2.实体类添加version成员变量,并且添加@Version注解
     *  3.注册配置类(MyBatisPlusConfig.java)
     *  4.version字段也是唯一的,自增机制,没执行一次就会增加一次(相同的sql语句只有一个会成立)
     */
    @Version
    private Long version;

    /**     枚举映射的两种方法
     *      一丶使用 @EnumValue 注解进行映射
     * @EnumValue 通用枚举类注解,将数据库字段映射成实体类的枚举类型成员变量
     *      1.数据库表新增状态status字段
     *      2.创建枚举类
     *      3.在需要映射的枚举变量上添加 @EnumValue 注解(数据类型需要相同)
     *      4.实体类添加该枚举类声明,且命名要与表字段相同/或者添加@TableField("status")
     *      5.在application.yml中配置扫描枚举类所在的包
     *         mybatis-plus:
     *           configuration:
     *              log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
     *
     *      二丶实现接口
     *      1.创建枚举类,实现 IEnum<Integer> 接口
     *      2.实现该接口的getValue方法,返回映射的字段
     *      3.实体类修改要映射的字段为枚举类声明
     *
     *      好处
     *      1.通过操作枚举类控制数据的范围,防止sql注入
     *      2.实现字段映射,将int类型的数据转为可视化数据
     *      3.如性别,状态,权限,通过枚举减少了数据的判断操作
     */
    @TableField("status")
    private StatusEnum status;


    /***
     * @TableLogic
     * 映射逻辑删除 (实质上执行的是更新操作)
     *  1.数据表添加deleted字段
     *  2.实体类添加注解
     *  3.在application.yml中添加配置
     *    mybatis-plus:
     *      global-config:
     *        db-config:
     *           logic-not-delete-value: 0   #0表示存在
     *           logic-delete-value: 1       #1表示删除
     */
    //@TableLogic
    private Integer deleted;


}
