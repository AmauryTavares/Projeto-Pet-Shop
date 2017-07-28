package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.DAO.IRepositorios.IRepositorioVenda;
import pet_shop.negocio.beans.Venda;

public class VendaDAO implements IRepositorioVenda {
	
	private ArrayList<Venda> repositorioVenda;
	private static VendaDAO instance;
	
	private VendaDAO() {
		this.repositorioVenda = new ArrayList<>();
	}
	
	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = new VendaDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Venda v) {
		this.repositorioVenda.add(v);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioVenda.size()) {
			this.repositorioVenda.remove(indice);
		}
	}

	@Override
	public Venda procurar(long id) {
		Venda busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioVenda.size()) {
			busca = this.repositorioVenda.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Venda newVenda, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioVenda.size()) {
			this.repositorioVenda.remove(indice);
			this.repositorioVenda.add(indice, newVenda);
		}
	}

	@Override
	public ArrayList<Venda> listarTudo() {
		return this.repositorioVenda;
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioVenda.size())) {
			
			if(this.repositorioVenda.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Venda v) {
		return this.repositorioVenda.contains(v);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioVenda.size()) {
			existe = true;
		}
		
		return existe;
	}

}
