package br.com.ifs.fln;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MensagemController {

    private static final String template="Olá,  %s!";

    private final AtomicLong  contador = new AtomicLong();

    //metodo que esta disponibilizado para a api
    @RequestMapping("/mensagem") //isso aqui é um andpoint //esse resquestParam pega o valor da web e injeta na variavel java String nome
    public Mensagem Retornamensagem(@RequestParam(value="nome", defaultValue="Mundo")String nome){
        //contador.increment é para gerar um id, perceba que esse contrutor é do modelo mensacomando paracomando para atualizar o intellij atualizar o intellijgem
        Mensagem msg = new Mensagem(contador.incrementAndGet(), String.format(template, nome));
        //usamos o string fomrat para fazer a formatação da mensagem onde template é minha
        //variavel da mensagem e depois da virgula colocamos oque vai no lugar do %s
        return msg;
    }

    @RequestMapping("/getnumeroInteiro")
    @ResponseBody
    public int NumeroInteiro(){
        return 100;
    }
}

// para ver isso funcoinando podes ir no navegador e colocar a url
// http://localhost:8080/mensagem?nome=Robert
// onde voce acessa o serviço na porta 8080 chama o recurso do endpoint (mensagem)
// e passa um valor para o parametro para nome (?nome) que no caso foi o valor robert

// a saida que vamos ter vai ser um JSON

// Caso não seja passado um parametro para a variavel por padrão vai ser adicionado
// o valor "Mundo"

// nesse caso ficaria localhost:8080/mensagem
