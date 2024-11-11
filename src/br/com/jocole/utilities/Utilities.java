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
import java.sql.Statement;
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

    public void mostrarTotalVendasDia(JComponent component) {
        try {
            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjocole", "seu_usuario", "sua_senha");

            // Query para somar as vendas do dia atual
            String query = "SELECT SUM(Valor_total_venda) FROM tbvendas WHERE Data_da_venda = CURDATE()";

            // Preparar a query e executar
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            double totalVendas = 0.0;

            // Se houver resultado, pegar o valor total
            if (rs.next()) {
                totalVendas = rs.getDouble(1); // Pegar a soma
            }

            // Fechar a conexão
            rs.close();
            stmt.close();
            conn.close();

            // Exibir o valor total no componente
            String totalFormatado = String.format("Total de vendas: R$ %.2f", totalVendas);
            if (component instanceof JLabel) {
                ((JLabel) component).setText(totalFormatado);
            } else if (component instanceof JTextField) {
                ((JTextField) component).setText(totalFormatado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar o erro, por exemplo, exibindo uma mensagem de erro no componente
            if (component instanceof JLabel) {
                ((JLabel) component).setText("Erro ao buscar total de vendas");
            } else if (component instanceof JTextField) {
                ((JTextField) component).setText("Erro");
            }
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
            // Adiciona a coluna 'Codigovenda' na consulta para pegar o ID das vendas
            String query = "SELECT Codigovenda, Sabor_picole, Quantidade_produto_vendido, Valor_total_venda, Data_da_venda FROM tbvendas";

            try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

                DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
                model.setRowCount(0);  // Limpa a tabela antes de adicionar os novos dados

                // Loop para preencher a tabela com os dados retornados da consulta
                while (rs.next()) {
                    int idVenda = rs.getInt("Codigovenda");                    // Pega o ID da venda
                    String sabor = rs.getString("Sabor_picole");            // Pega o sabor do picolé
                    int quantidadeVendida = rs.getInt("Quantidade_produto_vendido"); // Pega a quantidade vendida
                    double valorTotal = rs.getDouble("Valor_total_venda");   // Pega o valor total da venda
                    Date dataVenda = rs.getDate("Data_da_venda");            // Pega a data da venda

                    // Formata a data para exibição
                    String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataVenda);

                    // Adiciona uma nova linha na tabela com o ID da venda
                    model.addRow(new Object[]{idVenda, sabor, quantidadeVendida, valorTotal, dataFormatada});
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

            // Inserção da nova venda no banco de dados e recuperação do ID gerado
            String insertSaleQuery = "INSERT INTO tbvendas (Sabor_picole, Quantidade_produto_vendido, Data_da_venda, Valor_total_venda) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(insertSaleQuery, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, productName);
                ps.setInt(2, quantity);
                ps.setString(3, saleDate);  // A data já deve estar no formato apropriado (yyyy-MM-dd)
                ps.setDouble(4, totalValue);

                int affectedRows = ps.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Falha ao inserir a venda, nenhuma linha foi alterada.");
                }

                // Recupera o ID gerado automaticamente
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int saleId = generatedKeys.getInt(1);

                        // Atualiza a tabela com o ID da venda recém-adicionada
                        DefaultTableModel model = (DefaultTableModel) tableSales.getModel();
                        model.addRow(new Object[]{saleId, productName, quantity, totalValue, saleDate});

                        // Limpa os campos de texto após adicionar a venda
                        textFieldProductName.setText("");
                        textFieldProductQuantity.setText("");
                        textFieldSaleData.setText("");
                    } else {
                        throw new SQLException("Falha ao inserir a venda, não foi possível obter o ID.");
                    }
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser um número válido!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar a venda: " + e.getMessage());
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
