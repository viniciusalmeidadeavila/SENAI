public class Prato extends Produto {
    private String ingredientes;
    public Prato(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }

    public String getIngredientes(){
        return this.ingredientes;
    }
}
