/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;


import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class Cliente {

   
    public void criarTabelaCliente(Statement stmt) {
        try {
            String createTableCliente = "CREATE TABLE CLIENTE(CPF BIGINT(11), NOME VARCHAR(60), "
                    + "ENDERECO VARCHAR(100), TELEFONE BIGINT(13))";

            stmt.executeUpdate(createTableCliente);
            System.out.println("Tabela Criada");
        } catch (SQLException e) {

            System.out.println("Ocorreu um erro ao criar Tabela");


        }
    }

    public void inserirDadosCliente(Statement stmt) throws SQLException {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do cliente");
            String b = JOptionPane.showInputDialog("Digite o nome do cliente");
            String c = JOptionPane.showInputDialog("Digite o endereço do cliente");
            String d = JOptionPane.showInputDialog("Digite o telefone do cliente");

            stmt.executeUpdate("INSERT INTO CLIENTE"
                    + " VALUES ('" + a + "', '" + b + "','" + c + "', '" + d + "')");

             JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Cliente");

        } catch (SQLException e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Cliente");


        }
    }

    public void atualizarCPFCliente(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o nome do cliente");
            String b = JOptionPane.showInputDialog("Digite seu novo CPF");

            stmt.executeUpdate("UPDATE CLIENTE SET CPF_CLI = '" + b + "' WHERE NOME_CLI = '" + a + "'");

             JOptionPane.showMessageDialog(null, "CPF atualizado na tabela Cliente");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar CPF do cliente");


        }

    }

    public void atualizarNomeCliente(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do cliente");
            String b = JOptionPane.showInputDialog("Digite seu novo nome");

            stmt.executeUpdate("UPDATE CLIENTE SET NOME_CLI = '" + b + "' WHERE CPF_CLI = " + a + "");

            JOptionPane.showMessageDialog(null, "Nome atualizado na tabela Cliente");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o nome do cliente");


        }

    }

    public void atualizarEnderecoCliente(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do cliente");
            String b = JOptionPane.showInputDialog("Digite seu novo endereco");

            stmt.executeUpdate("UPDATE CLIENTE SET ENDERECO_CLI = '" + b + "' WHERE CPF_CLI = " + a + "");

             JOptionPane.showMessageDialog(null, "Endereço atualizado na tabela Cliente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar endereço do cliente");


        }

    }

    public void atualizarTelefoneCliente(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do cliente");
            String b = JOptionPane.showInputDialog("Digite seu novo telefone");

            stmt.executeUpdate("UPDATE CLIENTE SET TELEFONE_CLI = '" + b + "' WHERE CPF_CLI = " + a + "");

             JOptionPane.showMessageDialog(null, "Telefone atualizado na tabela Cliente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o telefone do cliente");


        }

    }

    public void selecionarDadosUmCliente(Statement stmt) throws SQLException {

        try {
            String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente a ser consultado");
            stmt.executeQuery("SELECT * FROM CLIENTE WHERE CPF_CLI = " + cpf + "");
            ResultSet rs = stmt.getResultSet();
            System.out.println("Exibindo os dados do cliente de CPF "+cpf);
            System.out.println("-------------------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.println("CPF do cliente: " + rs.getString(1));
                System.out.println("Nome do cliente: " + rs.getString(2));
                System.out.println("Endereço do cliente: " +rs.getString(3));
                System.out.println("Telefone do cliente: " + rs.getString(4));
                System.out.println("");
            }
                     
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados do cliente");

        }

    }

    public void selecionarDadosTodosClientes(Statement stmt) throws SQLException {
        try {
            
            stmt.executeQuery("Select * from Cliente");
            ResultSet rs = stmt.getResultSet();
            System.out.println("Exibindo os dados de todos os clientes");
            System.out.println("-------------------------------------------------------------------------");
            
            while (rs.next()) {
                System.out.println("CPF: " + rs.getString(1)+"   Nome: " + rs.getString(2)+"   Endereço: " +rs.getString(3)+"   Telefone: " + rs.getString(4));
                }
            System.out.println();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos clientes");


        }

    }

}
