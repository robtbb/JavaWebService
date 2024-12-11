package br.edu.ifsc.produto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

//	@RequestMapping(value = "/produto/{id}/{nome}/{preco}/{quantidade}/{taxaLucro}")
//	public Produto criarProduto(
//			@PathVariable("id") int id, 
//			@PathVariable("nome") String nome, 
//			@PathVariable("preco") double preco, 
//			@PathVariable("quantidade") int quantidade, 
//			@PathVariable("taxaLucro") int taxaLucro) {
//		
////		Produto produto = new Produto();
////		produto.setId(id);
////		produto.setNome(nome);
////		produto.setPreco(preco);
////		produto.setQuantidade(quantidade);
////		produto.setTaxaLucro(taxaLucro);
//		
//		Produto produto = new Produto(id, nome, quantidade, preco, taxaLucro);
//		
//		return produto;
//	}

	// A classe controle não é responsavel por fazer calculos ou logicas de problemas
	// a classe controller apenas recebe valores e os da para quem sabe manipular esses
	// dados da forma que a gente quer, feito isso ele recebe o valor e assim nos entrega
	// a resposta que ele recebeu
	
	@RequestMapping(value = "/produto/{id}/{nome}/{preco}/{quantidade}/{taxaLucro}", method = RequestMethod.GET)
	public double criarProduto(
			@PathVariable("id") int id, 
			@PathVariable("nome") String nome, 
			@PathVariable("preco") double preco, 
			@PathVariable("quantidade") int quantidade, 
			@PathVariable("taxaLucro") int taxaLucro) {
		Produto produto = new Produto(id, nome, quantidade, preco, taxaLucro);
		return produto.calcularPrecoVenda();
	}

	// parametros são dados de entrada então dados de saida são podem esta como parametro
	// como identificar um parametro ou dado de entrada, dados de entrada são dados
	// informações de um problema ou valores

	// ja os dados de saida é o resultado da manipulação desses dados um resposta
	// logo verificar sempre isso.

	//novamente quando a gente não define o nosso andpoint como method = RequestMethod.GET
	//o spring ja interpreta que esse endpoint é GET por padão

	@RequestMapping(value="/calcularTotal/{qtd}/{valorProduto}")
	public Double calcularValorTotal(
			@PathVariable("qtd") int qtd,
			@PathVariable("valorProduto")  Double valorUnitario){

		//perceba aqui então total minha variavel de saida
		Double total = qtd * valorUnitario;

		return total;

	}


}
