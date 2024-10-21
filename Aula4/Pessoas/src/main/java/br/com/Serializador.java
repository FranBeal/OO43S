package br.com;

import java.io.*;

public class Serializador {

    // Metodo para serializar e gravar um objeto em arquivo
    public void gravarNoArquivo(File arquivo, Object[] objetos) throws IOException {
        // Usando try-with-resources para garantir fechamento automático dos recursos
        try(FileOutputStream outFile = new FileOutputStream(arquivo);
            ObjectOutputStream s = new ObjectOutputStream(outFile)) {

            for (Object objeto : objetos) {
                s.writeObject(objeto);
                System.out.println("Objeto salvo com sucesso!");
            }
        }
    }

    // Metodo para ler um objeto serializado de um arquivo
    public Object lerDoArquivo(File arquivo) throws IOException, ClassNotFoundException {
        Object objeto = new Object();
        StringBuilder resultado = new StringBuilder();

        // Usando try-with-resources para garantir fechamento automático dos recursos
        try(FileInputStream inFile = new FileInputStream(arquivo);
            ObjectInputStream s = new ObjectInputStream(inFile)) {
            while (true) {
                try {
                    objeto = (Object) s.readObject();
                    resultado.append(objeto.toString()).append("\n");
                    System.out.println("Objeto recuperado com sucesso!");
                } catch (EOFException e) {
                    System.out.println("Fim do arquivo");
                    break;
                }
            }
        }
        return resultado.toString();
    }
}
