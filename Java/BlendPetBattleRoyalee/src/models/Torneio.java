package models;

import com.google.protobuf.Enum;

import java.util.Date;

public class Torneio {
    private String nome;
    private Enum status;
    private Date data_inicio;
    private int vencedor_torneio;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getVencedor_torneio() {
        return vencedor_torneio;
    }

    public void setVencedor_torneio(int vencedor_torneio) {
        this.vencedor_torneio = vencedor_torneio;
    }

}

enum status{
    inscricoes_abertas,
    em_andamento,
    finalizado
}