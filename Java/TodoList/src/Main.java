import models.Tarefa;
import repository.GerenciadorDeTarefas;

import java.util.List;
import java.util.Scanner;

class Main {
    private static GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rodando = true;

        System.out.println("=========================================");
        System.out.println(" Bem-vindo ao Gerenciador de Tarefas");
        System.out.println("=========================================");

        while (rodando) {
            exibirMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    adicionar();
                    break;
                case "2":
                    listar(gerenciador.listarTodas());
                    break;
                case "3":
                    filtrar();
                    break;
                case "4":
                    concluir();
                    break;
                case "5":
                    editar();
                    break;
                case "6":
                    remover();
                    break;
                case "0":
                    rodando = false;
                    System.out.println("Encerrando aplicação. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Adicionar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Filtrar tarefas por status");
        System.out.println("4. Marcar tarefa como concluída");
        System.out.println("5. Editar título de uma tarefa");
        System.out.println("6. Remover uma tarefa");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionar() {
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        if (!titulo.trim().isEmpty()) {
            gerenciador.adicionarTarefa(titulo);
            System.out.println("Tarefa adicionada com sucesso!");
        } else {
            System.out.println("O título não pode estar vazio.");
        }
    }

    private static void listar(List<Tarefa> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n--- SUAS TAREFAS ---");
            for (Tarefa t : lista) {
                System.out.println(t.toString());
            }
            System.out.println("--------------------");
        }
    }

    private static void filtrar() {
        System.out.println("1. Pendentes");
        System.out.println("2. Concluídas");
        System.out.print("Escolha o filtro: ");
        String filtro = scanner.nextLine();

        if (filtro.equals("1")) {
            listar(gerenciador.listarPorStatus(false));
        } else if (filtro.equals("2")) {
            listar(gerenciador.listarPorStatus(true));
        } else {
            System.out.println("Filtro inválido.");
        }
    }

    private static void concluir() {
        listar(gerenciador.listarTodas());
        System.out.print("Digite o ID da tarefa para concluir: ");
        String id = scanner.nextLine();
        if (gerenciador.marcarComoConcluida(id)) {
            System.out.println("Tarefa marcada como concluída!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    private static void editar() {
        listar(gerenciador.listarTodas());
        System.out.print("Digite o ID da tarefa que deseja editar: ");
        String id = scanner.nextLine();
        System.out.print("Digite o novo título: ");
        String novoTitulo = scanner.nextLine();

        if (gerenciador.editarTitulo(id, novoTitulo)) {
            System.out.println("Tarefa atualizada com sucesso!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    private static void remover() {
        listar(gerenciador.listarTodas());
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        String id = scanner.nextLine();
        if (gerenciador.removerTarefa(id)) {
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }
}