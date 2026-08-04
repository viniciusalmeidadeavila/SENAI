package view;

import models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    private static List<Usuario> bancoDeDadosFake = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int loop = -1;
        exibirTitulo();
        System.out.print("Aperte ENTER para continuar...");
        String enter = scanner.nextLine();
        while(loop != 0){
            menu();
            System.out.println("Escolha uma opção");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    break;
                case 0:
                    loop = 0;
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Cadastrar Usuario");
        System.out.println("3 - Escolher pet para batalha");
        System.out.println("0 - Sair");
    }

    public static void exibirTitulo() {
        System.out.println("===============================================================================");
        System.out.println("                                                                               ");
        System.out.println("  ██████╗ ██╗     ███████╗███╗   ██╗██████╗  ██████╗ ███████╗████████╗         ");
        System.out.println("  ██╔══██╗██║     ██╔════╝████╗  ██║██╔══██╗ ██╔══██╗██╔════╝╚══██╔══╝         ");
        System.out.println("  ██████╦╝██║     █████╗  ██╔██╗ ██║██║  ██║ ██████╔╝█████╗     ██║            ");
        System.out.println("  ██╔══██╗██║     ██╔══╝  ██║╚██╗██║██║  ██║ ██╔═══╝ ██╔══╝     ██║            ");
        System.out.println("  ██████╦╝███████╗███████╗██║ ╚████║██████╔╝ ██║     ███████╗   ██║            ");
        System.out.println("  ╚═════╝ ╚══════╝╚══════╝╚═╝  ╚═══╝╚═════╝  ╚═╝     ╚══════╝   ╚═╝            ");
        System.out.println("                                                                               ");
        System.out.println("                 B A T T L E   R O Y A L E   E D I T I O N                     ");
        System.out.println("                                                                               ");
        System.out.println("===============================================================================");
    }

    public static void cadastrarUsuario() {

        System.out.println("=======================================");
        System.out.println("         CADASTRO DE USUÁRIO           ");
        System.out.println("=======================================");

        System.out.print("Digite o seu nome: ");
        String nome = scanner.next();

        System.out.print("Crie uma senha forte: ");
        String senha = scanner.next();

        Usuario novoUsuario = new Usuario(nome, senha);

        bancoDeDadosFake.add(novoUsuario);

        System.out.println("\n[+] Usuario(a) " + novoUsuario.getNome() + " cadastrado(a) com sucesso!");
        System.out.println("Total de usuarios no sistema: " + bancoDeDadosFake.size());
        System.out.println("=======================================\n");
    }
}