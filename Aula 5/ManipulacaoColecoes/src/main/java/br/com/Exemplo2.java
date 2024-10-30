package br.com;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Exemplo2 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Tatiane", 23),
                new Pessoa("Vitor", 15),
                new Pessoa("Carlos", 18),
                new Pessoa("Camila", 22));

        // Filtrar pessoas com idade superior a 18 anos.
        List<Pessoa> maioresDeIdade = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .collect(Collectors.toList());
        System.out.println("Pessoas com idade superior a 18 anos:");
        System.out.println(maioresDeIdade.toString());

        //Lista com os nomes de todas as pessoas.
        List<String> nomesPessoas = pessoas.stream()
                .map(Pessoa::getNome)
                .collect(Collectors.toList());
        System.out.println("Lista com os nomes de todas as pessoas:");
        System.out.println(nomesPessoas.toString());

        //Calcular a idade média.
        OptionalDouble mediaIdade = pessoas.stream()
                .mapToInt(Pessoa::getIdade)
                .average();
        System.out.println("Idade media das pessoas:");
        System.out.println(mediaIdade.toString());
    }
}
