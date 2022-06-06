/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistence.Pacientes;

/**
 *
 * @author Alexandre
 */
public class TelaImprimir extends javax.swing.JFrame {

    public static String cpf;

    /**
     * Creates new form TelaImprimir
     */
    public TelaImprimir() {
        initComponents();
        btnImprimir.setVisible(false);
       
    }

    TelaImprimir(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void exportarCpf(Pacientes model) {

        txtCpf.setText(model.getCpf());

    }

    //lblAssinadoNome.setText("Assinado por: " + nome);
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        cmbResultado = new javax.swing.JComboBox<>();

        setTitle("TelaImprimir");
        getContentPane().setLayout(null);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(370, 110, 160, 40);

        btnImprimir.setText("IMPRIMIR");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir);
        btnImprimir.setBounds(370, 110, 160, 40);

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "NOME", "CONVENIO", "DATA DE NASCIMENTO", "STATUS EXAME", "TELEFONE", "ENDERECO"
            }
        ));
        jScrollPane1.setViewportView(tblPaciente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 860, 150);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/background Projeto_1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 0, 440, 310);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/background Projeto_1.jpg"))); // NOI18N
        jLabel2.setText("jLabel1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 440, 310);

        txtCpf.setEditable(false);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(220, 110, 130, 40);

        cmbResultado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RESULTADO GERAL" }));
        cmbResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbResultadoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbResultado);
        cmbResultado.setBounds(30, 110, 160, 40);

        setSize(new java.awt.Dimension(898, 209));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        JOptionPane.showMessageDialog(null, "Impresso com sucesso!");
        dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        btnImprimir.setVisible(true);
        btnBuscar.setVisible(false);
        
        try {
            // Conectar no BD
            Connection con;
            PreparedStatement st;
            ResultSet rs;
            String combo;
            DefaultTableModel tblPacientes;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoacesso", "root", "tico0715612!");

            combo = cmbResultado.getSelectedItem().toString();
            if (combo.equalsIgnoreCase("RESULTADO GERAL")) {
                st = con.prepareStatement("SELECT * FROM paciente WHERE cpf = ?");
                st.setString(1, txtCpf.getText());
                rs = st.executeQuery();
                tblPacientes = (DefaultTableModel) tblPaciente.getModel();
                while (rs.next()) { // Enquanto tiver linnha de cliente no rs
                    Object[] dados = {
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("convenio"),
                        rs.getString("datanascimento"),
                        rs.getString("statusexame"),
                        rs.getString("telefone"),
                        rs.getString("endereco")};
                    tblPacientes.addRow(dados);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no acesso à base de dados. Entre em contato com o administrador e informe o erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbResultadoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaImprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaImprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaImprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaImprimir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaImprimir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbResultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
