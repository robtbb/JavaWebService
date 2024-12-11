package com.sistemawebcar;

import java.util.ArrayList;
import java.util.List;

public class LivroDataSource {

    // Lista estática para armazenar os livros
    private static List<Livro> listaLivros = new ArrayList<>();

    // Método para criar uma lista inicial de livros
    public static void criarLista() {
        listaLivros.add(new Livro(1, 9780132350884, "Clean Code", "Robert C. Martin", "Prentice Hall", 150.00));
        listaLivros.add(new Livro(2, 9780201485677, "Refactoring", "Martin Fowler", "Addison-Wesley", 200.00));
        listaLivros.add(new Livro(3, 9780134685991, "Effective Java", "Joshua Bloch", "Addison-Wesley", 250.00));
        listaLivros.add(new Livro(4, 9780596007126, "Head First Java", "Kathy Sierra", "O'Reilly Media", 180.00));
        listaLivros.add(new Livro(5, 9780134494166, "Design Patterns", "Erich Gamma", "Addison-Wesley", 220.00));
    }

    // Retorna a lista de todos os livros
    public static List<Livro> getListaLivros() {
        return listaLivros;
    }

    // Adiciona um novo livro à lista
    public static void novo(Livro livro) {
        listaLivros.add(livro);
    }

    // Retorna um livro com base no ID
    public static Livro getPorId(int id) {
        for (Livro livro : listaLivros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    // Reajusta o preço de todos os livros com base em uma taxa
    public static void reajustarPrecoParaTodos(int taxa) {
        for (Livro livro : listaLivros) {
            livro.reajustarPreco(taxa);
        }
    }

    // Retorna uma lista de nomes e preços formatados
    public static List<String> getListaLivrosFormatada() {
        List<String> resultado = new ArrayList<>();
        for (Livro livro : listaLivros) {
            resultado.add(livro.getTitulo() + " - R$ " + String.format("%.2f", livro.getPreco()));
        }
        return resultado;
    }
}
