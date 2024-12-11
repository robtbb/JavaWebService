package com.sistemawebcar;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Livro {
    private int id;
    private int isbn;
    private String titulo;
    private String autor;
    private String editora;
    private double preco;


    public void reajustarPreco(int taxa) {
        // Calcula o novo preço com base na taxa fornecida
        double novoPreco = preco + (preco * taxa / 100.0);
        // Atualiza o preço do livro
        this.preco = novoPreco;
    }

}
