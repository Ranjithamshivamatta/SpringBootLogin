package com.bridgelabz.fundonoteapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FundoNoteApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(FundoNoteApp2Application.class, args);
	}

}
