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
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultHighlighter;
import rede_neural.Rede;

/**
 *
 * @author fabio
 */
public class Tela extends javax.swing.JFrame {

    private float[][] entradas;
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
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        AutomatoLayout = new javax.swing.JPanel();
        PanelAutomato = new javax.swing.JPanel();
        TelaPanel = new javax.swing.JScrollPane(this.view);
        EstadosBtnPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        numNeuronios = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        log = new javax.swing.JRadioButton();
        thip = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        numIt = new javax.swing.JRadioButton();
        erroMax = new javax.swing.JRadioButton();
        numItText = new javax.swing.JTextField();
        erroMaxText = new javax.swing.JTextField();
        treinarRede = new javax.swing.JButton();
        TabelaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPesos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
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
        TelaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clique no Neurônio para editar seus pesos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de neurônios da camada oculta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(numNeuronios, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numNeuronios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Função de Transferência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        buttonGroup1.add(log);
        log.setText("Logística");

        buttonGroup1.add(thip);
        thip.setText("Tangente Hiperbólica");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(log)
                    .addComponent(thip))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(log)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thip))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Condição de Parada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        buttonGroup2.add(numIt);
        numIt.setText("Número de Iterações");

        buttonGroup2.add(erroMax);
        erroMax.setText("Erro máximo da rede");

        numItText.setText("200");
        numItText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numItTextActionPerformed(evt);
            }
        });

        erroMaxText.setText("0.001");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(erroMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(numIt)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(numItText)
                    .addComponent(erroMaxText, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numIt)
                    .addComponent(numItText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(erroMax)
                    .addComponent(erroMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        treinarRede.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        treinarRede.setText("Treinar Rede");

        javax.swing.GroupLayout EstadosBtnPanelLayout = new javax.swing.GroupLayout(EstadosBtnPanel);
        EstadosBtnPanel.setLayout(EstadosBtnPanelLayout);
        EstadosBtnPanelLayout.setHorizontalGroup(
            EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstadosBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(treinarRede, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addContainerGap())
        );
        EstadosBtnPanelLayout.setVerticalGroup(
            EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstadosBtnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(treinarRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EstadosBtnPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(EstadosBtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );

        tabelaPesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Neurônio Ligado", "Pesos"
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
        tabelaPesos.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tabelaPesos);

        jButton1.setText("Salvar mudanças");

        javax.swing.GroupLayout TabelaPanelLayout = new javax.swing.GroupLayout(TabelaPanel);
        TabelaPanel.setLayout(TabelaPanelLayout);
        TabelaPanelLayout.setHorizontalGroup(
            TabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabelaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        TabelaPanelLayout.setVerticalGroup(
            TabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabelaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelAutomatoLayout = new javax.swing.GroupLayout(PanelAutomato);
        PanelAutomato.setLayout(PanelAutomatoLayout);
        PanelAutomatoLayout.setHorizontalGroup(
            PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAutomatoLayout.createSequentialGroup()
                        .addComponent(EstadosBtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(PanelAutomatoLayout.createSequentialGroup()
                        .addComponent(TelaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TabelaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        PanelAutomatoLayout.setVerticalGroup(
            PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAutomatoLayout.createSequentialGroup()
                .addComponent(EstadosBtnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelAutomatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TelaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TabelaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(AutomatoLayout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        this.neuronio = this.rede.busca(p.x, p.y);
        if (neuronio != null) {
            this.neuronio.setFocus(true);
            setTabelaPesos(this.neuronio);
        }

        this.TelaPanel.repaint();
    }//GEN-LAST:event_TelaPanelMouseClicked

    private void TelaPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelaPanelMouseDragged

    }//GEN-LAST:event_TelaPanelMouseDragged

    private void PopUpItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopUpItem1ActionPerformed

    }//GEN-LAST:event_PopUpItem1ActionPerformed

    private void PopUpItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopUpItem2ActionPerformed

    }//GEN-LAST:event_PopUpItem2ActionPerformed

    private void CriarLabel_PopUpItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarLabel_PopUpItem3ActionPerformed

    }//GEN-LAST:event_CriarLabel_PopUpItem3ActionPerformed

    private void TelaPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelaPanelKeyTyped

    }//GEN-LAST:event_TelaPanelKeyTyped

    private void load_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_menuActionPerformed
        int numEntradas;
        int numSaidas = 0;
        String aux, line;
        ArrayList<ArrayList<Integer>> entradas;

        JFileChooser jc = new JFileChooser("D:\\Users\\Gi\\Desktop\\Desktop\\BCC\\7SEMESTRE\\IA");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
        jc.setFileFilter(filter);
        int result;
        result = jc.showOpenDialog(null);

        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {

            entradas = new ArrayList();
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
                    entradas.add(new ArrayList());
                }

                numEntradas = entradas.size();

                while (in.ready()) {
                    line = in.readLine();
                    t1 = new StringTokenizer(line, ",");

                    for (int i = 0; i < numEntradas; i++) {
                        aux = t1.nextToken();
                        entradas.get(i).add(Integer.parseInt(aux));
                    }
                    aux = t1.nextToken();
                    if (!this.saidas.contains(Integer.parseInt(aux))) {
                        numSaidas++;
                    }
                    this.saidas.add(Integer.parseInt(aux));

                }
                this.r = new Rede(numEntradas, numSaidas);

                this.entradas = this.r.normalizaEntradas(entradas);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void numItTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numItTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numItTextActionPerformed

    public void criarRede() {

        int qtdEntrada = this.r.getQtdEntrada();
        int qtdSaida = this.r.getQtdSaida();
        int qtdOculta = this.r.getQtdOculta();

        // Criando os neurônios
        for (int i = 0; i < qtdEntrada; i++) {
            Neuronio n = new Neuronio(50, (i + 1) * 100, "e" + i, i, ENTRADA);
            this.rede.addNeuronio(n);
        }

        // Criando os neuronios da camada de saída, e setando os seus pesos
        for (int i = 0; i < qtdSaida; i++) {
            Neuronio n = new Neuronio(450, (i + 1) * 100, "s" + i, i, SAIDA);
            this.rede.addNeuronio(n);
            double[] pesos = new double[qtdOculta];

            for (int j = 0; j < qtdOculta; j++) {
                pesos[j] = Math.random();
            }
            n.setPeso(pesos);
        }

        // Criando os neuronios da camada de saída, e setando os seus pesos
        for (int i = 0; i < qtdOculta; i++) {
            Neuronio n = new Neuronio(250, (i + 1) * 100, "o" + i, i, OCULTA);
            double[] pesos = new double[qtdEntrada];

            for (int j = 0; j < qtdEntrada; j++) {
                pesos[j] = Math.random();
            }

            n.setPeso(pesos);
            this.rede.addNeuronio(n);
        }
        addArestas();

        this.TelaPanel.repaint();
    }

    public void addArestas() {
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
    }

    public void setTabelaPesos(Neuronio n) {
        int i = 0;
        DefaultTableModel model = (DefaultTableModel) this.tabelaPesos.getModel();

        if (n.getTipo() == ENTRADA) {
            model.setRowCount(0);
            return;
        }

        model.setRowCount(n.getPeso().length);

        for (Aresta a : this.rede.getArestas()) {

            if (a.getDestino() == n) {
                model.setValueAt(a.getOrigem().getEstado(), i, 0);
                model.setValueAt(n.getPeso()[a.getOrigem().getPos()], i, 1);

                i++;
            }

        }

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
    private javax.swing.JPanel TabelaPanel;
    private javax.swing.JScrollPane TelaPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton erroMax;
    private javax.swing.JTextField erroMaxText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem load_menu;
    private javax.swing.JRadioButton log;
    private javax.swing.JRadioButton numIt;
    private javax.swing.JTextField numItText;
    private javax.swing.JTextField numNeuronios;
    private javax.swing.JTable tabelaPesos;
    private javax.swing.JRadioButton thip;
    private javax.swing.JButton treinarRede;
    // End of variables declaration//GEN-END:variables
}
