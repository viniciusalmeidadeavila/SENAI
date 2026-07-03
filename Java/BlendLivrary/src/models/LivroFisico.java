package models;

public class LivroFisico extends Livro {
    private String localizacaoCorredor;

    public LivroFisico(int id, String titulo, String autor, String localizacaoCorredor) {
        super(id, titulo, autor);
        this.localizacaoCorredor = localizacaoCorredor;
    }

    @Override
    public String obterDetalhes() {
        return "[FÍSICO] " + getTitulo() + " - Autor: " + getAutor() + " (Corredor: " + localizacaoCorredor + ")";
    }

    public String getLocalizacaoCorredor(){
        return this.localizacaoCorredor;
    }

    public void setLocalizacaoCorredor(String localizacao){
        this.localizacaoCorredor = localizacao;
    }
}