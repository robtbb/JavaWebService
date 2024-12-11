package br.edu.ifsc.fln.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int potencia;

    @Enumerated(EnumType.STRING)
    private ETipoCombustivel tipoCombustivel;

    @OneToOne // Define relacionamento de um-para-um
    @JoinColumn(name = "modelo_id", nullable = false) // Define a coluna usada pra armazenar a chave estrangiera
    private Modelo modelo;

   
    public Motor() {}

    
    public Motor(int potencia, ETipoCombustivel tipoCombustivel, Modelo modelo) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
        this.modelo = modelo;
    }

    // Getters e Setters
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public ETipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(ETipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Modelo getModelo() {
        return modelo;
    }

    @JsonProperty("eTipoCombustivel") //  Mapear para o atributo tipoCombustivel
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "potencia=" + potencia +
                ", tipoCombustivel=" + tipoCombustivel +
                ", modelo=" + modelo +
                '}';
    }
}
