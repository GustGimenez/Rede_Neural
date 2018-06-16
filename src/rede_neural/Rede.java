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
                if (min > (int) e.get(j)) {
                    min = (int) e.get(j);
                }
            }
            for (int j = 0; j < e.size(); j++) {
                mEntradas[i][j] = (Float.parseFloat(e.get(j).toString()) - min) / (float) (max - min);
            }
        }

        return mEntradas;
    }

    public void calculaNetOculta(float[] entradas) {
        double net = 0;
        for (Neuronio n : this.rede.getOculta()) { //Pra cada neuronio
            for (int i = 0; i < entradas.length; i++) { //Pra cada entrada
                net += (double) n.getPeso().get(i) * entradas[i]; //Peso correspondente a entrada multiplicada pela mesma
            }
            n.setNet(net);
            net = 0;
        }//fim for entradas
    }//for neuronios

    public void calculaNetSaida() {
        double net = 0;
        int i = 0;
        for (Neuronio n : this.rede.getSaida()) {
            for (i = 0; i < this.rede.getOculta().size(); i++) {
                Neuronio nOculta = this.rede.getOculta().get(i);
                net += (double) n.getPeso().get(i) * nOculta.getSaida();
            }
            n.setNet(net);
            net = 0;
        }//fim for entradas
    }//for neuronios

    public void aplicaLogistica(boolean camada) {
        double saida;
        if (camada) { //Oculta
            for (Neuronio n : this.rede.getOculta()) {
                saida = 1 / (1 + (Math.pow(Math.E, -n.getNet())));
                n.setSaida(saida);
            }
        } else {//Saida
            for (Neuronio n : this.rede.getSaida()) {
                saida = 1 / (1 + (Math.pow(Math.E, -n.getNet())));
                n.setSaida(saida);
            }
        }

    }

    public void aplicaTanHiperbolica(boolean camada) {
        double saida;
        if (camada) { //Oculta
            for (Neuronio n : this.rede.getOculta()) {
                saida = (1 - (Math.pow(Math.E, -2 * n.getNet()))) / (1 + (Math.pow(Math.E, -2 * n.getNet())));
                n.setSaida(saida);
            }
        } else {//Saida
            for (Neuronio n : this.rede.getSaida()) {
                saida = (1 - (Math.pow(Math.E, -2 * n.getNet()))) / (1 + (Math.pow(Math.E, -2 * n.getNet())));
                n.setSaida(saida);
            }
        }
    }

    public void calculaErroSaida(boolean funT, int[] desejada) {
        double erro = 0;
        for (int i = 0; i < this.rede.getSaida().size(); i++) {
            Neuronio n = this.rede.getSaida().get(i);
            erro = (desejada[i] - n.getSaida());
            if (funT) {//Logistica
                erro *= ((Math.pow(Math.E, -n.getNet())) / Math.pow((1 + Math.pow(Math.E, -n.getNet())), 2));
            } else {//Tangente hiperbólica
                erro *= 1 - (n.getSaida() * n.getSaida());
            }
            n.setErro(erro);
        }
    }

    public void calculaErroOculta(boolean funT) {
        double erros = 0;
        for (int i = 0; i < this.rede.getSaida().size(); i++) {
            Neuronio nOculta = this.rede.getSaida().get(i);
            for (Neuronio n : this.rede.getOculta()) {
                erros += n.getErro() + (double) n.getPeso().get(i);
            }
            if (funT) { //Logistica
                erros *= ((Math.pow(Math.E, -nOculta.getNet())) / Math.pow((1 + Math.pow(Math.E, -nOculta.getNet())), 2));
            } else {//Hiperbolica
                erros *= 1 - (nOculta.getSaida() * nOculta.getSaida());
            }
            nOculta.setErro(erros);
            erros = 0;
        }

    }

    public void ajustaPesosSaida() {
        double peso = 0;
        for (Neuronio n : this.rede.getSaida()) {
            for (int i = 0; i < this.rede.getOculta().size(); i++) {
                Neuronio nOculta = this.rede.getOculta().get(i);
                peso = (double) n.getPeso().get(i) + 0.3 * n.getErro() * nOculta.getNet();
                n.getPeso().set(i, peso);
                peso = 0;
            }
        }
    }

    public void ajustaPesosOculta(float[] entrada) {
        double peso = 0;
        for (Neuronio n : this.rede.getOculta()) {
            for (int i = 0; i < entrada.length; i++) {
                peso = (double) n.getPeso().get(i) + 0.3 * n.getErro() * entrada[i];
                n.getPeso().set(i, peso);
                peso = 0;
            }
        }
    }

    public double calculaErroRede() {
        double erro = 0;
        for (Neuronio n : this.rede.getSaida()) {
            erro += n.getErro();
        }
        erro *= erro;
        erro = erro / 2;
        return erro;
    }

    public int[] saidaDesejada(ArrayList classe, boolean funT, int j) {
        int[] saida = new int[qtdSaida];
        for (int k = 0; k < qtdSaida; k++) {
            if (funT) {
                if ((int) classe.get(j) == (k + 1)) {
                    saida[k] = 1;
                } else {
                    saida[k] = 0;
                }
            } else {
                if ((int) classe.get(j) == (k + 1)) {
                    saida[k] = 1;
                } else {
                    saida[k] = -1;
                }
            }
        }
        return saida;

    }

    public void testaRede(Automato rede, float[][] entradas, ArrayList classe, boolean funT, int tam) {
        float[] entrada = new float[qtdEntrada];
        int[] saida;
        this.rede = rede;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < entradas[0].length; j++) {
                for (int k = 0; k < qtdEntrada; k++) {
                    entrada[k] = entradas[k][j];
                }
                saida = saidaDesejada(classe, funT, j);
                calculaNetOculta(entrada);
                if (funT) {//Logistica
                    aplicaLogistica(true); //Camada oculta
                } else {
                    aplicaTanHiperbolica(true);
                }
                calculaNetSaida();
                if (funT) {//Logistica
                    aplicaLogistica(false); //Camda de saida
                } else {
                    aplicaTanHiperbolica(false);
                }
            }
        }
    }

    public double treinaRedeIteracao(Automato rede, float[][] entradas, ArrayList classe, boolean funT, int tam) {
        float[] entrada = new float[qtdEntrada];
        int[] saida;
        this.rede = rede;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < entradas[0].length; j++) {
                for (int k = 0; k < qtdEntrada; k++) {
                    entrada[k] = entradas[k][j];
                }
                saida = saidaDesejada(classe, funT, j);
                calculaNetOculta(entrada);
                if (funT) {//Logistica
                    aplicaLogistica(true); //Camada oculta
                } else {
                    aplicaTanHiperbolica(true);
                }
                calculaNetSaida();
                if (funT) {//Logistica
                    aplicaLogistica(false); //Camda de saida
                } else {
                    aplicaTanHiperbolica(false);
                }
                calculaErroSaida(funT, saida);
                calculaErroOculta(funT);
                ajustaPesosOculta(entrada);
                ajustaPesosSaida();

            }
        }
        return calculaErroRede();
    }

    public int treinaRedeErro(Automato rede, float[][] entradas, ArrayList classe, boolean funT, double erro) {
        float[] entrada = new float[qtdEntrada];
        int[] saida;
        this.rede = rede;
        double e;
        int i = 0;
        boolean aux;

        do {
            aux = false;
            for (int j = 0; j < entradas[0].length; j++) {
                for (int k = 0; k < qtdEntrada; k++) {
                    entrada[k] = entradas[k][j];
                }
                saida = saidaDesejada(classe, funT, j);
                calculaNetOculta(entrada);
                if (funT) {//Logistica
                    aplicaLogistica(true); //Camada oculta
                } else {
                    aplicaTanHiperbolica(true);
                }
                calculaNetSaida();
                if (funT) {//Logistica
                    aplicaLogistica(false); //Camda de saida
                } else {
                    aplicaTanHiperbolica(false);
                }
                calculaErroSaida(funT, saida);
                calculaErroOculta(funT);
                ajustaPesosOculta(entrada);
                ajustaPesosSaida();

                e = calculaErroRede();
                System.out.println(e);

                if (e >= erro) {
                    aux = true;
                }

            }
            System.out.println(i);

            i++;
        } while (aux);
        return i;
    }

}
