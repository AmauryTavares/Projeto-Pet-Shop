package br.ufrpe.social_network.negocio;

import java.util.ArrayList;

import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class Fachada {
    
	private PersonController pessoas;
	private PostController posts;
	private static Fachada instance;
	
	private Fachada() {
		this.pessoas = PersonController.getInstance();
		this.posts = PostController.getInstance();
	}
	
	public static Fachada getInstace() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}
	
	public void cadastrarPessoa(Person p) {
		this.pessoas.savePerson(p);
	}
	
	public Person procurarPessoa(long id) {
		return this.pessoas.find(id);
	}
	
	public void excluirPessoa(Person p) {
		this.pessoas.delete(p);
	}
	
	public void alterarPessoa(Person p) {
		this.pessoas.update(p);
	}
	
	public Person[] listarPessoas() {
		return this.pessoas.listarPessoas();
	}
	
	public void cadastrarPost(Post p) {
		this.posts.cadastrar(p);
	}
	
	public void excluirPost(Post p) {
		this.posts.excluir(p);
	}
	
	public void alterarPost(Post p) {
		this.posts.alterar(p);
	}
	
	public Post procurarPost(long id) {
		return this.posts.procurar(id);
	}
	
	public ArrayList<Post> procurarPosts(Person p) {
		return this.posts.procurarPosts(p);
	}
	
	public ArrayList<Post> procurarComentarios(Person p) {
		return this.posts.comentarios(p);
	}
    
	public ArrayList<Post> listarPosts() {
		return this.posts.listarTudo();
	}
	
}
