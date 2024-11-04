/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.Color;

/**
 *
 * @author felipe.slima
 */
public class ChartHome {

    public JPanel criarGraficoDeBarras() {
        // Criar o dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1000, "Vendas", "Janeiro");
        dataset.addValue(1500, "Vendas", "Fevereiro");
        dataset.addValue(1200, "Vendas", "Março");
        dataset.addValue(1800, "Vendas", "Abril");

        // Criar o gráfico
        JFreeChart grafico = ChartFactory.createBarChart(
                "Vendas Mensais",  // Título do gráfico
                "Mês",             // Eixo X
                "Valor",           // Eixo Y
                dataset            // Dados
        );

        // Personalizar o gráfico
        CategoryPlot plot = grafico.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Definir a cor das barras usando os valores RGB (51, 0, 204)
        Color minhaCor = new Color(51, 0, 204);  // Cor baseada na imagem
        renderer.setSeriesPaint(0, minhaCor);    // Aplicar a cor às barras

        // Aumentar o espaçamento entre as barras usando o método setCategoryMargin
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.3); // Controlar o espaçamento entre as categorias (barras)

        // Definir a largura máxima das barras
        renderer.setMaximumBarWidth(0.05); // Reduz a largura das barras

        // Criar o ChartPanel e definir suas dimensões
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setSize(450, 450);  // Define o tamanho fixo do gráfico (450x450)

        // Criar um JPanel para incluir o gráfico
        JPanel panel = new JPanel(null);  // Null layout para posicionamento manual
        chartPanel.setBounds(0, 0, 450, 450);  // Definir as dimensões do ChartPanel
        panel.add(chartPanel);  // Adicionar o ChartPanel ao JPanel

        // Retornar o JPanel que contém o gráfico
        return panel;
    }
}