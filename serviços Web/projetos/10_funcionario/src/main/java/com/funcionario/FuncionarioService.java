package com.funcionario;


public class FuncionarioService {


    public FuncionarioDTO calcularSalarioLiquido(Double salarioBruto) {
        double salarioBase = salarioBruto;
        double descontoINSS = calcularINSS(salarioBase);
        double descontoIRPF = calcularIRPF(salarioBase - descontoINSS);
double salarioLiquido = salarioBase - descontoINSS - descontoIRPF;

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(salarioBruto, descontoINSS, descontoIRPF,salarioLiquido );

        return funcionarioDTO;
    }

    private double calcularINSS(double salarioBruto) {
        if (salarioBruto <= 1212.00) {
           // funcionarioDTO.setInss(salarioBruto * 0.075);
            return salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
          //  funcionarioDTO.setInss(salarioBruto * 0.09);
            return salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
           // funcionarioDTO.setInss(salarioBruto * 0.12);
            return salarioBruto * 0.12;
        } else {
          //  funcionarioDTO.setInss(salarioBruto * 0.14);
            return salarioBruto * 0.14;
        }
    }

    private double calcularIRPF(double salarioBase) {
        if (salarioBase <= 1903.98) {
            return 0;
        } else if (salarioBase <= 2826.65) {
          //  funcionarioDTO.setIrps(salarioBase * 0.075 - 142.80);
            return salarioBase * 0.075 - 142.80;
        } else if (salarioBase <= 3751.05) {
           // funcionarioDTO.setIrps(salarioBase * 0.15 - 354.80);
            return salarioBase * 0.15 - 354.80;
        } else if (salarioBase <= 4664.68) {
          //  funcionarioDTO.setIrps(salarioBase * 0.225 - 636.13);
            return salarioBase * 0.225 - 636.13;
        } else {
          //  funcionarioDTO.setIrps(salarioBase * 0.275 - 869.36);
            return salarioBase * 0.275 - 869.36;
        }
    }
}
