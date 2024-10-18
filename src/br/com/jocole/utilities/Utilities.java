/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.utilities;

import br.com.jocole.dal.ConnectionModule;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe.slima
 */
public class Utilities {

    public final void mostrarDataAtual(JComponent component) {
        // Obtém a data atual
        java.util.Date dataAtual = new java.util.Date();

        // Formata a data para o formato desejado (dia/mês/ano)
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // Define o texto do componente com a data formatada
        if (component instanceof JLabel) {
            ((JLabel) component).setText("Data: " + formato.format(dataAtual));
        } else if (component instanceof JTextField) {
            ((JTextField) component).setText(formato.format(dataAtual));
        }
    }

    public void loadProductsFromDatabase(JTable productTable, String tipoSelect, boolean isPreview) {
        Connection conn = ConnectionModule.connection();
        if (conn != null) {
            // Consultas para todos os valores
            String selectProdutos = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos";
            String selectMateriais = "SELECT Nome_material, Preco_material, Quantidade_material, Data_de_fabricacao FROM tbmaterial";

            // Consultas para apenas 3 valores (prévia)
            String previewProdutos = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos LIMIT 3";
            String previewMateriais = "SELECT Nome_material, Preco_material, Quantidade_material, Data_de_fabricacao FROM tbmaterial LIMIT 3";

            String query = "";

            // Define a consulta SQL com base no tipo e se é prévia
            if (tipoSelect.toLowerCase().equals("produtos")) {
                query = isPreview ? previewProdutos : selectProdutos;
            } else if (tipoSelect.toLowerCase().equals("materiais")) {
                query = isPreview ? previewMateriais : selectMateriais;
            }

            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                // Pega o modelo da tabela recebida como parâmetro
                DefaultTableModel model = (DefaultTableModel) productTable.getModel();
                model.setRowCount(0); // Limpa a tabela

                // Loop para adicionar as linhas à tabela
                while (rs.next()) {
                    String nome = tipoSelect.toLowerCase().equals("produtos") ? rs.getString("Sabor_picole") : rs.getString("Nome_material");
                    double preco = tipoSelect.toLowerCase().equals("produtos") ? rs.getDouble("Preco_produto") : rs.getDouble("Preco_material");
                    int quantidade = tipoSelect.toLowerCase().equals("produtos") ? rs.getInt("Quantidade_produtos") : rs.getInt("Quantidade_material");
                    Date dataFabricacao = rs.getDate("Data_de_fabricacao");
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataFabricacao);

                    // Adiciona uma nova linha com os dados
                    model.addRow(new Object[]{nome, preco, quantidade, dataFormatada});
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(conn + " é nulo!");
        }
    }

    public void loadMissingProductsFromDatabase(JTable tableMissingProduct) {
        Connection conn = ConnectionModule.connection();
        if (conn != null) {
            // Consulta SQL para produtos com quantidade abaixo de 30
            String selectMissingProducts = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos WHERE Quantidade_produtos < 30";

            try {
                PreparedStatement stmt = conn.prepareStatement(selectMissingProducts);
                ResultSet rs = stmt.executeQuery();

                // Pega o modelo da tabela recebida como parâmetro
                DefaultTableModel model = (DefaultTableModel) tableMissingProduct.getModel();
                model.setRowCount(0); // Limpa a tabela

                // Loop para adicionar as linhas à tabela
                while (rs.next()) {
                    String sabor = rs.getString("Sabor_picole");
                    double preco = rs.getDouble("Preco_produto");
                    int quantidade = rs.getInt("Quantidade_produtos");
                    Date dataFabricacao = rs.getDate("Data_de_fabricacao");

                    // Formatar a data para exibição (opcional)
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataFabricacao);

                    // Adiciona uma nova linha com os dados
                    model.addRow(new Object[]{sabor, preco, quantidade, dataFormatada});
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println(conn + " é nulo!");
        }
    }

    public void addSaleToTable(JTextField textFieldProductName, JTextField textFieldProductQuantity, JTextField textFieldSaleData, JTable tableSales) {
        // Obtém os valores dos campos de texto
        String productName = textFieldProductName.getText();
        String productQuantity = textFieldProductQuantity.getText();
        String saleDate = textFieldSaleData.getText();

        // Verifica se os campos obrigatórios estão preenchidos
        if (productName.isEmpty() || productQuantity.isEmpty() || saleDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
            return; // Sai do método para evitar o erro
        }

        try {
            // Converte a quantidade para inteiro
            int quantity = Integer.parseInt(productQuantity); // Verifica se é um número válido

            // Calcula o valor total (Exemplo: suposição de preço fixo por produto)
            double pricePerProduct = 10.00; // Exemplo de preço
            double totalValue = pricePerProduct * quantity; // Calcula o valor total da venda

            // Pega o modelo da tabela para adicionar uma nova linha
            DefaultTableModel model = (DefaultTableModel) tableSales.getModel();

            // Adiciona uma nova linha na tabela
            model.addRow(new Object[]{productName, productQuantity, totalValue, saleDate});

            // Limpa os campos de texto após a inserção
            textFieldProductName.setText("");
            textFieldProductQuantity.setText("");
            textFieldSaleData.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser um número válido!");
        }
    }

    public void loadSalesFromDatabase(JTable tableSales) {
        Connection conn = ConnectionModule.connection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            // Consulta SQL para obter as vendas
            String sql = "SELECT Sabor_picole, Quantidade_produto_vendido, Valor_total_venda, Data_da_venda FROM tbvendas";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Obtém o modelo da tabela
            DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
            model.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados

            // Preenche a tabela com os dados retornados da consulta
            while (rs.next()) {
                String sabor = rs.getString("Sabor_picole");
                int quantidadeVendida = rs.getInt("Quantidade_produto_vendido");
                double valorTotal = rs.getDouble("Valor_total_venda");
                Date dataVenda = rs.getDate("Data_da_venda");

                // Adiciona a linha na tabela
                model.addRow(new Object[]{sabor, quantidadeVendida, valorTotal, dataVenda});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar vendas do banco de dados: " + e.getMessage());
        } finally {
            // Fechar a conexão, statement e resultset
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
