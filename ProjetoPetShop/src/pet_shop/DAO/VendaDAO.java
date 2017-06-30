package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Venda;

public class VendaDAO {

	private ArrayList<Venda> repositorioVendas;
	private static VendaDAO instance;
	
	private VendaDAO() {
		this.repositorioVendas = new ArrayList<>();
	}
	
	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = new VendaDAO();
		}
		return instance;
	}
	
	public void cadastrarVenda(Venda v) {
		this.repositorioVendas.add(v);
	}
	
	public void alterarVenda(Venda v) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioVendas.size() && achou == false; i++) {
			if (this.repositorioVendas.get(i).getId() == v.getId()) {
				this.repositorioVendas.set(i, v);
				achou = true;
			}
		}
	}
	
	public void excluirVenda(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioVendas.size() && achou == false; i++) {
			if (this.repositorioVendas.get(i).getId() == id) {
				this.repositorioVendas.get(i);
				achou = true;
			}
		}
	}	
	public boolean existe(Venda venda) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioVendas.size() && verificar ==false;i++) {
			if (venda.equals(this.repositorioVendas.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
	public boolean existe(long id) {
		
		boolean existe = false;
		int i = 0;
		
		while((!existe) && (i < this.repositorioVendas.size())) {
			
			if(id == this.repositorioVendas.get(i).getId()) {
				existe = true;
			} 
			else 
			{
				i++;
			}
			
		}
		
		return existe;
		
	}
	public Venda listarVenda(long id) {
		boolean achou = false;
		Venda busca = null;
		for (int i = 0; i < this.repositorioVendas.size() && achou == false; i++) {
			if (this.repositorioVendas.get(i).getId() == id) {
				busca = this.repositorioVendas.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Venda> listarTudo() {
		return this.repositorioVendas;
	}
}
