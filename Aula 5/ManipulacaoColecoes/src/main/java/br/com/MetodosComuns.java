package br.com;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class MetodosComuns {
    public static void main(String[] args) {

        List<String> nomes = Arrays.asList("Tatiane", "Vitor", "Carlos", "Camila");

        List<Integer> tamanhosNomes = nomes.stream()
                .map(String::length)
                .collect(Collectors.toList());

        int somaTamanhos = tamanhosNomes.stream().reduce(0, Integer::sum);

        System.out.println(somaTamanhos);

        System.out.println(tamanhosNomes.toString());

        nomes.stream().forEach(System.out::println);

        Set<String> nomesUnicos = nomes.stream().collect(Collectors.toSet());

        System.out.println(nomesUnicos.toString());

        List<String> nomesOrdenados = nomes.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nomesOrdenados.toString());



        List<String> nomesComC = nomes.stream()
                .filter(nome -> nome.startsWith("C"))
                .collect(Collectors.toList());



        System.out.println(nomesComC.toString());
    }
}
