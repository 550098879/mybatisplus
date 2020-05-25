package org.zyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//可以扫多个包,但是出现同名类会存在冲突,需要修改
@MapperScan({"org.zyx.mapper","org.zyx.generator.mapper"})  //启动类需要添加@MapperScan("mapper所在的包,否则无法加载mapper bean")
public class MybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusApplication.class, args);
	}

}
