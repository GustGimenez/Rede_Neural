/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Automato {

    ArrayList<Neuronio> entrada;
    ArrayList<Neuronio> saida;
    ArrayList<Neuronio> oculta;

    ArrayList<Aresta> arestas;
    private Neuronio Inicial; // Mantém o inicial para ser mais facilmente manipulado

    public Automato() {
        this.entrada = new ArrayList();
        this.saida = new ArrayList();
        this.oculta = new ArrayList();
        this.arestas = new ArrayList();
    }

    public ArrayList<Neuronio> getEntrada() {
        return entrada;
    }

    public void setEntrada(ArrayList<Neuronio> entrada) {
        this.entrada = entrada;
    }

    public ArrayList<Neuronio> getSaida() {
        return saida;
    }

    public void setSaida(ArrayList<Neuronio> saida) {
        this.saida = saida;
    }

    public ArrayList<Neuronio> getOculta() {
        return oculta;
    }

    public void setOculta(ArrayList<Neuronio> oculta) {
        this.oculta = oculta;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    //Retona a posição do inicial
    public int getIni() {
        return this.Inicial.getPos();
    }

    // Seta um novo vertice inicial
    public void setInicial(Neuronio Inicial) {
        this.Inicial = Inicial;
    }

    // Retona o objeto vertice inicial
    public Neuronio getInicial() {
        return Inicial;
    }

    // retona a string de uma transição que foi clicada
//    public String getStrTrans(Point p) {
//        String str;
//        for (Aresta a : this.arestas) {
//            str = a.editaTransicao(p);
//            if (str != null) {
//                return str;
//            }
//        }
//        return null;
//    }
    //retorna uma aresta que foi clicada
//    public Aresta getArestas(Point p) {
//        String str;
//        for (Aresta a : this.arestas) {
//            str = a.editaTransicao(p);
//            if (str != null) {
//                return a;
//            }
//        }
//        return null;
//    }
    // Retorna uma dimensão baseado nos vertices mais distantes em relação a origem
    public java.awt.Dimension getSize() {
        ArrayList<Neuronio> vertices = new ArrayList();

        for (Neuronio neuronio : this.entrada) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.saida) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.oculta) {
            vertices.add(neuronio);
        }

        if (vertices.size() > 0) {
            float maxX = vertices.get(0).getX();
            float minX = vertices.get(0).getX();
            float maxY = vertices.get(0).getY();
            float minY = vertices.get(0).getY();

            //Encontra o maior e menor valores para X e Y
            for (Neuronio v : vertices) {
                if (maxX < v.getX()) {
                    maxX = v.getX();
                } else if (minX > v.getX()) {
                    minX = v.getX();
                }

                if (maxY < v.getY()) {
                    maxY = v.getY();
                } else if (minY > v.getY()) {
                    minY = v.getY();
                }
            }

            int w = (int) (maxX + (vertices.get(0).getRaio() * 5)) + 350;
            int h = (int) (maxY + (vertices.get(0).getRaio() * 5));

            return new java.awt.Dimension(w, h);
        } else {
            return new java.awt.Dimension(500, 500);
        }

    }

    public Dimension getDimensao() {
        ArrayList<Neuronio> vertices = new ArrayList();

        for (Neuronio neuronio : this.entrada) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.saida) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.oculta) {
            vertices.add(neuronio);
        }
        int x = 0, y = 0;
        for (Neuronio v : vertices) {
            if (v.getX() > x) {
                x = v.getX();
            }

            if (v.getY() > y) {
                y = v.getY();
            }
        }

        return new Dimension(x + 50, y + 50);
    }

    /*
    *@arg estado posição do estado que está sendo selecionado
    Seta estado como selecionado e retorna para que possa ser manipulado
     */
    public Neuronio setSelected(int estado) {
        ArrayList<Neuronio> vertices = new ArrayList();

        for (Neuronio neuronio : this.entrada) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.saida) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.oculta) {
            vertices.add(neuronio);
        }
        Neuronio v = vertices.get(estado);
        v.setFocus(true);
        return v;
    }

    // Percorre as transições para recuperar o alfabeto
//    public ArrayList<Character> getAlfabeto() {
//        ArrayList<Character> alfa = new ArrayList();
//
//        for (Aresta a : arestas) {
//            for (String s : a.getTrans()) {
//                String[] arrayStr = s.split(";");
//                if (!alfa.contains(arrayStr[0].charAt(0))) {
//                    alfa.add(arrayStr[0].charAt(0));
//                }
//                if (!alfa.contains(arrayStr[1].charAt(0))) {
//                    alfa.add(arrayStr[1].charAt(0));
//                }
//            }
//        }
//
//        return alfa;
//    }
    public void draw(Graphics2D g) {

        for (Neuronio n : this.entrada) {
            n.desenha(g);
        }
        for (Neuronio n : this.saida) {
            n.desenha(g);
        }
        for (Neuronio n : this.oculta) {
            n.desenha(g);
        }

        for (Aresta a : arestas) {
            a.draw(g);
        }

    }

    public Neuronio busca(int x, int y) {
        ArrayList<Neuronio> vertices = new ArrayList();

        for (Neuronio neuronio : this.entrada) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.saida) {
            vertices.add(neuronio);
        }
        for (Neuronio neuronio : this.oculta) {
            vertices.add(neuronio);
        }
        int x1, y1, r;
        r = 20;
        for (Neuronio v : vertices) {
            x1 = Math.abs(v.getX() - x);
            y1 = Math.abs(v.getY() - y);

            if (x1 < r && y1 < r) {
                return v;
            }
        }
        return null;
    }

    public void addAresta(Aresta a) {
        this.arestas.add(a);
    }

//    public void removeTransicao(Point p) {
//        for (Aresta a : this.arestas) {
//            if (a.excluiTransicao(p)) {
//                if (a.getTrans().size() == 0) {
//                    if (a.getTipo() == 2 || a.getTipo() == 3) {
//                        for (Aresta a1 : arestas) {
//                            if (a1.getOrigem().equals(a.getDestino()) && a1.getDestino().equals(a.getOrigem())) {
//                                a1.setTipo(1);
//                            }
//                        }
//                    }
//                    this.arestas.remove(a);
//                }
//                return;
//            }
//        }
//    }
    public void removeNeuronio(Neuronio vertice) {
        int num = this.arestas.size();
        Aresta a;
        for (int i = 0; i < num; i++) {
            a = this.arestas.get(i);
            if (a.getOrigem().equals(vertice) || a.getDestino().equals(vertice)) {
                this.arestas.remove(a);
                i--;
                num--;
            }
        }
        if (vertice.getEstado().charAt(0) == 'o') {
            this.oculta.remove(vertice);
        } else if (vertice.getEstado().charAt(0) == 'e') {
            this.entrada.remove(vertice);
        } else if (vertice.getEstado().charAt(0) == 's') {
            this.saida.remove(vertice);
        }
        //setEstados();
    }

    /*
    Pega as transições de v1 para os outros vertices e copia para v2
    ou seja, para cada transição de v1 para vx, cria uma transição v2 para vx
     */
//    private void copiaTrans(Neuronio v1, Neuronio vc) {
//        for (int i = 0; i < this.arestas.size(); i++) {
//            Aresta a = this.arestas.get(i);
//            if (a.getOrigem().equals(v1)) {
//                Aresta a2 = this.addAresta(vc, a.getDestino());
//                for (String s : a.getTrans()) {
//                    a2.addTransicao(s, null);
//                }
//            }
//        }
//    }
    // nome auto explicativo
}
