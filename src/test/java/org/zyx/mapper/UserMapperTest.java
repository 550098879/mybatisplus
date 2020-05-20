package org.zyx.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zyx.entity.User;
import org.zyx.enums.AgeEnum;

/**单元测试
 * Created by SunShine on 2020/5/19.
 */
@SpringBootTest  //相当于启动整个ioc容器
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void select(){
        userMapper.selectList(null).forEach(System.out::println);
    }


    @Test
    void save(){
        User user = new User();
        user.setName("使用枚举类设置age测试");
        user.setAge(AgeEnum.THREE);
        userMapper.insert(user);
        /**
         * 主键生成策略为AUTO/ASSIGN_ID/NONE/ASSIGN_UUID时,插入完成后会自动将id值返回到user中
         * 插入完成后,会将值自动返回到user对象中(省去id的获取)
         * 手动赋值依然使用数据库自增的方式
         */
        System.out.println(user);
    }

    @Test
    void update(){
        User user1 = userMapper.selectById(1006);
        user1.setName("一号");
        User user2 = userMapper.selectById(1006);
        user2.setName("二号");

        //UPDATE user SET ... version=2 WHERE id=1006 AND version=1
        userMapper.updateById(user2);
        //UPDATE user SET ... version=2 WHERE id=1006 AND version=1
        userMapper.updateById(user1);


    }



}