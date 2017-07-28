package pet_shop.DAO.IRepositorios;

import java.util.ArrayList;

import pet_shop.negocio.beans.Cliente;

public interface IRepositorioCliente {
	
	public abstract void cadastrar (Cliente c);
	public abstract void excluir (long id);
	public abstract Cliente procurar (long id);
	public abstract void alterar (Cliente newCliente, long id);
	public abstract ArrayList<Cliente> listarTudo ();
	public abstract boolean existe(Cliente c);
	public abstract boolean existe(long id);

}
