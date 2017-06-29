package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Produto;

public class ProdutoDAO {

	private ArrayList<Produto> repositorioProduto;
	private static ProdutoDAO instance;
	
	private ProdutoDAO() {
		this.repositorioProduto = new ArrayList<>();
	}
	
	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	public void cadastrarProduto(Produto p) {
		this.repositorioProduto.add(p);
	}
	
	public void alterarProduto(Produto p) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioProduto.size() && achou == false; i++) {
			if (this.repositorioProduto.get(i).getId() == p.getId()) {
				this.repositorioProduto.set(i, p);
				achou = true;
			}
		}
	}
	
	public void excluirProduto(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioProduto.size() && achou == false; i++) {
			if (this.repositorioProduto.get(i).getId() == id) {
				this.repositorioProduto.remove(i);
				achou = true;
			}
		}
	}
	
	public Produto listarProduto(long id) {
		boolean achou = false;
		Produto busca = null;
		for (int i = 0; i < this.repositorioProduto.size() && achou == false; i++) {
			if (this.repositorioProduto.get(i).getId() == id) {
				busca = this.repositorioProduto.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Produto> listarTudo() {
		return this.repositorioProduto;
	}
	
	public boolean existe(Produto p) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioProduto.size() && verificar == false; i++) {
			if (p.equals(this.repositorioProduto.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
}
