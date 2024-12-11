package br.edu.ifsc.calculadora.controller;

import br.edu.ifsc.calculadora.domain.Calculadora;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @RequestMapping("/soma/{valor1}/{valor2}", method= RequestMethod.GET)
    public int somar( @PathVariable("valor1") int a,
                       @PathVariable("valor2") int b){
        return Calculadora.somar(a,b);
    }
}

// para fazer a chamada da requisição então no navegador colocamos
// localhost:8080/soma/10/232
// onde valor1=10 e valor2=232