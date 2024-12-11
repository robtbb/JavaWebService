package com.mensagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MensagesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensagesApiApplication.class, args);
	}

}



// COMO FAZER AS CHAMADAS NO NAVEGADOR
// localhost:8080/curso?nome=Administracao

// localhost:<porta>/<nome da entidade/tabela> ? <variavel>=<valor>

// caso fosse mais de uma informação teriamos

//// localhost:8080/curso?nome=Administracao&hc=120