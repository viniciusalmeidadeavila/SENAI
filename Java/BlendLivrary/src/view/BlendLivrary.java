package views;

import controllers.LivroController;
import models.Livro;
import java.util.List;
import java.util.Scanner;

public class BlendLivrary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroController controller = new LivroController();
        int opcao = 0;

        System.out.println("Bem-vindo ao Sistema BlendLivrary!");

        while (opcao != 5) {
            System.out.println("\n=======================");
            System.out.println("         MENU          ");
            System.out.println("=======================");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Editar Livro");
            System.out.println("4. Excluir Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            // Tenta ler o número digitado
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o "Enter" da memória para não pular linhas depois
            } else {
                System.out.println("Erro: Por favor, digite um número válido.");
                scanner.nextLine(); // Limpa a sujeira
                continue; // Volta para o início do menu
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n-- NOVO CADASTRO --");
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Digite o tipo (FISICO ou DIGITAL): ");
                    String tipo = scanner.nextLine().toUpperCase(); // Força maiúsculas para bater com o banco

                    controller.cadastrarLivro(titulo, autor, tipo);
                    break;

                case 2:
                    System.out.println("\n-- LISTA DE LIVROS --");
                    List<Livro> livros = controller.listarLivros();

                    if (livros.isEmpty()) {
                        System.out.println("A biblioteca está vazia no momento.");
                    } else {
                        for (Livro l : livros) {
                            // Puxando os dados básicos de cada livro que veio do banco
                            System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo() + " | Autor: " + l.getAutor());
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n-- EDITAR LIVRO --");
                    System.out.print("Digite o ID do livro que deseja alterar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o Enter

                    System.out.print("Digite o novo título: ");
                    String novoTitulo = scanner.nextLine();

                    System.out.print("Digite o novo autor: ");
                    String novoAutor = scanner.nextLine();

                    controller.editarLivro(idEditar, novoTitulo, novoAutor);
                    break;

                case 4:
                    System.out.println("\n-- EXCLUIR LIVRO --");
                    System.out.print("Digite o ID do livro que deseja DELETAR: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // Limpa o Enter

                    controller.excluirLivro(idExcluir);
                    break;

                case 5:
                    System.out.println("\nSaindo do sistema... Até a próxima!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente escolhendo de 1 a 5.");
            }
        }

        scanner.close();
    }
}