package com.mensagem;

public class Curso {
    private final long id;
    private final String nome;
    private final int cartaHoraria;

    public Curso(long id, String nome, int cartaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cartaHoraria = cartaHoraria;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria(){
        return cartaHoraria;
    }

}


// COMO FAZER AS CHAMADAS NO NAVEGADOR
// localhost:8080/curso?nome=Administracao

// localhost:<porta>/<nome da entidade/tabela> ? <variavel>=<valor>

// caso fosse mais de uma informação teriamos

//// localhost:8080/curso?nome=Administracao&hc=120
