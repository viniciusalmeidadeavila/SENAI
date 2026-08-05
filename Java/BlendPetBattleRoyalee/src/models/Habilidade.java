package models;

public class Habilidade {
    private String nome;
    private String descricao;
    private int dano_base;
    private int custo_energia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDano_base() {
        return dano_base;
    }

    public void setDano_base(int dano_base) {
        this.dano_base = dano_base;
    }

    public int getCusto_energia() {
        return custo_energia;
    }

    public void setCusto_energia(int custo_energia) {
        this.custo_energia = custo_energia;
    }

}
