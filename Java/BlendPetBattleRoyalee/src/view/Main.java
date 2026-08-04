package view;

import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = -1;
        exibirTitulo();
        System.out.println("Escolha uma opção");
        while(loop != 0){
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    menu();
                    break;
                case 2:
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
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|  ____  _     _____ _   _ ____    ____  _____ _____                        |");
        System.out.println("| | __ )| |   | ____| \\ | |  _ \\  |  _ \\| ____|_   _|                       |");
        System.out.println("| |  _ \\| |   |  _| |  \\| | | | | | |_) |  _|   | |                         |");
        System.out.println("| | |_) | |___| |___| |\\  | |_| | |  __/| |___  | |                         |");
        System.out.println("| |____/|_____|_____|_| \\_|____/  |_|   |_____| |_|                         |");
        System.out.println("|                                                                               |");
        System.out.println("|               B A T T L E   R O Y A L E   E D I T I O N                       |");
        System.out.println("+-------------------------------------------------------------------------------+");
    }
}