package models;

public class LivroDigital extends Livro {
    private String formatoArquivo; // PDF, EPUB, etc.

    public LivroDigital(int id, String titulo, String autor, String formatoArquivo) {
        super(id, titulo, autor);
        this.formatoArquivo = formatoArquivo;
    }

    @Override
    public String obterDetalhes() {
        return "[DIGITAL] " + getTitulo() + " - Autor: " + getAutor() + " (Formato: " + formatoArquivo + ")";
    }
}