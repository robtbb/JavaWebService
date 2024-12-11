package com.funcionario;

public class FuncionarioDTO {

    private double salarioBruto;
    private double irps, inss;
    private double salarioLiquido;

    public FuncionarioDTO(double salarioBruto, double irps, double inss, double salarioLiquido) {
        this.salarioBruto = salarioBruto;
        this.irps = irps;
        this.inss = inss;
        this.salarioLiquido = salarioLiquido;
    }

    public double getSalarioBruto() {return salarioBruto;    }
    public void setSalarioBruto(double salarioBruto) {this.salarioBruto = salarioBruto;    }

    public double getIrps() {return irps;    }
    public void setIrps(double irps) {this.irps = irps;    }

    public double getInss() {return inss;    }
    public void setInss(double inss) {this.inss = inss;    }

    public double getSalarioLiquido() {return salarioLiquido;    }
    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
}

/*
ESSA CLASSSE  É RESPONSAVEL POR FAZER uma mascara nos dados
decidindo quais dados a pessoa que esta fazendo a requisição vai porder ser
pode ser o usuario por exemplo, não seria interessante meu usuario
ver o id do produto por exemplo, ou o codigo e verificaçao, então para isso
criamos uma claase para fazer um emcapsulamento das informações
e assim nos da uma saida mais segura dos dados.
 */
