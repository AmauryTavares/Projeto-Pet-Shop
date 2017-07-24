package pet_shop.DAO;

import pet_shop.negocio.beans.Produto;

public class ProdutoDAO extends RepositorioAbstrato<Produto>{

	private static ProdutoDAO instance;
	
	private ProdutoDAO() {
		super();
	}
	
	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	public Produto listarProduto(long id) {
		boolean achou = false;
		Produto busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}
