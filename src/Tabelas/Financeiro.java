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
public class Financeiro {
    


    
    public void criarTabelaFinanceiro(Statement stmt){
       try{
           String createTableFinanceiro = "CREATE TABLE FINANCEIRO(CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
                   + "DATA DATE NOT NULL, ENTRADA DOUBLE, SAIDA DOUBLE)";

           stmt.executeUpdate(createTableFinanceiro);
           System.out.println("Tabela Criada");
       } catch (Exception e) {

            System.out.println("Ocorreu um erro ao criar Tabela");
            
            System.exit(0);

        }
    }
    
     public void inserirDadosFinanceiro(Statement stmt){
     try{
            
            String data_fin  = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD) do financeiro");
            Double entrada_fin = Double.parseDouble(JOptionPane.showInputDialog("Digite a entrada do financeiro"));
            Double saida_fin = Double.parseDouble(JOptionPane.showInputDialog("Digite a saída"));
            
                         

            stmt.executeUpdate("INSERT INTO FINANCEIRO"
                    + " VALUES (CODIGO_FIN, '"+data_fin+"', "+entrada_fin+","+saida_fin+")");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Financeiro"); 
         
       } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir na tabela Financeiro");


        }   
    }
    
     public void inserirPedidoFinanceiro(Statement stmt, String data, double entrada, double saida){
     try{
          
            stmt.executeUpdate("INSERT INTO FINANCEIRO"
                    + " VALUES (CODIGO_FIN, '"+data+"', "+entrada+", "+saida+")");

            JOptionPane.showMessageDialog(null, "Dados inseridos na tabela Financeiro"); 
         
       } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir dados na tabela Financeiro");
            
            System.exit(0);

        }   
    } 
        
    public void atualizarDataFinanceiro(Statement stmt){
      
        try{
            int codigo_fin = Integer.parseInt(JOptionPane.showInputDialog("Digite o cÃ³digo"));
            String data_fin = JOptionPane.showInputDialog("Digite a nova data (AAAA-MM-DD)");

            stmt.executeUpdate("UPDATE FINANCEIRO SET DATA_FIN = '"+data_fin+"' WHERE CODIGO_FIN = "+codigo_fin+"");

            JOptionPane.showMessageDialog(null, "Data atualizada na tabela Financeiro");

           
       } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a data na tabela Financeiro");
            
            System.exit(0);

        }
        
    }
     
         
    public void atualizarEntradaFinanceiro(Statement stmt){
      
        try{
            int codigo_fin = Integer.parseInt(JOptionPane.showInputDialog("Informe o cÃ³digo"));
            Double entrada_fin = Double.parseDouble(JOptionPane.showInputDialog("Digite a nova entrada"));

            stmt.executeUpdate("UPDATE FINANCEIRO SET ENTRADA_FIN = '"+entrada_fin+"' WHERE CODIGO_FIN = "+codigo_fin+"");

            JOptionPane.showMessageDialog(null, "Entrada atualizada na tabela Financeiro");

           
       } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a entrada na tabela Financeiro");
            
            System.exit(0);

        }
        
    }
    
    public void atualizarSaidaFinanceiro(Statement stmt){
      
        try{
            int codigo_fin  = Integer.parseInt(JOptionPane.showInputDialog("Informe o cÃ³digo"));
            Double saida_fin = Double.parseDouble(JOptionPane.showInputDialog("Digite a nova saÃ­da"));

            stmt.executeUpdate("UPDATE FINANCEIRO SET SAIDA_FIN = '"+saida_fin+"' WHERE CODIGO_FIN = "+codigo_fin+"");

            JOptionPane.showMessageDialog(null, "Saída atualizada na tabela Financeiro");

           
       } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a saída na tabela Financeiro");
            
            System.exit(0);

        }
        
    }
      
    
    
    public void selecionarDadosUmFinanceiro(Statement stmt){
     try{
       
            String data = JOptionPane.showInputDialog("Informe a data a ser consultada (AAAA-MM-DD)");   
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCEIRO WHERE DATA_FIN='"+data+"'");

            System.out.println("Exibindo os registros");

            System.out.println("-------------------------------------------------------------------------");
            double somaE = 0, somaS = 0;
            while (rs.next()) {
               
                //mapeando com os numeros das colunas
                int codigo_fin = rs.getInt(1);
                String data_fin = rs.getString(2);
                Double entrada_fin = rs.getDouble(3);            
                Double saida_fin = rs.getDouble(4);
                somaE = somaE + entrada_fin;
                somaS = somaS + saida_fin;

                System.out.println(codigo_fin+"   "+data_fin+"   +R$ "+entrada_fin+"   -R$ "+saida_fin);
                
            }        
            System.out.println();         
            System.out.println("Total de Entrada no dia "+data+": +R$" + somaE);
            System.out.println("Total de Saída no dia "+data+":   -R$" + somaS);                        
            System.out.println("-----------------------------------------");
            System.out.println("Saldo no dia "+data+": R$" + (somaE-somaS));
            System.out.println("");
         
         
     }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar o financeiro desse dia");


        }
        
    }
    
    public void selecionarDadosMêsFinanceiro(Statement stmt){
     try{
       
            String mes = JOptionPane.showInputDialog("Informe o mês a ser consultado (MM)"); 
            String ano = JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)");
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCEIRO WHERE DATA_FIN LIKE '"+ano+"-"+mes+"-%'");

            System.out.println("Exibindo os registros");

            System.out.println("-------------------------------------------------------------------------");
            double somaE = 0, somaS = 0;
            while (rs.next()) {
               
                //mapeando com os numeros das colunas
                int codigo_fin = rs.getInt(1);
                String data_fin = rs.getString(2);
                Double entrada_fin = rs.getDouble(3);            
                Double saida_fin = rs.getDouble(4);
                somaE = somaE + entrada_fin;
                somaS = somaS + saida_fin;

                System.out.println(codigo_fin+"   "+data_fin+"   +R$ "+entrada_fin+"   -R$ "+saida_fin);
                
            }        
            System.out.println();         
            System.out.println("Total de Entrada no mês "+mes+" de "+ano+": +R$" + somaE);
            System.out.println("Total de Saída no mês "+mes+" de "+ano+":   -R$" + somaS);                        
            System.out.println("-----------------------------------------");
            System.out.println("Saldo no mês "+mes+" de "+ano+": R$" + (somaE-somaS));
            System.out.println("");
         
         
     }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar o financeiro desse mês");

        }
        
    }
    
    public void selecionarDadosAnoFinanceiro(Statement stmt){
     try{
       
            String ano = JOptionPane.showInputDialog("Informe o ano a ser consultado (AAAA)");
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCEIRO WHERE DATA_FIN LIKE '"+ano+"-%'");

            System.out.println("Exibindo os registros");

            System.out.println("-------------------------------------------------------------------------");
            double somaE = 0, somaS = 0;
            while (rs.next()) {
               
                //mapeando com os numeros das colunas
                int codigo_fin = rs.getInt(1);
                String data_fin = rs.getString(2);
                Double entrada_fin = rs.getDouble(3);            
                Double saida_fin = rs.getDouble(4);
                somaE = somaE + entrada_fin;
                somaS = somaS + saida_fin;

                System.out.println(codigo_fin+"   "+data_fin+"   +R$ "+entrada_fin+"   -R$ "+saida_fin);
                
            }        
            System.out.println();         
            System.out.println("Total de Entrada no ano de "+ano+": +R$" + somaE);
            System.out.println("Total de Saída no ano de "+ano+":   -R$" + somaS);                        
            System.out.println("-----------------------------------------");
            System.out.println("Saldo no ano de "+ano+": R$" + (somaE-somaS));
            System.out.println("");
         
         
     }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar o financeiro desse ano");


        }
        
    }
    
    public void selecionarDadosTodosFinanceiro(Statement stmt){
     try{
       
             
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCEIRO");

            System.out.println("Exibindo os registros");

            System.out.println("-------------------------------------------------------------------------");
            
            double somaE = 0, somaS = 0;
            while (rs.next()) {
               
                //mapeando com os numeros das colunas
                int codigo_fin = rs.getInt(1);
                String data_fin = rs.getString(2);
                double entrada_fin = rs.getDouble(3);            
                double saida_fin = rs.getDouble(4);
                somaE = somaE + entrada_fin;
                somaS = somaS + saida_fin;

                System.out.println(codigo_fin+"   "+data_fin+"   +R$ "+entrada_fin+"   -R$ "+saida_fin);
                
            }        
            System.out.println();         
            System.out.println("Total de Entrada: +R$" + somaE);
            System.out.println("Total de Saída:   -R$" + somaS);                     
            System.out.println("-----------------------------------------");
            System.out.println("Saldo: R$" + (somaE-somaS)); 
            System.out.println("");
         
     }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar todos os dados da tabela Financeiro");


        }
        
        
    }
    
    public void selecionarDadosTodosFinanceiroaAtualizar(Statement stmt){
     try{
       
             
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCEIRO");

            System.out.println("Exibindo os registros");

            System.out.println("-------------------------------------------------------------------------");
            
            double somaE = 0, somaS = 0;
            while (rs.next()) {
               
                //mapeando com os numeros das colunas
                int codigo_fin = rs.getInt(1);
                String data_fin = rs.getString(2);
                double entrada_fin = rs.getDouble(3);            
                double saida_fin = rs.getDouble(4);
                somaE = somaE + entrada_fin;
                somaS = somaS + saida_fin;

                System.out.println(codigo_fin+"   "+data_fin+"   +R$ "+entrada_fin+"   -R$ "+saida_fin);
                
            }        
                        
            System.out.println("-----------------------------------------");
         
     }catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao selecionar os dados da tabela Financeiro");
            
            System.exit(0);

        }
        
        
    }
    
     
    

}   
    
    
    



