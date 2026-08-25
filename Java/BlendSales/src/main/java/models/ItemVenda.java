package models;

public class ItemVenda {
    private int id;
    private int idVenda;
    private int idProduto;
    private int quantidade;
    private double precoUnitario;

    public ItemVenda(int id, int idVenda, int idProduto, int quantidade, double precoUnitario) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getIdVenda() { return idVenda; }
    public int getIdProduto() { return idProduto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}