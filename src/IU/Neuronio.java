/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Neuronio {

    private int x; //coordenadas do desenho
    private int y; //coordenadas do desenho
    private int raio; // dimensao do circulo
    private String estado; // oque será escrito no centro do circulo
    private boolean focus; // desenha com cor diferente
    private Color cor;  // cor padrão do contorno
    private ArrayList<Double> peso;
    private double net;
    private double saida;
    private double erro;

    private int pos; // posição no ArrayList da maquina
    private boolean visitado; // auxiliar

    // Gets e Sets e construtor
    public Neuronio(int x, int y, String estado, int pos) {
        this.raio = 20;
        this.x = x;
        this.y = y;
        this.pos = pos;
        this.estado = estado;
        this.focus = false;
        this.peso = new ArrayList();
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public double getErro() {
        return erro;
    }

    public void setErro(double erro) {
        this.erro = erro;
    }

    
    
    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public ArrayList getPeso() {
        return this.peso;
    }

    public void setPeso(ArrayList peso) {
        this.peso = peso;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public void setColor(Color c) {
        this.cor = c;
    }

    public Color getColor() {
        return this.cor;
    }

    //Funções de desenho e manipulação
    //Desenho
    public void desenha(Graphics2D g) {
        if (this.focus) { // cor se está sendo focado
            g.setColor(Color.GREEN);
        } else { // cor padrão do circulo interno
            g.setColor(Color.orange);
        }
        g.fillOval(x - raio, y - raio, raio * 2, raio * 2);

        g.setColor(Color.BLACK); // cor da borda
        // borda simples
        g.setStroke(new java.awt.BasicStroke(3f));
        g.drawOval(x - raio, y - raio, raio * 2, raio * 2);

        g.drawString(this.estado, this.x - 4, this.y + 4);

//        if(this.tipo != 0){
//            g.drawString(""+this.peso, this.x - 4, this.y - 10);
//        }
    }

    // Funçao com parametros mais simples para desenhar circulos 
    public void desenhaCirculoBresenham(int x1, int y1, int x2, int y2, Graphics2D g) {
        int r, x, y, d, dE, dSE;
        r = (int) Math.round(Math.sqrt(Math.pow((double) (x2 - x1), 2) + Math.pow((double) (y2 - y1), 2)));
        x = 0;
        y = r;
        d = 1 - r;
        dE = 3;
        dSE = -2 * y + 5;

        simetria8(x, y, g, x1, y1);
        while (x <= y) {
            if (d > 0) {
                d += dSE;
                dSE += 4;
                y--;
            } else {
                d += dE;
                dSE += 2;
            }
            x++;
            dE += 2;
            simetria8(x, y, g, x1, y1);
        }

    }

    // Funcao auxiliar ao DesenhaCirculoBresenham
    private void simetria8(int x, int y, Graphics2D g, int xc, int yc) {
        float contorno = 2f;

        g.fillRect(x + xc, y + yc, (int) contorno, (int) contorno);
        g.fillRect(-x + xc, y + yc, (int) contorno, (int) contorno);
        g.fillRect(x + xc, -y + yc, (int) contorno, (int) contorno);
        g.fillRect(-x + xc, -y + yc, (int) contorno, (int) contorno);
        g.fillRect(y + xc, x + yc, (int) contorno, (int) contorno);
        g.fillRect(-y + xc, x + yc, (int) contorno, (int) contorno);
        g.fillRect(y + xc, -x + yc, (int) contorno, (int) contorno);
        g.fillRect(-y + xc, -x + yc, (int) contorno, (int) contorno);

    }

    //Desenha label abaixo do vertice
}
