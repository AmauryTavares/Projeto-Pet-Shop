package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioServico;
import pet_shop.negocio.beans.Servico;

public class ServicoDAO extends RepositorioAbstrato<Servico> implements IRepositorioServico {
	
	private static ServicoDAO instance;
	private static long proximoID = 0;
	
	private ServicoDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = new ServicoDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Servico s) {
		if (!this.list.contains(s)) {
			s.setId(proximoID++);
			this.list.add(s);
		}
	}

	@Override
	public Servico procurar(long id) {
		Servico busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Servico> procurar(String nome) {
		List<Servico> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNome().equals(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return lista;
	}
	
	@Override
	public int procurarID(long id) { //procura pela reserva do atendimento
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
	public boolean existe(Servico s) {
		if (this.list.contains(s)) {
			return true;
		}
		return false;
	}
	
}