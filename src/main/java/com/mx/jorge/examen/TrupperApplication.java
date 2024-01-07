package com.mx.jorge.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mx.jorge.examen.utils", "com.mx.jorge.examen"})
public class TrupperApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrupperApplication.class, args);
	}

}
