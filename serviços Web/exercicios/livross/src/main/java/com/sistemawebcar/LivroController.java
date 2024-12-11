package com.sistemawebcar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {

    // Endpoint para criar um novo livro
    @RequestMapping(value = "/livro/{id}/{isbn}/{titulo}/{autor}/{editora}/{preco}")
    public Livro criarLivro(
            @PathVariable("id") int id,
            @PathVariable("isbn") int isbn,
            @PathVariable("titulo") String titulo,
            @PathVariable("autor") String autor,
            @PathVariable("editora") String editora,
            @PathVariable("preco") double preco) {

        Livro livro = new Livro();
        livro.setId(id);
        livro.setIsbn(isbn);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setPreco(preco);

        LivroDataSource.novo(livro);
        return livro;
    }

    // Endpoint para obter o preço de venda de um livro por índice
    @RequestMapping(value = "/preco_venda/{idx}")
    public double calcularPrecoVenda(@PathVariable("idx") int idx) {
        Livro livro = LivroDataSource.getListaLivros().get(idx);
        return livro.getPreco();
    }

    // Endpoint para retornar a lista completa de livros
    @RequestMapping(value = "/livros")
    public List<Livro> getLivros() {
        return LivroDataSource.getListaLivros();
    }

    // Endpoint para retornar uma lista formatada de livros (DTOs)
    @RequestMapping(value = "/livros_dto")
    public List<String> getLivroDTO() {
        return LivroDataSource.getListaLivrosFormatada();
    }

    // Endpoint para reajustar o preço de todos os livros
    @RequestMapping(value = "/reajustar/{taxa}")
    public String reajustarPreco(@PathVariable("taxa") int taxa) {
        LivroDataSource.reajustarPrecoParaTodos(taxa);
        return "Preços reajustados em " + taxa + "%!";
    }
}
