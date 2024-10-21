package br.com;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double valorUnitario;
    private double quantidade;
    private transient Double total; //Não será serializado

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade){
        this.quantidade = quantidade;
    }

    public double getTotal(){
        return quantidade * valorUnitario;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("Quantidade: ").append(this.quantidade).append("\n")
                .append("Valor unitario: ").append(this.valorUnitario).append("\n")
                .append("Total: ").append(getTotal());
        return sb.toString();
    }
}
