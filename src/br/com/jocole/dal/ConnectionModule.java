/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.dal;

import java.sql.*;

/**
 *
 * @author yuriv
 */
public class ConnectionModule {

    public static Connection connection() {
        System.out.println("teste");
        java.sql.Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbjocole";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);      
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
