package org.zyx.generator.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zyx.generator.mapper.TAccountMapper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TAccountTest {

    @Autowired
    private TAccountMapper tAccountMapper;

    @Test
    void test(){
        tAccountMapper.selectList(null).forEach(System.out::println);
    }


}