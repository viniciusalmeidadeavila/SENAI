import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    // "Banco de Dados" simulado com Arrays Paralelos
    static String[] nomes = new String[20];
    static String[] emails = new String[20];
    static String[] senhas = new String[20];
    static String[] niveis = new String[20];
    static int totalUsuarios = 0;

    // Histórico de Acessos
    static String[] historico = new String[100];
    static int totalHistorico = 0;

    // Áreas do Prédio
    static String[] areas = {"Recepção", "Escritório", "Servidores"};

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cadastro inicial do Administrador padrão para permitir o primeiro acesso
        cadastrarUsuario("Admin", "admin@empresa.com", "123", "ADM");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- BLEND - CONTROLE DE ACESSO ---");
            System.out.println("1 - Realizar Login / Acessar Áreas");
            System.out.println("2 - Menu Administrativo (Requer Login ADM)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: realizarLoginEAcesso(); break;
                    case 2: menuAdministrativo(); break;
                    case 0: System.out.println("Encerrando sistema..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
            }
        }
    }

    // --- FUNÇÕES DE NEGÓCIO ---
    public static void cadastrarUsuario(String nome, String email, String senha, String nivel) {
        if (totalUsuarios < 20) {
            nomes[totalUsuarios] = nome;
            emails[totalUsuarios] = email;
            // Codifica a senha usando o Base64 para não salvar em texto puro
            senhas[totalUsuarios] = Base64.getEncoder().encodeToString(senha.getBytes());
            niveis[totalUsuarios] = nivel.toUpperCase();
            totalUsuarios++;
        }
    }

    public static void registrarAcesso(String nome, String area, String resultado) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        if (totalHistorico < 100) {
            historico[totalHistorico] = "[" + dataHora + "] Usuário: " + nome + " | Área: " + area + " | Status: " + resultado;
            totalHistorico++;
        }
    }

    public static void realizarLoginEAcesso() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // A função retorna o índice ou -1
        int indiceUsuario = autenticarUsuario(email, senha);

        if (indiceUsuario != -1) {
            System.out.println("\nBem-vindo, " + nomes[indiceUsuario] + " (" + niveis[indiceUsuario] + ")");
            System.out.println("Escolha a área que deseja acessar:");
            for (int i = 0; i < areas.length; i++) System.out.println((i + 1) + " - " + areas[i]);

            try {
                int areaOperacao = Integer.parseInt(scanner.nextLine()) - 1;
                if (areaOperacao >= 0 && areaOperacao < areas.length) {
                    validarPermissao(indiceUsuario, areas[areaOperacao]);
                } else {
                    System.out.println("Área inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: Escolha de área inválida.");
            }
        } else {
            System.out.println("Login falhou! Credenciais incorretas.");
        }
    }

    public static int autenticarUsuario(String email, String senha) {
        // Esse base64 serve para transformar a senha digitada em uma string 'codificada'
        String senhaCriptografada = Base64.getEncoder().encodeToString(senha.getBytes());
        for (int i = 0; i < totalUsuarios; i++) {
            if (emails[i].equals(email) && senhas[i].equals(senhaCriptografada)) {
                return i; // Retorna a "linha" onde o usuário foi encontrado
            }
        }
        return -1; // Não encontrado
    }

    public static void validarPermissao(int indiceUsuario, String area) {
        String nivel = niveis[indiceUsuario];
        boolean autorizado = false;

        // Lógica de permissões por nível
        if (nivel.equals("ADM")) {
            autorizado = true;
        } else if (nivel.equals("FUNCIONARIO")) {
            if (area.equals("Recepção") || area.equals("Escritório")) autorizado = true;
        } else if (nivel.equals("VISITANTE")) {
            if (area.equals("Recepção")) autorizado = true;
        }

        if (autorizado) {
            System.out.println("ACESSO LIBERADO para " + area);
            registrarAcesso(nomes[indiceUsuario], area, "AUTORIZADO");
        } else {
            System.out.println("ACESSO NEGADO! Você não tem permissão para a área: " + area);
            registrarAcesso(nomes[indiceUsuario], area, "NEGADO");
        }
    }

    public static void menuAdministrativo() {
        System.out.println("\n--- VALIDAÇÃO DE ADMINISTRADOR ---");
        System.out.println("LOGIN PADRÃO ADM: email: admin@empresa.com, senha: 123");
        System.out.print("Email ADM: ");
        String email = scanner.nextLine();
        System.out.print("Senha ADM: ");
        String senha = scanner.nextLine();

        int indiceUsuario = autenticarUsuario(email, senha);
        int opcaoLoop = -1;
        if (indiceUsuario != -1 && niveis[indiceUsuario].equals("ADM")){
            System.out.println("O que você deseja fazer admin?");
            while(opcaoLoop != 0){
                System.out.println("1 - Cadastrar Usuário\n2 - Listar Usuários\n3 - Ver Histórico\n0 - Voltar");
                try {
                    int op = Integer.parseInt(scanner.nextLine());
                    if (op == 1) {
                        System.out.print("Nome: ");
                        String nomeCadastro = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailCadastro = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senhaCadastro = scanner.nextLine();
                        System.out.print("Nível (VISITANTE, FUNCIONARIO, ADM): ");
                        String nivel = scanner.nextLine();
                        cadastrarUsuario(nomeCadastro, emailCadastro, senhaCadastro, nivel);
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else if (op == 2) {
                        System.out.println("\n--- USUÁRIOS CADASTRADOS ---");
                        for (int i = 0; i < totalUsuarios; i++) {
                            System.out.println(nomes[i] + " | " + emails[i] + " | " + niveis[i]);
                        }
                    } else if (op == 3) {
                        System.out.println("\n--- HISTÓRICO COMPLETO ---");
                        for (int i = 0; i < totalHistorico; i++){
                            System.out.println(historico[i]);
                        }
                    }
                    else if (op == 0){
                        opcaoLoop = 0;
                    }
                } catch (Exception e) {
                    System.out.println("Erro na operação administrativa.");
                }
            }
        } else {
            System.out.println("Acesso negado! Apenas administradores podem acessar este menu.");
        }
    }
}