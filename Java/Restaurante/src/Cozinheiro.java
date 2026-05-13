public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }

    @Override
    public double calcularPagamento() {
        // Cozinheiro ganha o salário base + 20% de adicional noturno/insalubridade
        return this.salarioBase * 1.20;
    }

    public void prepararPrato(String prato) {
        System.out.println("O cozinheiro " + nome + " está preparando: " + prato);
    }
}