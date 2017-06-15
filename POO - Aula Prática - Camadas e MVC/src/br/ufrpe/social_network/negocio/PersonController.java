package br.ufrpe.social_network.negocio;

import br.ufrpe.social_network.dao.PersonDAO;
import br.ufrpe.social_network.negocio.beans.Person;

public class PersonController {
    
    private PersonDAO personsRepository;
    private static PersonController instance;
    
    private PersonController() {
    	this.personsRepository = PersonDAO.getInstance();
    }

    public static PersonController getInstance() {
        if (instance == null) {
            instance = new PersonController();
        }
        return instance;
    }
    
    public void savePerson(Person p) {
    	if (p != null && !(this.personsRepository.existe(p))) {
    		this.personsRepository.cadastrar(p);
    	}
    }
    
    public Person find(long personId) {
        return this.personsRepository.listar(personId);
    }
    
    public void update(Person newPerson) {
    	if (newPerson != null) {
    		this.personsRepository.alterar(newPerson);
    	}
    }
    
    public void delete(Person p) {
    	if (p != null) {
    		this.personsRepository.excluir(p.getId());
    	}
    }
}
