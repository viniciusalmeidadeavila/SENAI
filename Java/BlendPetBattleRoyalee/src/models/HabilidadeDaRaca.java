package models;

// Esta classe representa a ligação entre a Raça e a Habilidade
public class HabilidadeDaRaca implements HabilidadesDaRaca {

    private int racaID;
    private int habilidadeID;
    private int nivelDesbloqueado;

    // Como esta classe representa a relação, AQUI faz sentido sobrescrever tudo!
    @Override
    public int getRacaID() {
        return this.racaID;
    }

    @Override
    public int getHabilidadeID() {
        return this.habilidadeID;
    }

    @Override
    public int getNivelDesbloqueado() {
        return this.nivelDesbloqueado;
    }
}