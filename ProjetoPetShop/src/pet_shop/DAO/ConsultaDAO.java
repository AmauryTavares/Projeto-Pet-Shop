package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioConsulta;
import pet_shop.negocio.beans.Consulta;

public class ConsultaDAO implements IRepositorioConsulta {
	
	private ArrayList<Consulta> repositorioConsulta;
	private static ConsultaDAO instance;
	private static long proximoID = 0;
	
	private ConsultaDAO() {
		this.repositorioConsulta = new ArrayList<>();
	}
	
	public static ConsultaDAO getInstance() {
		if (instance == null) {
			instance = new ConsultaDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Consulta c) {
		ConsultaDAO.proximoID = this.repositorioConsulta.size() + 1;
		c.setId(proximoID);
		this.repositorioConsulta.add(c);		
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioConsulta.size()) {
			this.repositorioConsulta.remove(indice);
		}
	}

	@Override
	public Consulta procurar(long id) {
		Consulta busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioConsulta.size()) {
			busca = this.repositorioConsulta.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Consulta newConsulta, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioConsulta.size()) {
			this.repositorioConsulta.remove(indice);
			this.repositorioConsulta.add(indice, newConsulta);
		}
	}

	@Override
	public ArrayList<Consulta> listarTudo() {
		return (ArrayList<Consulta>) Collections.unmodifiableList(this.repositorioConsulta);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioConsulta.size())) {
			
			if(this.repositorioConsulta.get(i).getId() == id) {
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
		
		while((!achou) && (i < this.repositorioConsulta.size())) {
			
			if(this.repositorioConsulta.get(i).getAnimal().getDono().getId()== id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}
	
	@Override
	public void excluirAgendaPorPosicao(int i) {
		this.repositorioConsulta.remove(i);
	}
	
	@Override
	public boolean existeReservada(long id) {
		
		boolean existe = false;
		int indice = procurarIDReservada(id);
		
		if(indice != this.repositorioConsulta.size()) {
			existe = true;
		}
		
		return existe;
	}

	@Override
	public boolean existe(Consulta c) {
		return this.repositorioConsulta.contains(c);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioConsulta.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
