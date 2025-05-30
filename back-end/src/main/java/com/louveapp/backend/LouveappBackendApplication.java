package com.louveapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LouveappBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LouveappBackendApplication.class, args);
		//String senhaCriptografada = new BCryptPasswordEncoder().encode("admin123");
        //System.out.println("essa é a senha" + senhaCriptografada );
    }
}
	
	
	


