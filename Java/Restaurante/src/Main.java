import java.util.Scanner;

class Main{
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Restaurante blendLunch = new Restaurante();
        int opcao = -1;
        System.out.println("Seja bem vindo(a) á BLEND LUNCH!");
        while(opcao != 0){
            System.out.println("O que você deseja fazer?");
            System.out.println("[1] - Realizar um Pedido");
            System.out.println("[2] - Realizar Cadastros");
            System.out.println("[0] - Sair");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:

                    break;
                case 2:
                    System.out.println("\n--- ÁREA DE CADASTROS ---");
                    System.out.println("[1] - Cadastrar Prato");
                    System.out.println("[2] - Cadastrar Bebida");
                    System.out.println("[3] - Cadastrar Funcionário");
                    int subOpcao = scanner.nextInt();
                    switch (subOpcao){
                        case 1:
                            scanner.nextLine();
                            System.out.print("Nome do Prato: ");
                            String nomePrato = scanner.next();
                            System.out.print("Preço de Venda: ");
                            double precoPrato = scanner.nextDouble();
                            System.out.print("Ingredientes: ");
                            String ingredientes = scanner.next();
                            Prato novoPrato = new Prato(nomePrato, precoPrato, ingredientes);
                            blendLunch.cadastrarProduto(novoPrato);
                            break;
                        case 2:
                            System.out.print("Nome da Bebida: ");
                            String nomeBebida = scanner.nextLine();
                            System.out.print("Preço de Venda: ");
                            double precoBebida = scanner.nextDouble();
                            System.out.println("Volume (ML) da Bebida: ");
                            int ML = scanner.nextInt();
                            Bebida novaBebida = new Bebida(nomeBebida, precoBebida, ML);
                            blendLunch.cadastrarProduto(novaBebida);
                            break;
                        case 3:
                            int opcaoFuncionario;
                            System.out.println("Que tipo de Funcionário você quer cadastrar?");
                            System.out.println("[1] - Garcom");
                            System.out.println("[2] - Cozinheiro");
                            System.out.println("[3] - Gerente");
                            opcaoFuncionario = scanner.nextInt();
                            switch (opcaoFuncionario){
                                case 1:
                                    System.out.print("Nome: ");
                                    String nomeG = scanner.nextLine();
                                    System.out.print("CPF: ");
                                    String cpfG = scanner.nextLine();
                                    System.out.print("Salário Base: ");
                                    double salarioGarcom = scanner.nextDouble();
                                    Garcom novoGarcom = new Garcom(nomeG, cpfG, salarioGarcom);
                                    blendLunch.cadastrarFuncionario(novoGarcom);
                                    break;
                                case 2:
                                    System.out.print("Nome: ");
                                    String nomeCozinheiro = scanner.nextLine();
                                    System.out.print("CPF: ");
                                    String cpfCozinheiro = scanner.nextLine();
                                    System.out.print("Salário Base: ");
                                    double salarioCozinheiro = scanner.nextDouble();
                                    Cozinheiro novoCozinheiro = new Cozinheiro(nomeCozinheiro, cpfCozinheiro, salarioCozinheiro);
                                    blendLunch.cadastrarFuncionario(novoCozinheiro);
                                    break;
                                case 3:
                                    break;
                            }
                            break;
                    }
                    break;
                case 0:
                    opcao = 0;
                    break;
            }
        }
    }
}