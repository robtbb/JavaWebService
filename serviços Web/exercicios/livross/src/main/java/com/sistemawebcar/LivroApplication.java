package com.sistemawebcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivroApplication {

	public static void main(String[] args) {

		LivroDataSource.criarLista();

		SpringApplication.run(LivroApplication.class, args);
	}

}
