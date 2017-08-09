package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioVenda;
import pet_shop.negocio.beans.Venda;

public class VendaDAO extends RepositorioAbstrato<Venda> implements IRepositorioVenda {
	
	private static VendaDAO instance;
	private static long proximoID = 0;
	
	private VendaDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = new VendaDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Venda v) {
		if (!this.list.contains(v)) {
			v.setId(proximoID++);
			this.list.add(v);
		}
	}
	
	@Override
	public Venda procurar(long id) {
		Venda busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Venda> procurar(String nome) {
		List<Venda> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getCliente().getNome().equals(nome)) {
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
	public boolean existe(Venda v) {
		if (this.list.contains(v)) {
			return true;
		}
		return false;
	}
}
