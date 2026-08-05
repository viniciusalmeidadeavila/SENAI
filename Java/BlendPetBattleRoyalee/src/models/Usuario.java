package models;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int moedas;

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
}