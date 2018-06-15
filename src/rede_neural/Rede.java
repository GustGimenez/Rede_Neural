/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rede_neural;

import IU.Automato;
import IU.Neuronio;
import java.util.ArrayList;

/**
 *
 * @author Gi
 */
public class Rede {

    private int qtdEntrada;
    private int qtdSaida;
    private int qtdOculta;
    private Automato rede;
    
    private final int ENTRADA = 0;
    private final int OCULTA = 1;
    private final int SAIDA = 2;

    public Rede(int qtdEntrada, int qtdSaida) {
        this.qtdEntrada = qtdEntrada;
        this.qtdSaida = qtdSaida;
        this.qtdOculta = calculaQtdOculta();
    }

    public int calculaQtdOculta() {
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

    public float[][] normalizaEntradas(ArrayList<ArrayList<Integer>> entradas) {
        float[][] mEntradas = new float[entradas.size()][entradas.get(0).size()];
        int max, min;
        for (int i = 0; i < entradas.size(); i++) {
            ArrayList e = entradas.get(i);
            max = (int) e.get(0);
            min = max;
            for (int j = 1; j < e.size(); j++) {
                if (max < (int) e.get(j)) {
                    max = (int) e.get(j);
                }
                if(min > (int) e.get(j)){
                    min = (int) e.get(j);
                }
            }
            for (int j = 0; j < e.size(); j++) {
                mEntradas[i][j] =  (Float.parseFloat(e.get(j).toString()) - min) / (float)(max - min);
            }
        }

        return mEntradas;
    }
    
    public void calculaNetOculta(int[] entradas){
        double net = 0;
        for (Neuronio n : this.rede.getOculta()) {
                for (int i = 0; i < entradas.length; i++) {
                    net += (double) n.getPeso().get(i) * entradas[i];
                }
                n.setNet(net);
                net = 0;
            }//fim for entradas
    }//for neuronios

}
