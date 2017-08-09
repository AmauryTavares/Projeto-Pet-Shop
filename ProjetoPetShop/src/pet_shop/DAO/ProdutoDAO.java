package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioProduto;
import pet_shop.negocio.beans.Produto;

public class ProdutoDAO extends RepositorioAbstrato<Produto> implements IRepositorioProduto {
	
	private static ProdutoDAO instance;
	private static long proximoID = 0;
	
	private ProdutoDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Produto p) {
		if (!this.list.contains(p)) {
			p.setId(proximoID++);
			this.list.add(p);
		}
	}

	@Override
	public Produto procurar(long id) {
		Produto busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Produto> procurar(String nome) {
		List<Produto> lista = new ArrayList<>();

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
	public boolean existe(Produto p) {
		if (this.list.contains(p)) {
			return true;
		}
		return false;
	}
	
}
