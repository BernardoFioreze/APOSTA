package org.example;

import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;

public class BancoDeDados {

    public static void conexao() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://localhost/banco", "usuario", "senha");
            Resultset todasApostas = conexao.createStatement().executeQuery("SELECT + FROM APOSTA");
            while(todasApostas.next()) {
                System.out.println("Numeros Apostados: " + todasApostas.getValores;
            }
        } catch (ClassNotFoundException e ) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados." + ex.getMessage());
        } finally {
            if(conexao != null){
                conexao.close();
            }
        }
    }
}