/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionModule {

 /**
 * 
 * @author yuriv
 */

    public static Connection connection() {
        Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbjocole";
        String user = "root";
        String password = "";

        try {
            // Carregar o driver JDBC
            Class.forName(driver);  
            
            // Estabelecer a conexão com o banco de dados
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");
            return connection;

        } catch (ClassNotFoundException | SQLException e) {
            // Logar erro detalhado para facilitar o diagnóstico
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
