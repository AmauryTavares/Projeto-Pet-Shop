package br.ufrpe.social_network.gui;

import java.time.LocalDate;
import java.util.ArrayList;

import br.ufrpe.social_network.negocio.Fachada;
import br.ufrpe.social_network.negocio.beans.Person;
import br.ufrpe.social_network.negocio.beans.Post;

public class TextualUserInterface {
    
    public void showUserInterface() {
        
    	Fachada fachada = Fachada.getInstace();
    	
    	LocalDate data = LocalDate.of(1997, 7, 28);
    	Person p1 = new Person("Amaury Tavares", "Carpina", data);
    	data = LocalDate.of(1995, 1, 12);
    	Person p2 = new Person("Maria José", "Recife", data);
    	data = LocalDate.of(1988, 8, 15);
    	Person p3 = new Person("Pedro Lucas", "Olinda", data);
    	data = LocalDate.of(1999, 1, 26);
    	Person p4 = new Person("Antônio da Silva", "São Paulo", data);
    	
    	fachada.cadastrarPessoa(p1);
    	fachada.cadastrarPessoa(p2);
    	fachada.cadastrarPessoa(p3);
    	fachada.cadastrarPessoa(p4);
    	
    	listarPessoasCadastradas(fachada);
    	
    	fachada.excluirPessoa(p3);
    	
    	System.out.println("Após excluir uma pessoa: \n");
    	listarPessoasCadastradas(fachada);
    	
    	
    	p4.setName("Joaquim Severino");
    	fachada.alterarPessoa(p4);
    	
    	System.out.println("Após alterar o nome de uma pessoa (Exemplo: Pessoa de id 4): \n");
    	listarPessoasCadastradas(fachada);
    	
    	System.out.println("Busca de pessoa por id (Exemplo id = 2): \n\n" + fachada.procurarPessoa(2));
    	
    	for (int i = 1; i <= 15; i++) {   // Cria 15 posters
    		Post post;
    		if (i % 3 == 1) {
    			post = new Post("Texto " + i, p1);
    		} else if (i % 3 == 2) {
    			post = new Post("Texto " + i, p2);
    		} else {
    			post = new Post("Texto " + i, p4);
    		}	
    		fachada.cadastrarPost(post);
    	}
    	
    	int cont = 1;
    	
    	for (int j = 0; j < fachada.listarPessoas().length; j++) {
    		if (fachada.listarPessoas()[j] != null) {
    			for (int i = 1; i <= fachada.listarPosts().size(); i++) {   // cria comentários de uma única pessoa nos posts das outras pessoas
            		if(!(fachada.listarPessoas()[j].equals(fachada.listarPosts().get(i-1).getAuthor()))) {
            			Post comentario = new Post("Comentário " + cont++, fachada.listarPessoas()[j]);  // 1º comentário 
            			fachada.listarPosts().get(i-1).addComment(comentario);
            			comentario = new Post("Comentário " + cont++, fachada.listarPessoas()[j]);   // 2º comentário 
            			fachada.listarPosts().get(i-1).addComment(comentario);  
            		}
            	}
    		}
    	}
    	
    	System.out.println("\nPosts de cada pessoa:\n");
    	
    	for (int i = 0; i < fachada.listarPessoas().length; i++) { //Lista dos os posts de todas as pessoas
    		if (fachada.listarPessoas()[i] != null) {
    			System.out.println(fachada.listarPessoas()[i]);
    			for (int j = 0; j < fachada.listarPosts().size(); j++) {
        			if (fachada.listarPessoas()[i].equals(fachada.listarPosts().get(j).getAuthor())) {
        				System.out.println(fachada.listarPosts().get(j));
        			}
        		}
    		}	
    	} 	
    	
    	System.out.println("\nComentários de cada pessoa (DESAFIO):\n");
    	
    	for (int i = 0; i < fachada.listarPessoas().length; i++) {
    		if (fachada.listarPessoas()[i] != null) {
    			System.out.println(fachada.listarPessoas()[i]);
    			ArrayList<Post> comentarios = fachada.procurarComentarios(fachada.listarPessoas()[i]);
    			for (int j = 0; j < comentarios.size(); j++) {
    				System.out.println(comentarios.get(j));
    			}
    		}
    	}
    	
    }

	private void listarPessoasCadastradas(Fachada fachada) {
		for (Person pessoas : fachada.listarPessoas()) {
    		if (pessoas != null) {
    			System.out.println(pessoas);
    		}
		}
	}

}
