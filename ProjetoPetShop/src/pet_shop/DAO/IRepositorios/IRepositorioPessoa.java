package pet_shop.DAO.IRepositorios;

import java.io.IOException;
import java.util.List;

import pet_shop.negocio.beans.Pessoa;

public interface IRepositorioPessoa {
	
	public abstract void cadastrar (Pessoa c);
	public abstract Pessoa procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Pessoa a);
	public abstract List<Pessoa> procurar(String nome);
	public abstract void salvarArquivo() throws IOException;

}
