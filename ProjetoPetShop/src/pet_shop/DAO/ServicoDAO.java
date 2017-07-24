package pet_shop.DAO;

import pet_shop.negocio.beans.Servico;

public class ServicoDAO extends RepositorioAbstrato<Servico>{

	private static ServicoDAO instance;
	
	private ServicoDAO() {
		super();
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = new ServicoDAO();
		}
		return instance;
	}
	
	public Servico listarServico(long id) {
		boolean achou = false;
		Servico busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}