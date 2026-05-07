import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        double faturamentoGeral = 0;
        int quantidadeProdutos = 0;
        System.out.println("Quantos produtos deseja cadastrar?");
        quantidadeProdutos = scanner.nextInt();

        for (int i = 0; i < quantidadeProdutos; i++) {
            Produto produto = new Produto();
            System.out.println("\nCadastro do " + (i + 1) + "º produto:");
            System.out.print("Nome: ");
            produto.setNome(scanner.next());
            System.out.print("Unidade de medida (ex: kg, un): ");
            produto.setUnidadeMedida(scanner.next());
            System.out.print("Preço por unidade: ");
            produto.setPrecoUnidade(scanner.nextDouble());
            System.out.print("Quantidade inicial em estoque: ");
            produto.setSaldoAtual(scanner.nextInt());
            produtos.add(produto);
        }


        // --- MENU OPERACIONAL ---
        int opcao = -1;
        while (opcao != 0) {
            menu();
            opcao = scanner.nextInt();


            if (opcao >= 1 && opcao <= 4) {
                for (int i = 0; i < produtos.size(); i++) {
                    switch (opcao) {
                        case 1: // Entrada
                            Produto produtoDaLista = produtos.get(i);
                            System.out.println("Quantidade de entrada para " + produtos.get(i).getNome() + ":");
                            int entrada = scanner.nextInt();
                            produtoDaLista.registrarEntrada(entrada);
                            break;
                        case 2: // Saída
                            Produto produtoSaida = produtos.get(i);
                            System.out.println("Quantidade de saída para " + produtos.get(i).getNome() + ":");
                            int saida = scanner.nextInt();
                            produtoSaida.registrarSaida(saida);
                            break;
                        case 3: // Consulta específica
                            System.out.println("Produto: " + produtos.get(i).getNome() + " | Saldo: " + produtos.get(i).getSaldoAtual() + " " + produtos.get(i).getUnidadeMedida());
                            break;
                        case 4:
                            System.out.println("\n--- LISTAGEM ATUAL ---");
                            for (int j = 0; j < produtos.size(); j++) {
                                System.out.println(produtos.get(j).getNome() + ": " + produtos.get(j).getSaldoAtual() + " " + produtos.get(j).getUnidadeMedida());
                            }
                            break;
                    }
                }
            }
        }

        // --- RELATÓRIO FINAL ---
        System.out.println("\n========== RELATÓRIO FINAL ==========");
        int maiorVolumeSaida = -1;
        int indiceMaiorSaida = 0;


        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("------------------------------------");
            System.out.println("Produto: " + produtos.get(i).getNome());
            System.out.println("Saldo Final: " + produtos.get(i).getSaldoAtual() + " " + produtos.get(i).getUnidadeMedida());
            System.out.println("Valor Total em Saídas: R$ " + produtos.get(i).getFaturamentoPorProduto());


            // Lógica para identificar o maior volume de saída
            if (produtos.get(i).getTotalSaidas() > maiorVolumeSaida) {
                maiorVolumeSaida = produtos.get(i).getTotalSaidas();
                indiceMaiorSaida = i;
            }
        }


        System.out.println("------------------------------------");
        System.out.println("FATURAMENTO GERAL DA COOPERATIVA: R$ " + faturamentoGeral);
        if (quantidadeProdutos > 0) {
            System.out.println("PRODUTO COM MAIOR VOLUME DE SAÍDA: " + produtos.get(indiceMaiorSaida).getNome() + " (" + maiorVolumeSaida + " unidades)");
        }
        System.out.println("=====================================");

    }

    public static void menu() {
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Registrar entrada");
        System.out.println("2 - Registrar saída");
        System.out.println("3 - Consultar saldo de um produto");
        System.out.println("4 - Listar todos os produtos");
        System.out.println("0 - Encerrar e gerar relatório");
    }
}