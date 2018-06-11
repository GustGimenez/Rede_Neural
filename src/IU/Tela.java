/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import rede_neural.Rede;

/**
 *
 * @author fabio
 */
public class Tela extends javax.swing.JFrame {

    private ArrayList<ArrayList> entradas;
    private ArrayList<Integer> saidas;
    private Automato rede;
    private Neuronio neuronio;
    private Aresta aresta;
    private Rede r;
    private ViewPanel view;
    private ViewPanel view2;
    private ViewPanel view3;

    private final int ENTRADA = 0;
    private final int OCULTA = 1;
    private final int SAIDA = 2;

    private final boolean gr;
    private int auxX, auxY;
    private String strTrans;

    private int op; // 0 - novo estado, 1 -  nova transição, 2 - remover, 3 - arrastar

    private DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);

    /*
        *Inicializa as Views
        *Deve ser chamado ANTES initComponents
     */
    private void initTela() {
        this.view = new ViewPanel(rede);
        this.view2 = new ViewPanel(rede);
        this.view2.setBackground(Color.white);
        this.view3 = new ViewPanel(rede);
        this.view3.setBackground(Color.white);
    }

    /*
        *Setar valores iniciais dos componentes
        *Deve ser chamado DEPOIS initComponents
     */
    private void setComp() {

        this.view.setBackground(Color.white);
        this.TelaPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.TelaPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    public Tela() {
        rede = new Automato();
        this.gr = false;
        this.initTela();
        initComponents();
        this.setComp();

    }

    /*
        *Herdado do projeto de automatos
     */
    public Tela(Automato a) {
        this.gr = true;
        this.rede = a;
        this.initTela();
        initComponents();
        this.setComp();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Menu = new javax.swing.JPopupMenu();
        PopUpItem1 = new javax.swing.JCheckBoxMenuItem();
        PopUpItem2 = new javax.swing.JCheckBoxMenuItem();
        CriarLabel_PopUpItem3 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        AutomatoLayout = new javax.swing.JPanel();
        PanelAutomato = new javax.swing.JPanel();
        TelaPanel = new javax.swing.JScrollPane(this.view);
        EstadosBtnPanel = new javax.swing.JPanel();
        arrastarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        File_menu = new javax.swing.JMenu();
        load_menu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        PopUpItem1.setText("Inicial");
        PopUpItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopUpItem1ActionPerformed(evt);
            }
        });
        Menu.add(PopUpItem1);

        PopUpItem2.setText("Final");
        PopUpItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopUpItem2ActionPerformed(evt);
            }
        });
        Menu.add(PopUpItem2);

        CriarLabel_PopUpItem3.setLabel("Criar Label");
        CriarLabel_PopUpItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarLabel_PopUpItem3ActionPerformed(evt);
            }
        });
        Menu.add(CriarLabel_PopUpItem3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AutomatoLayout.setLayout(new java.awt.CardLayout());

        TelaPanel.setBackground(new java.awt.Color(204, 204, 204));
        TelaPanel.setAutoscrolls(true);
        TelaPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        TelaPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TelaPanelMouseDragged(evt);
            }
        });
        TelaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelaPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelaPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TelaPanelMouseReleased(evt);
            }
        });
        TelaPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelaPanelKeyTyped(evt);
            }
        });

        EstadosBtnPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        arrastarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrastarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EstadosBtnPanelLayout = new javax.swing.GroupLayout(EstadosBtnPanel);
        EstadosBtnPanel.setLayout(EstadosBtnPanelLayout);
        EstadosBtnPanelLayout.setHorizontalGroup(
            EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadosBtnPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrastarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EstadosBtnPanelLayout.setVerticalGroup(
            EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadosBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arrastarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Neurônios", "Pesos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout PanelAutomatoLayout = new javax.swing.GroupLayout(PanelAutomato);
        PanelAutomato.setLayout(PanelAutomatoLayout);
        PanelAutomatoLayout.setHorizontalGroup(
            PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EstadosBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelAutomatoLayout.createSequentialGroup()
                        .addComponent(TelaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        PanelAutomatoLayout.setVerticalGroup(
            PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EstadosBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TelaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PanelAutomatoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        AutomatoLayout.add(PanelAutomato, "AutomatoEdit");

        File_menu.setText("Arquivos");

        load_menu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        load_menu.setText("Carregar Arquivo de Treinamento");
        load_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                load_menuActionPerformed(evt);
            }
        });
        File_menu.add(load_menu);

        jMenuBar1.add(File_menu);

        jMenu1.setText("Rede");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AutomatoLayout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AutomatoLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TelaPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaPanelMouseReleased
        try {
            this.view.getS().setLine(0, 0, 0, 0);
            Point p = this.view.getMousePosition();
            Neuronio v = rede.busca(p.x, p.y);

        } catch (NullPointerException e) {

        } finally {
            this.TelaPanel.updateUI();
        }
    }//GEN-LAST:event_TelaPanelMouseReleased

    private void TelaPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaPanelMousePressed
        try {
            if (neuronio != null) {
                this.neuronio.setFocus(false);
            }
            Point p = this.view.getMousePosition();

            this.neuronio = rede.busca(p.x, p.y);
            if (neuronio != null) {
                this.neuronio.setFocus(true);
            }

            this.TelaPanel.repaint();
        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_TelaPanelMousePressed

    private void TelaPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaPanelMouseClicked
        Point p = this.view.getMousePosition();

        if (evt.getClickCount() == 2) { // verificar edição de estado
//            this.strTrans = this.rede.getStrTrans(p);
//            this.aresta = this.rede.getArestas(p);
//            if (strTrans != null) {
//                this.auxX = p.x;
//                this.auxY = p.y;
//
//            }
        }
        this.TelaPanel.repaint();
    }//GEN-LAST:event_TelaPanelMouseClicked

    private void TelaPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaPanelMouseDragged

    }//GEN-LAST:event_TelaPanelMouseDragged

    private void PopUpItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopUpItem1ActionPerformed

    }//GEN-LAST:event_PopUpItem1ActionPerformed

    private void PopUpItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopUpItem2ActionPerformed

    }//GEN-LAST:event_PopUpItem2ActionPerformed

    private void arrastarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrastarButtonActionPerformed
    }//GEN-LAST:event_arrastarButtonActionPerformed

    private void CriarLabel_PopUpItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarLabel_PopUpItem3ActionPerformed

    }//GEN-LAST:event_CriarLabel_PopUpItem3ActionPerformed

    private void TelaPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelaPanelKeyTyped

    }//GEN-LAST:event_TelaPanelKeyTyped

    private void load_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_menuActionPerformed
        int numEntradas;
        int numSaidas = 0;
        String aux, line;

        JFileChooser jc = new JFileChooser("D:\\Users\\Gi\\Desktop\\Desktop\\BCC\\7SEMESTRE\\IA");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
        jc.setFileFilter(filter);
        int result;
        result = jc.showOpenDialog(null);

        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {

            this.entradas = new ArrayList();
            this.saidas = new ArrayList();

            BufferedReader in = null;
            try {
                String filename = jc.getSelectedFile().getAbsolutePath();
                in = new BufferedReader(new FileReader(filename));

                line = in.readLine();
                StringTokenizer t1 = new StringTokenizer(line, ",");

                aux = t1.nextToken();
                while (t1.hasMoreTokens()) {
                    aux = t1.nextToken();
                    this.entradas.add(new ArrayList());
                }

                numEntradas = this.entradas.size();

                while (in.ready()) {
                    line = in.readLine();
                    t1 = new StringTokenizer(line, ",");

                    for (int i = 0; i < numEntradas; i++) {
                        aux = t1.nextToken();
                        this.entradas.get(i).add(Integer.parseInt(aux));
                    }
                    aux = t1.nextToken();
                    if (!this.saidas.contains(Integer.parseInt(aux))) {
                        numSaidas++;
                    }
                    this.saidas.add(Integer.parseInt(aux));

                }
                this.r = new Rede(numEntradas, numSaidas);
                
                criarRede();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_load_menuActionPerformed

    public void criarRede() {
        int qtdEntrada = this.r.getQtdEntrada();
        int qtdSaida = this.r.getQtdSaida();
        int qtdOculta = this.r.getQtdOculta();
        
        // Criando os neurônios
        for (int i = 1; i <= qtdEntrada; i++) {
            Neuronio n = new Neuronio(50, i * 100, "e" + i, ENTRADA);
            this.rede.addNeuronio(n);
        }
        
        // Criando os neuronios da camada de saída, e setando os seus pesos
        for (int i = 1; i <= qtdSaida; i++) {
            Neuronio n = new Neuronio(450, i * 100, "s" + i, SAIDA);
            this.rede.addNeuronio(n);
            double[] pesos = new double[qtdOculta];
            
            for (int j = 0; j < qtdOculta; j++) {
                pesos[j] = Math.random();
            }
            n.setPeso(pesos);
        }
        
        // Criando os neuronios da camada de saída, e setando os seus pesos
        for (int i = 1; i <= qtdOculta; i++) {
            Neuronio n = new Neuronio(250, i * 100, "o" + i, OCULTA);
            double[] pesos = new double[qtdEntrada];
            
            for (int j = 0; j < qtdEntrada; j++) {
                pesos[j] = Math.random();
            }
            
            n.setPeso(pesos);
            this.rede.addNeuronio(n);
        }

        for (Neuronio nIni : this.rede.getNeuronios()) {
            for (Neuronio nFim : this.rede.getNeuronios()) {
                if (nIni.getTipo() == ENTRADA) {
                    if (nFim.getTipo() == OCULTA) {
                        Aresta a = new Aresta(nIni, nFim);
                        this.rede.addAresta(a);
                    }
                } else if (nIni.getTipo() == OCULTA) {
                    if (nFim.getTipo() == SAIDA) {
                        Aresta a = new Aresta(nIni, nFim);
                        this.rede.addAresta(a);
                    }
                }
            }
        }

        this.TelaPanel.repaint();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });

    }

    public class MeuPanel extends javax.swing.JPanel {

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AutomatoLayout;
    private javax.swing.JMenuItem CriarLabel_PopUpItem3;
    private javax.swing.JPanel EstadosBtnPanel;
    private javax.swing.JMenu File_menu;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JPanel PanelAutomato;
    private javax.swing.JCheckBoxMenuItem PopUpItem1;
    private javax.swing.JCheckBoxMenuItem PopUpItem2;
    private javax.swing.JScrollPane TelaPanel;
    private javax.swing.JButton arrastarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem load_menu;
    // End of variables declaration//GEN-END:variables
}
