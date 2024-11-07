/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.utilities;

import br.com.jocole.dal.ConnectionModule;
import java.sql.Connection;
import java.sql.Date;
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

    final private Connection connection;

    public Utilities() {
        this.connection = ConnectionModule.connection();
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

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
        if (connection != null) {
            String selectProdutos = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos";
            String selectMateriais = "SELECT Nome_material, Preco_material, Quantidade_material, Data_de_fabricacao FROM tbmaterial";

            String previewProdutos = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos LIMIT 3";
            String previewMateriais = "SELECT Nome_material, Preco_material, Quantidade_material, Data_de_fabricacao FROM tbmaterial LIMIT 3";

            String query = "";

            if (tipoSelect.toLowerCase().equals("produtos")) {
                query = isPreview ? previewProdutos : selectProdutos;
            } else if (tipoSelect.toLowerCase().equals("materiais")) {
                query = isPreview ? previewMateriais : selectMateriais;
            }

            try {
                PreparedStatement stmt = connection.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                DefaultTableModel model = (DefaultTableModel) productTable.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String nome = tipoSelect.toLowerCase().equals("produtos") ? rs.getString("Sabor_picole") : rs.getString("Nome_material");
                    double preco = tipoSelect.toLowerCase().equals("produtos") ? rs.getDouble("Preco_produto") : rs.getDouble("Preco_material");
                    int quantidade = tipoSelect.toLowerCase().equals("produtos") ? rs.getInt("Quantidade_produtos") : rs.getInt("Quantidade_material");
                    Date dataFabricacao = rs.getDate("Data_de_fabricacao");
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataFabricacao);

                    model.addRow(new Object[]{nome, preco, quantidade, dataFormatada});
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Conexão é nula!");
        }
    }

    public void loadMissingProductsFromDatabase(JTable tableMissingProduct) {
        if (connection != null) {
            String selectMissingProducts = "SELECT Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao FROM tbprodutos WHERE Quantidade_produtos < 30";

            try {
                PreparedStatement stmt = connection.prepareStatement(selectMissingProducts);
                ResultSet rs = stmt.executeQuery();

                DefaultTableModel model = (DefaultTableModel) tableMissingProduct.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    String sabor = rs.getString("Sabor_picole");
                    double preco = rs.getDouble("Preco_produto");
                    int quantidade = rs.getInt("Quantidade_produtos");
                    Date dataFabricacao = rs.getDate("Data_de_fabricacao");
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataFabricacao);

                    model.addRow(new Object[]{sabor, preco, quantidade, dataFormatada});
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Conexão é nula!");
        }
    }

    public void loadSalesFromDatabase(JTable tableSales) {
        if (connection != null) {
            String query = "SELECT Sabor_picole, Quantidade_produto_vendido, Valor_total_venda, Data_da_venda FROM tbvendas";

            try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

                DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
                model.setRowCount(0);  // Limpa a tabela antes de adicionar os novos dados

                while (rs.next()) {
                    String sabor = rs.getString("Sabor_picole");
                    int quantidadeVendida = rs.getInt("Quantidade_produto_vendido");
                    double valorTotal = rs.getDouble("Valor_total_venda");
                    Date dataVenda = rs.getDate("Data_da_venda");

                    // Formata a data para exibição
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataVenda);

                    // Adiciona uma nova linha na tabela
                    model.addRow(new Object[]{sabor, quantidadeVendida, valorTotal, dataFormatada});
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao carregar vendas do banco de dados: " + e.getMessage());
            }
        } else {
            System.out.println("Conexão é nula!");
        }
    }

    public void addSaleToTable(JTextField textFieldProductName, JTextField textFieldProductQuantity, JTextField textFieldSaleData, JTable tableSales) {
        String productName = textFieldProductName.getText();
        String productQuantity = textFieldProductQuantity.getText();
        String saleDate = textFieldSaleData.getText();

        if (productName.isEmpty() || productQuantity.isEmpty() || saleDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
            return;
        }

        try {
            int quantity = Integer.parseInt(productQuantity);

            double pricePerProduct = getProductPriceFromDatabase(productName);

            if (pricePerProduct == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado no banco de dados!");
                return;
            }

            double totalValue = pricePerProduct * quantity;

            DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
            model.addRow(new Object[]{productName, productQuantity, totalValue, saleDate});

            textFieldProductName.setText("");
            textFieldProductQuantity.setText("");
            textFieldSaleData.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser um número válido!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o preço do produto no banco de dados: " + e.getMessage());
        }
    }

    private double getProductPriceFromDatabase(String productName) throws SQLException {
        String query = "SELECT Preco_produto FROM tbprodutos WHERE Sabor_picole = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getDouble("Preco_produto");
            } else {
                return -1;
            }
        }
    }
}
