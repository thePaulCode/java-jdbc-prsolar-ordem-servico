package dev.thepaulcode.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

   public static Connection criarConexao(){

       // Iniciar Conexao com Banco de Dados Postgresql
       Connection conexao = null;

       String dbURL = "jdbc:postgresql://localhost:5432/postgres";
       String username = "postgres";
       String password = "adadev1234";

       try {
           conexao = DriverManager.getConnection(dbURL, username, password);

           System.out.println("Conectado ao Banco de Dados com sucesso!");

       } catch (Exception ex) {
           ex.printStackTrace();
       }
       return conexao;
   }
    /*// Conexão realizada

    public static void main(String[] args) {
        criarConexao();
    }*/

}
