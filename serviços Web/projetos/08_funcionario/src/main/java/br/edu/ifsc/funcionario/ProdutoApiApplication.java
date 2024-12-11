package br.edu.ifsc.funcionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProdutoApiApplication {

	public static void main(String[] args) {
		
		FuncinarioDataSource.criarLista();
		
		SpringApplication.run(FuncionarioApiApplication.class, args);
	}

}
