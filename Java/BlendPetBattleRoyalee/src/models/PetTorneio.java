package models;

public class PetTorneio {

    private int torneioId;
    private int petId;
    private Integer posicaoFinal;

    public PetTorneio() {
    }

    public PetTorneio(int torneioId, int petId, Integer posicaoFinal) {
        this.torneioId = torneioId;
        this.petId = petId;
        this.posicaoFinal = posicaoFinal;
    }

    // Getters e Setters
    public int getTorneioId() {
        return torneioId;
    }

    public void setTorneioId(int torneioId) {
        this.torneioId = torneioId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Integer getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(Integer posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }
}
