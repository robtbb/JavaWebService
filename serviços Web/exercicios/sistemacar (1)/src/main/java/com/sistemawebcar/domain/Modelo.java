package com.sistemawebcar.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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

    @ManyToOne // ou @OneToOne, dependendo da relação entre as entidades
    @JoinColumn(name = "motor_id", nullable = false)
    private Motor motor;  // Relacionamento com Motor

    public Modelo() {
    }

    public Modelo(String descricao, int potenciaMotor) {
        this.descricao = descricao;
        this.motor = new Motor(potenciaMotor);
    }
}
