/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.jocole.screens;

import br.com.jocole.charts.BarChart;
import br.com.jocole.charts.PizzaChart;
import br.com.jocole.utilities.Utilities;
import java.awt.BorderLayout;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JPanel;

import java.awt.Color;

/**
 *
 * @author felipe.slima
 */
public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreenComTab
     */
    public MainScreen() {
        initComponents();

        Utilities util = new Utilities();

        util.mostrarDataAtual(labelData);
        util.mostrarDataAtual(textFieldSaleData);
        
        util.mostrarTotalVendasDia(labelSales);

        util.loadProductsFromDatabase(previewProductTableProducts, "produtos", true);
        util.loadProductsFromDatabase(productDisplayTable, "produtos", false);

        util.loadProductsFromDatabase(previewProductTableMaterials, "materiais", true);
        util.loadProductsFromDatabase(materialDisplayTable, "materiais", false);

        util.loadMissingProductsFromDatabase(tableMissingProduct);

        util.loadSalesFromDatabase(tableSales);

        // Criar um conjunto de dados dinâmico
        Map<String, Double> valuesChartPreview = new HashMap<>();
        valuesChartPreview.put("Janeiro", 1000.0);
        valuesChartPreview.put("Fevereiro", 1750.0);
        valuesChartPreview.put("Março", 1200.0);
        valuesChartPreview.put("Abril", 1800.0);

        // Criar o Map para associar a cor azul a todas as barras
        Map<String, Color> coresChartPreview = new HashMap<>();
        coresChartPreview.put("Janeiro", Color.BLUE);
        coresChartPreview.put("Fevereiro", Color.BLUE);
        coresChartPreview.put("Março", Color.BLUE);
        coresChartPreview.put("Abril", Color.BLUE);

        // Chamar o método para criar o gráfico
        JPanel graficoPanel = BarChart.criarGraficoDeBarras(
                "Vendas(R$) ", // Título do gráfico
                "Mês", // Rótulo do eixo X
                "Valor", // Rótulo do eixo Y
                valuesChartPreview,
                coresChartPreview // Dados dinâmicos
        );

        panelReportingHome.add(graficoPanel, BorderLayout.CENTER);

        // Definir a posição e o tamanho do gráfico
        graficoPanel.setBounds(0, 0, 525, 450);  // Definir a posição e o tamanho fixo do gráfico

        // Adicionar o painel de gráfico ao panelReportingHome
        panelReportingHome.add(graficoPanel);

        // Criar um conjunto de dados dinâmico
        Map<String, Double> valuesDailySales = new HashMap<>();
        valuesDailySales.put("Teste_01", 500.0);
        valuesDailySales.put("Teste_02", 600.0);
        valuesDailySales.put("Teste_03", 250.0);
        valuesDailySales.put("Teste_04", 700.0);

        Map<String, Color> coresDailySales = new HashMap<>();
        // Chamar o método para criar o gráfico
        JPanel graficoDailySales = BarChart.criarGraficoDeBarras(
                "Vendas Diárias", // Título do gráfico
                "Produto", // Rótulo do eixo X
                "Valor", // Rótulo do eixo Y
                valuesDailySales,
                coresDailySales// Dados dinâmicos
        );

        paneChart1.add(graficoDailySales, BorderLayout.CENTER);

        // Definir a posição e o tamanho do gráfico
        graficoDailySales.setBounds(0, 0, 525, 450);  // Definir a posição e o tamanho fixo do gráfico

        // Adicionar o painel de gráfico ao paneChart1
        paneChart1.add(graficoDailySales);

        // Criar um conjunto de dados dinâmico
        Map<String, Double> valuesFlavorSales = new HashMap<>();
        valuesFlavorSales.put("Morango", 1000.0);
        valuesFlavorSales.put("Chocolate", 1500.0);
        valuesFlavorSales.put("Creme", 1200.0);
        valuesFlavorSales.put("Batata Palha", 1800.0);

        // Chamar o método para criar o gráfico
        JPanel graficoFlavorSales = PizzaChart.criarGraficoDePizza(
                "Vendas por sabor", // Título do gráfico
                valuesFlavorSales
        );

        paneChart2.add(graficoFlavorSales, BorderLayout.CENTER);

        // Definir a posição e o tamanho do gráfico
        graficoFlavorSales.setBounds(0, 0, 525, 450);  // Definir a posição e o tamanho fixo do gráfico

        // Adicionar o painel de gráfico ao panelChart2
        paneChart2.add(graficoFlavorSales);

        // Criar um conjunto de dados dinâmico
        Map<String, Double> valuesMonthlyBilling = new HashMap<>();
        valuesMonthlyBilling.put("Teste_01", 500.0);
        valuesMonthlyBilling.put("Teste_02", 600.0);
        valuesMonthlyBilling.put("Teste_03", 250.0);
        valuesMonthlyBilling.put("Teste_04", 700.0);

        Map<String, Color> coresMonthlyBilling = new HashMap<>();
        // Chamar o método para criar o gráfico
        JPanel graficoMonthlyBilling = BarChart.criarGraficoDeBarras(
                "Faturamento Mensal", // Título do gráfico
                "Produto", // Rótulo do eixo X
                "Valor", // Rótulo do eixo Y
                valuesMonthlyBilling,
                coresMonthlyBilling// Dados dinâmicos
        );

        paneChart3.add(graficoMonthlyBilling, BorderLayout.CENTER);

        // Definir a posição e o tamanho do gráfico
        graficoMonthlyBilling.setBounds(0, 0, 525, 450);  // Definir a posição e o tamanho fixo do gráfico

        // Adicionar o painel de gráfico ao paneChart1
        paneChart3.add(graficoMonthlyBilling);

        // Criar um conjunto de dados dinâmico
        Map<String, Double> valuesStockSales = new HashMap<>();
        valuesStockSales.put("Estoque", 1000.0);
        valuesStockSales.put("Vendas", 700.0);

        Map<String, Color> coresStockSales = new HashMap<>();
        coresStockSales.put("Estoque", Color.BLUE);
        coresStockSales.put("Vendas", Color.RED);
        // Chamar o método para criar o gráfico
        JPanel graficoStockSales = BarChart.criarGraficoDeBarras(
                "Estoque X Vendas", // Título do gráfico
                "Produto", // Rótulo do eixo X
                "Valor", // Rótulo do eixo Y
                valuesStockSales,
                coresStockSales// Dados dinâmicos
        );

        paneChart4.add(graficoStockSales, BorderLayout.CENTER);

        // Definir a posição e o tamanho do gráfico
        graficoStockSales.setBounds(0, 0, 525, 450);  // Definir a posição e o tamanho fixo do gráfico

        // Adicionar o painel de gráfico ao paneChart1
        paneChart4.add(graficoStockSales);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FixedMenu = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnStocke = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnReporting = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSales = new javax.swing.JButton();
        AgrupamentoTelas = new javax.swing.JTabbedPane();
        HomeScreen = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonToStockOne = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        previewProductTableMaterials = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonToStockTwo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        previewProductTableProducts = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableBesteSellerProducts = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableMissingProduct = new javax.swing.JTable();
        panelReportingHome = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        labelData = new javax.swing.JLabel();
        labelSales = new javax.swing.JLabel();
        StockScreen = new javax.swing.JPanel();
        AgrupamentoTelasEstoque = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        materialDisplayTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        productDisplayTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        ReportingScreen = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        paneChart1 = new javax.swing.JPanel();
        paneChart2 = new javax.swing.JPanel();
        paneChart3 = new javax.swing.JPanel();
        paneChart4 = new javax.swing.JPanel();
        SalesScreen = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableSales = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldProductName = new javax.swing.JTextField();
        textFieldProductQuantity = new javax.swing.JTextField();
        buttonAddSale = new javax.swing.JButton();
        buttonAlterSale = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textFieldSaleData = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textFieldSaleID = new javax.swing.JTextField();
        buttonRemoveSale = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FixedMenu.setBackground(new java.awt.Color(52, 106, 178));
        FixedMenu.setForeground(new java.awt.Color(255, 255, 255));
        FixedMenu.setPreferredSize(new java.awt.Dimension(220, 755));
        FixedMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/logo.png"))); // NOI18N
        FixedMenu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 13, -1, -1));

        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/Power_icon.png"))); // NOI18N
        buttonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLogoutMouseClicked(evt);
            }
        });
        FixedMenu.add(buttonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, -1, -1));

        jPanel1.setBackground(new java.awt.Color(52, 106, 178));

        btnHome.setBackground(new java.awt.Color(52, 106, 178));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/home-2.png"))); // NOI18N
        btnHome.setText("Início");
        btnHome.setBorder(null);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        FixedMenu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 119, -1, -1));

        jPanel2.setBackground(new java.awt.Color(52, 106, 178));

        btnStocke.setBackground(new java.awt.Color(52, 106, 178));
        btnStocke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/box.png"))); // NOI18N
        btnStocke.setText("Estoque");
        btnStocke.setBorder(null);
        btnStocke.setContentAreaFilled(false);
        btnStocke.setOpaque(true);
        btnStocke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnStocke, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnStocke, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        FixedMenu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 220, -1));

        jPanel3.setBackground(new java.awt.Color(52, 106, 178));

        btnReporting.setBackground(new java.awt.Color(52, 106, 178));
        btnReporting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/graph 1.png"))); // NOI18N
        btnReporting.setText("Relatórios");
        btnReporting.setBorder(null);
        btnReporting.setContentAreaFilled(false);
        btnReporting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnReporting, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnReporting, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        FixedMenu.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 220, -1));

        jPanel4.setBackground(new java.awt.Color(52, 106, 178));

        btnSales.setBackground(new java.awt.Color(52, 106, 178));
        btnSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/cash register.png"))); // NOI18N
        btnSales.setText("Vendas");
        btnSales.setBorder(null);
        btnSales.setContentAreaFilled(false);
        btnSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSales, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        FixedMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 437, 220, -1));

        getContentPane().add(FixedMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 770));

        HomeScreen.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Materiais em estoque");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/BoxBetter.png"))); // NOI18N

        buttonToStockOne.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonToStockOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/arrow.png"))); // NOI18N
        buttonToStockOne.setText("Conferir estoques");
        buttonToStockOne.setBorder(null);
        buttonToStockOne.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonToStockOne.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonToStockOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToStockOneActionPerformed(evt);
            }
        });

        previewProductTableMaterials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Preço", "Quant."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        previewProductTableMaterials.setGridColor(new java.awt.Color(0, 0, 0));
        previewProductTableMaterials.setShowHorizontalLines(true);
        previewProductTableMaterials.setShowVerticalLines(true);
        jScrollPane4.setViewportView(previewProductTableMaterials);
        if (previewProductTableMaterials.getColumnModel().getColumnCount() > 0) {
            previewProductTableMaterials.getColumnModel().getColumn(0).setResizable(false);
            previewProductTableMaterials.getColumnModel().getColumn(1).setResizable(false);
            previewProductTableMaterials.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(buttonToStockOne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonToStockOne, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Produtos em estoques");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/stock.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        buttonToStockTwo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonToStockTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/arrow.png"))); // NOI18N
        buttonToStockTwo.setText("Conferir estoques");
        buttonToStockTwo.setBorder(null);
        buttonToStockTwo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonToStockTwo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonToStockTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonToStockTwoActionPerformed(evt);
            }
        });

        previewProductTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sabor", "Preço", "Quant."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        previewProductTableProducts.setGridColor(new java.awt.Color(0, 0, 0));
        previewProductTableProducts.setShowHorizontalLines(true);
        previewProductTableProducts.setShowVerticalLines(true);
        jScrollPane2.setViewportView(previewProductTableProducts);
        if (previewProductTableProducts.getColumnModel().getColumnCount() > 0) {
            previewProductTableProducts.getColumnModel().getColumn(0).setResizable(false);
            previewProductTableProducts.getColumnModel().getColumn(1).setResizable(false);
            previewProductTableProducts.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel8)))
                .addContainerGap(8, Short.MAX_VALUE))
            .addComponent(buttonToStockTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(buttonToStockTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Produtos mais Vendidos");

        tableBesteSellerProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sabor", "Vendas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBesteSellerProducts.setGridColor(new java.awt.Color(0, 0, 0));
        tableBesteSellerProducts.setShowHorizontalLines(true);
        tableBesteSellerProducts.setShowVerticalLines(true);
        jScrollPane7.setViewportView(tableBesteSellerProducts);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Produtos em Falta");

        tableMissingProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMissingProduct.setGridColor(new java.awt.Color(0, 0, 0));
        tableMissingProduct.setShowHorizontalLines(true);
        tableMissingProduct.setShowVerticalLines(true);
        jScrollPane6.setViewportView(tableMissingProduct);
        if (tableMissingProduct.getColumnModel().getColumnCount() > 0) {
            tableMissingProduct.getColumnModel().getColumn(0).setResizable(false);
            tableMissingProduct.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(71, 71, 71))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelReportingHome.setBackground(new java.awt.Color(255, 255, 255));
        panelReportingHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panelReportingHomeLayout = new javax.swing.GroupLayout(panelReportingHome);
        panelReportingHome.setLayout(panelReportingHomeLayout);
        panelReportingHomeLayout.setHorizontalGroup(
            panelReportingHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelReportingHomeLayout.setVerticalGroup(
            panelReportingHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        labelData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelData.setText("Data:");

        labelSales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSales.setText("Vendas do dia: R$");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(labelSales, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData)
                    .addComponent(labelSales))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomeScreenLayout = new javax.swing.GroupLayout(HomeScreen);
        HomeScreen.setLayout(HomeScreenLayout);
        HomeScreenLayout.setHorizontalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeScreenLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeScreenLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelReportingHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        HomeScreenLayout.setVerticalGroup(
            HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(HomeScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeScreenLayout.createSequentialGroup()
                        .addComponent(panelReportingHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        AgrupamentoTelas.addTab("Início", HomeScreen);

        StockScreen.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        materialDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sabor", "Preço", "Quantidade", "Data de Fabricação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        materialDisplayTable.setGridColor(new java.awt.Color(0, 0, 0));
        materialDisplayTable.setShowHorizontalLines(true);
        materialDisplayTable.setShowVerticalLines(true);
        jScrollPane3.setViewportView(materialDisplayTable);
        if (materialDisplayTable.getColumnModel().getColumnCount() > 0) {
            materialDisplayTable.getColumnModel().getColumn(0).setResizable(false);
            materialDisplayTable.getColumnModel().getColumn(1).setResizable(false);
            materialDisplayTable.getColumnModel().getColumn(2).setResizable(false);
            materialDisplayTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/plusIcon.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/deleteIcon.png"))); // NOI18N
        jButton5.setBorder(null);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(45, 45, 45))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        AgrupamentoTelasEstoque.addTab("Estoque material", jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        productDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sabor", "Preço", "Quantidade", "Data de Fabricação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productDisplayTable.setGridColor(new java.awt.Color(0, 0, 0));
        productDisplayTable.setShowHorizontalLines(true);
        productDisplayTable.setShowVerticalLines(true);
        jScrollPane5.setViewportView(productDisplayTable);
        if (productDisplayTable.getColumnModel().getColumnCount() > 0) {
            productDisplayTable.getColumnModel().getColumn(0).setResizable(false);
            productDisplayTable.getColumnModel().getColumn(1).setResizable(false);
            productDisplayTable.getColumnModel().getColumn(2).setResizable(false);
            productDisplayTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/plusIcon.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/deleteIcon.png"))); // NOI18N
        jButton7.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(31, 31, 31)
                .addComponent(jButton7)
                .addGap(45, 45, 45))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        AgrupamentoTelasEstoque.addTab("Estoque Produto", jPanel8);

        javax.swing.GroupLayout StockScreenLayout = new javax.swing.GroupLayout(StockScreen);
        StockScreen.setLayout(StockScreenLayout);
        StockScreenLayout.setHorizontalGroup(
            StockScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgrupamentoTelasEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        StockScreenLayout.setVerticalGroup(
            StockScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgrupamentoTelasEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        AgrupamentoTelas.addTab("Estoque", StockScreen);

        ReportingScreen.setBackground(new java.awt.Color(255, 255, 51));

        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        paneChart1.setBackground(new java.awt.Color(255, 255, 255));
        paneChart1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout paneChart1Layout = new javax.swing.GroupLayout(paneChart1);
        paneChart1.setLayout(paneChart1Layout);
        paneChart1Layout.setHorizontalGroup(
            paneChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        paneChart1Layout.setVerticalGroup(
            paneChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        paneChart2.setBackground(new java.awt.Color(255, 255, 255));
        paneChart2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout paneChart2Layout = new javax.swing.GroupLayout(paneChart2);
        paneChart2.setLayout(paneChart2Layout);
        paneChart2Layout.setHorizontalGroup(
            paneChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneChart2Layout.setVerticalGroup(
            paneChart2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        paneChart3.setBackground(new java.awt.Color(255, 255, 255));
        paneChart3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout paneChart3Layout = new javax.swing.GroupLayout(paneChart3);
        paneChart3.setLayout(paneChart3Layout);
        paneChart3Layout.setHorizontalGroup(
            paneChart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paneChart3Layout.setVerticalGroup(
            paneChart3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        paneChart4.setBackground(new java.awt.Color(255, 255, 255));
        paneChart4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout paneChart4Layout = new javax.swing.GroupLayout(paneChart4);
        paneChart4.setLayout(paneChart4Layout);
        paneChart4Layout.setHorizontalGroup(
            paneChart4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );
        paneChart4Layout.setVerticalGroup(
            paneChart4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneChart3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneChart4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneChart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneChart3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneChart4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel11);

        javax.swing.GroupLayout ReportingScreenLayout = new javax.swing.GroupLayout(ReportingScreen);
        ReportingScreen.setLayout(ReportingScreenLayout);
        ReportingScreenLayout.setHorizontalGroup(
            ReportingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
        );
        ReportingScreenLayout.setVerticalGroup(
            ReportingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportingScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AgrupamentoTelas.addTab("Relatórios", ReportingScreen);

        SalesScreen.setBackground(new java.awt.Color(255, 255, 255));

        tableSales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tableSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do produto", "Quantidade vendida", "Valor total", "Data "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSales.setGridColor(new java.awt.Color(0, 0, 0));
        tableSales.setShowHorizontalLines(true);
        tableSales.setShowVerticalLines(true);
        jScrollPane8.setViewportView(tableSales);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Quantidade vendida");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nome do produto");

        textFieldProductName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        textFieldProductQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        textFieldProductQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProductQuantityActionPerformed(evt);
            }
        });

        buttonAddSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/plusIcon.png"))); // NOI18N
        buttonAddSale.setBorder(null);
        buttonAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSaleActionPerformed(evt);
            }
        });

        buttonAlterSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/alterIcon.png"))); // NOI18N
        buttonAlterSale.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Data da venda");

        textFieldSaleData.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("ID da venda");

        textFieldSaleID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        buttonRemoveSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jocole/images/deleteIcon.png"))); // NOI18N
        buttonRemoveSale.setBorder(null);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldProductQuantity)
                            .addComponent(textFieldProductName)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldSaleData)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textFieldSaleID)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(buttonAddSale)
                        .addGap(9, 9, 9)
                        .addComponent(buttonRemoveSale)
                        .addGap(9, 9, 9)
                        .addComponent(buttonAlterSale)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldSaleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textFieldSaleData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddSale)
                    .addComponent(buttonAlterSale)
                    .addComponent(buttonRemoveSale))
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout SalesScreenLayout = new javax.swing.GroupLayout(SalesScreen);
        SalesScreen.setLayout(SalesScreenLayout);
        SalesScreenLayout.setHorizontalGroup(
            SalesScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalesScreenLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        SalesScreenLayout.setVerticalGroup(
            SalesScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesScreenLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(SalesScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        AgrupamentoTelas.addTab("Vendas", SalesScreen);

        getContentPane().add(AgrupamentoTelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, -38, 1290, 810));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogoutMouseClicked
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_buttonLogoutMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(0);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnStockeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockeActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(1);
    }//GEN-LAST:event_btnStockeActionPerformed

    private void btnReportingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportingActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(2);
    }//GEN-LAST:event_btnReportingActionPerformed

    private void btnSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(3);
    }//GEN-LAST:event_btnSalesActionPerformed

    private void buttonToStockTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToStockTwoActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(1);
    }//GEN-LAST:event_buttonToStockTwoActionPerformed

    private void buttonToStockOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonToStockOneActionPerformed
        // TODO add your handling code here:
        AgrupamentoTelas.setSelectedIndex(1);
    }//GEN-LAST:event_buttonToStockOneActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void buttonAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSaleActionPerformed
        // TODO add your handling code here:
        Utilities util = new Utilities();
        util.addSaleToTable(textFieldProductName, textFieldProductQuantity, textFieldSaleData, tableSales);
    }//GEN-LAST:event_buttonAddSaleActionPerformed

    private void textFieldProductQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProductQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProductQuantityActionPerformed

    private void logout() {
        System.out.println("Saindo!");
        //fecha a janela
        this.dispose();
        //Chama a janela de login
        //LoginScreen loginScreen = new LoginScreen();
        //loginScreen.setVisible(true);
    }

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AgrupamentoTelas;
    private javax.swing.JTabbedPane AgrupamentoTelasEstoque;
    private javax.swing.JPanel FixedMenu;
    private javax.swing.JPanel HomeScreen;
    private javax.swing.JPanel ReportingScreen;
    private javax.swing.JPanel SalesScreen;
    private javax.swing.JPanel StockScreen;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReporting;
    private javax.swing.JButton btnSales;
    private javax.swing.JButton btnStocke;
    private javax.swing.JButton buttonAddSale;
    private javax.swing.JButton buttonAlterSale;
    private javax.swing.JLabel buttonLogout;
    private javax.swing.JButton buttonRemoveSale;
    private javax.swing.JButton buttonToStockOne;
    private javax.swing.JButton buttonToStockTwo;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelSales;
    private javax.swing.JLabel logo;
    private javax.swing.JTable materialDisplayTable;
    private javax.swing.JPanel paneChart1;
    private javax.swing.JPanel paneChart2;
    private javax.swing.JPanel paneChart3;
    private javax.swing.JPanel paneChart4;
    private javax.swing.JPanel panelReportingHome;
    private javax.swing.JTable previewProductTableMaterials;
    private javax.swing.JTable previewProductTableProducts;
    private javax.swing.JTable productDisplayTable;
    private javax.swing.JTable tableBesteSellerProducts;
    private javax.swing.JTable tableMissingProduct;
    private javax.swing.JTable tableSales;
    private javax.swing.JTextField textFieldProductName;
    private javax.swing.JTextField textFieldProductQuantity;
    private javax.swing.JTextField textFieldSaleData;
    private javax.swing.JTextField textFieldSaleID;
    // End of variables declaration//GEN-END:variables
}
