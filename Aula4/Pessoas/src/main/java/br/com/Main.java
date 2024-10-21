package br.com;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Instância do Serializador para salvar e ler o objeto
        Serializador ser = new Serializador();
        // Criando uma lista de pessoas
        Pessoa[] pessoas = new Pessoa[3];

        pessoas[0] = new Pessoa();
        pessoas[0].setNome("Franciele");
        pessoas[0].setProfissao("Professora");
        pessoas[0].setDataNascimento(LocalDate.parse("1979-09-25"));

        pessoas[1] = new Pessoa();
        pessoas[1].setNome("Maria");
        pessoas[1].setProfissao("Desenvolvedora");
        pessoas[1].setDataNascimento(LocalDate.parse("2002-08-31"));

        pessoas[2] = new Pessoa();
        pessoas[2].setNome("Joao");
        pessoas[2].setProfissao("Contador");
        pessoas[2].setDataNascimento(LocalDate.parse("2004-07-06"));

        // Definindo o caminho do arquivo onde o objeto será gravado
        File file = new File("D:\\dev\\OO43S\\Aula4\\Pessoas\\pessoas.dat");

        // Serializa o objeto pessoa e grava no arquivo
        ser.gravarNoArquivo(file, pessoas);

        // Lê o objeto do arquivo e imprime no console
        System.out.println(ser.lerDoArquivo(file).toString());
    }
}

