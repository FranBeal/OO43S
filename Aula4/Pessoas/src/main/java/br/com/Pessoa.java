package br.com;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

// Classe Pessoa implementa Serializable para permitir a serialização de seus objetos
public class Pessoa implements Serializable {
    private String nome;
    private String profissao;
    private LocalDate dataNascimento;
    private transient int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Exibir a data de nascimento no formato dd/MM/yyyy
    public String getDataNascimentoFormatada() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dataNascimento.format(formato);
    }

    public int getIdade() {
        LocalDate dataAtual = LocalDate.now();
        // Calcula o período entre a data de nascimento e a data atual
        return Period.between(this.dataNascimento, dataAtual).getYears();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("Profissao: ").append(this.profissao).append("\n")
                .append("Data de Nascimento: ").append(getDataNascimentoFormatada()).append("\n")
                .append("Idade: ").append(getIdade());
        return sb.toString();
    }
}
