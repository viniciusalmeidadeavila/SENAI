package controllers;

import models.Livro;
import repository.LivroRepository;
import java.util.List;

public class LivroController {

    // Instancia o repository para poder acessar o banco
    private final LivroRepository repository;

    public LivroController() {
        this.repository = new LivroRepository();
    }

    // Acionado pela View para criar um novo livro
    public void cadastrarLivro(String titulo, String autor) {
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);

        // Manda o repository salvar no banco
        repository.adicionar(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    // Acionado pela View para listar os livros na tela
    public List<Livro> listarLivros() {
        return repository.buscarTodos();
    }

    // Acionado pela View para alterar um livro existente
    public void editarLivro(int id, String novoTitulo, String novoAutor) {
        Livro livroEditado = new Livro();
        livroEditado.setId(id);
        livroEditado.setTitulo(novoTitulo);
        livroEditado.setAutor(novoAutor);

        repository.atualizar(livroEditado);
        System.out.println("Livro atualizado com sucesso!");
    }

    // Acionado pela View para excluir um livro
    public void excluirLivro(int id) {
        repository.deletar(id);
        System.out.println("Livro excluído com sucesso!");
    }
}