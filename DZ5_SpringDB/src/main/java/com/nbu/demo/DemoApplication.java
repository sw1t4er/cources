package com.nbu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// для хапуска:
	// в application.properties изменить: spring.jpa.hibernate.ddl-auto=create
	// права IDEA настроить БД, сделать тестовое соединения, соответсвенно изменить настройки в application.properties

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
