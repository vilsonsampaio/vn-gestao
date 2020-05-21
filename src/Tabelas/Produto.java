/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Produto {

    double preco;

    public void criarTabelaProduto(Statement stmt) {
        try {
            String createTableProduto = "CREATE TABLE PRODUTO(CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT, NOME VARCHAR(45), "
                    + "PRECO DOUBLE";

            stmt.executeUpdate(createTableProduto);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");

        }
    }

    public void inserirDadosProduto(Statement stmt) {
        try {
            String b = JOptionPane.showInputDialog("Digite o nome do produto");
            double c = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto"));
            

            stmt.executeUpdate("INSERT INTO PRODUTO"
                    + " VALUES (CODIGO_PRODUTO, '" + b + "', " + c + ")");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Produto");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Produto");

        }
    }

    public void atualizarNomeProduto(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código do produto");
            String b = JOptionPane.showInputDialog("Digite seu novo nome");

            stmt.executeUpdate("UPDATE PRODUTO SET NOME_PRODUTO = '" + b + "' WHERE CODIGO_PRODUTO = " + a + "");

            JOptionPane.showMessageDialog(null, "Nome atualizado na tabela Produto");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o nome do produto");

        }
    }

    public void atualizarPrecoProduto(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código do produto");
            double b = Double.parseDouble(JOptionPane.showInputDialog("Digite seu novo preço"));

            stmt.executeUpdate("UPDATE PRODUTO SET PRECO_PRODUTO = " + b + " WHERE CODIGO_PRODUTO = " + a + "");

            JOptionPane.showMessageDialog(null, "Preço atualizado na tabela Produto");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o preço do produto");

        }

    }

    public void selecionarDadosUmProduto(Statement stmt) {
        try {

            String codigo = JOptionPane.showInputDialog("Informe o código do produto a ser consultado");
            stmt.executeQuery("SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO = " + codigo + "");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os dados do produto de código " + codigo);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.println("Código: " + rs.getInt(1));
                System.out.println("Nome: " + rs.getString(2));
                System.out.println("Preço: R$ " + rs.getDouble(3));
            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados do produto");

        }

    }

    public void selecionarDadosTodosProdutos(Statement stmt) {
        try {

            stmt.executeQuery("SELECT * FROM PRODUTO");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros dos produtos");
            

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {
                int a = rs.getInt(1); 
                String b = rs.getString(2);
                double c = rs.getDouble(3);
                System.out.println(a + "   " + b+ "   R$ " + c);

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos produtos");

        }

    }
    


}


