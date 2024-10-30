package br.com;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReferenciaMetodo {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("Amanda", "Paulo", "Clarice");


        nomes.forEach(System.out::println);
        // Equivalente a nomes.forEach(nome -> System.out.println(nome));

        String nomeMaisLongo = nomes.stream()
               .max(Comparator.comparingInt(String::length))
                .orElse("");
        // Equivale a .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))

        System.out.println(nomeMaisLongo);

        List<Pessoa> pessoas = Arrays.asList("Amanda", "Paulo", "Clarice")
                .stream()
                .map(Pessoa::new) // Cria uma nova instância de Pessoa para cada nome
                .collect(Collectors.toList());
        // Equivale a .map((String nome) -> new Pessoa(nome))

    }
}
