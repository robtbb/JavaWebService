package com.funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDataSource {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    // Method to initialize the list of Funcionarios
    public static void criarLista() {
            listaFuncionarios.add(new Funcionario(1,"jorginhoDoPeneu", 1000.0, 2));
            listaFuncionarios.add(new Funcionario(2,"Cabelinho", 2300.0, 4));
            listaFuncionarios.add(new Funcionario(3,"ZeDoPorco", 2000.0, 3));

    }

    // Method to add a new Funcionario to the list
    public static void novo(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    // Method to get the list of Funcionarios
    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    //

    public static Funcionario buscarPorMatricula(int matriculaDada){
        for(Funcionario funcionario : listaFuncionarios){
            if(funcionario.getMatricula() == matriculaDada){
                return funcionario;
            }
        }
        return null;
    }





}
