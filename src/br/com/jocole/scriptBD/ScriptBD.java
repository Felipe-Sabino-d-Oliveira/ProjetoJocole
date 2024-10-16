/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.scriptBD;

/**
 *
 * @author yuriv
 */
public class ScriptBD {
    //Codigo para acessar a aplicacao
    //CREATE DATABASE dbjocole;
    //USE dbjocole;

    //-- Código para criar a tabela de usuários
    //CREATE TABLE tbusers (iduser INTEGER AUTO_INCREMENT PRIMARY KEY, Login VARCHAR(30) NOT NULL, Password VARCHAR(30) NOT NULL, Name VARCHAR(20) NOT NULL);
    //INSERT INTO tbusers(Login, Password, Name) VALUES ('admin', 'admin', 'Administrado');
    //-- Select da tabela(Lembrar de apagar a tabela e recriar para renovar os IDs)
    //SELECT * FROM tbusers;
    
    //-- Código para criar a tabela de picoles
    //CREATE TABLE tbprodutos (Codigopicole INTEGER AUTO_INCREMENT PRIMARY KEY, Sabor_picole VARCHAR(50) NOT NULL, Preco_produto DECIMAL(10,2), Quantidade_produtos INTEGER NOT NULL, Data_de_fabricacao DATE);
    //-- inserindo na tabela apenas valores de exemplo:
    //INSERT INTO tbprodutos (Sabor_picole, Preco_produto, Quantidade_produtos, Data_de_fabricacao) VALUES ('Morango', 4.00, 10, '2024-10-04'), ('Teste_01', 9.99, 9, '1999-09-09'), ('Teste_02', 9.99, 9, '1999-09-09'), ('Teste_03', 9.99, 9, '1999-09-09');
    //-- Select da tabela(Lembrar de apagar a tabela e recriar para renovar os IDs)
    //SELECT * FROM tbprodutos;
    
    //-- Código para criar a tabela de matéria prima
    //CREATE TABLE tbmaterial(Codigomaterial INTEGER AUTO_INCREMENT PRIMARY KEY, Nome_material VARCHAR(50) NOT NULL, Preco_material DECIMAL(10,2), Quantidade_material INTEGER NOT NULL, Data_de_fabricacao DATE);
    //INSERT INTO tbmaterial(Nome_material, Preco_material, Quantidade_material, Data_de_fabricacao) VALUES("Materia_Prima_teste", 0.00, 0, '2001-01-01'), ("Materia_Prima_teste2", 2.00, 2, '2002-02-02'), ("Materia_Prima_teste3", 3.00, 3, '2003-03-03'), ("Materia_Prima_teste4", 4.00, 4, '2004-04-04'), ("Materia_Prima_teste5", 5.00, 5, '2005-05-05');
    //SELECT * FROM tbmaterial;
    //-- Código para criar a tabela de 

}
