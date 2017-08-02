package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioAtendimento;
import pet_shop.negocio.beans.Atendimento;

public class AtendimentoDAO extends RepositorioAbstrato<Atendimento> implements IRepositorioAtendimento {
	
	private ArrayList<Atendimento> repositorioAtendimento;
	private static AtendimentoDAO instance;
	private static long proximoID = 0;
	
	private AtendimentoDAO() {
		this.repositorioAtendimento = new ArrayList<>();
	}
	
	public static AtendimentoDAO getInstance() {
		if (instance == null) {
			instance = new AtendimentoDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Atendimento a) {
		AtendimentoDAO.proximoID = this.repositorioAtendimento.size() + 1;
		a.setId(proximoID);
		this.repositorioAtendimento.add(a);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAtendimento.size()) {
			this.repositorioAtendimento.remove(indice);
		}
	}

	@Override
	public Atendimento procurar(long id) {
		Atendimento busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioAtendimento.size()) {
			busca = this.repositorioAtendimento.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Atendimento newAtendimento, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioAtendimento.size()) {
			this.repositorioAtendimento.remove(indice);
			this.repositorioAtendimento.add(indice, newAtendimento);
		}
	}

	@Override
	public ArrayList<Atendimento> listarTudo() {
		return (ArrayList<Atendimento>) Collections.unmodifiableList(this.repositorioAtendimento);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioAtendimento.size())) {
			
			if(this.repositorioAtendimento.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Atendimento a) {
		return this.repositorioAtendimento.contains(a);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioAtendimento.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
