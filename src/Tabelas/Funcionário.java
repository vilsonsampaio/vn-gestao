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
public class Funcionário {

    public void criarTabelaFuncionario(Statement stmt) {
        try {
            String createTableFuncionario = "CREATE TABLE FUNCIONARIO(CPF BIGINT(11), NOME VARCHAR(60), "
                    + "FUNCAO VARCHAR(25), SALARIO DOUBLE)";

            stmt.executeUpdate(createTableFuncionario);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");


        }
    }

    public void inserirDadosFuncionario(Statement stmt) {
        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do funcionário");
            String b = JOptionPane.showInputDialog("Digite o nome do funcionário");
            String c = JOptionPane.showInputDialog("Digite a função do funcionário");
            double d = Double.parseDouble(JOptionPane.showInputDialog("Digite salário"));

            stmt.executeUpdate("INSERT INTO FUNCIONARIO"
                    + " VALUES (" + a + ", '" + b + "','" + c + "', " + d + ");");

             JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Funcionário");

        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Funcionário");


        }
    }

    public void atualizarCPFFuncionario(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o nome do funcionário");
            String b = JOptionPane.showInputDialog("Digite seu novo CPF");

            stmt.executeUpdate("UPDATE FUNCIONARIO SET CPF_FUN = '" + b + "' WHERE NOME_FUN = '" + a + "'");

             JOptionPane.showMessageDialog(null, "CPF atualizado na tabela Funcionário");

        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o CPF do funcionário");


        }

    }

    public void atualizarNomeFuncionario(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do funcionário");
            String b = JOptionPane.showInputDialog("Digite seu novo nome");

            stmt.executeUpdate("UPDATE FUNCIONARIO SET NOME_FUN = '" + b + "' WHERE CPF_FUN = " + a + "");

             JOptionPane.showMessageDialog(null, "Nome atualizado na tabela Funcionário");

        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o nome do funcionário");


        }

    }

    public void atualizarFuncaoFuncionario(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do funcionário");
            String b = JOptionPane.showInputDialog("Digite sua nova função");

            stmt.executeUpdate("UPDATE FUNCIONARIO SET FUNCAO_FUN = '" + b + "' WHERE CPF_FUN = '" + a + "'");

             JOptionPane.showMessageDialog(null, "Função atualizada na tabela Funcionário");

        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a função do funcionário");


        }

    }

    public void atualizarSalarioFuncionario(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o CPF do funcionário");
            double b = Double.parseDouble(JOptionPane.showInputDialog("Digite seu novo salário"));

            stmt.executeUpdate("UPDATE FUNCIONARIO SET SALARIO_FUN = " + b + " WHERE CPF_FUN = " + a + "");

            JOptionPane.showMessageDialog(null, "Salário atualizado na tabela Funcionário");

        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o salário do funcionário");


        }

    }

    public void selecionarDadosUmFuncionario(Statement stmt) {
        try {

            String cpf = JOptionPane.showInputDialog("Informe o CPF do funcionário a ser consultado");
            stmt.executeQuery("SELECT * FROM FUNCIONARIO WHERE CPF_FUN = " + cpf + "");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os dados do funcionário de CPF " + cpf);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CPF do funcionário: " + rs.getString(1));
                System.out.println("Nome do funcionário: " + rs.getString(2));
                System.out.println("Função do funcionário: " + rs.getString(3));
                System.out.println("Salário do funcionário: R$" + rs.getDouble(4));
                
            }
            System.out.println("");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados do funcionário");


        }

    }

    public void selecionarDadosTodosFuncionarios(Statement stmt) {
        try {

            ResultSet rs = stmt.executeQuery("SELECT * FROM FUNCIONARIO");

            System.out.println("Exibindo os registros da tabela Funcionário");

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CPF: "+rs.getString(1)+"   Nome: "+rs.getString(2)+"   Função: "+rs.getString(3)+"   Salário: R$"+rs.getDouble(4));
                
            }
            System.out.println();
        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos funcionários");

        }

    }

}
