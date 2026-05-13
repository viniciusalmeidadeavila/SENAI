import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Produto> cardapio;
    private ArrayList<Funcionario> equipe;
    private ArrayList<Pedido> historicoPedidos;

    public Restaurante() {
        this.cardapio = new ArrayList<>();
        this.equipe = new ArrayList<>();
        this.historicoPedidos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto p) {
        cardapio.add(p);
        System.out.println("Produto cadastrado: " + p.getNome());
    }

    public void cadastrarFuncionario(Funcionario f) {
        equipe.add(f);
        System.out.println("Funcionário cadastrado: " + f.getNome() + " (Matrícula: " + f.getMatricula() + ")");
    }

    // Métodos de Busca
    public Produto buscarProdutoPorNome(String nome) {
        for (Produto p : cardapio) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }

    public ArrayList<Produto> getCardapio(){
        return this.cardapio;
    }
}