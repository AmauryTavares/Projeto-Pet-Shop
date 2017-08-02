package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioFuncionario;
import pet_shop.negocio.beans.Funcionario;

public class FuncionarioDAO implements IRepositorioFuncionario {
	
	private ArrayList<Funcionario> repositorioFuncionario;
	private static FuncionarioDAO instance;
	private static long proximoID = 0;
	
	private FuncionarioDAO() {
		this.repositorioFuncionario = new ArrayList<>();
	}
	
	public static FuncionarioDAO getInstance() {
		if (instance == null) {
			instance = new FuncionarioDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Funcionario f) {
		FuncionarioDAO.proximoID = this.repositorioFuncionario.size() + 1;
		f.setId(proximoID);
		this.repositorioFuncionario.add(f);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioFuncionario.size()) {
			this.repositorioFuncionario.remove(indice);
		}
	}

	@Override
	public Funcionario procurar(long id) {
		Funcionario busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioFuncionario.size()) {
			busca = this.repositorioFuncionario.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Funcionario newFuncionario, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioFuncionario.size()) {
			this.repositorioFuncionario.remove(indice);
			this.repositorioFuncionario.add(indice, newFuncionario);
		}
	}

	@Override
	public ArrayList<Funcionario> listarTudo() {
		return (ArrayList<Funcionario>) Collections.unmodifiableList(this.repositorioFuncionario);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioFuncionario.size())) {
			
			if(this.repositorioFuncionario.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Funcionario f) {
		return this.repositorioFuncionario.contains(f);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioFuncionario.size()) {
			existe = true;
		}
		
		return existe;
	}

}
