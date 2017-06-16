package br.ufrpe.social_network.negocio;

import java.util.ArrayList;

import br.ufrpe.social_network.dao.PostDAO;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class PostController {
    
    private PostDAO postsRepository;
    private static PostController instance;
    
    private PostController() {
    	this.postsRepository = PostDAO.getInstance();
    }
    
    public static PostController getInstance() {
    	if (instance == null) {
    		instance = new PostController();
    	}
    	return instance;
    }
    
    public void cadastrar(Post p) {
    	if (p != null) {
    		this.postsRepository.cadastrar(p);
    	}
    }
    
    public void excluir(Post p) {
    	if (p != null) {
    		this.postsRepository.excluir(p.getId());
    	}
    }
    
    public void alterar(Post p) {
    	if (p != null) {
    		this.postsRepository.alterar(p);
    	}
    }
    
    public Post procurar(long id) {
    	return this.postsRepository.listar(id);
    }
    
    public ArrayList<Post> procurarPosts(Person p) {
    	ArrayList<Post> busca = null;
    	if (p != null) {
    		busca = this.postsRepository.listarTodosPorPerson(p);
    	}
    	return busca;
    }
    
    public ArrayList<Post> comentarios(Person p) {
    	ArrayList<Post> busca = null;
    	if (p != null) {
    		busca = this.postsRepository.listarComentarios(this.postsRepository.listarTudo(), p);
    	}
    	return busca;
    }
    
    public ArrayList<Post> listarTudo() {
    	return this.postsRepository.listarTudo();
    }
}
