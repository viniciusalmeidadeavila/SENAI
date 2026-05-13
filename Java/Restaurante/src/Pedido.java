import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private Funcionario funcionario; // Associação: quem está atendendo
    private ArrayList<Produto> itens; // Lista de produtos pedidos
    private String status; // "Aberto", "Pronto", "Pago"

    public Pedido(int idPedido, Funcionario funcionario) {
        this.idPedido = idPedido;
        this.funcionario = funcionario;
        this.itens = new ArrayList<>(); // Inicializa a lista vazia
        this.status = "Aberto";
    }

    public void adicionarPedido(Produto produto){
        this.itens.add(produto);
        System.out.println("Pedido " + produto.getNome() + " adicionado ao pedido #" + idPedido);
    }

    public double calcularPrecoTotalPedido() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }
        return total;
    }

    public void imprimirComanda() {
        System.out.println("--- COMANDA PEDIDO #" + idPedido + " ---");
        System.out.println("Atendente: " + funcionario.getNome());
        for (Produto produto : itens) {
            System.out.println("- " + produto.getNome() + ": R$ " + produto.getPreco());
        }
        System.out.println("TOTAL: R$ " + calcularPrecoTotalPedido());
        System.out.println("---------------------------");
    }
}