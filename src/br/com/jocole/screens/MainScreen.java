/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.jocole.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author yuri.vasconcelos
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    private CardLayout cardLayout;

    public MainScreen() {
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

        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);  // Configurar o layout do contentPane para usar CardLayout

        painel2 = new javax.swing.JPanel();
        painel2_2 = new javax.swing.JPanel();
        botaoPainelDois = new javax.swing.JButton();
        painel1 = new javax.swing.JPanel();
        painel1_1 = new javax.swing.JPanel();
        botaoPainelUm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        painel2_2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout painel2_2Layout = new javax.swing.GroupLayout(painel2_2);
        painel2_2.setLayout(painel2_2Layout);
        painel2_2Layout.setHorizontalGroup(
            painel2_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        painel2_2Layout.setVerticalGroup(
            painel2_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        botaoPainelDois.setText("Mudar para Painel 1");
        botaoPainelDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPainelDoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(painel2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(botaoPainelDois)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(painel2_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(botaoPainelDois)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        painel1_1.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout painel1_1Layout = new javax.swing.GroupLayout(painel1_1);
        painel1_1.setLayout(painel1_1Layout);
        painel1_1Layout.setHorizontalGroup(
            painel1_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        painel1_1Layout.setVerticalGroup(
            painel1_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        botaoPainelUm.setText("Mudar para Painel 2");
        botaoPainelUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPainelUmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel1Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painel1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPainelUm))
                .addGap(155, 155, 155))
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(painel1_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(botaoPainelUm)
                .addGap(45, 45, 45))
        );

        // Adicionando os painéis ao CardLayout com seus respectivos nomes
        getContentPane().add(painel1, "Painel 1");
        getContentPane().add(painel2, "Painel 2");

        // Exibir o painel 1 inicialmente
        cardLayout.show(getContentPane(), "Painel 1");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPainelDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPainelDoisActionPerformed
        // TODO add your handling code here:
        // Trocar para o Painel 1
        if (painel1 == null) {
            System.out.println("Painel 1 não está inicializado.");
        } else {
            cardLayout.show(getContentPane(), "Painel 1");
        }

    }//GEN-LAST:event_botaoPainelDoisActionPerformed

    private void botaoPainelUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPainelUmActionPerformed
        // TODO add your handling code here:
        if (painel1 == null) {
            System.out.println("Painel 2 não está inicializado.");
        } else {
            cardLayout.show(getContentPane(), "Painel 2");
        }

    }//GEN-LAST:event_botaoPainelUmActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPainelDois;
    private javax.swing.JButton botaoPainelUm;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel1_1;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel2_2;
    // End of variables declaration//GEN-END:variables
}
