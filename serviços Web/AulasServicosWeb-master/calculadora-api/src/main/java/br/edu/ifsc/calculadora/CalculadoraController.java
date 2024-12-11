package br.edu.ifsc.calculadora;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

	//perceba aquilo que ja foi expecificado no arquivo principal
	//temos o ponto de acesso a esse andpoint que nome caso é **somar**
	//e enseguida ja estamos expecificando quais variaveis iram ser
	//utilizadas para armazenas os valores passados na chamada dessa
	//requisição. Sendo assim no navegador fica

	// localhost:8080/somar/2/3    onde valor1=2 e valor2=3

	// logo ja inserimos os valores diretamente sem a necessidade de
	// expecificar qual é a variavel que vai receber os valores


	//anotações para orientação ao Framework Spring Boot
	@RequestMapping(value = "/somar/{opt1}/{opt2}", method = RequestMethod.GET)
	public Double somar(
			@PathVariable("opt1") Double valor1,
			@PathVariable("opt2") Double valor2) {
		return valor1 + valor2;
	}

	//qual a diferença de usar o tipo primitivo double e a classe Double
	//apenas que ao usar a classe Double se tem mais recursos

	//se eu não colocar method = RequestMethod.GET o sistema por padrão ja
	//define como GET

	
	@RequestMapping(value = "/subtrair/{valor1}/{valor2}", method = RequestMethod.GET)
	public Double subtrair(
			@PathVariable("valor1") Double v1,
			@PathVariable("valor2") Double v2) {
		return v1 - v2;
	}
	//perceba que não necessariamente a variavel que esta dentro do path precisa
	//ser igual a nossa variavel que esta no java, entretanto por
	//questão de boas prativas de prog é indicado deixar elas com o mesmo nome

	//sempre primeiro em se preocupar em fazer a logica dos probleas e depois
	//fazer as anotações dando as anotações adequadas a cada coisa



	@RequestMapping(value = "/multiplicar/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double multiplicar(
			@PathVariable("numero1") Double numero1,
			@PathVariable("numero") Double numero2){
		return numero1 * numero2;
	}

	@RequestMapping(value = "/dividir/{valor1}/{valor2}", method = RequestMethod.GET)
	public Double dividir(
			@PathVariable("valor1") Double valor1,
			@PathVariable("valor2") Double valor2){

		if (valor2 == 0){
			throw new IllegalArgumentException("O divisor não pode ser zero.");
		}
		return valor1/valor2;
	}


}
