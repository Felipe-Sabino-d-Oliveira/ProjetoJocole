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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe.slima
 */
public class Utilities {

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

}
