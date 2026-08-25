package models;
import java.time.LocalDate;

public class Venda {
    private int id;
    private int idCliente;
    private int idUsuario;
    private int idFormaPagamento;
    private LocalDate dataVenda;

    public Venda(int idCliente, int idUsuario, int idFormaPagamento){
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}