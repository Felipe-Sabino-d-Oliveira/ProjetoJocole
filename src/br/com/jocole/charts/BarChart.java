/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.CategoryAxis;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.Map;
/**
 *
 * @author felipe.slima
 */
public class BarChart {

// Método para criar gráficos de barras dinamicamente
        public static JPanel criarGraficoDeBarras(String tituloGrafico, String eixoX, String eixoY, 
                                              Map<String, Double> valores, Map<String, Color> cores) {
        // Criar o dataset com os valores recebidos dinamicamente
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Adicionar os valores ao dataset (chave = categoria, valor = valor)
        for (Map.Entry<String, Double> entrada : valores.entrySet()) {
            dataset.addValue(entrada.getValue(), entrada.getKey(), entrada.getKey());
        }

        // Criar o gráfico com os parâmetros recebidos
        JFreeChart grafico = ChartFactory.createBarChart(
                tituloGrafico,  // Título do gráfico
                eixoX,          // Rótulo do eixo X (categoria)
                eixoY,          // Rótulo do eixo Y (valor)
                dataset         // Dataset criado com os valores
        );

        // Personalizar o gráfico
        CategoryPlot plot = grafico.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Aplicar cores diferentes para cada barra
        int i = 0;
        for (String categoria : valores.keySet()) {
            // Verificar se existe uma cor para essa categoria
            Color cor = cores.getOrDefault(categoria, Color.GRAY);  // Cor padrão caso não tenha uma definida
            renderer.setSeriesPaint(i, cor);  // Aplicar cor à barra correspondente
            i++;
        }

        // Aumentar o espaçamento entre as barras
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.025);  // Espaçamento entre as categorias (barras)

        // Definir a largura máxima das barras
        renderer.setMaximumBarWidth(0.05);  // Reduz a largura das barras

        // Criar o ChartPanel e definir suas dimensões
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setSize(525, 450);  // Define o tamanho fixo do gráfico

        // Criar um JPanel para incluir o gráfico
        JPanel panel = new JPanel(null);  // Null layout para posicionamento manual
        chartPanel.setBounds(0, 0, 525, 450);  // Definir as dimensões do ChartPanel
        panel.add(chartPanel);  // Adicionar o ChartPanel ao JPanel

        // Retornar o JPanel que contém o gráfico
        return panel;
    }

}