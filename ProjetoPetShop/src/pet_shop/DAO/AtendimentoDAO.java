package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioAtendimento;
import pet_shop.negocio.beans.Atendimento;

public class AtendimentoDAO extends RepositorioAbstrato<Atendimento> implements IRepositorioAtendimento {
	
	private static AtendimentoDAO instance;
	private static long proximoID = 0;
	
	private AtendimentoDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static AtendimentoDAO getInstance() {
		if (instance == null) {
			instance = new AtendimentoDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Atendimento a) {
		if (!this.list.contains(a)) {
			a.setId(proximoID++);
			this.list.add(a);
		}
	}

	@Override
	public Atendimento procurar(long id) {
		Atendimento busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Atendimento> procurar(String nome) {
		List<Atendimento> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getAnimal().getDono().getNome().equals(nome)) {
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
	public boolean existe(Atendimento a) {
		if (this.list.contains(a)) {
			return true;
		}
		return false;
	}
	
}
