package org.zyx.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**单元测试
 * Created by SunShine on 2020/5/19.
 */
@SpringBootTest  //相当于启动整个ioc容器
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void test(){

        userMapper.selectList(null).forEach(System.out::println);

    }

}