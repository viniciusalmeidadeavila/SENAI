package models;

import java.time.LocalDateTime;

public class Batalha {
    private int id;
    private int petDesafianteId;
    private int petOponenteId;
    private Integer vencedorId;
    private String status;
    private Integer torneioId;
    private String fase;
    private LocalDateTime dataBatalha;

    public Batalha() {
    }

    public Batalha(int id, int petDesafianteId, int petOponenteId, Integer vencedorId, String status, Integer torneioId, String fase, LocalDateTime dataBatalha) {
        this.id = id;
        this.petDesafianteId = petDesafianteId;
        this.petOponenteId = petOponenteId;
        this.vencedorId = vencedorId;
        this.status = status;
        this.torneioId = torneioId;
        this.fase = fase;
        this.dataBatalha = dataBatalha;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetDesafianteId() {
        return petDesafianteId;
    }

    public void setPetDesafianteId(int petDesafianteId) {
        this.petDesafianteId = petDesafianteId;
    }

    public int getPetOponenteId() {
        return petOponenteId;
    }

    public void setPetOponenteId(int petOponenteId) {
        this.petOponenteId = petOponenteId;
    }

    public Integer getVencedorId() {
        return vencedorId;
    }

    public void setVencedorId(Integer vencedorId) {
        this.vencedorId = vencedorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTorneioId() {
        return torneioId;
    }

    public void setTorneioId(Integer torneioId) {
        this.torneioId = torneioId;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public LocalDateTime getDataBatalha() {
        return dataBatalha;
    }

    public void setDataBatalha(LocalDateTime dataBatalha) {
        this.dataBatalha = dataBatalha;
    }
}