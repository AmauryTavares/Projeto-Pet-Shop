package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Cliente;

public class ClienteDAO {

	private ArrayList<Cliente> repositorioCliente;
	private static ClienteDAO instance;
	
	private ClienteDAO() {
		this.repositorioCliente = new ArrayList<>();
	}
	
	public static ClienteDAO getInstance() {
		if (instance == null) {
			instance = new ClienteDAO();
		}
		return instance;
	}
	
	public void cadastrarCliente(Cliente c) {
		this.repositorioCliente.add(c);
	}
	
	public void alterarCliente(Cliente c, long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioCliente.size() && achou == false; i++) {
			if (this.repositorioCliente.get(i).getId() == id) {
				this.repositorioCliente.get(i).setBairro(c.getBairro());
				this.repositorioCliente.get(i).setCpf(c.getCpf());
				this.repositorioCliente.get(i).setEmail(c.getEmail());	
				this.repositorioCliente.get(i).setNome(c.getNome());
				this.repositorioCliente.get(i).setNumCasa(c.getNumCasa());
				this.repositorioCliente.get(i).setRua(c.getRua());
				this.repositorioCliente.get(i).setTelefone(c.getTelefone());
				achou = true;
			}
		}
	}
	
	public void excluirCliente(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioCliente.size() && achou == false; i++) {
			if (this.repositorioCliente.get(i).getId() == id) {
				this.repositorioCliente.remove(i);
				achou = true;
			}
		}
	}
	
	public Cliente listarCliente(long id) {
		boolean achou = false;
		Cliente busca = null;
		for (int i = 0; i < this.repositorioCliente.size() && achou == false; i++) {
			if (this.repositorioCliente.get(i).getId() == id) {
				busca = this.repositorioCliente.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Cliente> listarTudo() {
		return this.repositorioCliente;
	}
	
	public boolean existe(Cliente c) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioCliente.size() && verificar == false; i++) {
			if (c.equals(this.repositorioCliente.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
}
