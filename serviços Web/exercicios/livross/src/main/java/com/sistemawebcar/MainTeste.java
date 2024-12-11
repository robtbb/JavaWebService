package com.sistemawebcar;

public class MainTeste {
    public static void main(String[] args) {

        Livro livro = new Livro();
        livro.setId(1);
        livro.setIsbn(123456);
        livro.setTitulo("Aprendendo Java");
        livro.setAutor("João Silva");
        livro.setEditora("Editora Exemplo");
        livro.setPreco(100.00);

        System.out.println("Preço antes do reajuste: " + livro.getPreco());

        // Reajusta o preço em 10%
        livro.reajustarPreco(10);

        System.out.println("Preço após reajuste: " + livro.getPreco());
    }
}
