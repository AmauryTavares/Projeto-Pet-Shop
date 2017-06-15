package br.ufrpe.social_network.dao;

import java.util.ArrayList;

import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class PostDAO {

	private ArrayList<Post> repositorioPost;
	private static PostDAO instance;

	private PostDAO() {
		this.repositorioPost = new ArrayList<>();
	}

	public static PostDAO getInstance() {
		if (instance == null) {
			instance = new PostDAO();
		}
		return instance;
	}

	public void cadastrar(Post p) {
		this.repositorioPost.add(p);
	}

	public void excluir(long id) {
		for (int i = 0; i < this.repositorioPost.size(); i++) {
			if (this.repositorioPost.get(i).getId() == id) {
				this.repositorioPost.remove(i);
			}
		}
	}
	
	public void alterar(Post p) {
		if (this.repositorioPost.contains(p)) {
			this.repositorioPost.remove(p);
		}
	}
	
	public Post listar(long id) {
		Post busca = null;
		for (int i = 0; i < this.repositorioPost.size(); i++) {
			if (this.repositorioPost.get(i).getId() == id) {
				busca = this.repositorioPost.get(i); 
			}
		}
		return busca;
	}
	
	public ArrayList<Post> listarTudo() {
		return this.repositorioPost;
	}

	public ArrayList<Post> listarTodosPorPerson(Person p) {
		ArrayList<Post> busca = new ArrayList<>();
		for (int i = 0; i < this.repositorioPost.size(); i++) {
			if (p.equals(this.repositorioPost.get(i).getAuthor())) {
				busca.add(this.repositorioPost.get(i));
			}
		}
		return busca;
	}
	
	public ArrayList<Post> listarComentarios(ArrayList<Post> comentarios, Person p) {
		ArrayList<Post> busca = new ArrayList<>();
		for (int i = 0; i < comentarios.size(); i++) {
			if (comentarios.get(i).getComments().size() > 0) {
				busca.addAll(listarComentarios(comentarios.get(i).getComments(), p));
			}
			if (p.equals(comentarios.get(i).getAuthor())) {
				busca.add(comentarios.get(i));
			}
		}
		return busca;
	}

}
