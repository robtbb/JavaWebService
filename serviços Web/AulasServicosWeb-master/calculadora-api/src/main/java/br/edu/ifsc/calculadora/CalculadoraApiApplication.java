package br.edu.ifsc.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApiApplication.class, args);
	}

}

/**
 * EXEMPLO DO USO DE PATHVARIABLE que no caso é apenas uma
 * maneira mais simples para estar estruturando os andpoints
 * afim de fazer nossas requisições de maneira mais simples
 *
 * antes ao criar um endpoint a gente apenas marcava o ponto
 * de acesso ao endpoint tendo assim que se preocupar en por
 * as variaveis a reserm usadas e por valores pra elas
 *
 * ex:
 *
 * @GetMapping("curso")
 * public String cadastroCurso(@RequestParam(value="id") Long id,
 * 							   @RequestParam(value="nome") String nome){
 *
 * 	return new curso(id, nome); *
 * }
 *
 * e com isso a gente teria que fazer a requisição no navegador da
 * seguinte forma *** localhost:8080/curso?id=1 & nome=engenharia
 *
 * entretanto o sistema pathvariable tira essa necessidade de por
 * as variaveis e atribuir os valores da seguinte forma que d
 * codigo esta a mostrar
 *
 */