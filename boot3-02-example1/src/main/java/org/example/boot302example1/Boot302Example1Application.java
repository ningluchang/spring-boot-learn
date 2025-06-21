package org.example.boot302example1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.boot302example1.mapper")
public class Boot302Example1Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot302Example1Application.class, args);
	}

}
