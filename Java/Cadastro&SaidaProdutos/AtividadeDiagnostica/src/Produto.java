public class Produto {
    private String nome;
    private String unidadeMedida;
    private double precoUnidade;
    private int saldoAtual;
    private int totalEntradas;
    private int totalSaidas;
    private double faturamentoPorProduto;


    public void registrarEntrada(int quantidade){
        if (quantidade > 0) {
            saldoAtual += quantidade;
            totalEntradas += quantidade;
        }
        else{
            System.out.println("Entrada Inválida!");
        }
    }


    public void registrarSaida(int quantidade){
        if (quantidade > 0 && quantidade <= this.saldoAtual) {
            this.saldoAtual -= quantidade;
            this.totalSaidas += quantidade;
            double valorVenda = quantidade * this.precoUnidade;
            this.faturamentoPorProduto += valorVenda;
            System.out.println("Saída registrada! Valor: R$ " + valorVenda);
        }
        else{
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }


    public void setNome(String nome){
        this.nome = nome;
    }


    public void setUnidadeMedida(String unidade){
        this.unidadeMedida = unidade;
    }


    public void setPrecoUnidade(double precoUnidade) {
        this.precoUnidade = precoUnidade;
    }


    public void setSaldoAtual(int saldoAtual) {
        this.saldoAtual = saldoAtual;
    }


    public void setTotalEntradas(int totalEntradas) {
        this.totalEntradas = totalEntradas;
    }


    public void setTotalSaidas(int totalSaidas) {
        this.totalSaidas = totalSaidas;
    }


    public void setFaturamentoPorProduto(double faturamentoPorProduto) {
        this.faturamentoPorProduto = faturamentoPorProduto;
    }


    // Getters
    public String getNome() {
        return nome;
    }


    public String getUnidadeMedida() {
        return unidadeMedida;
    }


    public double getPrecoUnidade() {
        return precoUnidade;
    }


    public int getSaldoAtual() {
        return saldoAtual;
    }


    public int getTotalEntradas() {
        return totalEntradas;
    }


    public int getTotalSaidas() {
        return totalSaidas;
    }


    public double getFaturamentoPorProduto() {
        return faturamentoPorProduto;
    }
}
