package vngestãodeempresas;


import java.sql.SQLException;
import Tabelas.*;
import Conexão.*;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class VNGestãoDeEmpresas {

    public static void main(String[] args) throws SQLException {
          
              
        
        
        

        Cliente cliente = new Cliente();           
        Estoque estoque = new Estoque();
        Financeiro financeiro = new Financeiro();
        Fornecedor fornecedor = new Fornecedor();
        Funcionário funcionário = new Funcionário();
        Pedido pedido = new Pedido();
        Produto produto = new Produto();
        Produção produção = new Produção();

        // Mensagem de bem-vindo
        int bemvindo = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao VN - Gestão de empresas\n"
                + "\nDeseja se conectar?"
                + "\n1 - Sim"
                + "\n2 - Não"));
        if (bemvindo == 1) {
            //Conexão com o banco
            Conexão con = new Conexão();
            
            if (con!=null) {
                //Acesso as tabelas
                Statement stmt = con.con.createStatement();
                int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual tabela você deseja acessar?\n"
                        + "\n1 - Cliente"
                        + "\n2 - Funcionário"
                        + "\n3 - Fornecedor"
                        + "\n4 - Produto"
                        + "\n5 - Produção"
                        + "\n6 - Pedido"
                        + "\n7 - Financeiro"
                        + "\n8 - Estoque"
                        + "\n0 - Sair"));
                
                while (opcao != 0) {
                    if (opcao == 1) {
                        // Acessando a tabela cliente;
                        int opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                + "\n1- Inserir dados na tabela cliente"
                                + "\n2 - Atualizar dados na tabela cliente"
                                + "\n3 - Selecionar dados na tabela cliente"
                                + "\n0 - Sair"));
                        while (opcaoCliente != 0) {
                            switch (opcaoCliente) {
                                case 1:
                                    // Inserir dados em cliente
                                    cliente.inserirDadosCliente(stmt);
                                    break;
                                case 2:
                                    // Atualizar dados em cliente
                                    cliente.selecionarDadosTodosClientes(stmt);
                                    int atualizarCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                            + "\n1 - CPF do cliente"
                                            + "\n2 - Nome do cliente"
                                            + "\n3 - Endereço do cliente"
                                            + "\n4 - Telefone do cliente"
                                            + "\n0 - Sair"));
                                    // Opções do que atualizar em cliente
                                    while (atualizarCliente != 0) {
                                        switch (atualizarCliente) {
                                            case 1:
                                                cliente.atualizarCPFCliente(stmt);
                                                break;
                                            case 2:
                                                cliente.atualizarNomeCliente(stmt);
                                                break;
                                            case 3:
                                                cliente.atualizarEnderecoCliente(stmt);
                                                break;
                                            case 4:
                                                cliente.atualizarTelefoneCliente(stmt);
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                        }
                                        atualizarCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                + "\n1 - CPF do cliente"
                                                + "\n2 - Nome do cliente"
                                                + "\n3 - Endereço do cliente"
                                                + "\n4 - Telefone do cliente"
                                                + "\n0 - Sair"));
                                    }
                                    //Voltar ao menu de opções do que fazer em cliente
                                    opcaoCliente = 0;
                                    break;
                                case 3:
                                    // Selecionar tabela cliente
                                    int selecionarCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                            + "\n1 - Dados de um cliente específico"
                                            + "\n2 - Dados de todos os clientes"
                                            + "\n0 - Sair"));
                                    // Opções do que selecionar em cliente
                                    while (selecionarCliente != 0) {
                                        switch (selecionarCliente) {
                                            case 1:
                                                cliente.selecionarDadosUmCliente(stmt);
                                                break;
                                            case 2:
                                                cliente.selecionarDadosTodosClientes(stmt);
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                        }
                                        selecionarCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                + "\n1 - Dados de um cliente específico"
                                                + "\n2 - Dados de todos os clientes"
                                                + "\n0 - Sair"));
                                    }
                                    //Voltar ao menu de opções do que fazer em cliente
                                    opcaoCliente = 0;

                            }
                            opcaoCliente = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                    + "\n1- Inserir dados na tabela cliente"
                                    + "\n2 - Atualizar dados na tabela cliente"
                                    + "\n3 - Selecionar dados na tabela cliente"
                                    + "\n0 - Sair"));
                        }
                        //Voltar ao menu de qual tabela deseja acessar
                        opcao=0;
                    } else {
                        if (opcao==2){
                            int opcaoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                    + "\n1- Inserir dados na tabela funcionário"
                                    + "\n2 - Atualizar dados na tabela funcionário"
                                    + "\n3 - Selecionar dados na tabela funcionário"
                                    + "\n0 - Sair"));
                            while (opcaoFuncionario != 0) {
                                switch (opcaoFuncionario) {
                                    case 1:
                                        // Inserir dados em funcionário
                                        funcionário.inserirDadosFuncionario(stmt);
                                        break;
                                    case 2:
                                        // Atualizar dados em funcionário
                                        funcionário.selecionarDadosTodosFuncionarios(stmt);
                                        int atualizarFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                + "\n1 - CPF do funcionário"
                                                + "\n2 - Nome do funcionário"
                                                + "\n3 - Função do funcionário"
                                                + "\n4 - Salário do funcionário"
                                                + "\n0 - Sair"));
                                        // Opções do que atualizar em funcionário
                                        while (atualizarFuncionario != 0) {
                                            switch (atualizarFuncionario) {
                                                case 1:
                                                    funcionário.atualizarCPFFuncionario(stmt);
                                                    break;
                                                case 2:
                                                    funcionário.atualizarNomeFuncionario(stmt);
                                                    break;
                                                case 3:
                                                    funcionário.atualizarFuncaoFuncionario(stmt);
                                                    break;
                                                case 4:
                                                    funcionário.atualizarSalarioFuncionario(stmt);
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opção inválida");
                                            }
                                            atualizarFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                    + "\n1 - CPF do funcionário"
                                                    + "\n2 - Nome do funcionário"
                                                    + "\n3 - Função do funcionário"
                                                    + "\n4 - Salário do funcionário"
                                                    + "\n0 - Sair"));
                                        }
                                        //Voltar ao menu de opções do que fazer em funcionário
                                        opcaoFuncionario = 0;
                                        break;
                                    case 3:
                                        // Selecionar tabela funcionário
                                        int selecionarFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                + "\n1 - Dados de um funcionário específico"
                                                + "\n2 - Dados de todos os funcionários"
                                                + "\n0 - Sair"));
                                        // Opções do que selecionar em funcionário
                                        while (selecionarFuncionario != 0) {
                                            switch (selecionarFuncionario) {
                                                case 1:
                                                    funcionário.selecionarDadosUmFuncionario(stmt);
                                                    break;
                                                case 2:
                                                    funcionário.selecionarDadosTodosFuncionarios(stmt);
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opção inválida");
                                            }
                                            selecionarFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                    + "\n1 - Dados de um funcionário específico"
                                                    + "\n2 - Dados de todos os funcionários"
                                                    + "\n0 - Sair"));
                                        }
                                        //Voltar ao menu de opções do que fazer em funcionário
                                        opcaoFuncionario = 0;

                                }
                                opcaoFuncionario = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                        + "\n1- Inserir dados na tabela funcionário"
                                        + "\n2 - Atualizar dados na tabela funcionário"
                                        + "\n3 - Selecionar dados na tabela funcionário"
                                        + "\n0 - Sair"));
                            }
                            opcao = 0;

                            }  else {
                                if (opcao==3){
                                    // Acessando a tabela fornecedor
                                    int opcaoFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                            + "\n1- Inserir dados na tabela fornecedor"
                                            + "\n2 - Atualizar dados na tabela fornecedor"
                                            + "\n3 - Selecionar dados na tabela fornecedor"
                                            + "\n0 - Sair"));
                                    while (opcaoFornecedor != 0) {
                                        switch (opcaoFornecedor) {
                                            case 1:
                                                // Inserir dados em fornecedor
                                                fornecedor.inserirDadosFornecedor(stmt);
                                                break;
                                            case 2:
                                                // Atualizar dados em fornecedor
                                                fornecedor.selecionarDadosTodosFornecedores(stmt);
                                                int atualizarFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                        + "\n1 - CNPJ do fornecedor"
                                                        + "\n2 - Nome do fornecedor"
                                                        + "\n3 - Endereço do fornecedor"
                                                        + "\n4 - Telefone do fornecedor"
                                                        + "\n0 - Sair"));
                                                // Opções do que atualizar em fornecedor
                                                while (atualizarFornecedor != 0) {
                                                    switch (atualizarFornecedor) {
                                                        case 1:
                                                            fornecedor.atualizarCNPJFornecedor(stmt);
                                                            break;
                                                        case 2:
                                                            fornecedor.atualizarNomeFornecedor(stmt);
                                                            break;
                                                        case 3:
                                                            fornecedor.atualizarEnderecoFornecedor(stmt);
                                                            break;
                                                        case 4:
                                                            fornecedor.atualizarTelefoneFornecedor(stmt);
                                                            break;
                                                        default:
                                                            JOptionPane.showMessageDialog(null, "Opção inválida");
                                                    }
                                                    atualizarFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                            + "\n1 - CNPJ do fornecedor"
                                                            + "\n2 - Nome do fornecedor"
                                                            + "\n3 - Endereço do fornecedor"
                                                            + "\n4 - Telefone do fornecedor"
                                                            + "\n0 - Sair"));
                                                }
                                                //Voltar ao menu de opções do que fazer em fornecedor
                                                opcaoFornecedor = 0;
                                                break;
                                            case 3:
                                                // Selecionar tabela fornecedor
                                                int selecionarFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                        + "\n1 - Dados de um fornecedor específico"
                                                        + "\n2 - Dados de todos os fornecedores"
                                                        + "\n0 - Sair"));
                                                // Opções do que selecionar em funcionário
                                                while (selecionarFornecedor != 0) {
                                                    switch (selecionarFornecedor) {
                                                        case 1:
                                                            fornecedor.selecionarDadosUmFornecedor(stmt);
                                                            break;
                                                        case 2:
                                                            fornecedor.selecionarDadosTodosFornecedores(stmt);
                                                            break;
                                                        default:
                                                            JOptionPane.showMessageDialog(null, "Opção inválida");
                                                    }
                                                    selecionarFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                            + "\n1 - Dados de um fornecedor específico"
                                                            + "\n2 - Dados de todos os fornecedores"
                                                            + "\n0 - Sair"));
                                                }
                                                //Voltar ao menu de opções do que fazer em fornecedor
                                                opcaoFornecedor = 0;

                                        }
                                        opcaoFornecedor = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                + "\n1- Inserir dados na tabela fornecedor"
                                                + "\n2 - Atualizar dados na tabela fornecedor"
                                                + "\n3 - Selecionar dados na tabela fornecedor"
                                                + "\n0 - Sair"));
                                    }
                                opcao=0;    
                                }  else {
                                    if (opcao==4) {
                                        // Acessando a tabela produto
                                        int opcaoProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                + "\n1- Inserir dados na tabela produto"
                                                + "\n2 - Atualizar dados na tabela produto"
                                                + "\n3 - Selecionar dados na tabela produto"
                                                + "\n0 - Sair"));
                                        while (opcaoProduto != 0) {
                                            switch (opcaoProduto) {
                                                case 1:
                                                    // Inserir dados em produto
                                                    produto.inserirDadosProduto(stmt);
                                                    break;
                                                case 2:
                                                    // Atualizar dados em produto
                                                    produto.selecionarDadosTodosProdutos(stmt);                                                
                                                    int atualizarProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                            + "\n1 - Nome do produto"
                                                            + "\n2 - Preço do produto"
                                                            + "\n0 - Sair"));
                                                    // Opções do que atualizar em produto
                                                    while (atualizarProduto != 0) {
                                                        switch (atualizarProduto) {
                                                            case 1:
                                                                produto.atualizarNomeProduto(stmt);
                                                                break;
                                                            case 2:
                                                                produto.atualizarPrecoProduto(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        atualizarProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                + "\n1 - Nome do produto"
                                                                + "\n2 - Preço do produto"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em produto
                                                    opcaoProduto = 0;
                                                    break;
                                                case 3:
                                                    // Selecionar tabela produto
                                                    int selecionarProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                            + "\n1 - Dados de um produto específico"
                                                            + "\n2 - Dados de todos os produtos"
                                                            + "\n0 - Sair"));
                                                    // Opções do que selecionar em produto
                                                    while (selecionarProduto != 0) {
                                                        switch (selecionarProduto) {
                                                            case 1:
                                                                produto.selecionarDadosUmProduto(stmt);
                                                                break;
                                                            case 2:
                                                                produto.selecionarDadosTodosProdutos(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        selecionarProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                + "\n1 - Dados de um produto específico"
                                                                + "\n2 - Dados de todos os produtos"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em produto
                                                    opcaoProduto = 0;

                                            }
                                            opcaoProduto = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                    + "\n1- Inserir dados na tabela produto"
                                                    + "\n2 - Atualizar dados na tabela produto"
                                                    + "\n3 - Selecionar dados na tabela produto"
                                                    + "\n0 - Sair"));
                                        }
                                    opcao=0;    
                                }  else {
                                        if (opcao==5) {
                                        // Acessando a tabela produção
                                        produto.selecionarDadosTodosProdutos(stmt);
                                        int opcaoProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                + "\n1- Inserir dados na tabela produção"
                                                + "\n2 - Atualizar dados na tabela produção"
                                                + "\n3 - Selecionar dados na tabela produção"
                                                + "\n0 - Sair"));
                                        while (opcaoProducao != 0) {
                                            switch (opcaoProducao) {
                                                case 1:
                                                    // Inserir dados em produção
                                                    produção.inserirDadosProducao(stmt);
                                                    break;
                                                case 2:
                                                    // Atualizar dados em produção
                                                    produção.selecionarTodasProducoes(stmt);                                             
                                                    int atualizarProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                            + "\n1 - Data da produção"
                                                            + "\n0 - Sair"));
                                                    // Opções do que atualizar em produção
                                                    while (atualizarProducao != 0) {
                                                        switch (atualizarProducao) {
                                                            case 1:
                                                                produção.atualizarDataProducao(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        atualizarProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                + "\n1 - Data da produção"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em produção
                                                    opcaoProducao = 0;
                                                    break;
                                                case 3:
                                                    // Selecionar tabela produção
                                                    int selecionarProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                            + "\n1 - Produções em uma data específica"
                                                            + "\n2 - Produções em um mês específico"
                                                            + "\n3 - Produções em um ano específico"
                                                            + "\n4 - Todas as produções"
                                                            + "\n0 - Sair"));
                                                    // Opções do que selecionar em produção
                                                    while (selecionarProducao != 0) {
                                                        switch (selecionarProducao) {
                                                            case 1:
                                                                produção.selecionarDataProducao(stmt);
                                                                break;
                                                            case 2:
                                                                produção.selecionarMesProducao(stmt);
                                                                break;
                                                            case 3:
                                                                produção.selecionarAnoProducao(stmt);
                                                            case 4:
                                                                produção.selecionarTodasProducoes(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        selecionarProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                + "\n1 - Produções em uma data específica"
                                                                + "\n2 - Produções em um mês específico"
                                                                + "\n3 - Produções em um ano específico"
                                                                + "\n4 - Todas as produções"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em produção
                                                    opcaoProducao = 0;

                                            }
                                            opcaoProducao = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                    + "\n1- Inserir dados na tabela produção"
                                                    + "\n2 - Atualizar dados na tabela produção"
                                                    + "\n3 - Selecionar dados na tabela produção"
                                                    + "\n0 - Sair"));
                                        }
                                    opcao=0;    
                                }  else {
                                            if (opcao==6) {
                                        // Acessando a tabela pedido
                                        cliente.selecionarDadosTodosClientes(stmt);
                                        produto.selecionarDadosTodosProdutos(stmt);
                                        int opcaoPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                + "\n1- Inserir dados na tabela pedido"
                                                + "\n2 - Atualizar dados na tabela pedido"
                                                + "\n3 - Selecionar dados na tabela pedido"
                                                + "\n0 - Sair"));
                                        while (opcaoPedido != 0) {
                                            switch (opcaoPedido) {
                                                case 1:
                                                    // Inserir dados em pedido
                                                    pedido.inserirDadosPedido(stmt);
                                                    break;
                                                case 2:
                                                    // Atualizar dados em pedido
                                                    pedido.selecionarDadosTodosPedidos(stmt);
                                                    int atualizarPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                            + "\n1 - Status do pedido"
                                                            + "\n2 - CPF do cliente"
                                                            + "\n0 - Sair"));
                                                    // Opções do que atualizar em pedido
                                                    while (atualizarPedido!= 0) {
                                                        switch (atualizarPedido) {
                                                            case 1:
                                                                pedido.atualizarStatusPedido(stmt);
                                                                break;
                                                            case 2:
                                                                cliente.selecionarDadosTodosClientes(stmt);
                                                                pedido.atualizarCodigoClientePedido(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        atualizarPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                + "\n1 - Status do pedido"
                                                                + "\n2 - CPF do cliente"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em pedido
                                                    opcaoPedido = 0;
                                                    break;
                                                case 3:
                                                    // Selecionar tabela pedido
                                                    int selecionarPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                            + "\n1 - Dados do(s) pedido(s) feito(s) por um cliente específico"
                                                            + "\n2 - Dados de todos os pedidos feitos em uma data"
                                                            + "\n3 - Dados de todos os pedidos feitos em um mês"
                                                            + "\n4 - Dados de todos os pedidos feitos em um ano"
                                                            + "\n5 - Dados de todos os pedidos"
                                                            + "\n0 - Sair"));
                                                    // Opções do que selecionar em pedido
                                                    while (selecionarPedido != 0) {
                                                        switch (selecionarPedido) {
                                                            case 1:
                                                                pedido.selecionarDadosUmPedido(stmt);
                                                                break;
                                                            case 2:
                                                                pedido.selecionarDadosDataTodosPedidos(stmt);
                                                                break;
                                                            case 3:
                                                                pedido.selecionarDadosMesTodosPedidos(stmt);
                                                                break;
                                                            case 4:
                                                                pedido.selecionarDadosAnoTodosPedidos(stmt);
                                                                break;
                                                            case 5:
                                                                pedido.selecionarDadosTodosPedidos(stmt);
                                                                break;
                                                            default:
                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                        }
                                                        selecionarPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                + "\n1 - Dados do(s) pedido(s) feito(s) por um cliente específico"
                                                                + "\n2 - Dados de todos os pedidos feitos em uma data"
                                                                + "\n3 - Dados de todos os pedidos feitos em um mês"
                                                                + "\n4 - Dados de todos os pedidos feitos em um ano"
                                                                + "\n5 - Dados de todos os pedidos"
                                                                + "\n0 - Sair"));
                                                    }
                                                    //Voltar ao menu de opções do que fazer em pedido
                                                    opcaoPedido= 0;

                                            }
                                            opcaoPedido = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                    + "\n1- Inserir dados na tabela pedido"
                                                    + "\n2 - Atualizar dados na tabela pedido"
                                                    + "\n3 - Selecionar dados na tabela pedido"
                                                    + "\n0 - Sair"));
                                        }
                                    opcao=0;    
                                }  else {
                                                if (opcao==7) {
                                                    // Acessando a tabela financeiro
                                                    int opcaoFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                            + "\n1- Inserir dados na tabela financeiro (inicial)"
                                                            + "\n2 - Atualizar dados na tabela financeiro (inicial)"
                                                            + "\n3 - Selecionar dados na tabela financeiro"
                                                            + "\n0 - Sair"));
                                                    while (opcaoFinanceiro != 0) {
                                                        switch (opcaoFinanceiro) {
                                                            case 1:
                                                                // Inserir dados em financeiro
                                                                financeiro.inserirDadosFinanceiro(stmt);
                                                                break;
                                                            case 2:
                                                                // Atualizar dados em financeiro
                                                                financeiro.selecionarDadosTodosFinanceiroaAtualizar(stmt);
                                                                int atualizarFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                        + "\n1 - Data de um financeiro"
                                                                        + "\n2 - Entrada no financeiro"
                                                                        + "\n3 - Saída no financeiro"
                                                                        + "\n0 - Sair"));;
                                                                // Opções do que atualizar em financeiro
                                                                while (atualizarFinanceiro!= 0) {
                                                                    switch (atualizarFinanceiro) {
                                                                        case 1:
                                                                            financeiro.atualizarDataFinanceiro(stmt);
                                                                            break;
                                                                        case 2:
                                                                            financeiro.atualizarEntradaFinanceiro(stmt);
                                                                            break;
                                                                        case 3:
                                                                            financeiro.atualizarSaidaFinanceiro(stmt);
                                                                            break;
                                                                        default:
                                                                            JOptionPane.showMessageDialog(null, "Opção inválida");
                                                                    }
                                                                    atualizarFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                            + "\n1 - Data de um financeiro"
                                                                            + "\n2 - Entrada no financeiro"
                                                                            + "\n3 - Saída no financeiro"
                                                                            + "\n0 - Sair"));;
                                                                }
                                                                //Voltar ao menu de opções do que fazer em financeiro
                                                                opcaoFinanceiro = 0;
                                                                break;
                                                            case 3:
                                                                // Selecionar tabela financeiro
                                                                int selecionarFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                        + "\n1 - Financeiro de um dia específico"
                                                                        + "\n2 - Financeiro de um mês específico"
                                                                        + "\n3 - Financeiro de um ano específico"
                                                                        + "\n4 - Todas as entradas e saídas"
                                                                        + "\n0 - Sair"));
                                                                // Opções do que selecionar em financeiro
                                                                while (selecionarFinanceiro != 0) {
                                                                    switch (selecionarFinanceiro) {
                                                                        case 1:
                                                                            financeiro.selecionarDadosUmFinanceiro(stmt);
                                                                            break;
                                                                        case 2:
                                                                            financeiro.selecionarDadosMêsFinanceiro(stmt);
                                                                            break;
                                                                        case 3:
                                                                            financeiro.selecionarDadosAnoFinanceiro(stmt);
                                                                            break;
                                                                        case 4:
                                                                            financeiro.selecionarDadosTodosFinanceiro(stmt);
                                                                            break;
                                                                        default:
                                                                            JOptionPane.showMessageDialog(null, "Opção inválida");
                                                                    }
                                                                    selecionarFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                            + "\n1 - Financeiro de um dia específico"
                                                                            + "\n2 - Financeiro de um mês específico"
                                                                            + "\n3 - Financeiro de um ano específico"
                                                                            + "\n4 - Todas as entradas e saídas"
                                                                            + "\n0 - Sair"));
                                                                }
                                                                //Voltar ao menu de opções do que fazer em financeiro
                                                                opcaoFinanceiro= 0;

                                                        }
                                                        opcaoFinanceiro = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                                + "\n1- Inserir dados na tabela financeiro (inicial)"
                                                                + "\n2 - Atualizar dados na tabela financeiro (inicial)"
                                                                + "\n3 - Selecionar dados na tabela financeiro"
                                                                + "\n0 - Sair"));
                                                    }
                                                opcao=0;    
                                                }  else {
                                                    if (opcao==8) {
                                                        // Acessando a tabela estoque
                                                        produto.selecionarDadosTodosProdutos(stmt);
                                                        int opcaoEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                                + "\n1- Inserir dados inciais na tabela estoque"
                                                                + "\n2- Atualizar dados iniciais na tabela estoque"
                                                                + "\n3- Selecionar dados na tabela estoque"
                                                                + "\n0 - Sair"));
                                                        while (opcaoEstoque != 0) {
                                                            switch (opcaoEstoque) {
                                                                case 1: 
                                                                    // Inserir dados tabela estoque
                                                                    estoque.inserirDadosIniciaisEstoque(stmt);
                                                                    break;
                                                                case 2:
                                                                    // Selecionar tabela estoque
                                                                    estoque.selecionarDadosEstoqueTodosProdutos(stmt);
                                                                    int atualizarEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja atualizar?\n"
                                                                            + "\n1 - Quantidade de produto"
                                                                            + "\n2 - Código do produto"
                                                                            + "\n0 - Sair"));
                                                                    // Opções do que atualizar em estoque
                                                                    while (atualizarEstoque != 0) {
                                                                        switch (atualizarEstoque) {
                                                                            case 1:
                                                                                estoque.atualizarQtdeEstoqueInicial(stmt);
                                                                                break;
                                                                            case 2:
                                                                                estoque.atualizarCodigoProdutoEstoqueInicial(stmt);
                                                                                break;
                                                                            default:
                                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                                        }
                                                                        atualizarEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                                + "\n1 - Quantidade de produto"
                                                                                + "\n2 - Código do produto"
                                                                                + "\n0 - Sair"));
                                                                    }
                                                                    break;    
                                                                case 3:
                                                                    // Selecionar tabela estoque
                                                                    int selecionarEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                            + "\n1 - Estoque de um produto específico"
                                                                            + "\n0 - Sair"));
                                                                    // Opções do que selecionar em estoque
                                                                    while (selecionarEstoque != 0) {
                                                                        switch (selecionarEstoque) {
                                                                            case 1:
                                                                                estoque.selecionarDadosEstoqueUmProduto(stmt);
                                                                                break;
                                                                            default:
                                                                                JOptionPane.showMessageDialog(null, "Opção inválida");
                                                                        }
                                                                        selecionarEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja selecionar?\n"
                                                                                + "\n1 - Estoque de um produto específico"
                                                                                + "\n0 - Sair"));
                                                                    }
                                                                    break;
                                                                default:
                                                                    JOptionPane.showMessageDialog(null, "Opção inválida");
                                                                     // Voltar ao menu de opções do que fazer em estoque
                                                                    opcaoEstoque= 0;

                                                            }
                                                            opcaoEstoque = Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer?\n"
                                                                    + "\n1- Inserir dados inciais na tabela estoque"
                                                                    + "\n2- Atualizar dados iniciais na tabela estoque"
                                                                    + "\n3- Selecionar dados na tabela estoque"
                                                                    + "\n0 - Sair"));
                                                        }
                                                    opcao=0;    
                                                }  else {
                                                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                                                    }
                                                }
                                            }
                                        }

                                    }

                            }
                        }

                    }

                opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual tabela você deseja acessar?\n"
                        + "\n1 - Cliente"
                        + "\n2 - Funcionário"
                        + "\n3 - Fornecedor"
                        + "\n4 - Produto"
                        + "\n5 - Produção"
                        + "\n6 - Pedido"
                        + "\n7 - Financeiro"
                        + "\n8 - Estoque"
                        + "\n0 - Sair"));
                }


            }
        }
    }
}


        
