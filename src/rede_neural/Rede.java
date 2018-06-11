/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rede_neural;

/**
 *
 * @author Gi
 */
public class Rede {
    private int qtdEntrada;
    private int qtdSaida;
    private int qtdOculta;

    public Rede(int qtdEntrada, int qtdSaida) {
        this.qtdEntrada = qtdEntrada;
        this.qtdSaida = qtdSaida;
        this.qtdOculta = calculaQtdOculta();
    }
    
    public int calculaQtdOculta(){
        return (int) Math.sqrt(this.qtdEntrada * this.qtdSaida);
    }

    public int getQtdEntrada() {
        return qtdEntrada;
    }

    public void setQtdEntrada(int qtdEntrada) {
        this.qtdEntrada = qtdEntrada;
    }

    public int getQtdSaida() {
        return qtdSaida;
    }

    public void setQtdSaida(int qtdSaida) {
        this.qtdSaida = qtdSaida;
    }

    public int getQtdOculta() {
        return qtdOculta;
    }

    public void setQtdOculta(int qtdOculta) {
        this.qtdOculta = qtdOculta;
    }
    
    
}
