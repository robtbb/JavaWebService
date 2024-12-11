package com.mensagem;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {


    private static final String template=" %s!";

    private final AtomicLong contador = new AtomicLong();

    //metodo que esta disponibilizado para a api
    @RequestMapping("/cadastro") //isso aqui é um andpoint //esse resquestParam pega o valor da web e injeta na variavel java String nome
    public Curso Retornamensagem(@RequestParam(value="curso", defaultValue="null")String curso){
        //contador.increment é para gerar um id, perceba que esse contrutor é do modelo mensagem
        Curso msg = new Curso(contador.incrementAndGet(), String.format(template, curso));
        //usamos o string fomrat para fazer a formatação da mensagem onde template é minha
        //variavel da mensagem e depois da virgula colocamos oque vai no lugar do %s
        return msg;
    }


}
