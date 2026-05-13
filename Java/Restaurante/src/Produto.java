public class Produto {
    private int id;
    private String nome;
    private double preco;
    private static int contadorID = 1;

    public Produto(String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = contadorID++;
    }

    public String getNome(){
        return this.nome;
    }

    public double getPreco(){
        return this.preco;
    }
}
