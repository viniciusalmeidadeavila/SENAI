package models;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Tarefa {
    private String id;
    private String titulo;
    private boolean concluida;
    private LocalDateTime dataCriacao;

    public Tarefa(String titulo) {
        this.id = UUID.randomUUID().toString().substring(0, 8); // ID curto e único
        this.titulo = titulo;
        this.concluida = false;
        this.dataCriacao = LocalDateTime.now();
    }

    // Construtor usado para recriar tarefas a partir do arquivo salvo (Persistência)
    public Tarefa(String id, String titulo, boolean concluida, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.concluida = concluida;
        this.dataCriacao = dataCriacao;
    }

    public String getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public boolean isConcluida() { return concluida; }
    public void marcarComoConcluida() { this.concluida = true; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }

    @Override
    public String toString() {
        String status = concluida ? "[X]" : "[ ]";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return String.format("%s ID: %s | %s (Criada em: %s)", status, id, titulo, dataCriacao.format(formatter));
    }
}