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
public class Veiculo extends javax.swing.JInternalFrame {

    // Usando variavel de conexao
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;

    private void consultar() {
        String sql = "SELECT * FROM veiculos WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdVeiculo.getText());
            result = pst.executeQuery();
            if (result.next()) {
                txtMontadora.setText(result.getString(2));
                txtModelo.setText(result.getString(3));
                txtPlaca.setText(result.getString(4));
                cbCombustivel.setSelectedItem(result.getString(5));
                txtCor.setText(result.getString(6));
                txtAnoFab.setText(result.getString(7));
                txtAnoModel.setText(result.getString(8));
                txtValorDia.setText(result.getString(9));

            } else {
                JOptionPane.showMessageDialog(null, "Veiculo não encontrado :C ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void limpar() {
        int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Limpar Todos os Campos ?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (opc == JOptionPane.YES_OPTION) {
            txtMontadora.setText(null);
            txtModelo.setText(null);
            txtPlaca.setText(null);
            txtCor.setText(null);
            txtAnoFab.setText(null);
            txtAnoModel.setText(null);
            txtValorDia.setText(null);
        }

    }

    private void adicionar() {

        String sql = "INSERT INTO veiculos (montadora,modelo,placa,combustivel,cor,ano_fab,ano_model,valor_dia) VALUES (?,?,?,?,?,?,?,?);";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtMontadora.getText());
            pst.setString(2, txtModelo.getText());
            pst.setString(3, txtPlaca.getText());
            pst.setString(5, txtCor.getText());
            pst.setString(6, txtAnoFab.getText());
            pst.setString(7, txtAnoModel.getText());
            pst.setString(8, txtValorDia.getText());
            pst.setString(4, cbCombustivel.getSelectedItem().toString());
            if ((txtMontadora.getText().isEmpty()) || (txtModelo.getText().isEmpty()) || (txtPlaca.getText().isEmpty()) || (txtCor.getText().isEmpty()) || (txtAnoFab.getText().isEmpty()) || (txtPlaca.getText().isEmpty()) || (txtAnoModel.getText().isEmpty()) || (txtValorDia.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso");
                    txtMontadora.setText(null);
                    txtModelo.setText(null);
                    txtPlaca.setText(null);
                    txtCor.setText(null);
                    txtAnoFab.setText(null);
                    txtAnoModel.setText(null);
                    txtValorDia.setText(null);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void editar() {

        String sql = "UPDATE veiculos SET montadora=?,modelo=?,placa=?,combustivel=?,cor=?,ano_fab=?,ano_model=?,valor_dia=? WHERE id=?;";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtMontadora.getText());
            pst.setString(2, txtModelo.getText());
            pst.setString(3, txtPlaca.getText());
            pst.setString(5, txtCor.getText());
            pst.setString(6, txtAnoFab.getText());
            pst.setString(7, txtAnoModel.getText());
            pst.setString(8, txtValorDia.getText());
            pst.setString(4, cbCombustivel.getSelectedItem().toString());
            pst.setString(9, txtIdVeiculo.getText());

            if ((txtMontadora.getText().isEmpty()) || (txtModelo.getText().isEmpty()) || (txtPlaca.getText().isEmpty()) || (txtCor.getText().isEmpty()) || (txtAnoFab.getText().isEmpty()) || (txtPlaca.getText().isEmpty()) || (txtAnoModel.getText().isEmpty()) || (txtValorDia.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo Atualizado com sucesso");
                    txtMontadora.setText(null);
                    txtModelo.setText(null);
                    txtPlaca.setText(null);
                    txtCor.setText(null);
                    txtAnoFab.setText(null);
                    txtAnoModel.setText(null);
                    txtValorDia.setText(null);
                    btnCadastrarVeiculo.setEnabled(true);
                    
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
      private void deletar(){
        int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM veiculos WHERE id=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtIdVeiculo.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo removido com sucesso");
                    txtMontadora.setText(null);
                    txtModelo.setText(null);
                    txtPlaca.setText(null);
                    txtCor.setText(null);
                    txtAnoFab.setText(null);
                    txtAnoModel.setText(null);
                    txtValorDia.setText(null);
                    btnCadastrarVeiculo.setEnabled(true);
                } else {
                    
                    JOptionPane.showMessageDialog(null, "erro ao tentar remover veiculo");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }


    private void consultarModelo() throws SQLException {

        String sql = "SELECT * FROM veiculos WHERE montadora LIKE ?;";
        pst = conn.prepareStatement(sql);

        try {
            pst.setString(1, txtPesqVeiculo.getText() + "%");
            result = pst.executeQuery();
            // comando abaixo usa a biblioteca rs2xml.jar para preencher a tabela abaixo
            tbVeiculo.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void setarCampos() {

        int set = tbVeiculo.getSelectedRow();
        txtIdVeiculo.setText(tbVeiculo.getModel().getValueAt(set,0).toString());
        txtMontadora.setText(tbVeiculo.getModel().getValueAt(set,1).toString());
        txtModelo.setText(tbVeiculo.getModel().getValueAt(set,2).toString());
        txtPlaca.setText(tbVeiculo.getModel().getValueAt(set,3).toString());
        cbCombustivel.setSelectedItem(tbVeiculo.getModel().getValueAt(set,4).toString());
        txtCor.setText(tbVeiculo.getModel().getValueAt(set,5).toString());
        txtAnoFab.setText(tbVeiculo.getModel().getValueAt(set,6).toString());
        txtAnoModel.setText(tbVeiculo.getModel().getValueAt(set,7).toString());
        txtValorDia.setText(tbVeiculo.getModel().getValueAt(set,8).toString());
        btnCadastrarVeiculo.setEnabled(false);

    }

    /**
     * Creates new form Veiculo
     */
    public Veiculo() {
        initComponents();
        conn = ModuleConnection.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Conexão Erro");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCadastrarVeiculo = new javax.swing.JButton();
        txtMontadora = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAnoFab = new javax.swing.JTextField();
        txtAnoModel = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtValorDia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();
        txtPesqVeiculo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdVeiculo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbCombustivel = new javax.swing.JComboBox<>();
        btEditVeiculo = new javax.swing.JButton();
        btDelVeiculo = new javax.swing.JButton();
        btLimparCamposVeiculos = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setTitle("Cadastro de Veiculos");
        setPreferredSize(new java.awt.Dimension(906, 496));

        jLabel1.setText("*Montadora");

        jLabel2.setText("*Modelo");

        jLabel3.setText("*Combustivel");

        jLabel4.setText("*Placa");

        jLabel5.setText("*Cor");

        jLabel6.setText("*Valor Diaria");

        jLabel7.setText("*Ano Fabricação");

        jLabel8.setText("*Ano Modelo");

        btnCadastrarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698913-icon-81-document-add-32.png"))); // NOI18N
        btnCadastrarVeiculo.setToolTipText("Adicionar");
        btnCadastrarVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVeiculoActionPerformed(evt);
            }
        });

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        tbVeiculo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
        tbVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVeiculo);

        txtPesqVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqVeiculoKeyReleased(evt);
            }
        });

        jLabel10.setText("Pequisar");

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 2, 18)); // NOI18N
        jLabel11.setText("Veiculos");

        jLabel9.setText("* Campos Obrigatórios");

        txtIdVeiculo.setEditable(false);
        txtIdVeiculo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setText("ID");

        cbCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alcool", "Gasolina", "Flex ", "Gás", "Diesel" }));

        btEditVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698873-icon-136-document-edit-32.png"))); // NOI18N
        btEditVeiculo.setToolTipText("Editar");
        btEditVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditVeiculoActionPerformed(evt);
            }
        });

        btDelVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698910-icon-79-document-cancel-32.png"))); // NOI18N
        btDelVeiculo.setToolTipText("Excluir");
        btDelVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDelVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelVeiculoActionPerformed(evt);
            }
        });

        btLimparCamposVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698908-icon-27-trash-can-32.png"))); // NOI18N
        btLimparCamposVeiculos.setToolTipText("Limpar Campos");
        btLimparCamposVeiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLimparCamposVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparCamposVeiculosActionPerformed(evt);
            }
        });

        jLabel13.setText("Montadora");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698838-icon-111-search-32.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnoModel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAnoFab, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(349, 349, 349)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(36, 36, 36)
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel1)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(37, 37, 37)
                                                    .addComponent(jLabel12)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPesqVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)))))
                        .addGap(0, 92, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnCadastrarVeiculo)
                .addGap(18, 18, 18)
                .addComponent(btEditVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDelVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btLimparCamposVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMontadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtAnoFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtAnoModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtValorDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPesqVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarVeiculo)
                    .addComponent(btEditVeiculo)
                    .addComponent(btDelVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimparCamposVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVeiculoActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnCadastrarVeiculoActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void btLimparCamposVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparCamposVeiculosActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btLimparCamposVeiculosActionPerformed

    private void btEditVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditVeiculoActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btEditVeiculoActionPerformed

    private void txtPesqVeiculoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqVeiculoKeyReleased
        try {
            // TODO add your handling code here:
            consultarModelo();
        } catch (SQLException ex) {
            Logger.getLogger(Veiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesqVeiculoKeyReleased

    private void tbVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculoMouseClicked
        // TODO add your handling code here:
        setarCampos();
    }//GEN-LAST:event_tbVeiculoMouseClicked

    private void btDelVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelVeiculoActionPerformed
        // TODO add your handling code here:
        deletar();
    }//GEN-LAST:event_btDelVeiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelVeiculo;
    private javax.swing.JButton btEditVeiculo;
    private javax.swing.JButton btLimparCamposVeiculos;
    private javax.swing.JButton btnCadastrarVeiculo;
    private javax.swing.JComboBox<String> cbCombustivel;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeiculo;
    private javax.swing.JTextField txtAnoFab;
    private javax.swing.JTextField txtAnoModel;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtIdVeiculo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMontadora;
    private javax.swing.JTextField txtPesqVeiculo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValorDia;
    // End of variables declaration//GEN-END:variables
}
