package br.edu.ifsc.funcionario;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
	
	// objetos no formato JSON
	// declarações --> consumir / produzir
    @RequestMapping(value = "/novo_funcionario", method = RequestMethod.POST, 
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE)
	public Funcionario novo(@RequestBody Funcionario funcionario) {

		FuncinarioDataSource.novo(funcionario);
		return funcionario;
	}	

	@RequestMapping(value = "/funcionario/{id}/{nome}/{preco}/{quantidade}/{taxaLucro}",
			 method = RequestMethod.GET)
	public Funcionario criarFuncionario(
			@PathVariable("id") int id, 
			@PathVariable("nome") String nome, 
			@PathVariable("preco") double preco, 
			@PathVariable("quantidade") int quantidade, 
			@PathVariable("taxaLucro") int taxaLucro) {
		
	
		Funcionario funcionario = new Funcionario(id, nome, salarioBase, preco, d;
		
		FuncinarioDataSource.novo(funcionario);
		
		return funcionario;
	}
	
	@RequestMapping(value = "/preco_venda/{idx}")
	public double calcularPrecoVenda(
			@PathVariable("idx") int idx) {
		Funcionario funcionario = FuncinarioDataSource.getListaFuncionarios().get(idx);
		return funcionario.calcularSalarioLiquido();
	}
	
	
	@RequestMapping(value = "/funcionarios")
	public List<Funcionario> getFuncionarios() {
		return FuncinarioDataSource.getListaFuncionarios();
	}
	
	@RequestMapping(value = "/funcionarios_dto")
	public List<FuncinarioDTO> getFuncionarioDTO() {
		return FuncinarioDataSource.getListaFuncionariosDTO();
	}
	
	@RequestMapping(value = "/preco_venda_dto/{id}")
	public FuncinarioDTO getPrecoVendaDTO(
			@PathVariable("id") int id) {
		Funcionario funcionario = FuncinarioDataSource.getPorMatricula(id);
		FuncinarioDTO funcionarioDTO = new FuncinarioDTO(funcionario.getNome(), funcionario.calcularSalarioLiquido());
		
		return funcionarioDTO;
		
		//return FuncionarioDataSource.calcularPrecoVendaDTO(id);
	}
	
}
