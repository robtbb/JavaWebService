package br.edu.ifsc.calculadora.domain;

public class Calculadora {
    public static int somar(int a, int b){
        return a + b;
    }

    //perceba que estamos usando a classe Double e não o tipo primitivo
    public static Double somar(Double a, Double b){
        return a + b;
    }

    public static int subtrair(int a, int b){
        return a - b;
    }

}
