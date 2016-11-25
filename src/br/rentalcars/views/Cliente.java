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
public class Cliente extends javax.swing.JInternalFrame {
    // Usando variavel de conexao

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet result = null;

    private void consultar() {
        String sql = "SELECT * FROM clientes WHERE id=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdCliente.getText());
            result = pst.executeQuery();
            if (result.next()) {
                TxtNome.setText(result.getString(2));
                TxtEmail.setText(result.getString(3));
                txtNasc.setText(result.getString(4));
                cbSexo.setSelectedItem(result.getString(5));
                TxtCpf.setText(result.getString(6));
                TxtRg.setText(result.getString(7));
                TxtCelular.setText(result.getString(8));
                TxtTelefone.setText(result.getString(9));
                TxtRua.setText(result.getString(10));
                TxtCidade.setText(result.getString(11));
                TxtCep.setText(result.getString(12));
                TxtNumero.setText(result.getString(13));
                cbUf.setSelectedItem(result.getString(14));

            } else {

                JOptionPane.showMessageDialog(null, "Cliente não encontrado :C ");
                TxtNome.setText(null);
                TxtEmail.setText(null);
                txtNasc.setText(null);
                cbSexo.setSelectedItem(null);
                TxtCpf.setText(null);
                TxtRg.setText(null);
                TxtCelular.setText(null);
                TxtTelefone.setText(null);
                TxtRua.setText(null);
                TxtCidade.setText(null);
                TxtCep.setText(null);
                TxtNumero.setText(null);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void limpar() {
        int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Limpar Todos os Campos ?", "Atenção", JOptionPane.YES_NO_OPTION);

        if (opc == JOptionPane.YES_OPTION) {
            TxtNome.setText(null);
            TxtEmail.setText(null);
            txtNasc.setText(null);
            cbSexo.setSelectedItem(null);
            TxtCpf.setText(null);
            TxtRg.setText(null);
            TxtCelular.setText(null);
            TxtTelefone.setText(null);
            TxtRua.setText(null);
            TxtCidade.setText(null);
            TxtCep.setText(null);
            TxtNumero.setText(null);
        }

    }

    private void adicionar() {

        String sql = "INSERT INTO clientes (nome,email,nasc,sexo,cpf,rg,celular,fone,rua,cidade,cep,n,uf) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TxtNome.getText());
            pst.setString(2, TxtEmail.getText());
            pst.setString(3, txtNasc.getText());
            pst.setString(4, cbSexo.getSelectedItem().toString());
            pst.setString(5, TxtCpf.getText());
            pst.setString(6, TxtRg.getText());
            pst.setString(7, TxtCelular.getText());
            pst.setString(8, TxtTelefone.getText());
            pst.setString(9, TxtRua.getText());
            pst.setString(10, TxtCidade.getText());
            pst.setString(11, TxtCep.getText());
            pst.setString(12, TxtNumero.getText());
            pst.setString(13, cbUf.getSelectedItem().toString());
            if ((TxtNome.getText().isEmpty()) || (TxtEmail.getText().isEmpty()) || (txtNasc.getText().isEmpty()) || (TxtCpf.getText().isEmpty()) || (TxtRg.getText().isEmpty()) || (TxtCelular.getText().isEmpty()) || (TxtTelefone.getText().isEmpty()) || (TxtRua.getText().isEmpty()) | (TxtCidade.getText().isEmpty()) | (TxtCep.getText().isEmpty()) | (TxtNumero.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
                    TxtNome.setText(null);
                    TxtEmail.setText(null);
                    txtNasc.setText(null);
                    cbSexo.setSelectedItem(null);
                    TxtCpf.setText(null);
                    TxtRg.setText(null);
                    TxtCelular.setText(null);
                    TxtTelefone.setText(null);
                    TxtRua.setText(null);
                    TxtCidade.setText(null);
                    TxtCep.setText(null);
                    TxtNumero.setText(null);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void editar() {

        String sql = "UPDATE clientes SET nome=?,email=?,nasc=?,sexo=?,cpf=?,rg=?,celular=?,fone=?,rua=?,cidade=?,cep=?,n=?,uf=? WHERE id=?;";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, TxtNome.getText());
            pst.setString(2, TxtEmail.getText());
            pst.setString(3, txtNasc.getText());
            pst.setString(4, cbSexo.getSelectedItem().toString());
            pst.setString(5, TxtCpf.getText());
            pst.setString(6, TxtRg.getText());
            pst.setString(7, TxtCelular.getText());
            pst.setString(8, TxtTelefone.getText());
            pst.setString(9, TxtRua.getText());
            pst.setString(10, TxtCidade.getText());
            pst.setString(11, TxtCep.getText());
            pst.setString(12, TxtNumero.getText());
            pst.setString(13, cbUf.getSelectedItem().toString());
            pst.setString(14, txtIdCliente.getText());
            if ((TxtNome.getText().isEmpty()) || (TxtEmail.getText().isEmpty()) || (txtNasc.getText().isEmpty()) || (TxtCpf.getText().isEmpty()) || (TxtRg.getText().isEmpty()) || (TxtCelular.getText().isEmpty()) || (TxtTelefone.getText().isEmpty()) || (TxtRua.getText().isEmpty()) | (TxtCidade.getText().isEmpty()) | (TxtCep.getText().isEmpty()) | (TxtNumero.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios");

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
                    TxtNome.setText(null);
                    TxtEmail.setText(null);
                    txtNasc.setText(null);
                    cbSexo.setSelectedItem(null);
                    TxtCpf.setText(null);
                    TxtRg.setText(null);
                    TxtCelular.setText(null);
                    TxtTelefone.setText(null);
                    TxtRua.setText(null);
                    TxtCidade.setText(null);
                    TxtCep.setText(null);
                    TxtNumero.setText(null);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void consultarNome() throws SQLException {

        String sql = "SELECT * FROM clientes WHERE nome LIKE ?;";
        pst = conn.prepareStatement(sql);

        try {
            pst.setString(1, txtPesqCli.getText() + "%");
            result = pst.executeQuery();
            // comando abaixo usa a biblioteca rs2xml.jar para preencher a tabela abaixo
            tbCliente.setModel(DbUtils.resultSetToTableModel(result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    private void setarCampos() {

        int set = tbCliente.getSelectedRow();
        TxtNome.setText(tbCliente.getModel().getValueAt(set, 1).toString());
        TxtEmail.setText(tbCliente.getModel().getValueAt(set, 2).toString());
        txtNasc.setText(tbCliente.getModel().getValueAt(set, 3).toString());
        cbSexo.setSelectedItem(tbCliente.getModel().getValueAt(set, 4).toString());
        TxtCpf.setText(tbCliente.getModel().getValueAt(set, 5).toString());
        TxtRg.setText(tbCliente.getModel().getValueAt(set, 6).toString());
        TxtTelefone.setText(tbCliente.getModel().getValueAt(set, 7).toString());
        TxtCelular.setText(tbCliente.getModel().getValueAt(set, 8).toString());
        TxtRua.setText(tbCliente.getModel().getValueAt(set, 9).toString());
        TxtCidade.setText(tbCliente.getModel().getValueAt(set, 10).toString());
        TxtCep.setText(tbCliente.getModel().getValueAt(set, 11).toString());
        TxtNumero.setText(tbCliente.getModel().getValueAt(set, 12).toString());
        cbUf.setSelectedItem(tbCliente.getModel().getValueAt(set, 13).toString());

    }

    /**
     * Creates new form Cliente
     */
    public Cliente() {
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

        TxtRg = new javax.swing.JTextField();
        TxtCpf = new javax.swing.JTextField();
        TxtNome = new javax.swing.JTextField();
        TxtRua = new javax.swing.JTextField();
        TxtCidade = new javax.swing.JTextField();
        TxtNumero = new javax.swing.JTextField();
        TxtTelefone = new javax.swing.JTextField();
        TxtCelular = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtCep = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCadastrarCli = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        txtPesqCli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnPesqCli = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btLimparCamposCliente = new javax.swing.JButton();
        cbUf = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNasc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        setResizable(true);
        setTitle("Cadastro de Clientes");
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        TxtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNumeroActionPerformed(evt);
            }
        });

        jLabel1.setText("*Nome");

        jLabel2.setText("*RG");

        jLabel3.setText("*CPF");

        jLabel4.setText("*Rua");

        jLabel5.setText("*Cidade");

        jLabel6.setText("*Nº");

        jLabel7.setText("*CEP");

        jLabel8.setText("*Telefone");

        jLabel9.setText("Celular");

        jLabel10.setText("*E-mail");

        btnCadastrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698913-icon-81-document-add-32.png"))); // NOI18N
        btnCadastrarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCliActionPerformed(evt);
            }
        });

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        tbCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        txtPesqCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqCliKeyReleased(evt);
            }
        });

        jLabel12.setText("Pequisar");

        btnPesqCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698838-icon-111-search-32.png"))); // NOI18N
        btnPesqCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqCliActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("DejaVu Serif", 2, 18)); // NOI18N
        jLabel13.setText("Clientes");

        jLabel14.setText("ID");

        jLabel11.setText("* Campos Obrigatórios");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698910-icon-79-document-cancel-32.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698873-icon-136-document-edit-32.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btLimparCamposCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/rentalcars/icons/698908-icon-27-trash-can-32.png"))); // NOI18N
        btLimparCamposCliente.setToolTipText("Limpar Campos");
        btLimparCamposCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparCamposClienteActionPerformed(evt);
            }
        });

        cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));

        jLabel15.setText("UF");

        jLabel16.setText("*Nacimento");

        jLabel17.setText("Sexo");

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel18.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNumero)))
                        .addGap(161, 161, 161))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(260, 260, 260))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(btnCadastrarCli)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btLimparCamposCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel17)
                            .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtRg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(TxtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addComponent(btnPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastrarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLimparCamposCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
        );

        setBounds(0, 0, 1000, 550);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNumeroActionPerformed

    private void btnCadastrarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCliActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnCadastrarCliActionPerformed

    private void btnPesqCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqCliActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnPesqCliActionPerformed

    private void btLimparCamposClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparCamposClienteActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btLimparCamposClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbClienteKeyReleased

    }//GEN-LAST:event_tbClienteKeyReleased

    private void txtPesqCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqCliKeyReleased
        // TODO add your handling code here: 
        try {
            // TODO add your handling code here:
            consultarNome();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesqCliKeyReleased

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        // TODO add your handling code here:
        setarCampos();
    }//GEN-LAST:event_tbClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtCelular;
    private javax.swing.JTextField TxtCep;
    private javax.swing.JTextField TxtCidade;
    private javax.swing.JTextField TxtCpf;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtNumero;
    private javax.swing.JTextField TxtRg;
    private javax.swing.JTextField TxtRua;
    private javax.swing.JTextField TxtTelefone;
    private javax.swing.JButton btLimparCamposCliente;
    private javax.swing.JButton btnCadastrarCli;
    private javax.swing.JButton btnPesqCli;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cbUf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNasc;
    private javax.swing.JTextField txtPesqCli;
    // End of variables declaration//GEN-END:variables
}
