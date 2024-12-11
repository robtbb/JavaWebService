package com.mensagem;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CursoController {

    //private static final String template = "%s!";

    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/curso") //curso é o nome da minha table, ou a mina entidade, aqui estamos fazendo uma requisição para atribuir valores a curso
    public Curso getCurso(//para isso usamos esse metodo onde
            @RequestParam(value="nome", defaultValue="Desconhecido") String nome,
            @RequestParam(value="ch", defaultValue = "0") int ch){
        return new Curso(contador.incrementAndGet(), nome, ch);
    }

}



// COMO FAZER AS CHAMADAS NO NAVEGADOR
// localhost:8080/curso?nome=Administracao

// localhost:<porta>/<nome da entidade/tabela> ? <variavel>=<valor>

// caso fosse mais de uma informação teriamos

//// localhost:8080/curso?nome=Administracao & ch=120


/**
 * DOCUMENTAÇÃO SOBRE O CODIGO
 *
 * Esse código define um endpoint em uma aplicação Spring Boot
 * que lida com uma requisição `GET` para a URL `/curso`. Aqui
 * está uma explicação detalhada de cada parte:
 *
 * 1. **`@GetMapping("/curso")`**:  Curso é o nome da nossa tabela a nossa entidade
 * queremos atribuir valores a ela, para isso criamos um endpoint dentro desse metodo
 * que vai nos auxiliar a epgar informações do navegador temos parametros/variaveis
 * para identificar que  ** nome ** e **ch** são variaveis precisamos idenficar isso
 *
 * por isso atribuimos a frente da veriavel @RequestPram() dentro dessa anotaçao a gente
 * expecificou como queremos que isse parametro/variavel se comporte e como vai ser chamada no navegador
 * ou qual vai ser a variavel global dela ***value="nome" *** isso se ferefe a como
 * ela sera identificada quando queremos atribuir valores a variavel String nome
 * , colocamos o mesmo nome apenas para saber a qual variavel esse value se refere
 *
 * fazemos o mesmo para a proxima variavel e assim por diante se tivesse mais
 *
 * perceba mais uma vez, aqui estamos usando o metodo para pegar valores
 *
 *
 *    - Esse é um mapeamento de endpoint. A anotação `@GetMapping`
 *      indica que esse método será chamado quando uma requisição
 *      `GET` for feita para o caminho `/curso`.
 *    - No contexto de uma API, `/curso` representa a rota que os
 *    clientes podem acessar para criar ou buscar dados de um curso.
 *
 * 2. **`public Curso getCurso(...)`**:
 *    - Esse é o método que lida com a requisição para o endpoint `/curso`.
 *    - Ele retorna uma instância da classe `Curso`, que provavelmente
 *    é uma entidade ou modelo representando um curso no sistema,
 *    com atributos como `id`, `nome` e `ch` (carga horária).
 *
 * 3. **Parâmetros `@RequestParam`**:
 *    - `@RequestParam` indica que os parâmetros `nome` e `ch` serão
 *    recebidos na URL como parâmetros de consulta (query parameters).
 *    - Exemplo de URL: `http://localhost:8080/curso?nome=Matematica&ch=60`
 *    - Cada parâmetro possui um valor padrão, caso não sejam fornecidos
 *    na requisição:
 *      - **`@RequestParam(value="nome", defaultValue="Desconhecido")
 *      String nome`**: Se o parâmetro `nome` não for passado na URL,
 *      ele assume o valor `"Desconhecido"`.
 *      - **`@RequestParam(value="ch", defaultValue="0") int ch`**: Se
 *      o parâmetro `ch` (carga horária) não for passado na URL, ele
 *      assume o valor `0`.
 *
 * 4. **`return new Curso(contador.incrementAndGet(), nome, ch);`**:
 *    - Aqui, o método retorna uma nova instância de `Curso`, utilizando
 *    os valores de `nome` e `ch` passados pela URL, ou seus valores
 *    padrão caso não sejam informados.
 *    - `contador.incrementAndGet()` provavelmente gera um identificador
 *    único para o curso, incrementando algum contador (como um `AtomicLong`).
 *
 * **Resumindo**, essa configuração permite que você acesse o endpoint
 * `/curso` com parâmetros de consulta opcionais para `nome` e `ch`. A
 * resposta será um objeto `Curso` com os valores fornecidos, que podem
 * ser usados no lado do cliente para exibir ou manipular os dados.
 */