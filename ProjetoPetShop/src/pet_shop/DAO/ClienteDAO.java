package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioCliente;
import pet_shop.negocio.beans.Cliente;

public class ClienteDAO extends RepositorioAbstrato<Cliente> implements IRepositorioCliente {
	
	private ArrayList<Cliente> repositorioCliente;
	private static ClienteDAO instance;
	private static long proximoID = 0;
	
	private ClienteDAO() {
		this.repositorioCliente = new ArrayList<>();
	}
	
	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}

	@Override
	public void cadastrar(Cliente c) {
		ClienteDAO.proximoID = this.repositorioCliente.size() + 1;
		c.setId(proximoID);
		this.repositorioCliente.add(c);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioCliente.size()) {
			this.repositorioCliente.remove(indice);
		}
	}

	@Override
	public Cliente procurar(long id) {
		Cliente busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioCliente.size()) {
			busca = this.repositorioCliente.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Cliente newCliente, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioCliente.size()) {
			this.repositorioCliente.remove(indice);
			this.repositorioCliente.add(indice, newCliente);
		}
	}

	@Override
	public ArrayList<Cliente> listarTudo() {
		return (ArrayList<Cliente>) Collections.unmodifiableList(this.repositorioCliente);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioCliente.size())) {
			
			if(this.repositorioCliente.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Cliente c) {
		return this.repositorioCliente.contains(c);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioCliente.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
