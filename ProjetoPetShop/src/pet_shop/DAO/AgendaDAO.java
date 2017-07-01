package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Agenda;

public class AgendaDAO {

	private ArrayList<Agenda> repositorioAgenda;
	private static AgendaDAO instance;
	
	private AgendaDAO() {
		this.repositorioAgenda = new ArrayList<>();
	}
	
	public static AgendaDAO getInstance() {
		if (instance == null) {
			instance = new AgendaDAO();
		}
		return instance;
	}
	
	public void cadastrarAgenda(Agenda a) {
		this.repositorioAgenda.add(a);
	}
	
	public void alterarAgenda(Agenda a, long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == id) {
				this.repositorioAgenda.get(i).setAnimal(a.getAnimal());
				this.repositorioAgenda.get(i).setDataMarcada(a.getDataMarcada());
				this.repositorioAgenda.get(i).setServicos(a.getServicos());
				achou = true;
			}
		}
	}
	
	public void excluirAgenda(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == id) {
				this.repositorioAgenda.remove(i);
				achou = true;
			}
		}
	}
	
	public void excluirAgendaPorPosicao(int i) { 
		this.repositorioAgenda.remove(i);
	}
	
	public Agenda listarAgenda(long id) {
		boolean achou = false;
		Agenda busca = null;
		for (int i = 0; i < this.repositorioAgenda.size() && achou == false; i++) {
			if (this.repositorioAgenda.get(i).getId() == id) {
				busca = this.repositorioAgenda.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Agenda> listarTudo() {
		return this.repositorioAgenda;
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioAgenda.size())) {
			
			if(this.repositorioAgenda.get(i).getId() == id) {
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
		
		while((!achou) && (i < this.repositorioAgenda.size())) {
			
			if(this.repositorioAgenda.get(i).getAnimal().getDono().getId() == id) {
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
		
		if(indice != repositorioAgenda.size()) {
			existe = true;
		}
		
		return existe;
	}
	
	public boolean existe(long id) {
		
		boolean existe = false;
		int indice = procurarID(id);
		
		if(indice != repositorioAgenda.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
