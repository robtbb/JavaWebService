package com.funcionario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioControle {

    // Adding an employee to the array that plays the role of database
    @RequestMapping(value = "funcionario/{matricula}/{nome}/{salarioBruto}/{numeroDependentes}")
    public Funcionario criarFuncionario(
            @PathVariable int matricula,
            @PathVariable String nome,
            @PathVariable double salarioBruto,
            @PathVariable int numeroDependentes) {

        Funcionario funcionario = new Funcionario(matricula, nome, salarioBruto, numeroDependentes);
        FuncionarioDataSource.novo(funcionario);
        return funcionario;
    }

    // list all employees
    @RequestMapping(value="/funcionarios")
    public List<Funcionario> getFuncionarios(){
        return FuncionarioDataSource.getListaFuncionarios();
    }

    // search employee by enrollment
    @RequestMapping(value = "/funcionario/{matricula}")
    public Funcionario getFuncionarioPorMatricula(@PathVariable int matricula){
       return FuncionarioDataSource.buscarPorMatricula(matricula);
    }

    // calculate the net salary of an employee give his enrollment
    @RequestMapping(value = "salario_liquido/{salarioBruto}")
    public FuncionarioDTO salarioLiquido(
            @PathVariable("salarioBruto") double salarioBruto){

        FuncionarioService funcionarioService = new FuncionarioService();

     return funcionarioService.calcularSalarioLiquido(salarioBruto);
    }


}

// o controlle não é responsavel por implementar logicas de resolução de problema
// mas recebe dados e os envia para quem sabe manipular e enseguida nos entrega
// o valor gerado.