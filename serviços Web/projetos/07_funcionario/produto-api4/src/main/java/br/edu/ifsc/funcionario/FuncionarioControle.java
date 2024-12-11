package br.edu.ifsc.funcionario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class FuncionarioControle {


    @RequestMapping(value = "/criar_funcionario/{matricula}/{nome}/{salarioBase}/{numeroDependentes}")
    public Funcionario criarFuncionario(
            @PathVariable("matricula") int matricula,
            @PathVariable("nome") String nome,
            @PathVariable("salarioBase") double salarioBase,
            @PathVariable("numeroDependentes") int numeroDependentes) {

        Funcionario funcionario = new Funcionario(matricula, nome, salarioBase, numeroDependentes);

        // Incluir um novo funcionário na lista
        FuncionarioDataSource.novo(funcionario);

        return funcionario;
    }

    @RequestMapping(value = "/fornecedor")
    public List<Funcionario> getListaFuncionarios() {
        return FuncionarioDataSource.getListaFuncionarios();
    }

    @RequestMapping(value = "/lista_por_id/{idx}")
    public List<Funcionario> litarFuncionaroiPorId(
            @PathVariable("idx") int idx) {
        Funcionario funcionario = FuncionarioDataSource.getListaFuncionarios().get(idx);

        return FuncionarioDataSource.getListaFuncionarios();
    }

    @GetMapping("/calcularSalario/{matricula}/{salarioBruto}/{taxa}")
    public Double calcularSalario(@PathVariable int matricula, @PathVariable double salarioBruto, @PathVariable int taxa) {
        // Busca o Funcionario pelo ID
        Funcionario funcionario = FuncionarioDataSource.buscarPorMatricula(matricula);

        if (funcionario != null) {
            // Calcula o salário líquido
            return calcularSalarioLiquido(salarioBruto, taxa);
        } else {
            throw new RuntimeException("Funcionario com ID " + matricula + " não encontrado.");
        }
    }

    // Método privado para calcular o salário líquido
    private Double calcularSalarioLiquido(double salarioBruto, int taxa) {
        return salarioBruto - taxa;
    }



    /**
     * Obtém um DTO de funcionário com base na matrícula.
     *
     * @param matricula Matrícula do funcionário.
     * @return DTO do funcionário.
     */

}

/*
A classe controller é responsável por gerenciar as requisições
a partir dos endpoints, captando os dados do cliente e
direcionando-os para a lógica de manipulação, retornando os resultados adequados.
*/

