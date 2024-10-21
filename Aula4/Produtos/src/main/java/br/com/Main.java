package br.com;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Criando uma lista de produtos
        Produto[] produtos = new Produto[3];

        produtos[0] = new Produto();
        produtos[0].setNome("Laranja");
        produtos[0].setValorUnitario(8.75);
        produtos[0].setQuantidade(2.5);

        produtos[1] = new Produto();
        produtos[1].setNome("Melancia");
        produtos[1].setValorUnitario(10.20);
        produtos[1].setQuantidade(8.5);

        produtos[2] = new Produto();
        produtos[2].setNome("Banana");
        produtos[2].setValorUnitario(4.80);
        produtos[2].setQuantidade(3.7);

        File file = new File("D:\\dev\\OO\\Aula4\\Produtos\\produtos.dat");

        // Grava todos os produtos de uma vez
        produtoDAO.gravarProdutosNoArquivo(file, produtos);

        // Lê e imprime os produtos do arquivo
        System.out.println(produtoDAO.leProdutoDoArquivo(file));
    }
}