package pet_shop.DAO;

import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioConsulta;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Consulta;

public class ConsultaDAO extends RepositorioAbstrato<Consulta> implements IRepositorioConsulta {

	private static ConsultaDAO instance;
	private static long proximoID = 0;
	
	private ConsultaDAO() {
		super();
		proximoID = this.list.get(this.list.size() - 1).getId();
	}
	
	public static ConsultaDAO getInstance() {
		if (instance == null) {
			instance = new ConsultaDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Consulta c) {
		if(!this.list.contains(c)) {
			c.setId(proximoID++);
			this.list.add(c);
		}
	}
	
	@Override
	public Consulta procurar(long id) {
		Consulta busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		
		return busca;
	}
	
	@Override
	public List<Consulta> procurar(String nome) {
		List<Consulta> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getAnimal().getDono().getNome().equals(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return lista;
	}

	@Override
	public int procurarID(long id) { //procura pela reserva do conuslta
		boolean achou = false;
		int i;
		
		for (i = 0; i < this.list.size() && !achou; i++) {
			if (this.list.get(i).getId() == id) {
				achou = true;
			}	
		}
		return i;
	}

	@Override
	public List<Consulta> procurarIDReservada(long id) { //procura pela reserva do cliente
		boolean achou = false;
		List<Consulta> lista = new ArrayList<>();
		
		for (int i = 0; i < this.list.size() && !achou; i++) {
			if (this.list.get(i).getAnimal().getDono().getId() == id) {
				lista.add(this.list.get(i));
				achou = true;
			}	
		}	
		return lista;	
	}
	
	@Override
	public boolean existe(Consulta c) {
		if (this.list.contains(c)) {
			return true;
		}
		return false;
	}
}
