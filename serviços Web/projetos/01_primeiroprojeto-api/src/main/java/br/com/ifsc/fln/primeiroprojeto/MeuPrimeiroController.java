package br.com.ifsc.fln.primeiroprojeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //essa classe sera responsavel por recebber requisições web
public class MeuPrimeiroController {

    @GetMapping(value = "/hello") //esse hello é oque vai ser chamado no navegador localhost:8080/hello
    @ResponseBody                   // e que nos retorna a string
    public String helloWorld() {
        return "Hello. Alunos de serviços web!";
    }
}
