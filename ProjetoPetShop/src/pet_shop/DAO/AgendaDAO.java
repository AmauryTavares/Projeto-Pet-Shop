package pet_shop.DAO;

import java.util.ArrayList;
import pet_shop.DAO.IRepositorios.IRepositorioAgenda;
import pet_shop.negocio.beans.Agenda;

public class AgendaDAO implements IRepositorioAgenda {
	
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
	
	@Override
	public void cadastrar(Agenda a) {
		this.repositorioAgenda.add(a);		
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAgenda.size()) {
			this.repositorioAgenda.remove(indice);
		}
	}

	@Override
	public Agenda procurar(long id) {
		Agenda busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioAgenda.size()) {
			busca = this.repositorioAgenda.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Agenda newAgenda, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAgenda.size()) {
			this.repositorioAgenda.remove(indice);
			this.repositorioAgenda.add(indice, newAgenda);
		}
	}

	@Override
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
	
	@Override
	public int procurarIDReservada(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioAgenda.size())) {
			
			if(this.repositorioAgenda.get(i).getAnimal().getDono().getId()== id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}
	
	@Override
	public void excluirAgendaPorPosicao(int i) {
		this.repositorioAgenda.remove(i);
	}
	
	@Override
	public boolean existeReservada(long id) {
		
		boolean existe = false;
		int indice = procurarIDReservada(id);
		
		if(indice != this.repositorioAgenda.size()) {
			existe = true;
		}
		
		return existe;
	}

	@Override
	public boolean existe(Agenda a) {
		return this.repositorioAgenda.contains(a);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioAgenda.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
