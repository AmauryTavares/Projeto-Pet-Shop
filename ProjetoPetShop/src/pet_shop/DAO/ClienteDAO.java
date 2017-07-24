package pet_shop.DAO;

import pet_shop.negocio.beans.Cliente;

public class ClienteDAO extends RepositorioAbstrato<Cliente>{

	private static ClienteDAO instance;
	
	private ClienteDAO() {
		super();
	}
	
	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
		
	public Cliente procurarCliente(long id) {
		boolean achou = false;
		Cliente busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}
