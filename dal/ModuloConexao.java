/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.shield.dal;
import java.sql.*;

/**
 *
 * @author caio
 */
public class ModuloConexao {
    
    //método responsavel por estabelecer a conexão com o banco
    public static Connection conector(){
        java.sql.Connection conexao = null;
        // a linha abaixo chama o drive que eu importei
        String driver = "com.mysql.jdbc.Driver";
        // armazenando informações referente ao banco
        String url = "jdbc:mysql://127.0.0.1:3306/dbshield";
        String user = "root";
        String password = "";
        //estabelecendo a conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha abaixo serve de apoio para esclarecer o erro.
            System.out.println(e);
            return null;
        }
    }
}
