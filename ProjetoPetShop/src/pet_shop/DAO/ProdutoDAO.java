package pet_shop.DAO;

import java.util.ArrayList;
import java.util.Collections;

import pet_shop.DAO.IRepositorios.IRepositorioProduto;
import pet_shop.negocio.beans.Produto;

public class ProdutoDAO implements IRepositorioProduto {
	
	private ArrayList<Produto> repositorioProduto;
	private static ProdutoDAO instance;
	private static long proximoID = 0;
	
	private ProdutoDAO() {
		this.repositorioProduto = new ArrayList<>();
	}
	
	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Produto p) {
		ProdutoDAO.proximoID = this.repositorioProduto.size() + 1;
		p.setId(proximoID);
		this.repositorioProduto.add(p);
	}

	@Override
	public void excluir(long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioProduto.size()) {
			this.repositorioProduto.remove(indice);
		}
	}

	@Override
	public Produto procurar(long id) {
		Produto busca = null;
		
		int indice = procurarID(id);
		if(indice != this.repositorioProduto.size()) {
			busca = this.repositorioProduto.get(indice);
		}
		
		return busca;
	}

	@Override
	public void alterar(Produto newProduto, long id) {
		int indice = procurarID(id);
		if(indice != this.repositorioProduto.size()) {
			this.repositorioProduto.remove(indice);
			this.repositorioProduto.add(indice, newProduto);
		}
	}

	@Override
	public ArrayList<Produto> listarTudo() {
		return (ArrayList<Produto>) Collections.unmodifiableList(this.repositorioProduto);
	}
	
	public int procurarID(long id) { //procura pela reserva do cliente
		
		boolean achou = false;
		int i = 0;
		
		while((!achou) && (i < this.repositorioProduto.size())) {
			
			if(this.repositorioProduto.get(i).getId() == id) {
				achou = true;
			} else {
				i++;
			}
			
		}
		
		return i;
		
	}

	@Override
	public boolean existe(Produto p) {
		return this.repositorioProduto.contains(p);
	}

	@Override
	public boolean existe(long id) {
		boolean existe = false;
		int i = procurarID(id);
		
		if(i != this.repositorioProduto.size()) {
			existe = true;
		}
		
		return existe;
	}
	
}
