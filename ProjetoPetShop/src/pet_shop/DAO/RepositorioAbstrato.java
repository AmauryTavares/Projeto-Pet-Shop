package pet_shop.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RepositorioAbstrato<T> implements Serializable{

	private static final long serialVersionUID = 8438542004654857380L;
	protected List<T> list;
	
	public RepositorioAbstrato() {
		this.list = new ArrayList<>();
	}
	
	public void alterar(T t, int indice) {
		if (indice >= 0) {
			this.list.set(indice, t);
		}
	}
	
	public List<T>  listar() {
		return Collections.unmodifiableList(this.list);
	}
	
	public void excluir(T t) {
		if (this.list.contains(t)) {
			this.list.remove(t);
		}
	}
	
}
