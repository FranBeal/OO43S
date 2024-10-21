package br.com;

import java.io.*;

public class ProdutoDAO {

    public void gravarProdutosNoArquivo(File arquivo, Produto[] produtos) {
        try (FileOutputStream fos = new FileOutputStream(arquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Produto produto : produtos) {
                oos.writeObject(produto);
                System.out.println("Produto " + produto.getNome() + " salvo com sucesso!");
            }
        } catch (IOException e) {
            System.err.println("Erro ao gravar os produtos no arquivo: " + e.getMessage());
        }
    }

    public String leProdutoDoArquivo(File arquivo) {
        Produto produto;
        StringBuilder resultado = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(arquivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    produto = (Produto) ois.readObject();
                    resultado.append(produto.toString()).append("\n");
                    System.out.println("Produto " + produto.getNome() + " recuperado com sucesso!");
                } catch (EOFException e) {
                    System.out.println("Fim do arquivo");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler os produtos do arquivo: " + e.getMessage());
        }

        return resultado.toString();
    }
}
