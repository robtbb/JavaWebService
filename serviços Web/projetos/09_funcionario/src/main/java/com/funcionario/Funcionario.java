package com.funcionario;


import lombok.Data;

@Data
public class Funcionario {

    private int matricula;
    private String nome;
    private double salarioBase;
    private int numeroDependentes;

    public Funcionario(int matricula, String nome, double salarioBase, int numeroDependentes) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.numeroDependentes = numeroDependentes;
    }

    public double calcularSalarioLiquido(){
        return salarioBase * matricula;
    }
}
