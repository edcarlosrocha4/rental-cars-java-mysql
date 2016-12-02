/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rentalcars.views;

import java.sql.*;
import br.rentalcars.dal.ModuleConnection;
import static java.lang.reflect.Array.set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author alefsilva
 */
public class Usuario extends javax.swing.JInternalFrame {

    // Usando variavel de conexao
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;

    /**
     * Creates new form Usuario
     */
    public Usuario() {
        initComponents();
        conn = ModuleConnection.connect();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Conexão Erro");
        }
    }

    private void consultar() {
        String sql = "SELECT * FROM users WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdUsuario.getText());
            result = pst.executeQuery();
            if (result.next()) {
                txtNomeUsuario.setText(result.getString(4));
                txtEmailUsuario.setText(result.getString(5));
                txtLoginUsuario.setText(result.getString(2));
                txtPasswordUsuario.setText(result.getString(3));
                cbPerfilUsuario.setSelectedItem(result.getString(6));

            } else {

                JOptionPane.showMessageDialog(null, "Usuario não encontrado :C ");
                txtNomeUsuario.setText(null);
                txtEmailUsuario.setText(null);
                txtLoginUsuario.setText(null);
                txtPasswordUsuario.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void limpar() {

        int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Limpar Todos os Campos ?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (opc == JOptionPane.YES_OPTION) {
            txtNomeUsuario.setText(null);
            txtEmailUsuario.setText(null);
            txtLoginUsuario.setText(null);
            txtPasswordUsuario.setText(null);
            txtIdUsuario.setText(null);
        }

    }

    private void adicionar() {

        String sql = "INSERT INTO users (username,password,nome,email,perfil) VALUES (?,?,?,?,?);";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtLoginUsuario.getText());
            pst.setString(2, txtPasswordUsuario.getText());
            pst.setString(3, txtNomeUsuario.getText());
            pst.setString(4, txtEmailUsuario.getText());
            pst.setString(5, cbPerfilUsuario.getSelectedItem().toString());
            if ((txtNomeUsuario.getText().isEmpty()) || (txtEmailUsuario.getText().isEmpty()) || (txtLoginUsuario.getText().isEmpty()) || (txtPasswordUsuario.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
                    txtNomeUsuario.setText(null);
                    txtEmailUsuario.setText(null);
                    txtLoginUsuario.setText(null);
                    txtPasswordUsuario.setText(null);
                    txtIdUsuario.setText(null);
                    btnAddUsuario.setEnabled(true);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void editar() {

        String sql = "UPDATE users SET username=?,password=?,nome=?,email=?,perfil=? WHERE id=?;";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtLoginUsuario.getText());
            pst.setString(2, txtPasswordUsuario.getText());
            pst.setString(3, txtNomeUsuario.getText());
            pst.setString(4, txtEmailUsuario.getText());
            pst.setString(5, cbPerfilUsuario.getSelectedItem().toString());
            pst.setString(6, txtIdUsuario.getText());
            if ((txtNomeUsuario.getText().isEmpty()) || (txtEmailUsuario.getText().isEmpty()) || (txtLoginUsuario.getText().isEmpty()) || (txtPasswordUsuario.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso");
                    txtNomeUsuario.setText(null);
                    txtEmailUsuario.setText(null);
                    txtLoginUsuario.setText(null);
                    txtPasswordUsuario.setText(null);
                    txtIdUsuario.setText(null);
                    btnAddUsuario.setEnabled(true);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
    private void deletar(){
        int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este usuario ?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM users WHERE id=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtIdUsuario.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso");
                    txtNomeUsuario.setText(null);
                    txtEmailUsuario.setText(null);
                    txtLoginUsuario.setText(null);
                    txtPasswordUsuario.setText(null);
                    txtIdUsuario.setText(null);
                    btnAddUsuario.setEnabled(true);
                } else {
                    
                    JOptionPane.showMessageDialog(null, "erro ao tentar remover usuário");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }

    private void consultarNome() throws SQLException {

        String sql = "SELECT * FROM users WHERE nome LIKE ?;";
        pst = conn.prepareStatement(sql);

        try {
            pst.setString(1, txtPesqUsuarioNome.getText() + "%");
            result = pst.executeQuery();
            // comando abaixo usa a biblioteca rs2xml.jar para preencher a tabela abaixo
            tbUsuario.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
    
    private void setarCampos(){
        
        int set = tbUsuario.getSelectedRow();
        txtIdUsuario.setText(tbUsuario.getModel().getValueAt(set, 0).toString());
        txtNomeUsuario.setText(tbUsuario.getModel().getValueAt(set,1).toString());
        txtEmailUsuario.setText(tbUsuario.getModel().getValueAt(set,2).toString());
        txtLoginUsuario.setText(tbUsuario.getModel().getValueAt(set,3).toString());
        txtPasswordUsuario.setText(tbUsuario.getModel().getValueAt(set,4).toString());
        btnAddUsuario.setEnabled(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        btnAddUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPasswordUsuario = new javax.swing.JPasswordField();
        txtNomeUsuario = new javax.swing.JTextField();
        txtEmailUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLoginUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbPerfilUsuario = new javax.swing.JComboBox<>();
        btnEditUsuario = new javax.swing.JButton();
        btnDeleteUsuario = new javax.swing.JButton();
        btnLimparUsuario = new javax.swing.JButton();
        txtPesqUsuarioNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 2, 18)); // NOI18N
        jLabel11.setText("Novo Cliente");

        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(905, 495));

        btnAddUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698913-icon-81-document-add-32.png"))); // NOI18N
        btnAddUsuario.setToolTipText("Adicionar");
        btnAddUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setText("* Nome");

        jLabel2.setText("* E-mail");

        jLabel3.setText("* Senha");

        jLabel4.setText("* Perfil ");

        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        jLabel13.setFont(new java.awt.Font("DejaVu Serif", 2, 18)); // NOI18N
        jLabel13.setText("Usuários");

        jLabel6.setText("* Login");

        jLabel7.setText("ID");

        txtIdUsuario.setEditable(false);
        txtIdUsuario.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setText("* Campos Obrigatorios");

        cbPerfilUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        btnEditUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698873-icon-136-document-edit-32.png"))); // NOI18N
        btnEditUsuario.setToolTipText("Editar");
        btnEditUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUsuarioActionPerformed(evt);
            }
        });

        btnDeleteUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698910-icon-79-document-cancel-32.png"))); // NOI18N
        btnDeleteUsuario.setToolTipText("Excluir");
        btnDeleteUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUsuarioActionPerformed(evt);
            }
        });

        btnLimparUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698908-icon-27-trash-can-32.png"))); // NOI18N
        btnLimparUsuario.setToolTipText("Limpar Campos");
        btnLimparUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparUsuarioActionPerformed(evt);
            }
        });

        txtPesqUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqUsuarioNomeActionPerformed(evt);
            }
        });
        txtPesqUsuarioNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqUsuarioNomeKeyReleased(evt);
            }
        });

        jLabel5.setText("Nome");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel9.setText("Pesquisar ");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698838-icon-111-search-32.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAddUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimparUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPesqUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel6))
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPasswordUsuario)
                                            .addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(143, 143, 143))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesqUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimparUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAddUsuario)
                        .addComponent(btnEditUsuario)
                        .addComponent(btnDeleteUsuario)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuarioActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAddUsuarioActionPerformed

    private void btnLimparUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparUsuarioActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparUsuarioActionPerformed

    private void txtPesqUsuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqUsuarioNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqUsuarioNomeActionPerformed

    private void btnEditUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUsuarioActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_btnEditUsuarioActionPerformed

    private void txtPesqUsuarioNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqUsuarioNomeKeyReleased
        try {
            // TODO add your handling code here:
            consultarNome();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesqUsuarioNomeKeyReleased

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        // TODO add your handling code here:
        setarCampos();
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btnDeleteUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUsuarioActionPerformed
        // TODO add your handling code here:
        deletar();
    }//GEN-LAST:event_btnDeleteUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnDeleteUsuario;
    private javax.swing.JButton btnEditUsuario;
    private javax.swing.JButton btnLimparUsuario;
    private javax.swing.JComboBox<String> cbPerfilUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuario;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtLoginUsuario;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JPasswordField txtPasswordUsuario;
    private javax.swing.JTextField txtPesqUsuarioNome;
    // End of variables declaration//GEN-END:variables
}
