public abstract class Funcionario {
    protected String nome;
    private String cpf;
    protected double salarioBase;
    private int matricula = 1;
    private static int contadorMatricula = 1;

    public Funcionario(String nome, String cpf, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.matricula = contadorMatricula++;
    }

    public abstract double calcularPagamento();

    public String getNome() {
        return nome;
    }

    public int getMatricula(){
        return this.matricula;
    }
}