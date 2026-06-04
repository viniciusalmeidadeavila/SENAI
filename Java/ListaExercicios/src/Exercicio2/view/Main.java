package Exercicio2.view;

import Exercicio2.controller.CategoriaController;
import Exercicio2.controller.ProdutoController;
import Exercicio2.controller.Conexao;
import Exercicio2.models.Categoria;
import Exercicio2.models.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Conexao minhaConexao = new Conexao();

        CategoriaController categoriaController = new CategoriaController(minhaConexao);
        ProdutoController produtoController = new ProdutoController(minhaConexao);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========= MENU =========");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Listar Categorias");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastrar Nova Categoria ---");
                    System.out.print("Digite o nome da categoria: ");
                    String nomeCat = scanner.nextLine();

                    Categoria novaCategoria = new Categoria();
                    novaCategoria.setNome(nomeCat);

                    categoriaController.CadastrarCategoria(novaCategoria);
                    break;

                case 2:
                    System.out.println("\n--- Lista de Categorias ---");
                    List<Categoria> categorias = categoriaController.listarTodos();
                    if (categorias.isEmpty()) {
                        System.out.println("Nenhuma categoria cadastrada.");
                    } else {
                        for (Categoria c : categorias) {
                            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Cadastrar Novo Produto ---");

                    List<Categoria> catsDisponiveis = categoriaController.listarTodos();
                    if (catsDisponiveis.isEmpty()) {
                        System.out.println("[Erro] Você precisa cadastrar pelo menos uma categoria antes!");
                        break;
                    }

                    System.out.println("Categorias disponíveis:");
                    for (Categoria c : catsDisponiveis) {
                        System.out.println("ID: " + c.getId() + " - " + c.getNome());
                    }

                    System.out.print("Digite o ID da categoria do produto: ");
                    int idCatEscolhida = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer

                    Categoria catSelecionada = new Categoria();
                    catSelecionada.setId(idCatEscolhida);

                    // Passo 2: Coletar dados do produto
                    System.out.print("Digite o nome do produto: ");
                    String nomeProd = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double precoProd = scanner.nextDouble();

                    Produto novoProduto = new Produto();
                    novoProduto.setNome(nomeProd);
                    novoProduto.setPreco(precoProd);
                    novoProduto.setCategoria(catSelecionada);

                    produtoController.CadastrarProduto(novoProduto);
                    break;

                case 4:
                    System.out.println("\n--- Lista de Produtos ---");
                    List<Produto> produtos = produtoController.listarTodos();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println("Produto: " + p.getNome() +
                                    " | Preço: R$ " + p.getPreco() +
                                    " | Categoria: " + p.getCategoria().getNome());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}