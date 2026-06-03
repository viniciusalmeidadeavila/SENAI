package Exercicio1.view;

import Exercicio1.controller.ClienteController;
import Exercicio1.models.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ClienteController controller = new ClienteController();
        int opcao = -1;
        while(opcao != 0){
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Todos os Clientes");
            System.out.println("3. Buscar Cliente por CPF");
            System.out.println("4. Atualizar Contato (E-mail/Telefone)");
            System.out.println("5. Remover Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrar Cliente ---");
                    Cliente novoCliente = new Cliente();

                    System.out.print("Nome: ");
                    novoCliente.setNome(entrada.next());

                    System.out.print("CPF: ");
                    novoCliente.setCpf(entrada.next());

                    System.out.print("E-mail: ");
                    novoCliente.setEmail(entrada.next());

                    System.out.print("Telefone: ");
                    novoCliente.setTelefone(entrada.next());

                    controller.cadastrar(novoCliente);
                    break;

                case 2:
                    System.out.println("\n--- Listar Clientes ---");
                    List<Cliente> lista = controller.listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado no banco.");
                    } else {
                        for (Cliente cliente : lista) {
                            System.out.println("----------------------------------------");
                            System.out.println("Nome: " + cliente.getNome());
                            System.out.println("CPF: " + cliente.getCpf());
                            System.out.println("E-mail: " + cliente.getEmail());
                            System.out.println("Telefone: " + cliente.getTelefone());
                            System.out.println("Data Cadastro: " + cliente.getData_cadastro());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Buscar por CPF ---");
                    System.out.print("Digite o CPF do cliente: ");
                    String cpfBusca = entrada.next();

                    Cliente clienteEncontrado = controller.buscarPorCpf(cpfBusca);
                    if (clienteEncontrado != null) {
                        System.out.println("\nCliente Encontrado:");
                        System.out.println("Nome: " + clienteEncontrado.getNome());
                        System.out.println("CPF: " + clienteEncontrado.getCpf());
                        System.out.println("E-mail: " + clienteEncontrado.getEmail());
                        System.out.println("Telefone: " + clienteEncontrado.getTelefone());
                    } else {
                        System.out.println("Cliente com o CPF informado não foi encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Atualizar Contato ---");
                    System.out.print("Digite o CPF do cliente que deseja atualizar: ");
                    String cpfAtualizar = entrada.nextLine();

                    if (controller.buscarPorCpf(cpfAtualizar) != null) {
                        System.out.print("Digite o NOVO E-mail: ");
                        String novoEmail = entrada.next();
                        System.out.print("Digite o NOVO Telefone: ");
                        String novoTelefone = entrada.next();

                        controller.atualizarContato(cpfAtualizar, novoEmail, novoTelefone);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Remover Cliente ---");
                    System.out.print("Digite o CPF do cliente que deseja remover: ");
                    String cpfRemover = entrada.next();

                    System.out.print("Tem certeza que deseja remover? (S/N): ");
                    String conf = entrada.next();
                    if (conf.equalsIgnoreCase("S")) {
                        controller.remover(cpfRemover);
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}