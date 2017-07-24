package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RepositorioAbstrato<T> {
	
	protected List<T> elements;
	
	public RepositorioAbstrato() {
		this.elements = new ArrayList<>();
	}
	
	public void cadastrar (T obj) {
		if(!this.elements.contains(obj)) {
			this.elements.add(obj);
		}
	}
	
	public void excluir (T obj) {
		int i = this.elements.indexOf(obj);
		if(i != -1) {
			this.elements.remove(i);
		}
	}
	
	public List<T> listarTudo () {
		return Collections.unmodifiableList(this.elements);
	}
	
	public void alterar (T newObj) {
		int i = this.elements.indexOf(newObj);	
		if(i != -1) {
			this.elements.add(i, newObj);
		}
	}
	
	public boolean existe(T obj) {
		return this.elements.contains(obj);
	}

}
