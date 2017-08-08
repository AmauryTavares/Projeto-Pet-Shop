package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioPessoa;
import pet_shop.negocio.beans.Consulta;
import pet_shop.negocio.beans.Pessoa;

public class PessoaDAO extends RepositorioAbstrato<Pessoa> implements IRepositorioPessoa {
	
	private static PessoaDAO instance;
	private static long proximoID = 0;
	
	private PessoaDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static PessoaDAO getInstance() {
		if (instance == null) {
			instance = new PessoaDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Pessoa p) {
		if(!this.list.contains(p)) {
			p.setId(proximoID++);
			this.list.add(p);
		}
	}
	
	@Override
	public Pessoa procurar(long id) {
		Pessoa busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		
		return busca;
	}

	@Override
	public List<Pessoa> procurar(String nome) {
		List<Pessoa> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNome().equals(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return lista;
	}
	
	@Override
	public int procurarID(long id) { //procura pela reserva do cliente
		boolean achou = false;
		int i;
		
		for (i = 0; i < this.list.size() && !achou; i++) {
			if (this.list.get(i).getId() == id) {
				achou = true;
			}	
		}
		return i;
	}
	
	@Override
	public boolean existe(Pessoa p) {
		if (this.list.contains(p)) {
			return true;
		}
		return false;
	}
	
}
