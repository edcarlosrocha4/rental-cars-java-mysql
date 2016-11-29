/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rentalcars.views;

import br.rentalcars.dal.ModuleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author alefsilva
 */
public class AlugaVeiculo extends javax.swing.JInternalFrame {
    // Usando variavel de conexao

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;
    String tipo;
    double total, valorDia;

    /**
     * Creates new form AlugaVeiculo
     */
    public AlugaVeiculo() {
        initComponents();
        conn = ModuleConnection.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Conexão Erro");
        }
    }

    private void alugar() {

        String sql = "INSERT INTO locacoes (veiculo_id,cliente_id,quantidade_dias,forma_pagamento,parcelas,valor_dia,valor_total,status) VALUES (?,?,?,?,?,?,?);  ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdVeiculo.getText());
            pst.setString(2, txtIdCliente.getText());
            pst.setString(3, txtDiasContratado.getText());
            pst.setString(4, cbFormaPag.getSelectedItem().toString());
            pst.setString(5, cbVezesPag.getSelectedItem().toString());
            pst.setString(6, txtValorDia.getText());
            // Linha Abaixo Captura e converte o valor para double para  realização do calculo 
            int quantidade = Integer.parseInt(txtDiasContratado.getText());
            // Linha abaixo converte o valor diario para double 
            valorDia = Double.parseDouble(txtValorDia.getText());
            // linha abaixo realiza o calculo do valor total
            total = valorDia * quantidade;
            pst.setString(7, Double.toString((double) total));
            pst.setString(8, cbStatus.getSelectedItem().toString());
            if ((txtIdVeiculo.getText().isEmpty()) || (txtIdCliente.getText().isEmpty()) || (txtDiasContratado.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo Reservado ou Alocado com sucesso");
                    txtIdVeiculo.setText(null);
                    txtIdCliente.setText(null);
                    txtDiasContratado.setText(null);
                    txtValorDia.setText(null);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void consultarVeiculo() throws SQLException {

        String sql = "SELECT * FROM veiculos WHERE montadora LIKE ?;";
        pst = conn.prepareStatement(sql);

        try {
            pst.setString(1, txtPesqVeiculo.getText() + "%");
            result = pst.executeQuery();
            // comando abaixo usa a biblioteca rs2xml.jar para preencher a tabela abaixo
            tbVeiculos.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void consultarCliente() throws SQLException {

        String sql = "SELECT * FROM users WHERE nome LIKE ?;";
        pst = conn.prepareStatement(sql);

        try {
            pst.setString(1, txtPesqCliente.getText() + "%");
            result = pst.executeQuery();
            // comando abaixo usa a biblioteca rs2xml.jar para preencher a tabela abaixo
            tbClientes.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void setarCampoVeiculo() {

        int set = tbVeiculos.getSelectedRow();
        txtIdVeiculo.setText(tbVeiculos.getModel().getValueAt(set, 0).toString());
        txtValorDia.setText(tbVeiculos.getModel().getValueAt(set, 8).toString());

    }

    private void setarCampoCliente() {

        int set = tbClientes.getSelectedRow();
        txtIdCliente.setText(tbClientes.getModel().getValueAt(set, 0).toString());

    }

    private void buscar() {
        String n = JOptionPane.showInputDialog("Numero de Identificação da Alocação?");
        String sql = "SELECT * FROM locacoes WHERE id=" + n;
        try {
            pst = conn.prepareStatement(sql);
            result = pst.executeQuery();
            if (result.next()) {
                txtIdNota.setText(result.getString(1));
                txtIdVeiculo.setText(result.getString(2));
                txtIdCliente.setText(result.getString(3));
                txtDiasContratado.setText(result.getString(4));
                txtDataNota.setText(result.getString(5));
                cbFormaPag.setSelectedItem(result.getString(6));
                cbVezesPag.setSelectedItem(result.getString(7));
                txtValorTotal.setText(result.getString(8));
                cbStatus.setSelectedItem(result.getString(9));
                tbVeiculos.setVisible(false);
                txtPesqVeiculo.setEnabled(false);
                tbClientes.setVisible(false);
                txtPesqCliente.setEnabled(false);
                btnAlugar.setEnabled(false);

            } else {

                JOptionPane.showMessageDialog(null, "Locação não encontrado :C ");

            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "Locação Invalida");
            
        }catch(Exception e2){
            JOptionPane.showMessageDialog(null,e2);
            
        }

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAlugar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        txtIdVeiculo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btAluga = new javax.swing.JButton();
        btDelAluguel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        txtPesqVeiculo = new javax.swing.JTextField();
        txtPesqCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtDiasContratado = new javax.swing.JTextField();
        cbFormaPag = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbVezesPag = new javax.swing.JComboBox<>();
        btDelAluguel1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdNota = new javax.swing.JTextField();
        txtDataNota = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btPrint = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtValorDia = new javax.swing.JTextField();
        btBucarLocacao = new javax.swing.JButton();
        txtValorTotal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setTitle("Registrar Locação Veiculo");
        setPreferredSize(new java.awt.Dimension(905, 495));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("* ID Veiculo");

        jLabel2.setText("* ID Cliente");

        jLabel3.setText("* Dias Contratados");

        btnAlugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698905-icon-24-key-32.png"))); // NOI18N
        btnAlugar.setToolTipText("Alugar");
        btnAlugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlugarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 2, 18)); // NOI18N
        jLabel11.setText("Alugar Veiculo ");

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVeiculos);

        txtIdVeiculo.setEditable(false);
        txtIdVeiculo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Pequisar Veiculo Por Fabricante");

        btAluga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698873-icon-136-document-edit-32.png"))); // NOI18N
        btAluga.setToolTipText("Editar");
        btAluga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btDelAluguel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698910-icon-79-document-cancel-32.png"))); // NOI18N
        btDelAluguel.setToolTipText("Excluir");
        btDelAluguel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbClientes);

        txtPesqVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqVeiculoKeyReleased(evt);
            }
        });

        txtPesqCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqClienteKeyReleased(evt);
            }
        });

        jLabel5.setText("Pequisar Cliente Por Nome");

        txtIdCliente.setEditable(false);
        txtIdCliente.setBackground(new java.awt.Color(204, 204, 204));

        txtDiasContratado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasContratadoActionPerformed(evt);
            }
        });

        cbFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão de Credito" }));

        jLabel6.setText("Forma de Pagamento");

        jLabel7.setText("N ° de Parcelas");

        cbVezesPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 ", "2 ", "3 ", "4 ", "5 ", "6" }));

        btDelAluguel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698908-icon-27-trash-can-32.png"))); // NOI18N
        btDelAluguel1.setToolTipText("Limpar");
        btDelAluguel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("N° Locação");

        jLabel9.setText("Data - Hora");

        txtIdNota.setEditable(false);
        txtIdNota.setBackground(new java.awt.Color(204, 204, 204));

        txtDataNota.setEditable(false);
        txtDataNota.setBackground(new java.awt.Color(204, 204, 204));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reservado", "Pagamento Confirmado" }));

        jLabel13.setText("Situação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdNota, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataNota))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel10.setText("* Campos Obrigatórios");

        btPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698852-icon-124-printer-text-32.png"))); // NOI18N
        btPrint.setToolTipText("Imprimir nota");
        btPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setText("Valor Dia");

        txtValorDia.setEditable(false);
        txtValorDia.setBackground(new java.awt.Color(204, 204, 204));

        btBucarLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698838-icon-111-search-32.png"))); // NOI18N
        btBucarLocacao.setToolTipText("Buscar Locação");
        btBucarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBucarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBucarLocacaoActionPerformed(evt);
            }
        });

        txtValorTotal.setEditable(false);
        txtValorTotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel14.setText("Valor Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtDiasContratado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(txtIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel12)))
                                .addGap(34, 34, 34))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6))
                                    .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cbVezesPag, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValorTotal)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(txtPesqCliente)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesqVeiculo)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAluga, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDelAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBucarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelAluguel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiasContratado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbVezesPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesqVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(txtPesqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAlugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAluga)
                            .addComponent(btDelAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDelAluguel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBucarLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        setBounds(0, 0, 904, 493);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlugarActionPerformed
        // TODO add your handling code here:
        alugar();
    }//GEN-LAST:event_btnAlugarActionPerformed

    private void tbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculosMouseClicked
        // TODO add your handling code here:
        setarCampoVeiculo();

    }//GEN-LAST:event_tbVeiculosMouseClicked

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        // TODO add your handling code here:

        setarCampoCliente();
    }//GEN-LAST:event_tbClientesMouseClicked

    private void txtPesqClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqClienteKeyReleased
        try {
            // TODO add your handling code here:
            consultarCliente();
        } catch (SQLException ex) {
            Logger.getLogger(AlugaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesqClienteKeyReleased

    private void txtPesqVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqVeiculoKeyReleased
        try {
            // TODO add your handling code here:
            consultarVeiculo();
        } catch (SQLException ex) {
            Logger.getLogger(AlugaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesqVeiculoKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtDiasContratadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasContratadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasContratadoActionPerformed

    private void btBucarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBucarLocacaoActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_btBucarLocacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAluga;
    private javax.swing.JButton btBucarLocacao;
    private javax.swing.JButton btDelAluguel;
    private javax.swing.JButton btDelAluguel1;
    private javax.swing.JButton btPrint;
    private javax.swing.JButton btnAlugar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbFormaPag;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbVezesPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField txtDataNota;
    private javax.swing.JTextField txtDiasContratado;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdNota;
    private javax.swing.JTextField txtIdVeiculo;
    private javax.swing.JTextField txtPesqCliente;
    private javax.swing.JTextField txtPesqVeiculo;
    private javax.swing.JTextField txtValorDia;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
