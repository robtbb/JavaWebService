package br.edu.ifsc.produto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//identifica minha classe que é um controller
public class ProdutoController {

	//@RequestMapping aqui identificamos os ponto de acesso a esse metodo *calcularValorTotal*
	// que nesse caso é ***calcular_total**** e em sequida informamaos
	// variaveis que vão receber valores *quantidade* e *calorUnitario*

	// no navegador temos algo como

	// localhost:8080/calcular_total/2/50   onde 2 é a quantidade e 50 meu valor unitario

	//não necessariamente o nome dessas variaveis {quantidade}/{valoreUnitario} precise ser
	//igual ao que esta dentro do metodo em si *int quantidade* *Double valorUnitario* mas
	//por ordem é feito assim

	// method = ResquatMethod.GET define que nosso metodo é usado para requisições GET e por isso
	// posso usar os recurso para esse fim
	@RequestMapping(value = "/calcular_total/{quantidade}/{valorUnitario}", method = RequestMethod.GET)
	public Double calcularValorTotal(
			@PathVariable("quantidade") int quantidade, //@PathVariable identifica que quantidade é uma variavel e dentro esta como ela vai ser identificada no navegador quando formos azer a requisisção
			@PathVariable("valorUnitario") Double valorUnitario){

		//@PathVariable mapeia as variaveis que estaõ reservadas para o navegador e coloca dentro da variavel
		//que estamos usando dentro do java que nesse caso é int quantiade e double valorUnitario
		
		Double total = quantidade * valorUnitario;
		
		return total;
	}
	
	
	@RequestMapping(value = "/preco_venda/{preco}/{taxa}")
	public Double calcularPrecoVenda(
			@PathVariable("preco") double preco,
			@PathVariable("taxa") int taxa) {
		
		double precoVenda = calcularPrecoProduto(preco, taxa);
		
		return precoVenda;
	}
	
	private Double calcularPrecoProduto(double preco, int taxa) {
		return preco + (preco * taxa / 100);
	}
}


/*
    UMA BREVE BIZURADA aantes de implementar o spring controller primeiro a gente
    implementa a logica, os metodos que seram usando sem pensar nas requisições

    As classes com anotanão @RestController são responsaveis para definir andpoints
    mas oque são esses andpoints? São metodos responsaveis por fazer o mapeamento
    de entidades e atribuir valores, pegar valores da entidade ou coisa assim,
    não precisa ser uma entidade pode ser um documento html por exemplo

    mas eles fazem isso, não so pegam como tambem enviam dados e deletam dados

    Responsabilidade Principal:
Gerenciar e manipular requisições e respostas
 HTTP (como GET, POST, PUT, DELETE).
Cada método dentro de uma classe @RestController geralmente
        representa uma operação específica da API
        (como buscar dados, criar novos registros,
        atualizar ou deletar dados).


Endpoints RESTful:

Dentro de uma classe @RestController, você pode
definir múltiplos métodos mapeados para
diferentes endpoints usando anotações como
 @GetMapping, @PostMapping, @PutMapping e @DeleteMapping.


 */