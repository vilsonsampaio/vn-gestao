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
public class Fornecedor {

    public void criarTabelaFornecedor(Statement stmt) {
        try {
            String createTableFornecedor = "CREATE TABLE FORNECEDOR(CNPJ BIGINT(14), NOME VARCHAR(60), "
                    + "ENDERECO VARCHAR(100), TELEFONE BIGINT(13))";

            stmt.executeUpdate(createTableFornecedor);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");


        }
    }

    public void inserirDadosFornecedor(Statement stmt) {
        try {
            String a = JOptionPane.showInputDialog("Digite o CNPJ do fornecedor");
            String b = JOptionPane.showInputDialog("Digite o nome do fornecedor");
            String c = JOptionPane.showInputDialog("Digite o endereço do fornecedor");
            String d = JOptionPane.showInputDialog("Digite o telefone do fornecedor");

            stmt.executeUpdate("INSERT INTO FORNECEDOR"
                    + " VALUES ('" + a + "', '" + b + "','" + c + "', '" + d + "')");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Fornecedor");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Fornecedor");


        }
    }

    public void atualizarCNPJFornecedor(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o nome do fornecedor");
            String b = JOptionPane.showInputDialog("Digite seu novo CNPJ");

            stmt.executeUpdate("UPDATE FORNECEDOR SET CNPJ_FOR = " + b + " WHERE NOME_FOR = '" + a + "'");

            JOptionPane.showMessageDialog(null, "CNPJ atualizado na tabela Fornecedor");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar CNPJ do fornecedor");


        }

    }

    public void atualizarNomeFornecedor(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CNPJ do fornecedor");
            String b = JOptionPane.showInputDialog("Digite seu novo nome");

            stmt.executeUpdate("UPDATE FORNECEDOR SET NOME_FOR = '" + b + "' WHERE CNPJ_FOR = " + a + "");

            JOptionPane.showMessageDialog(null, "Nome atualizado na tabela Fornecedor");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o nome do fornecedor");


        }

    }

    public void atualizarEnderecoFornecedor(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPNJ do fornecedor");
            String b = JOptionPane.showInputDialog("Digite seu novo endereco");

            stmt.executeUpdate("UPDATE FORNECEDOR SET ENDERECO_FOR = '" + b + "' WHERE CNPJ_FOR = " + a + "");

            JOptionPane.showMessageDialog(null, "Endereço atualizado na tabela Fornecedor");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o endereço do fornecedor");


        }

    }

    public void atualizarTelefoneFornecedor(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CNPJ do fornecedor");
            String b = JOptionPane.showInputDialog("Digite seu novo telefone");

            stmt.executeUpdate("UPDATE FORNECEDOR SET TELEFONE_FOR = '" + b + "' WHERE CNPJ_FOR = " + a + "");

            JOptionPane.showMessageDialog(null, "Telefone atualizado na tabela Fornecedor");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o telefone do fornecedor");
;

        }

    }

    public void selecionarDadosUmFornecedor(Statement stmt) {
        try {

            String cnpj = JOptionPane.showInputDialog("Informe o CNPJ do fornecedor a ser consultado");
            stmt.executeQuery("SELECT * FROM FORNECEDOR WHERE CNPJ_FOR = " + cnpj + "");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os dados do fornecedor de CNPJ " + cnpj);

            System.out.println("-------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.println("CNPJ do fornecedor: " + rs.getString(1));
                System.out.println("Nome do fornecedor: " + rs.getString(2));
                System.out.println("Endereço do fornecedor: " + rs.getString(3));
                System.out.println("Telefone do fornecedor: " + rs.getString(4));
                System.out.println("");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados do fornecedor");


        }

    }

    public void selecionarDadosTodosFornecedores(Statement stmt) {
        try {

            stmt.executeQuery("SELECT * FROM FORNECEDOR");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os dados de todos os fornecedores");

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CNPJ: "+rs.getString(1) + "   Nome: " + rs.getString(2) + "   Endereço: " + rs.getString(3) + "   Telefone: " + rs.getString(4));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos fornecedores");

        }

    }

}
