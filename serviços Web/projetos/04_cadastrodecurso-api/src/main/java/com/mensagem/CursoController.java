package com.mensagem;

//import java.util.concurrent.atomic.AtomicLong;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CursoController {


//    private static final String template=" %s ";
//    private static final String cargaHoraria=" %s ";
//
//    private final AtomicLong contador = new AtomicLong();
//
//    //metodo que esta disponibilizado para a api
//    @RequestMapping("/cadastro") //isso aqui é um andpoint //esse resquestParam pega o valor da web e injeta na variavel java String nome
//    public Curso Retornamensagem(@RequestParam(value="curso", defaultValue="null") String curso,
//                                 @RequestParam(value="ch", defaultValue="0") int ch){
//        //contador.increment é para gerar um id, perceba que esse contrutor é do modelo mensagem
//        Curso msg = new Curso(contador.incrementAndGet(), String.format(template, curso), String.format(cargaHoraria, ch));
//
//        //usamos o string fomrat para fazer a formatação da mensagem onde template é minha
//        //variavel da mensagem e depois da virgula colocamos oque vai no lugar do %s
//        return msg;




//
//   }
//
//
//}

// ou podemos fazer também de forma mais simplificada


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    private final AtomicLong contador = new AtomicLong();

    // Método que está disponibilizado para a API
    @RequestMapping("/cadastro") // Isso aqui é um endpoint
    public Curso Retornamensagem(
            @RequestParam(value = "curso", defaultValue = "null") String curso,
            @RequestParam(value = "ch", defaultValue = "0") int ch) {

        // Criação de um novo objeto Curso usando curso e ch diretamente
        Curso msg = new Curso(contador.incrementAndGet(), curso, ch);

        return msg;
    }
}



// COMO FAZER AS CHAMADAS NO NAVEGADOR
// localhost:8080/curso?nome=Administracao

// localhost:<porta>/<nome da entidade/tabela> ? <variavel>=<valor>

// caso fosse mais de uma informação teriamos

//// localhost:8080/curso?nome=Administracao&horario=12
