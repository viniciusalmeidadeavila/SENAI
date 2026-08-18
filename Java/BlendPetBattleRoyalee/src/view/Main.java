package view;

import controller.UsuarioController;
import database.Conexao;
import models.Usuario;

import java.util.Scanner;

class Main{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        UsuarioController controllerUsuario = new UsuarioController(conexao.conectar());

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
                    fazerLogin(controllerUsuario);
                    break;
                case 2:
                    cadastrarUsuario(controllerUsuario);
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

    public static void cadastrarUsuario(UsuarioController controllerCadastro) {
        System.out.println("=======================================");
        System.out.println("         CADASTRO DE USUÁRIO           ");
        System.out.println("=======================================");

        System.out.print("Digite o seu nome: ");
        String nome = scanner.next();

        System.out.println("Digite seu email: ");
        String email = scanner.next();

        System.out.print("Crie uma senha forte: ");
        String senha = scanner.next();
        controllerCadastro.cadastrarUsuario(nome, email, senha);
        System.out.println("\n[+] Usuario(a) " + nome + " cadastrado(a) com sucesso!");
        System.out.println("=======================================\n");
    }

    public static void fazerLogin(UsuarioController controllerLogin){
        System.out.println("\n--- TELA DE LOGIN ---");
        System.out.print("Digite seu email: ");
        String emailLogin = scanner.next();
        System.out.print("Digite sua senha: ");
        String senhaLogin = scanner.next();
        Usuario usuarioLogado = controllerLogin.fazerLogin(emailLogin, senhaLogin);
        if (usuarioLogado != null) {
            System.out.println("\n[+] Login realizado com sucesso!");
            System.out.println("Bem-vindo(a) à Arena, " + usuarioLogado.getNome() + "!");
            // Aqui você pode mudar o estado do jogo para o "Menu Principal" logado,
            // onde o usuario escolhe o pet, entra no torneio, etc.
        } else {
            System.out.println("\n[-] Erro: Email ou senha incorretos.");
        }
    }
}