package org.example.boot304accessright;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.boot304accessright.mapper")
public class Boot304AccessRightApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot304AccessRightApplication.class, args);
	}

}
