package pet_shop.DAO;

import pet_shop.negocio.beans.Agenda;

public class AgendaDAO extends RepositorioAbstrato<Agenda>{

	private static AgendaDAO instance;
	
	private AgendaDAO() {
		super();
	}
	
	public static AgendaDAO getInstance() {
		if (instance == null) {
			instance = new AgendaDAO();
		}
		return instance;
	}
	
	public void excluirAgendaPorPosicao(int i) { 
		this.elements.remove(i);
	}
	
	public Agenda procurarAgenda(long id) {
		boolean achou = false;
		Agenda busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.elements.size())) {
			
			if(this.elements.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}
	
	public int procurarIDReservada(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.elements.size())) {
			
			if(this.elements.get(i).getAnimal().getDono().getId()== id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}
	
	public boolean existeReservada(long id) {
		
		boolean existe = false;
		int indice = procurarIDReservada(id);
		
		if(indice != this.elements.size()) {
			existe = true;
		}
		
		return existe;
	}
	

	
}
