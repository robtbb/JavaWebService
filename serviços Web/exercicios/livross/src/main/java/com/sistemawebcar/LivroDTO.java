package com.sistemawebcar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {

    private String nome;
    private double preco;

    public void ProdutoDTO(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

}

