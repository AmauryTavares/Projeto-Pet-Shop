package pet_shop.DAO;

import pet_shop.negocio.beans.Atendimento;

public class AtendimentoDAO extends RepositorioAbstrato<Atendimento>{

	private static AtendimentoDAO instance;
	
	private AtendimentoDAO() {
		super();
	}
	
	public static AtendimentoDAO getInstance() {
		if (instance == null) {
			instance = new AtendimentoDAO();
		}
		return instance;
	}
	
	public Atendimento listarAtendimento(long id) {
		boolean achou = false;
		Atendimento busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
}
