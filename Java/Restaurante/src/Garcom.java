public class Garcom extends Funcionario {
    private double taxaComissao = 0.10;
    public Garcom(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }

    @Override
    public double calcularPagamento() {
        return salarioBase + (salarioBase * taxaComissao);
    }
}