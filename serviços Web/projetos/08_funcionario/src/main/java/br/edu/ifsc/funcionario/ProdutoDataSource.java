package br.edu.ifsc.funcionario;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataSource {

	private static List<Funcionario> listaProdutos = new ArrayList<>();
	
	public static void criarLista() {
		
		//MOCK DE DADOS - dados fictícios para teste de aplicação
		
		listaProdutos.add(new Funcionario(1, "Tenis", 10, 120.0, 30));
		listaProdutos.add(new Funcionario(2, "Sapato", 50, 200.0, 10));
		listaProdutos.add(new Funcionario(3, "Calça", 4, 125.0, 20));
		listaProdutos.add(new Funcionario(4, "Casaco", 33, 128.0, 30));
		listaProdutos.add(new Funcionario(5, "Camiseta", 12, 123.0, 5));
	}
	
	public static List<Funcionario> getListaProdutos() {
		return listaProdutos;
	}
	
	public static void novo(Funcionario produto) {
		listaProdutos.add(produto);
	}
	
	public static void adicionar(Funcionario produto) {
		listaProdutos.add(produto);
	}
	
	public static Funcionario getPorId(int id) {
		for (Funcionario produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
	
	public static List<FuncinarioDTO> getListaProdutosDTO() {
		List<FuncinarioDTO> resultado = new ArrayList<>();
		for (Funcionario produto: listaProdutos) {
			FuncinarioDTO produtoDTO = new FuncinarioDTO(produto.getNome(), produto.calcularPrecoVenda());
			resultado.add(produtoDTO);
		}
		
		return resultado;
	}
	
	public static FuncinarioDTO calcularPrecoVendaDTO(int id) {
		FuncinarioDTO produtoDTO = null;
		for (Funcionario produto : listaProdutos) {
			if (produto.getId() == id) {
				produtoDTO = new FuncinarioDTO(produto.getNome(), produto.calcularPrecoVenda());
				return produtoDTO;
			}
		}
		produtoDTO = new FuncinarioDTO("Não encontrado", 0.0);
		return produtoDTO;
	}
	
}
