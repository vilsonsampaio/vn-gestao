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
public class Pedido {


    Financeiro fin = new Financeiro();
    Estoque est = new Estoque();



    public void criarTabelaPedido(Statement stmt) {
        try {
            String createTablePedido = "CREATE TABLE PEDIDO(CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
                    + "DATA DATE NOT NULL, STATUS VARCHAR(45), QUANTIDADE INT NOT NULL,  CODIGO_PRODUTO int not null references PRODUTO, TOTAL DOUBLE)";

            stmt.executeUpdate(createTablePedido);
            System.out.println("Tabela Criada");
        } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");

            System.exit(0);

        }
    }

    public void inserirDadosPedido(Statement stmt) {
        try {
            
            String b = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD) do pedido");
            String c = JOptionPane.showInputDialog("Digite o status do pedido");
            int d = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do pedido"));
            String e = JOptionPane.showInputDialog("Digite o código do cliente que realizou o pedido");
            String f = JOptionPane.showInputDialog("Digite o código do produto comprado");
            double g = Double.parseDouble(JOptionPane.showInputDialog("Digite o total do pedido"));
            est.inserirDadosEstoque(stmt, (-d), f);
            fin.inserirPedidoFinanceiro(stmt, b, g, 0);
                    

            //stmt.executeQuery("SELECT PRECO FROM PRODUTO WHERE CODIGO = '"+e+"'");
            //ResultSet rs = stmt.getResultSet();
            //System.out.println(rs.getDouble(3));
            stmt.executeUpdate("INSERT INTO PEDIDO"
                    + " VALUES (CODIGO_PED, '"+b+"', '"+c+"', "+d+", '"+e+"', '"+f+"', "+g+");");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir os dados na tabela Pedido");

        }
    }

    public void atualizarStatusPedido(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código do pedido");
            String b = JOptionPane.showInputDialog("Digite o novo status");

            stmt.executeUpdate("UPDATE PEDIDO SET STATUS_PED = '" + b + "' WHERE CODIGO_PED = " + a + "");

            JOptionPane.showMessageDialog(null, "Status atualiado na tabela Pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o status na tabela Pedido");

        }

    }
    
    public void atualizarCodigoClientePedido(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código do pedido");
            String b = JOptionPane.showInputDialog("Digite o novo código do cliente");

            stmt.executeUpdate("UPDATE PEDIDO SET CPF_CLI = '" + b + "' WHERE CODIGO_PED = " + a + "");

            JOptionPane.showMessageDialog(null, "Código do cliente atualiado na tabela Pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o código do cliente na tabela Pedido");

        }

    }
    
    public void atualizarDataPedido(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Digite o código do pedido");
            String b = JOptionPane.showInputDialog("Digite a nova data");

            stmt.executeUpdate("UPDATE PEDIDO SET DATA_PED = '" + b + "' WHERE CODIGO_PED = " + a + "");

            JOptionPane.showMessageDialog(null, "Código do cliente atualiado na tabela Pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o código do cliente na tabela Pedido");

        }

    }
     
    public void atualizarQuantidadePedido(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Informe o código do pedido");
            int b = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade"));
            String e = "CODIGO_PRODUTO";

            stmt.executeUpdate("UPDATE PEDIDO SET QUANTIDADE_PED = '" + b + "' WHERE CODIGO_PED = " + a + "");

            JOptionPane.showMessageDialog(null, "Quantidade atualizada na tabela Pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a quantidade do pedido");

        }

    }

    public void atualizarTotalPedido(Statement stmt) {

        try {
            String a = JOptionPane.showInputDialog("Informe o código do pedido");
            Double b = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo total"));

            stmt.executeUpdate("UPDATE PEDIDO SET TOTAL_PED = " + b + " WHERE CODIGO_PED = " + a + "");

            JOptionPane.showMessageDialog(null, "Total atualizado na tabela pedido");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o total do pedido");

        }

    }

    public void selecionarDadosUmPedido(Statement stmt) {
        try {

            String codigo = JOptionPane.showInputDialog("Informe o código do cliente");
            stmt.executeQuery("SELECT * FROM PEDIDO WHERE CPF_CLI ='" + codigo + "'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo o dados do pedido de código "+codigo);

            System.out.println("-------------------------------------------------------------------------");

            while (rs.next()) {
                //mapeando com os numeros das colunas
             
                System.out.println("CODIGO DO PEDIDO: " + rs.getInt(1)+"   DATA DO PEDIDO: " + rs.getString(2)+"   "
                        + "STATUS: " + rs.getString(3)+"   QUANTIDADE: " + rs.getInt(4)+"   CPF DO CLIENTE: "
                        + ""+rs.getString(5)+"   CÓDIGO DO PRODUTO: " + rs.getInt(6)+"   TOTAL: R$" + rs.getDouble(7));

            }
            System.out.println();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados do pedido desse cliente");

        }

    }

    public void selecionarDadosDataTodosPedidos(Statement stmt) {
        try {

            String data = JOptionPane.showInputDialog("Informe a data a ser consultada (AAAA-MM-DD)");
            stmt.executeQuery("SELECT * FROM PEDIDO WHERE DATA_PED='" + data + "'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros dos pedidos feitos em "+data);

            System.out.println("-------------------------------------------------------------------------");

            while (rs.next()) {

                
                System.out.println("CODIGO DO PEDIDO: " + rs.getInt(1)+"   DATA DO PEDIDO: " + rs.getString(2)+"   "
                        + "STATUS: " + rs.getString(3)+"   QUANTIDADE: " + rs.getInt(4)+"   CPF DO CLIENTE: "
                        + ""+rs.getString(5)+"   CÓDIGO DO PRODUTO: " + rs.getInt(6)+"   TOTAL: R$" + rs.getDouble(7));
                

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos pedidos feitos nesse dia");

        }

    }
    
    public void selecionarDadosMesTodosPedidos(Statement stmt) {
        try {

            int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o mês a ser consultado (MM)"));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)"));

            stmt.executeQuery("SELECT * FROM PEDIDO WHERE DATA_PED LIKE '"+ano+"-"+mes+"-%'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros dos pedidos feitos no mês "+mes+" de "+ano);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CODIGO DO PEDIDO: " + rs.getInt(1)+"   DATA DO PEDIDO: " + rs.getString(2)+"   "
                        + "STATUS: " + rs.getString(3)+"   QUANTIDADE: " + rs.getInt(4)+"   CPF DO CLIENTE: "
                        + ""+rs.getString(5)+"   CÓDIGO DO PRODUTO: " + rs.getInt(6)+"   TOTAL: R$" + rs.getDouble(7));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos pedidos feitos nesse mês");


        }

    }
    
    public void selecionarDadosAnoTodosPedidos(Statement stmt) {
        try {

            int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)"));

            stmt.executeQuery("SELECT * FROM PEDIDO WHERE DATA_PED LIKE '"+ano+"-%'");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros dos pedidos feitos no ano "+ano);

            System.out.println("-------------------------------------------------------------------------");
            while (rs.next()) {

                System.out.println("CODIGO DO PEDIDO: " + rs.getInt(1)+"   DATA DO PEDIDO: " + rs.getString(2)+"   "
                        + "STATUS: " + rs.getString(3)+"   QUANTIDADE: " + rs.getInt(4)+"   CPF DO CLIENTE: "
                        + ""+rs.getString(5)+"   CÓDIGO DO PRODUTO: " + rs.getInt(6)+"   TOTAL: R$" + rs.getDouble(7));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos pedidos feitos nesse ano");


        }

    }
    
    public void selecionarDadosTodosPedidos(Statement stmt) {
        try {

            stmt.executeQuery("SELECT * FROM PEDIDO");
            ResultSet rs = stmt.getResultSet();

            System.out.println("Exibindo os registros de todos os pedidos");

            System.out.println("-------------------------------------------------------------------------");

            while (rs.next()) {

                //mapeando com os numeros das colunas
                System.out.println("CODIGO DO PEDIDO: " + rs.getInt(1)+"   DATA DO PEDIDO: " + rs.getString(2)+"   "
                        + "STATUS: " + rs.getString(3)+"   QUANTIDADE: " + rs.getInt(4)+"   CPF DO CLIENTE: "
                        + ""+rs.getString(5)+"   CÓDIGO DO PRODUTO: " + rs.getInt(6)+"   TOTAL: R$" + rs.getDouble(7));

            }
            System.out.println("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados dos pedidos");

        }

    }

}
