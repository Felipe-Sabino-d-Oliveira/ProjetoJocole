/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.dal;

import java.sql.*;
import br.com.jocole.entites.Product;
import java.util.LinkedList;

/**
 *
 * @author felipe.slima
 */
public class ProductDAO {
    
    // Método para buscar produtos do banco de dados
    public LinkedList<Product> buscarProdutos() {
        LinkedList<Product> listaProdutos = new LinkedList<>();
        Connection connection = ConnectionModule.connection();
        
        String sql = "SELECT codigo_picole, sabor_picole, preco_produto, quantidade_produtos, data_de_fabricacao FROM produtos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Percorre o resultado da consulta
            while (rs.next()) {
                Product produto = new Product();
                produto.setCodigo_picole(rs.getInt("codigo_picole"));
                produto.setSabor_picole(rs.getString("sabor_picole"));
                produto.setPreco_produto(rs.getDouble("preco_produto"));
                produto.setQuantidade_produtos(rs.getInt("quantidade_produtos"));
                produto.setData_de_fabricacao(rs.getDate("data_de_fabricacao"));
                
                // Adiciona o produto à lista
                listaProdutos.add(produto);
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }

        return listaProdutos;
    }
}
