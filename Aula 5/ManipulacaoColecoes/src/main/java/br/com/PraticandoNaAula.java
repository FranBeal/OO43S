package br.com;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PraticandoNaAula {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Tatiane", 23, 4500.00),
                new Pessoa("Vitor", 19, 1850.00),
                new Pessoa("Carlos", 18, 1800.00),
                new Pessoa("Camila", 22, 5200.00),
                new Pessoa("Marcela", 22, 15500.00),
                new Pessoa("Pedro", 22, 15500.00));

        //Listar o nome das pessoas
        List<String> nomes = pessoas.stream()
                .map(Pessoa::getNome)//Equivalente .map(pessoa -> pessoa.getNome())
                .collect(Collectors.toList());
        System.out.println("Nomes das pessoas: "+nomes);
        //Ou, desta forma
        /*
        System.out.println("Nomes das pessoas: ");
        pessoas.stream().map(Pessoa::getNome).forEach(System.out::println);
        */

        //Listar o nome das pessoas em ordem alfabética
        List<String> nomesOrdenados = pessoas.stream()
                .map(Pessoa::getNome)
                .sorted()
                .collect(Collectors.toList());

        //Listar todas as pessoas com mais de 20 anos
        List<Pessoa> pessoasMaisDe20 = pessoas.stream()
                .filter(p -> p.getIdade() > 20)
                .collect(Collectors.toList());
        System.out.println("Pessoas com mais de 20 anos: "+pessoasMaisDe20);

        //Listar os salarios
        List<Double> salarios = pessoas.stream()
                .map(Pessoa::getSalario)
                .collect(Collectors.toList());
        System.out.println("Salarios: "+salarios);

        //Listar os salarios sem repetir
        Set<Double> salariosDistintos = pessoas.stream()
                .map(Pessoa::getSalario)
                .collect(Collectors.toSet());

        //Ou desta forma
        /*
        List<Double> salariosDistintos = pessoas.stream()
                .map(Pessoa::getSalario)
                .distinct()
                .collect(Collectors.toList());
        */
        System.out.println("Salarios sem repeticao: "+salariosDistintos);

        //Retornar a quantidade de pessoas com salarios acima de 5.000,00
        long pessoasComSalarioAlto = pessoas.stream()
                .filter(p -> p.getSalario() > 5000)
                .count();
        System.out.println("Quantidade de pessoas com salario acima de 5mil: "+pessoasComSalarioAlto);

        //Retornar a soma dos salarios
        double somaSalarios = pessoas.stream()
                .map(pessoa -> pessoa.getSalario())
                .reduce(0.0, (s1, s2) -> s1 + s2);//Equivalente .reduce(0.0, Integer::sum)
        //Ou desta forma,
        /*
        double somaSalarios = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .sum();
        */
        System.out.println("Soma dos salarios: "+somaSalarios);

        //Retornar a média salarial
        double mediaSalarial = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)//.mapToDouble(pessoa-> pessoa.getSalario())
                .average()
                .orElse(0.0);//se não encontrar nada, retornar 0
        System.out.println("Média dos salarios: "+mediaSalarial);

        /*Optional permite lidar com valores que podem ser nulos de forma mais segura e explícita.
          Força o programador a pensar na possibilidade de um valor nulo, evitando os erros
          NullPointerException. Esta classe possui dois estados: vazio (representado por Optional.empty() )
          ou contendo um valor não nulo*/

        //Retornar o maior salario
        double maiorSalario = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .max()
                .orElse(0.0); //fornecer um valor padrão caso o resultado seja vazio ou null
        System.out.println("Maior salário: "+maiorSalario);
        //Ou desta forma,
        /*
        pessoas.stream()
                .max(Comparator.comparing(Pessoa::getSalario))
                .ifPresent(f -> System.out.println("Maior salário: "+f.getSalario()));
        */

        //Retornar o menor salario
        double menorSalario = pessoas.stream()
                .mapToDouble(Pessoa::getSalario)
                .min()
                .orElse(0.0); //fornecer um valor padrão caso o resultado seja vazio ou null
        System.out.println("Menor salário: "+menorSalario);
        //Ou desta forma,
        /*
        pessoas.stream()
                .min(Comparator.comparing(Pessoa::getSalario))
                .ifPresent(f -> System.out.println("Menor salário: "+f.getSalario()));
        */
    }
}
