/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jocole.entites;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author yuri.vasconcelos
 */
public class Product {

    private LinkedList<Product> produtos = new LinkedList<>();
    
    private int codigo_picole;
    private String sabor_picole;
    private double preco_produto;
    private int quantidade_produtos;
    private Date data_de_fabricacao;

    public String getSabor_picole() {
        return sabor_picole;
    }

    public void setSabor_picole(String sabor_picole) {
        this.sabor_picole = sabor_picole;
    }

    public Date getData_de_fabricacao() {
        return data_de_fabricacao;
    }

    public void setData_de_fabricacao(Date data_de_fabricacao) {
        this.data_de_fabricacao = data_de_fabricacao;
    }

    public int getCodigo_picole() {
        return codigo_picole;
    }

    public void setCodigo_picole(int codigo_picole) {
        this.codigo_picole = codigo_picole;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQuantidade_produtos() {
        return quantidade_produtos;
    }

    public void setQuantidade_produtos(int quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }

    public LinkedList<Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(LinkedList<Product> produtos) {
        this.produtos = produtos;
    }

}
