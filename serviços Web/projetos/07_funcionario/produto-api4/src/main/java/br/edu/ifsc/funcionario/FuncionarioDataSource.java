package br.edu.ifsc.funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDataSource {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public static void criarLista() {
        listaFuncionarios.add(new Funcionario(1, "Cleitinho", 100.0, 3));
        listaFuncionarios.add(new Funcionario(2, "Juinho", 50.0, 10));
        listaFuncionarios.add(new Funcionario(3, "Cabelinho", 400.0,  20));
    }

    public static List<Funcionario> getListaFuncionarios() {return listaFuncionarios;    }

    public static void novo(Funcionario funcionario) {listaFuncionarios.add(funcionario);    }

    //buscar por id
    public static Funcionario buscarPorMatricula(int matricula){
        for(Funcionario funcionario : listaFuncionarios){
            if(funcionario.getMatricula() == matricula){
                return funcionario;
            }
        }
        return null;
    }
}
