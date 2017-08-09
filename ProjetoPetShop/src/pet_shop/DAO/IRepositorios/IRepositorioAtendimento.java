package pet_shop.DAO.IRepositorios;

import java.io.IOException;
import java.util.List;

import pet_shop.negocio.beans.Atendimento;

public interface IRepositorioAtendimento {
	
	public abstract void cadastrar (Atendimento a);
	public abstract Atendimento procurar (long id);
	public abstract int procurarID(long id);
	public abstract boolean existe(Atendimento a);
	public abstract List<Atendimento> procurar(String nome);
	public abstract void salvarArquivo() throws IOException;
	
}
