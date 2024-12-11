package com.cambio;

import java.util.ArrayList;
import java.util.List;

public class MoedaDataSource {

    private static List<Moeda> listaMoedas = new ArrayList<>();

    // Method to initialize the list of Moedas
    public static void criarLista() {
        listaMoedas.add(new Moeda(1,"DC"));
        listaMoedas.add(new Moeda(2,"DC"));

    }

    // Method to add a new Moeda to the list
    public static void novo(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // Method to get the list of Moedas
    public static List<Moeda> getListaMoedas() {
        return listaMoedas;
    }

    //

    public static Moeda buscarPorMatricula(int matriculaDada){
        for(Moeda moeda : listaMoedas){
            if(moeda.getMatricula() == matriculaDada){
                return moeda;
            }
        }
        return null;
    }
    
}
