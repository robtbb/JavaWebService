package br.edu.ifsc.funcionario;

import lombok.Data;


public class Funcionario {


	private int matricula;
	private String nome;
	private Double salarioBase;
	private int numeroDependentes;

	public Funcionario() {}

	// Constructor with parameters
	public Funcionario(int matricula, String nome, Double salarioBase, int numeroDependentes) {
		this.matricula = matricula;
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.numeroDependentes = numeroDependentes;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}
}
