package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Funcionario;

public interface IRepositorioFuncionario {
	
	public abstract void cadastrar (Funcionario f);
	public abstract void excluir (long id);
	public abstract Funcionario procurar (long id);
	public abstract void alterar (Funcionario newFuncionario, long id);
	public abstract ArrayList<Funcionario> listarTudo ();
	public abstract boolean existe (Funcionario f);
	public abstract boolean existe(long id);

}
