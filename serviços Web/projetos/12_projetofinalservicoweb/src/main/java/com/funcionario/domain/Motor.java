package com.funcionario.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int potencia;

    private ETipoCombustivel tipoCombustivel;

public Motor(int potencia){
    this.potencia = potencia;
}


}
