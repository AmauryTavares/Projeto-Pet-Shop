package pet_shop.DAO;

import pet_shop.negocio.beans.Funcionario;

public class FuncionarioDAO extends RepositorioAbstrato<Funcionario>{

	private static FuncionarioDAO instance;
	
	private FuncionarioDAO() {
		super();
	}
	
	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
		}
		return instance;
	}
	
	public Funcionario listarFuncionario(long id) {
		boolean achou = false;
		Funcionario busca = null;
		for (int i = 0; i < this.elements.size() && achou == false; i++) {
			if (this.elements.get(i).getId() == id) {
				busca = this.elements.get(i);
				achou = true;
			}
		}
		return busca;
	}

}
