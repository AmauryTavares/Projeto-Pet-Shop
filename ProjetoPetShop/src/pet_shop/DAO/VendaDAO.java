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

import pet_shop.DAO.IRepositorios.IRepositorioVenda;
import pet_shop.negocio.beans.Venda;

public class VendaDAO extends RepositorioAbstrato<Venda> implements IRepositorioVenda, Serializable {

	private static final long serialVersionUID = -7572397131810134937L;
	private static VendaDAO instance;
	private static long proximoID = 0;
	
	private VendaDAO() {
		super();
		if (this.list.size() > 0) {
			proximoID = this.list.get(this.list.size() - 1).getId();
		} else {
			proximoID = 1;
		}
	}
	
	public static VendaDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	@Override
	public void cadastrar(Venda v) {
		if (!this.list.contains(v)) {
			v.setId(proximoID++);
			this.list.add(v);
		}
	}
	
	@Override
	public Venda procurar(long id) {
		Venda busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Venda> procurar(String nome) {
		List<Venda> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getCliente().getNome().contains(nome)) {
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
		return i;
	}
	
	@Override
	public boolean existe(Venda v) {
		if (this.list.contains(v)) {
			return true;
		}
		return false;
	}

	@Override
	public void salvarArquivo() throws IOException {
		if (instance == null) {
			return;
		}
		
		File out = new File("repositorio_venda.dat");
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
	
	private static VendaDAO lerArquivo() {
		VendaDAO repositorioLocal = null;
		
		File in = new File("repositorio_venda.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (VendaDAO) o;
		} catch (Exception e) {
			repositorioLocal = new VendaDAO();
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
