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
import java.awt.Color;

/**
 *
 * @author felipe.slima
 */
public class ChartHome {
    
    public ChartPanel criarGraficoDeBarras() {
        // Criar dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1000, "Vendas", "Janeiro");
        dataset.addValue(1500, "Vendas", "Fevereiro");
        dataset.addValue(1200, "Vendas", "Março");
        dataset.addValue(1800, "Vendas", "Abril");

        // Criar o gráfico
        JFreeChart grafico = ChartFactory.createBarChart(
                "Vendas Mensais", // Título do gráfico
                "Mês", // Eixo X
                "Valor", // Eixo Y
                dataset
        );

        // Customizar as cores do gráfico (opcional)
        CategoryPlot plot = grafico.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);  // Cor da primeira série (azul)

        // Retornar o gráfico empacotado em um ChartPanel
        return new ChartPanel(grafico);
    }
}
