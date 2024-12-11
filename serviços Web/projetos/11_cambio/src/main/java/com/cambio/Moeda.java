package com.cambio;

import java.util.Map;

public class Moeda {
    private double quantia;
    private String operacao;
    private Map<String, Double> resultados;

    public Moeda(double quantia, String operacao) {
        this.quantia = quantia;
        this.operacao = operacao;
    }

    public Moeda(double quantida, String operacao, Map<String, Double> resultados) {
        this.quantia = quantia;
        this.operacao = operacao;
        this.resultados = resultados;
    }

    public double getValor() {
        return quantia;
    }

    public void setValor(double quantia) {
        this.quantia = quantia;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Map<String, Double> getResultados() {
        return resultados;
    }

    public void setResultados(Map<String, Double> resultados) {
        this.resultados = resultados;
    }
}
