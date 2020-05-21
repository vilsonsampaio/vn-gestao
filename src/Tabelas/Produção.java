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
public class Produção {

    Estoque est = new Estoque();
    Produto prod = new Produto();

    public void criarTabelaProducao(Statement stmt) {
        try {
            String createTableProducao = "CREATE TABLE PRODUCAO(CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + " DATA DATE NOT NULL, QUANTIDADE INT NOT NULL,  CODIGO_PRODUTO int not null references PRODUTO)";

            stmt.executeUpdate(createTableProducao);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");

            System.exit(0);

        }
    }

    public void inserirDadosProducao(Statement stmt) {
        try {
            String b = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD) da produção");
            int c = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade da produção"));
            String d = JOptionPane.showInputDialog("Digite o código do produto produzido");
            

            stmt.executeUpdate("INSERT INTO PRODUCAO"
                    + " VALUES (CODIGO_PRODUCAO, '" + b + "', '" + c + "','" + d + "')");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Produção");
            est.inserirDadosEstoque(stmt, c, d);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Produção");


        }
    }

    public void atualizarDataProducao(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código da produção");
            String b = JOptionPane.showInputDialog("Digite a nova data");

            stmt.executeUpdate("UPDATE PRODUCAO SET DATA_PRODUCAO = '" + b + "' WHERE CODIGO_PRODUCAO = " + a + "");

            JOptionPane.showMessageDialog(null, "Data atualizada na tabela Produção");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a data da produção");


        }

    }
    
   

    public void selecionarDataProducao(Statement stmt) {
        try {

            String data = JOptionPane.showInputDialog("Informe a data a ser consultada (AAAA-MM-DD)");

            stmt.executeQuery("SELECT * FROM PRODUCAO WHERE DATA_PRODUCAO = '" + data + "'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros das produções feitas em "+data);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CODIGO: "+rs.getInt(1) + "   DATA: " + rs.getString(2) + "   QUANTIDADE: " + rs.getInt(3) + "   CODIGO_PRODUTO: " + rs.getInt(4));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados das produções feitas nesse dia");


        }

    }

    public void selecionarMesProducao(Statement stmt) {
        try {

            int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês a ser consultado (MM)"));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)"));

            stmt.executeQuery("SELECT * FROM PRODUCAO WHERE DATA_PRODUCAO LIKE '"+ano+"-"+mes+"%'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros das produções feitas no mês "+mes+" de "+ano);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CODIGO: "+rs.getInt(1) + "   DATA: " + rs.getString(2) + "   QUANTIDADE: " + rs.getInt(3) + "   CODIGO_PRODUTO: " + rs.getInt(4));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados das produções feitas nesse mês");


        }

    }
    
    public void selecionarAnoProducao(Statement stmt) {
        try {

            int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)"));

            stmt.executeQuery("SELECT * FROM PRODUCAO WHERE DATA_PRODUCAO LIKE '"+ano+"-%'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros das produções feitas no ano "+ano);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CODIGO: "+rs.getInt(1) + "   DATA: " + rs.getString(2) + "   QUANTIDADE: " + rs.getInt(3) + "   CODIGO_PRODUTO: " + rs.getInt(4));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados das produções feitas nesse ano");


        }

    }
    
    public void selecionarTodasProducoes(Statement stmt) {
        try {

            stmt.executeQuery("SELECT * FROM PRODUCAO");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros de todas as produções");

            System.out.println("-------------------------------------------------------------------------");
            
            while (rs.next()) {

              
                System.out.println("CODIGO: "+rs.getInt(1) + "   DATA: " + rs.getString(2) + "   QUANTIDADE: " + rs.getInt(3) + "   CODIGO_PRODUTO: " + rs.getInt(4));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar todos os dados da tabela Produção");


        }

    }
}
