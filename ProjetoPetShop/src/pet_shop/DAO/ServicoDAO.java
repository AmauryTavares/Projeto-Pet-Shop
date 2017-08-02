package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioServico;
import pet_shop.negocio.beans.Servico;

public class ServicoDAO implements IRepositorioServico {
	
	private ArrayList<Servico> repositorioServico;
	private static ServicoDAO instance;
	private static long proximoID = 0;
	
	private ServicoDAO() {
		this.repositorioServico = new ArrayList<>();
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = new ServicoDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Servico s) {
		ServicoDAO.proximoID = this.repositorioServico.size() + 1;
		s.setId(proximoID);
		this.repositorioServico.add(s);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioServico.size()) {
			this.repositorioServico.remove(indice);
		}
	}

	@Override
	public Servico procurar(long id) {
		Servico busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioServico.size()) {
			busca = this.repositorioServico.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Servico newServico, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioServico.size()) {
			this.repositorioServico.remove(indice);
			this.repositorioServico.add(indice, newServico);
		}
	}

	@Override
	public ArrayList<Servico> listarTudo() {
		return (ArrayList<Servico>) Collections.unmodifiableList(this.repositorioServico);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioServico.size())) {
			
			if(this.repositorioServico.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Servico s) {
		return this.repositorioServico.contains(s);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioServico.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}