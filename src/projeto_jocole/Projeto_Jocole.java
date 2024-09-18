/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto_jocole;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author felipe.slima
 */
public class Projeto_Jocole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Criando o JFrame principal
        JFrame frame = new JFrame("Sistema PDV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Criando o CardLayout para alternar entre os painéis
        CardLayout cardLayout = new CardLayout();
        JPanel panelContainer = new JPanel(cardLayout);

        // Criando os painéis (telas) que serão alternados
        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Tela de Login"));
        JButton goToDashboardButton = new JButton("Ir para o Dashboard");
        loginPanel.add(goToDashboardButton);

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.add(new JLabel("Dashboard do PDV"));
        JButton goToLoginButton = new JButton("Voltar para o Login");
        dashboardPanel.add(goToLoginButton);

        // Adicionando os painéis ao container
        panelContainer.add(loginPanel, "login");
        panelContainer.add(dashboardPanel, "dashboard");

        // Adicionando ação aos botões para alternar as telas
        goToDashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alterna para o painel de Dashboard
                cardLayout.show(panelContainer, "dashboard");
            }
        });

        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Alterna de volta para o painel de Login
                cardLayout.show(panelContainer, "login");
            }
        });

        // Adicionando o container com os painéis ao JFrame
        frame.add(panelContainer);

        // Tornando a janela visível
        frame.setVisible(true);
    }

}
