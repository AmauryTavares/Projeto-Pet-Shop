package pet_shop.negocio;

import pet_shop.DAO.FuncionarioDAO;
import pet_shop.negocio.beans.Funcionario;

import java.util.ArrayList;

public class FuncionarioController {
	private FuncionarioDAO repositorioFuncionarios;
	private static FuncionarioController instance;
	
	private FuncionarioController() {
        this.repositorioFuncionarios = FuncionarioDAO.getInstance(); 
    }
	
	public static FuncionarioController getInstance() {
		if(instance == null)
			instance = new FuncionarioController();
		
		return instance;
	}
	
	public void cadastrarFuncionario(Funcionario f) {
	    if (f == null) {
	      //Exceção
	    } else {
	      if (!this.existe(f)) {
	        this.repositorioFuncionarios.cadastrarFuncionario(f);
	      } 
	    }
	}
	
	public void descadastrarFuncionario(long id){
		Funcionario f = this.repositorioFuncionarios.listarFuncionario(id);
		if(f != null){
			this.repositorioFuncionarios.excluirFuncionario(id);
		}
	}
	
	public Funcionario listarFuncionario(long id){
		return this.repositorioFuncionarios.listarFuncionario(id);
	}
	
	public boolean existe(Funcionario f) {
	    return this.repositorioFuncionarios.existe(f);
	}
	
	public void excluirFuncionario(long id){
		this.repositorioFuncionarios.excluirFuncionario(id);
	}
	
	public ArrayList<Funcionario> listarTudoFuncionario(){
		return this.repositorioFuncionarios.listarTudo();
	}
	
	public void AlteraFuncionario(Funcionario novoFuncionario, long id) {
		Funcionario f = this.repositorioFuncionarios.listarFuncionario(id);
		if( (f != null) && (novoFuncionario.getNome() != null) && (novoFuncionario.getCpf()!=null)) {
			this.repositorioFuncionarios.alterarFuncionario(novoFuncionario, id);
		}
	}
}
