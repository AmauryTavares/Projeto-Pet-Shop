package pet_shop.DAO.IRepositorios;

import java.io.IOException;
import java.util.List;

import pet_shop.negocio.beans.Venda;

public interface IRepositorioVenda {
	
	public abstract void cadastrar (Venda v);
	public abstract Venda procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Venda a);
	public abstract List<Venda> procurar(String nome);
	public abstract void salvarArquivo() throws IOException;

}
