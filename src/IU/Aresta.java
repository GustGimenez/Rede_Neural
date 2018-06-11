/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.geom.QuadCurve2D;

/**
 *
 * @author fabio
 */
public class Aresta {

    private final Neuronio origem;
    private final Neuronio destino;
    //private final String s;

    public Aresta(Neuronio o, Neuronio d) {
        this.origem = o;
        this.destino = d;
  //      this.s = s;

    }

    public Neuronio getOrigem() {
        return origem;
    }

    public Neuronio getDestino() {
        return destino;
    }

//    public String getTrans() {
//        return s;
//    }

    //Função para desenho 
    public void draw(Graphics2D g) {
        int des;
        g.setStroke(new java.awt.BasicStroke(2.0f));
        g.setColor(Color.BLACK);
        int r = this.origem.getRaio();
        Point po = new Point(this.origem.getX(), this.origem.getY());
        Point pd = new Point(this.destino.getX(), this.destino.getY());

        Point p1 = calculaAresta(po, pd, r);
        Point p2 = calculaAresta(pd, po, r);
        int x = (po.x + pd.x) / 2;
        int y = (po.y + pd.y) / 2;

        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        des = -12;
        g.setStroke(new java.awt.BasicStroke(1f));

//        g.drawString(s, x, y + des);

        this.drawArrowNew(g, po, pd, 6, r);

    }

    //Desenha setinha ao final da linha
    private void drawArrowNew(Graphics2D g2, Point s, Point t, int size, int deslocamento) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));

        float cos = (t.x - s.x) / r;
        float sen = (t.y - s.y) / r;
        int xAB = size + deslocamento;
        int yA = size;
        int yB = -size;

        Point pc = new Point(Math.round(deslocamento * -cos) + t.x, Math.round(deslocamento * -sen) + t.y);
        Point pa = new Point(Math.round(xAB * -cos - yA * -sen) + t.x, Math.round(xAB * -sen + yA * -cos) + t.y);
        Point pb = new Point(Math.round(xAB * -cos - yB * -sen) + t.x, Math.round(xAB * -sen + yB * -cos) + t.y);

        g2.drawLine(pc.x, pc.y, pa.x, pa.y);
        g2.drawLine(pc.x, pc.y, pb.x, pb.y);
    }

    //Verifica o ponto onde a aresta encosta no vertice
    private Point calculaAresta(Point s, Point t, int deslocamento) {
        float r = (float) Math.sqrt(Math.pow(s.x - t.x, 2) + Math.pow(s.y - t.y, 2));

        float cos = (t.x - s.x) / r;
        float sen = (t.y - s.y) / r;
        return new Point(Math.round(deslocamento * -cos) + t.x, Math.round(deslocamento * -sen) + t.y);

    }

    //Adiciona ou edita uma transição
    //strComp serve para comparação
//    public void addTransicao(String aux, String strComp) {
//        if (strComp == null) {  //se strComp é null, então é um novo estado
//            if (!this.trans.contains(aux)) {
//                this.trans.add(aux);
//            }
//        } else { // se strComp não é null, estamos editando um estado
//            int i = this.trans.indexOf(strComp);
//            this.trans.remove(i);
//            this.trans.add(i, aux);
//        }
//
//    }

    // verifica a partir do ponto do click se existe uma transição desenhada no local
//    public boolean excluiTransicao(Point p) {
//        int max = this.trans.size();
//        Point po = new Point(this.origem.getX(), this.origem.getY());
//        Point pd = new Point(this.destino.getX(), this.destino.getY());
//        int offset = 0;
//        int mult = -1;
//
//        offset = -12;
//
//        int y = (po.y + pd.y) / 2 - 10 + offset;
//        int x = (po.x + pd.x) / 2 - 7;
//        for (int i = 0; i < 1; i++) {
//            if (p.x > x && p.x < x + 50 && p.y > y && p.y < y + 12) {
//                break;
//            }
//            y += 13 * mult;
//        }
//
//        return (max > this.trans.size());
//    }

    // Verifica a partir de um click se existe uma transição para ser editada
//    public String editaTransicao(Point p) {
//        int max = this.trans.size();
//        Point po = new Point(this.origem.getX(), this.origem.getY());
//        Point pd = new Point(this.destino.getX(), this.destino.getY());
//        int offset = 0;
//        int mult = -1;
//        switch (this.tipo) {
//            case Aresta.TIPO_SIMPLES:
//                offset = -12;
//                break;
//            case Aresta.TIPO_CURVADO_SUPERIOR:
//                offset = -22;
//                break;
//            case Aresta.TIPO_CURVADO_INFERIOR:
//                offset = 32;
//                mult = 1;
//                break;
//            case Aresta.TIPO_SELF:
//                offset = -65;
//                break;
//
//        }
//        int y = (po.y + pd.y) / 2 - 10 + offset;
//        int x = (po.x + pd.x) / 2 - 7;
//        for (int i = 0; i < max; i++) {
//            if (p.x > x && p.x < x + 50 && p.y > y && p.y < y + 12) {
//                return this.trans.get(i);
//            }
//            y += 13 * mult;
//        }
//
//        return null;
//    }
}
