package com.sistemawebcar.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity  // Adiciona a anotação para tornar Motor uma entidade JPA
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usando Identity para gerar o id de forma automática
    private Long id;

    private int potencia;

    @Enumerated(EnumType.STRING) // Garantir que o tipo do combustível seja armazenado como string no banco
    private ETipoCombustivel tipoCombustivel = ETipoCombustivel.DIESEL;

    public Motor(int potencia){
        this.potencia = potencia;
    }

    public Motor() {

    }
}
