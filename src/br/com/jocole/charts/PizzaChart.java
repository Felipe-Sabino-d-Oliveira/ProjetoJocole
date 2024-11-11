/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.charts;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Map;

/**
 *
 * @author felipe.slima
 */
public class PizzaChart {

        public static JPanel criarGraficoDePizza(String tituloGrafico, Map<String, Double> valores) {
        // Criar o dataset para o gráfico de pizza
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Adicionar os valores ao dataset (chave = categoria, valor = valor)
        for (Map.Entry<String, Double> entrada : valores.entrySet()) {
            dataset.setValue(entrada.getKey(), entrada.getValue());
        }

        // Criar o gráfico de pizza com o dataset e o título fornecido
        JFreeChart grafico = ChartFactory.createPieChart(
                tituloGrafico,   // Título do gráfico
                dataset,         // Dataset criado com os valores
                true,            // Mostrar legendas
                true,            // Ferramentas de dicas (tooltips)
                false            // URLs (não necessário em um gráfico simples)
        );

        // Customizar o gráfico de pizza para exibir os valores
        PiePlot plot = (PiePlot) grafico.getPlot();
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator(
                "{0} = {1} ({2})")); // Exibe: categoria = valor (porcentagem)

        // Definir o formato dos valores, para mostrar valores com 2 casas decimais
        plot.setLabelBackgroundPaint(new Color(220, 220, 220));  // Cor do fundo dos rótulos
        plot.setLabelOutlinePaint(null);  // Remove a borda dos rótulos

        // Personalizar o gráfico (opcional)
        grafico.setBackgroundPaint(Color.white);

        // Criar o ChartPanel e definir suas dimensões
        ChartPanel chartPanel = new ChartPanel(grafico);
        chartPanel.setSize(450, 450);  // Define o tamanho fixo do gráfico

        // Criar um JPanel para incluir o gráfico
        JPanel panel = new JPanel(null);  // Null layout para posicionamento manual
        chartPanel.setBounds(0, 0, 450, 450);  // Definir as dimensões do ChartPanel
        panel.add(chartPanel);  // Adicionar o ChartPanel ao JPanel

        // Retornar o JPanel que contém o gráfico
        return panel;
    }

}
