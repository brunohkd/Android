package com.martin.calculadorasimples.entidade;

/**
 * Created by 978907 on 29/10/2016.
 */
public class Calculo {

    private long id;
    private double valorUm;
    private double valorDois;
    private double resposta;

    public Calculo(){

    }

    public Calculo(double valorUm, double valorDois, double resposta) {
        this.valorUm = valorUm;
        this.valorDois = valorDois;
        this.resposta = resposta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValorUm() {
        return valorUm;
    }

    public void setValorUm(double valorUm) {
        this.valorUm = valorUm;
    }

    public double getValorDois() {
        return valorDois;
    }

    public void setValorDois(double valorDois) {
        this.valorDois = valorDois;
    }

    public double getResposta() {
        return resposta;
    }

    public void setResposta(double resposta) {
        this.resposta = resposta;
    }
}
