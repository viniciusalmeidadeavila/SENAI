package models;

public class Pet {
    private String nome;
    private int nivel;
    private int experiencia;
    private Usuario usuario_id;
    private Raca raca_id;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Raca getRaca_id() {
        return raca_id;
    }

    public void setRaca_id(Raca raca_id) {
        this.raca_id = raca_id;
    }
}
