/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rentalcars.views;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author alefsilva
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal1
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpDesktop = new javax.swing.JDesktopPane();
        lbUsuario = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        newCliente = new javax.swing.JMenu();
        MenCadCliente = new javax.swing.JMenuItem();
        MenCadVeiculo = new javax.swing.JMenuItem();
        MenCadUsuario = new javax.swing.JMenuItem();
        MenCadAlugar = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        MenConsulTodosUsuarios = new javax.swing.JMenu();
        MenCadTodosClientes = new javax.swing.JMenuItem();
        MenConsulClientes = new javax.swing.JMenuItem();
        MenConsulTodosVeiculos = new javax.swing.JMenuItem();
        MenTodasLocacoes = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        MenTodasNotas = new javax.swing.JMenuItem();
        MenBtnExit = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rental Sytem - Painel de Controle");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jdpDesktop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jdpDesktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jdpDesktopLayout = new javax.swing.GroupLayout(jdpDesktop);
        jdpDesktop.setLayout(jdpDesktopLayout);
        jdpDesktopLayout.setHorizontalGroup(
            jdpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        jdpDesktopLayout.setVerticalGroup(
            jdpDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        lbUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        lbUsuario.setText("Usuário");

        lbData.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lbData.setText("Data");

        newCliente.setText("CADASTRAR");
        newCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClienteActionPerformed(evt);
            }
        });

        MenCadCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        MenCadCliente.setText("CLIENTE");
        MenCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadClienteActionPerformed(evt);
            }
        });
        newCliente.add(MenCadCliente);

        MenCadVeiculo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        MenCadVeiculo.setText("VEICULO");
        MenCadVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadVeiculoActionPerformed(evt);
            }
        });
        newCliente.add(MenCadVeiculo);

        MenCadUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        MenCadUsuario.setText("USUÁRIO");
        MenCadUsuario.setEnabled(false);
        MenCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadUsuarioActionPerformed(evt);
            }
        });
        newCliente.add(MenCadUsuario);

        jMenuBar1.add(newCliente);

        MenCadAlugar.setText("ALUGAR");

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem9.setText("VEICULO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        MenCadAlugar.add(jMenuItem9);

        jMenuBar1.add(MenCadAlugar);

        MenConsulTodosUsuarios.setText("CONSULTAR");

        MenCadTodosClientes.setText("TODOS USUARIOS");
        MenCadTodosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadTodosClientesActionPerformed(evt);
            }
        });
        MenConsulTodosUsuarios.add(MenCadTodosClientes);

        MenConsulClientes.setText("TODOS CLIENTES");
        MenConsulClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenConsulClientesActionPerformed(evt);
            }
        });
        MenConsulTodosUsuarios.add(MenConsulClientes);

        MenConsulTodosVeiculos.setText("TODOS VEICULOS");
        MenConsulTodosVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenConsulTodosVeiculosActionPerformed(evt);
            }
        });
        MenConsulTodosUsuarios.add(MenConsulTodosVeiculos);

        jMenuBar1.add(MenConsulTodosUsuarios);

        MenTodasLocacoes.setText("RELÁTORIOS");

        jMenuItem10.setText("LOCAÇÕES");
        jMenuItem10.setEnabled(false);
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        MenTodasLocacoes.add(jMenuItem10);

        MenTodasNotas.setText("NOTAS FISCAIS");
        MenTodasNotas.setEnabled(false);
        MenTodasNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenTodasNotasActionPerformed(evt);
            }
        });
        MenTodasLocacoes.add(MenTodasNotas);

        jMenuBar1.add(MenTodasLocacoes);

        MenBtnExit.setText("OPÇÕES");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenBtnExit.add(jMenuItem6);

        jMenuBar1.add(MenBtnExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdpDesktop)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbData)
                            .addComponent(lbUsuario))
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jdpDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadClienteActionPerformed
        // TODO add your handling code here:
        Cliente TelaCliente = new Cliente();
        jdpDesktop.add(TelaCliente);
        TelaCliente.setVisible(true);
    }//GEN-LAST:event_MenCadClienteActionPerformed

    private void MenCadVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadVeiculoActionPerformed
        // TODO add your handling code here:
        Veiculo TelaVeiculo = new Veiculo();
        jdpDesktop.add(TelaVeiculo);
        TelaVeiculo.setVisible(true);
    }//GEN-LAST:event_MenCadVeiculoActionPerformed

    private void MenCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadUsuarioActionPerformed
        // TODO add your handling code here:
        Usuario TelaUsuario = new Usuario();
        jdpDesktop.add(TelaUsuario);
        TelaUsuario.setVisible(true);
    }//GEN-LAST:event_MenCadUsuarioActionPerformed

    private void newClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newClienteActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        AlugaVeiculo TelaAlugaVeiculo = new AlugaVeiculo();
        jdpDesktop.add(TelaAlugaVeiculo);
        TelaAlugaVeiculo.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void MenCadTodosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadTodosClientesActionPerformed
        // TODO add your handling code here:
        TodosUsuarios TelaTodosUsuarios = new TodosUsuarios();
        jdpDesktop.add(TelaTodosUsuarios);
        TelaTodosUsuarios.setVisible(true);
    }//GEN-LAST:event_MenCadTodosClientesActionPerformed

    private void MenConsulClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenConsulClientesActionPerformed
        // TODO add your handling code here:
        TodosClientes TelaTodosClientes = new TodosClientes();
        jdpDesktop.add(TelaTodosClientes);
        TelaTodosClientes.setVisible(true);
    }//GEN-LAST:event_MenConsulClientesActionPerformed

    private void MenConsulTodosVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenConsulTodosVeiculosActionPerformed
        // TODO add your handling code here:
        TodosVeiculos TelaTodosVeiculos = new TodosVeiculos();
        jdpDesktop.add(TelaTodosVeiculos);
        TelaTodosVeiculos.setVisible(true);
    }//GEN-LAST:event_MenConsulTodosVeiculosActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        TodasLocacoes TelaTodasLocacoes = new TodasLocacoes();
        jdpDesktop.add(TelaTodasLocacoes);
        TelaTodasLocacoes.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void MenTodasNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenTodasNotasActionPerformed
        // TODO add your handling code here:
        TodasNotas TelaTodasNotas = new TodasNotas();
        jdpDesktop.add(TelaTodasNotas);
        TelaTodasNotas.setVisible(true);
    }//GEN-LAST:event_MenTodasNotasActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        // Exibir uma confirmação de fechar o sistema
        int sair = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair ?","Atenção",JOptionPane.YES_NO_OPTION);
        
        if(sair == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Substituir Lable Data  ldData por data atual do sistema ao inicializar a tela.
        Date data = new Date();
        DateFormat formatada = DateFormat.getDateInstance(DateFormat.SHORT);
        lbData.setText(formatada.format(data));
        
        
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenBtnExit;
    private javax.swing.JMenu MenCadAlugar;
    private javax.swing.JMenuItem MenCadCliente;
    private javax.swing.JMenuItem MenCadTodosClientes;
    public static javax.swing.JMenuItem MenCadUsuario;
    private javax.swing.JMenuItem MenCadVeiculo;
    private javax.swing.JMenuItem MenConsulClientes;
    private javax.swing.JMenu MenConsulTodosUsuarios;
    private javax.swing.JMenuItem MenConsulTodosVeiculos;
    private javax.swing.JMenu MenTodasLocacoes;
    public static javax.swing.JMenuItem MenTodasNotas;
    private javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JDesktopPane jdpDesktop;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JMenu newCliente;
    // End of variables declaration//GEN-END:variables
}