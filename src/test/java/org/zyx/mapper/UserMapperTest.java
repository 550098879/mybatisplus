package org.zyx.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zyx.entity.User;
import org.zyx.enums.AgeEnum;
import org.zyx.enums.StatusEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 单元测试
 * Created by SunShine on 2020/5/19.
 */
@SpringBootTest
        //相当于启动整个ioc容器
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void selectAll() {
//        添加@TableLogic注解后,select语句会添加条件  where deleted = 0
        userMapper.selectList(null).forEach(System.out::println);
    }


    @Test
    void save() {
        User user = new User();
        user.setName("张三");
        user.setAge(AgeEnum.THREE);
        userMapper.insert(user);
        /*
         * 主键生成策略为AUTO/ASSIGN_ID/NONE/ASSIGN_UUID时,插入完成后会自动将id值返回到user中
         * 插入完成后,会将值自动返回到user对象中(省去id的获取)
         * 手动赋值依然使用数据库自增的方式
         */
        System.out.println(user);
    }

    @Test
    void update() {

        //验证乐观锁的步骤
        User user1 = userMapper.selectById(1006);
        user1.setName("一号");
        User user2 = userMapper.selectById(1006);
        user2.setName("二号");
        //UPDATE user SET ... version=2 WHERE id=1006 AND version=1
        userMapper.updateById(user2);
        //UPDATE user SET ... version=2 WHERE id=1006 AND version=1
        userMapper.updateById(user1);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age","15");
        user1.setStatus(StatusEnum.REST);
        userMapper.update(user1,wrapper);




    }

    @Test
    void delete() {
        /** 删除操作
         * 1.deleteById(),
         * 2.deleteBatchIds(Arrays.asList(val1,val2)) ,根据集合删除
         * 3.delete(wrapper);通过wrapper添加条件
         * 4.deleteByMap();将条件放入map中
         */
//        userMapper.deleteById(1007);
//        userMapper.deleteBatchIds(Arrays.asList(1001,1002));
        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("name","李四");

        Map<String,Object> map = new HashMap<>();
        map.put("age","1");
        userMapper.deleteByMap(map);

    }

    @Test
    void selectList() {
        // userMapper.selectList(null);//不加条件,全部查询 ,返回对象集合

        /** QueryWrapper:类似mybatis逆向生成的Example
         * 1.eq :单条件 eq(column,value); 等于   / ne : 不等于<>
         * 2.allEq:多条件,参数为map集合
         * 3.lt(less than) 小于  lt(column,val) 查询字段小于val的数据, (gt[great than]是大于)
         * 4.ge: 大于等于  / le 小于等于
         * 5.like: 模糊查询 %val%  ; likeLeft: %val 以val结尾; likeRight : val% ; 以val开头
         * 6.inSql: 联合查询 (column,"sql条件语句")  --重点
         * 7.orderByAsc: 升序(小到大),  orderByDesc: 降序(大到小)
         * 8.having: 直接添加条件
         */
        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("name","张三");//column=val
//        userMapper.selectList(wrapper);

//        wrapper.lt("age",10);

//        Map<String,String> map = new HashMap<>();
//        map.put("age","1");
//        map.put("name","张三");
//        wrapper.allEq(map);

//        wrapper.like("name","张");

//        wrapper.inSql("id","select id from user where id >10");
//        wrapper.inSql("age","select age from user where age > 3");

        wrapper.orderByAsc("age");
        wrapper.having("id < 10");

        userMapper.selectList(wrapper).forEach(System.out::println);

    }

    @Test
    void selectBy() {
        /** 1.selectById() ,根据主键id查询
         *  2.selectBatchIds(集合) 根据多个id查询 ,快速创建ArrayList: Arrays.asList(1,2,3)
         *  3.selectByMap(map),以map作为条件,map只能做等值判断,   /逻辑判断,需要使用 Wrapper 来处理
         *  4.selectCount(wrapper) 需要使用Wrapper添加条件
         *  5.selectMaps 将查询的结果集封装到Map中
         *  6.selectPage();分页查询,(逻辑处理)
         *      1)在MyBatisPlusConfig配置类中添加一个 Bean
         *      2) Page<User> page = new Page<>(1,5); 当前页,每页个数
         *         Page<User> result = userMapper.selectPage(page, null);
         *      3)result中包含分页中所需要的数据
         *  7.selectMapsPage();将结果集封装到map中
         *  8.selectObjs():返回object对象,对象中存储所有的id(主键)集合
         *  9.selectOne();返回一条数据,查询的必须只有一条数据
         *
         */
//        System.out.println(userMapper.selectById(1002));
//        userMapper.selectBatchIds(Arrays.asList(1,2,3)).forEach(System.out::println);

//        Map<String,Object> map = new HashMap<>();
//        map.put("age","1");
//        map.put("name","张三");
//        userMapper.selectByMap(map);

        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.ge("id", 1);
//        System.out.println(userMapper.selectCount(wrapper));

//        userMapper.selectMaps(wrapper).forEach(System.out::println);

//        //分页查询(类似PageData,包含分页所需的所有信息)
//        Page<User> page = new Page<>(2,5);
//        Page<User> result = userMapper.selectPage(page, null);//条件
//        System.out.println("每页个数:"+result.getSize());
//        System.out.println("总数(wrapper所查总数):"+result.getTotal());
//        //结果
//        result.getRecords().forEach(System.out::println);

//        Page<Map<String,Object>> mapPage = new Page<Map<String, Object>>(3,5);
//        userMapper.selectMapsPage(mapPage,null).getRecords();

//        userMapper.selectObjs(null).forEach(System.out::println);
        wrapper.eq("id",1);
        System.out.println(userMapper.selectOne(wrapper));

    }

    /**
     * 多表关联查询:自定义sql语句,使用注解式sql语句快速完成
     *      定义VO,只设置需要的属性
     * 1.在userMapper中新增方法,添加注解,将sql语句放入执行即可
     * 2.注意参数和泛型即可
     *
     * DTO  和 VO 的区别
     *  1.DTO : Data to Object, 业务层,针对数据库
     *  2.VO : view Object ,视图层,针对前端数据
     */
    @Test
    void productVO(){
        userMapper.productVOList(1).forEach(System.out::println);
    }




}