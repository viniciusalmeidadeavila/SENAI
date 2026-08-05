package models;

public class Item {
    private int id;
    private String nomeItem;
    private String descricao;
    private double preco;
    private double efeitoValor;

    public Item() {
    }

    public Item(int id, String nomeItem, String descricao, double preco, double efeitoValor) {
        this.id = id;
        this.nomeItem = nomeItem;
        this.descricao = descricao;
        this.preco = preco;
        this.efeitoValor = efeitoValor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEfeitoValor() {
        return efeitoValor;
    }

    public void setEfeitoValor(double efeitoValor) {
        this.efeitoValor = efeitoValor;
    }
}