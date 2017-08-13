package pet_shop.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pet_shop.DAO.IRepositorios.IRepositorioProduto;
import pet_shop.negocio.beans.Produto;

public class ProdutoDAO extends RepositorioAbstrato<Produto> implements IRepositorioProduto, Serializable {
	
	private static final long serialVersionUID = -5258187152061595343L;
	private static ProdutoDAO instance;
	private static long proximoID;
	
	private ProdutoDAO() {
		super();
	}
	
	public static ProdutoDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Produto p) {
		if (!this.list.contains(p)) {
			if (this.list.size() > 0) {
				proximoID = this.list.get(this.list.size() - 1).getId() + 1;
			} else {
				proximoID = 1;
			}
			p.setId(proximoID);
			this.list.add(p);
		}
	}

	@Override
	public Produto procurar(long id) {
		Produto busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Produto> procurar(String nome) {
		List<Produto> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNome().contains(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return Collections.unmodifiableList(lista);
	}
	
	@Override
	public int procurarID(long id) { //procura pela reserva do atendimento
		boolean achou = false;
		int i;
		
		for (i = 0; i < this.list.size() && !achou; i++) {
			if (this.list.get(i).getId() == id) {
				achou = true;
			}	
		}
		return i - 1;
	}
	
	@Override
	public boolean existe(Produto p) {
		if (this.list.contains(p)) {
			return true;
		}
		return false;
	}

	@Override
	public void salvarArquivo() throws IOException {
		if (instance == null) {
			return;
		}
		
		File out = new File("src/pet_shop/arquivos/repositorio_produto.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (!out.exists()) {
			out.createNewFile();
		}
		
		try{
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try{
					oos.close();
				} catch (IOException e) {
					// Silencia a exceção
				}
			}
		}
	}
	
	private static ProdutoDAO lerArquivo() {
		ProdutoDAO repositorioLocal = null;
		
		File in = new File("src/pet_shop/arquivos/repositorio_produto.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (ProdutoDAO) o;
		} catch (Exception e) {
			repositorioLocal = new ProdutoDAO();
		} finally {
			if (ois != null) {
				try{
					ois.close();
				} catch (IOException e) {
					// Silencia a exceção
				}
			}
		}
		
		return repositorioLocal;
	}
	
}
