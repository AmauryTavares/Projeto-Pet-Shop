package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Funcionario;

public class FuncionarioDAO {

	private ArrayList<Funcionario> repositorioFuncionario;
	private static FuncionarioDAO instance;
	
	private FuncionarioDAO() {
		this.repositorioFuncionario = new ArrayList<>();
	}
	
	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
		}
		return instance;
	}
	
	public void cadastrarFuncionario(Funcionario f) {
		this.repositorioFuncionario.add(f);
	}
	
	public void alterarFuncionario(Funcionario f) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioFuncionario.size() && achou == false; i++) {
			if (this.repositorioFuncionario.get(i).getId() == f.getId()) {
				this.repositorioFuncionario.set(i, f);
				achou = true;
			}
		}
	}
	
	public void excluirFuncionario(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioFuncionario.size() && achou == false; i++) {
			if (this.repositorioFuncionario.get(i).getId() == id) {
				this.repositorioFuncionario.remove(i);
				achou = true;
			}
		}
	}
	
	public Funcionario listarFuncionario(long id) {
		boolean achou = false;
		Funcionario busca = null;
		for (int i = 0; i < this.repositorioFuncionario.size() && achou == false; i++) {
			if (this.repositorioFuncionario.get(i).getId() == id) {
				busca = this.repositorioFuncionario.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Funcionario> listarTudo() {
		return this.repositorioFuncionario;
	}
	
	public boolean existe(Funcionario f) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioFuncionario.size() && verificar == false; i++) {
			if (f.equals(this.repositorioFuncionario.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
}
