package com.cambio;

public class MoedaDTO {
    private String moeda;
    private double compra;
    private double venda;

    public MoedaDTO(String moeda, double compra, double venda) {
        this.moeda = moeda;
        this.compra = compra;
        this.venda = venda;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }
}
