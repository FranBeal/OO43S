package br.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutrosExemplos {
    public static void main(String[] args) {
        //somar os quadrados dos números pares da lista abaixo
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 55);

        int SomaQuadradoDosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
                //equivalente .reduce(0, (n1, n2) -> n1 + n2);


        List<Double> numerosAleatorios = Arrays.asList(5.3, 2.4, 1.9, 4.0, 0.78);

        List<Double> doublesOrdenados = numerosAleatorios.stream()
                        .sorted(Double::compare)
                        .toList();
        //equivalente .sorted((n1, n2)-> Double.compare(n1, n2))
        System.out.println(doublesOrdenados.toString());

        List<String> alunos = Arrays.asList("Joao", "Maria", "Carla","Antonia","Mateus");
        alunos.stream()
                .sorted()
                .forEach(nome->System.out.println(nome));

        List<Integer> num = Arrays.asList(1, 2, 3, 4);
        Integer soma = num.stream().reduce(0, (a, b) -> a + b);
        System.out.println(soma);
    }
}
