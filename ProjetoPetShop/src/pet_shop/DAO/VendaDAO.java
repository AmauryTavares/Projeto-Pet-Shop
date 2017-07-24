package pet_shop.DAO;

import pet_shop.negocio.beans.Venda;

public class VendaDAO extends RepositorioAbstrato<Venda>{

	private static VendaDAO instance;
	
	private VendaDAO() {
		super();
	}
	
	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = new VendaDAO();
		}
		return instance;
	}
	
	public Venda listarVenda(long id) {
		boolean achou = false;
		Venda busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}
