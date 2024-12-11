package com.funcionario.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private ECategoria ecategoria = ECategoria.PADRAO;


    private Motor motor;

    public Modelo(String descricao, String tipoMotor, int potenciaMotor){
        this.descricao = descricao;
        this.motor = new Motor(234);
    }


}
