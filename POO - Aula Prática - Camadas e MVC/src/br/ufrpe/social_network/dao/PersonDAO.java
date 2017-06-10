package br.ufrpe.social_network.dao;

import java.util.Arrays;

import br.ufrpe.social_network.negocio.beans.Person;

public class PersonDAO {
    
    private Person[] repositorioPerson;
    private static PersonDAO instance;
    private static int proximaPosicao = 0;
    
    private PersonDAO() {
    	repositorioPerson = new Person[100];
    }
    
    public static PersonDAO getInstance() {
    	if (instance == null) {
    		instance = new PersonDAO();
    	}
    	return instance;
    }
    
    public void cadastrar(Person p) {
    	if (p != null && proximaPosicao < repositorioPerson.length) {
    		repositorioPerson[proximaPosicao] = p;
    		proximaPosicao++;
    	} 
    }
    
    public void alterar(Person p) {
    	int idInt = (int)p.getId();
    	int posicao = procurar(idInt); // procurar a posição da pessoa no array
    	if (p != null && posicao != -1) {
    		repositorioPerson[posicao] = p;
    	}
    }
    
    public void excluir(long id) {
    	int idInt = (int) id;
    	int posicao = procurar(idInt);
    	if (posicao != -1) {
    		repositorioPerson[posicao] = repositorioPerson[proximaPosicao - 1];
    		Arrays.sort(repositorioPerson); // ******testar 
    		proximaPosicao--;
    	}
    }
    
    public Person listar(int id) {
    	Person busca = null;
    	boolean verificar = false;
    	
    	for (int i = 0; i < proximaPosicao && verificar == false; i++) {
			if (repositorioPerson[i].getId() == id) {
				busca = repositorioPerson[i];
				verificar = true;
			}
		}
    	return busca;
    }
    
    private int procurar(int id) {
    	for (int i = 0; i < proximaPosicao; i++) {
			if (id == repositorioPerson[i].getId()) {
				return i;
			}
		}
    	return -1;
    }
    
}
