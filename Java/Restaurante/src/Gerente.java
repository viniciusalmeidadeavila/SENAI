public class Gerente extends Funcionario {
    private String senhaAcesso;

    public Gerente(String nome, String cpf, double salarioBase, String senhaAcesso) {
        super(nome, cpf, salarioBase);
        this.senhaAcesso = senhaAcesso;
    }

    @Override
    public double calcularPagamento() {
        return this.salarioBase + 1000.00; // Bônus fixo de cargo de confiança
    }

    public void fecharCaixa() {
        System.out.println("Gerente " + nome + " fechando o caixa do dia.");
    }
}