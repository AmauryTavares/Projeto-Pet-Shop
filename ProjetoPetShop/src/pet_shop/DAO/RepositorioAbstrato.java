package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioAbstrato<T> {
	
	protected List<T> elements = new ArrayList<>();
	
	public void cadastrar (T t) {
		this.elements.add(t);
	}
	
	public void excluir (T t) {
		this.elements.remove(t);
	}


}
