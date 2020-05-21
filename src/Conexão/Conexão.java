/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexão;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Conexão {


    public Connection con;

       public Conexão() throws SQLException {
        String url;
        String user = JOptionPane.showInputDialog("Informe o login");
        String password = JOptionPane.showInputDialog("Informe a senha");
        //String user = "root";
        //String password = "123456";

        try {
            url = "jdbc:mysql://localhost/VilsonSampaio";
            con = DriverManager.getConnection(url, user, password);
            if (con != null) {

                JOptionPane.showMessageDialog(null, "Conectado com sucesso!");

            } else {

                JOptionPane.showMessageDialog(null, "Não foi possivel realizar a conexão");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar a conexão");
        }
        

    }
   
    
 
}
