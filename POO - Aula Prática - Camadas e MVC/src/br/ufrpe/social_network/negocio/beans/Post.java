package br.ufrpe.social_network.negocio.beans;

import java.util.ArrayList;

public class Post {
    
	private static long nextid = 1;
	
    private long id;
    private String texto;
    private Person author;
    private ArrayList<Post> comments;

    public Post(String texto, Person author) {
        this.id = nextid;
        nextid++;
        this.texto = texto;
        this.author = author;
        this.comments = new ArrayList<>();
    }
    
    public Post() {
        this(null, null);
    }
<<<<<<< HEAD
=======

    public long getId() {
        return this.id;
    }
    
    
    // TODO gerar todos os métodos get/set, exceto o setId
>>>>>>> refs/remotes/upstream/master
    
    public void addComment(Post comment) {
        if (comment != null) {
            this.comments.add(comment);
        }
    }
    
    public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public ArrayList<Post> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Post> comments) {
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public void removeComment(Long id) {
		boolean resultado = false;
		for (int i = 0; i < comments.size() && resultado == false; i++) {
			if (comments.get(i).getId() == id) {
				resultado = true;
				comments.remove(i);
				i--;
			}
		}
    }
    
    @Override
    public String toString() {
    	String text = "Nome: " + this.author.getName() + "\n\tTexto: " + this.texto;
    	
    	if (comments.size() != 0) {
    		text += "\n\n\tCometário(s): ";
    		for (int i = 0; i < comments.size(); i++) {
    			text +=  "\n\t" + this.comments.get(i);
			}
    	}
    	
    	text += "\n";
    	
        return text;
    }
}
