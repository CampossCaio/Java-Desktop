/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package br.com.shield.classes;

import java.sql.*;
import br.com.shield.dal.ModuloConexao;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author caio
 */
public class Clientes extends ModuloConexao{

    //Usando variável conexao DAL
    Connection conexao = null;
    //Crinado variáveis especiais para conexão com o banco
    //Prepared Statement e ResultSet são frameworks do pacote java.sql
    // e serve  para preparar e executar as instruções sql
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Construtor
    public Clientes() {
       conexao = ModuloConexao.conector();
    }
    
    //O Método abaixo pesquisa o cliente de acordo com a letra que vai sendo digitida na campo txtclipesquisar
   public Vector pesquisar(String pesq) throws Exception{
       //A linha abaixo cria um vetor dinamico de clientes
       Vector tb = new Vector();
       //A linha abaixo cria o comando sql para realizar a busca pelo cliente utilizando like
       String sql = "select * from tbclientes where nomecli like '"+pesq+"%'";
       //A linha abaixo tetorna o erro caso não consiga realizar a peesquisa no banco
       try {
            pst = conexao.prepareStatement(sql);
       rs = pst.executeQuery();
       //O vetor abaixo se refere a cada linha dentro da tabela cliente
       while(rs.next()){
           Vector nl = new Vector();
           nl.add(rs.getInt(1));
           nl.add(rs.getString(2));
           nl.add(rs.getString(3));
           nl.add(rs.getString(4));
           tb.add(nl);
       }
       //A linha abaixo retorna o erro
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,e);
       }
      
       return tb;
}
}