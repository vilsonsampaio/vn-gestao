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
public class Estoque {

    Produto prod = new Produto();

    public void criarTabelaEstoque(Statement stmt) {
        try {
            String createTableEstoque = "CREATE TABLE ESTOQUE(CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + " QUANTIDADE INT NOT NULL,  CODIGO_PRODUTO int not null references PRODUTO)";

            stmt.executeUpdate(createTableEstoque);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");

            System.exit(0);

        }
    }

    public void inserirDadosEstoque(Statement stmt, int qtde, String codigo_produto) {
        try {
            stmt.executeUpdate("INSERT INTO ESTOQUE"
                    + " VALUES (CODIGO_EST, '" + qtde + "', '" + codigo_produto + "')");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela estoque");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir a quantidade na tabela Estoque");

        }
    }

    public void inserirDadosIniciaisEstoque(Statement stmt) {
        try {
            int qtde = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto"));
            int codigo_produto = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto"));
            stmt.executeUpdate("INSERT INTO ESTOQUE"
                    + " VALUES (CODIGO_EST, '" + qtde + "', '" + codigo_produto + "')");

            JOptionPane.showMessageDialog(null, "Dados iniciais nseridos na tabela estoque");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir os dados iniciais na tabela Estoque");

        }
    }

    public void atualizarQtdeEstoqueInicial(Statement stmt) {

        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do estoque"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite sua nova quantidade"));

            stmt.executeUpdate("UPDATE ESTOQUE SET QUANTIDADE_EST = " + b + " WHERE CODIGO_EST = " + a + "");

            JOptionPane.showMessageDialog(null, "Quantidade inicial do produto atualizada na tabela Estoque");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a quantidade inicial do produto na tabela Estoque");

        }
    }

    public void atualizarCodigoProdutoEstoqueInicial(Statement stmt) {

        try {
            int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do estoque"));
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código do produto"));

            stmt.executeUpdate("UPDATE ESTOQUE SET CODIGO_PRODUTO = '" + b + "' WHERE CODIGO_EST = " + a + "");

            JOptionPane.showMessageDialog(null, "Código do produto atualizado na tabela Estoque");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o código do produto na tabela Estoque");

        }
    }

    public void selecionarDadosEstoqueUmProduto(Statement stmt) {
        try {

            String codigo = JOptionPane.showInputDialog("Informe o código do produto");
            stmt.executeQuery("SELECT * FROM ESTOQUE WHERE CODIGO_PRODUTO='" + codigo + "'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo o dados do estoque");

            System.out.println("-------------------------------------------------------------------------");
            int soma = 0;
            while (rs.next()) {

                //mapenado com nome das colunas
                //int cod = rs.getInt("CODIGO");
                int qtde = rs.getInt(2);
                soma = soma + qtde;

                //mapeando com os numeros das colunas
                // int qtde = rs.getInt(2);
                //int cod_produto = rs.getInt(3);
                //soma = soma + qtde;
            }
            System.out.println("Estoque do produto "+codigo+": "+soma);
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados");


        }

    }

    public void selecionarDadosEstoqueTodosProdutos(Statement stmt) throws SQLException {
        try {

            
            
            
            
            stmt.executeQuery("SELECT * FROM ESTOQUE");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo o dados do estoque");

            System.out.println("-------------------------------------------------------------------------");
            int soma = 0;
            while (rs.next()) {

                System.out.println("CODIGO: "+rs.getInt(1)+"   QUANTIDADE: "+rs.getInt(2)+"   COD_PRODUTO: "+rs.getInt(3));
               

                //mapeando com os numeros das colunas
                // int qtde = rs.getInt(2);
                //int cod_produto = rs.getInt(3);
                //soma = soma + qtde;
            }
            System.out.println("");
            

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados");


        }

    }
}
