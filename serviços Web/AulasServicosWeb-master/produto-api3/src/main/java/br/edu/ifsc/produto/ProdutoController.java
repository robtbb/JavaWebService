package br.edu.ifsc.produto;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

	@RequestMapping(value = "/produto/{id}/{nome}/{preco}/{quantidade}/{taxaLucro}")
	public Produto criarProduto(
			@PathVariable("id") int id, 
			@PathVariable("nome") String nome, 
			@PathVariable("preco") double preco, 
			@PathVariable("quantidade") int quantidade, 
			@PathVariable("taxaLucro") int taxaLucro) {
		
	
		Produto produto = new Produto(id, nome, quantidade, preco, taxaLucro);
		produto.setNome(nome);
		
		ProdutoDataSource pds = new ProdutoDataSource(); 
		
		pds.novo(produto);
		
		ProdutoDataSource.novo(produto);
		
		return produto;
	}
	
	@RequestMapping(value = "/preco_venda/{idx}")
	public double calcularPrecoVenda(
			@PathVariable("idx") int idx) {
		Produto produto = ProdutoDataSource.getListaProdutos().get(idx);
		return produto.calcularPrecoVenda();
	}
	
	
	@RequestMapping(value = "/produtos")
	public List<Produto> getProdutos() {
		return ProdutoDataSource.getListaProdutos();
	}


	// eu poderia coloar **precoVenda...** Mas porque não fazer isso
	// para nome que estão sendo associado a um endpoint?
	// porque pode haver uma variavel com o mesmo nome e é de
	// costume por os nome de variaveis ou metodos dessa forma

	@RequestMapping(value = "/preco_venda/{preco}/{taxa}")
	public Double calcularPrecoVenda(
			@PathVariable("preco") double preco,
			@PathVariable("taxa") int taxa){
//então perceba que fazemos o andpoint para captar valores do navegador ou
// de um ambiente qualque, damos nomes as variaveis que vão armazenas os
		// valores que vem de fora e colocamos elas dentro das variaveis java
		// ao fazer isso jogamos os valores na nossa variavel java e ele manupula
		// as informações, vale lembrar mais uma vez que o controler nao é
		// responsavel por fazer logicas de problemas, mas ele entrega esses
		// dados que sao entregues a ele e os entrega a quem sabe manipular
		// transformando dados em valores e nos devolvendo o que queremos
		// como é feito aqui, os dados que vieram da nossa requisição são entregues
		// ao metodo calcularPrecoProduto e logo depois o controle retorna
		// o valor obtido, claro que isso aqui é um exemplo simples e que
		// em problemas mais completos esses metodos estaram em outros classes
		// que estaram em outros pacotes
		double precoVenda = calcularPrecoProduto(preco, taxa);


		// aqui dentro podemos por rotinas como estruturas
		// de deciões ou laços entretanto como ja foi dito
		// o controler é o cara que pega informações da a
		// quem sabe manipular os dados e nos retorna os
		// valores

		return precoVenda;
	}

	//implementando um metodo para suporte
	private Double calcularPrecoProduto(double preco, int taxa){
		return preco + (preco * taxa/100);
	}




}
