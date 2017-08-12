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

import pet_shop.DAO.IRepositorios.IRepositorioServico;
import pet_shop.negocio.beans.Servico;

public class ServicoDAO extends RepositorioAbstrato<Servico> implements IRepositorioServico, Serializable {
	
	private static final long serialVersionUID = -5248313831869228830L;
	private static ServicoDAO instance;
	private static long proximoID;
	
	private ServicoDAO() {
		super();
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	@Override
	public void cadastrar(Servico s) {
		if (!this.list.contains(s)) {
			if (this.list.size() > 0) {
				proximoID = this.list.get(this.list.size() - 1).getId() + 1;
			} else {
				proximoID = 1;
			}
			s.setId(proximoID);
			this.list.add(s);
		}
	}

	@Override
	public Servico procurar(long id) {
		Servico busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Servico> procurar(String nome) {
		List<Servico> lista = new ArrayList<>();

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
	public boolean existe(Servico s) {
		if (this.list.contains(s)) {
			return true;
		}
		return false;
	}

	private static ServicoDAO lerArquivo() {
		ServicoDAO repositorioLocal = null;
		
		File in = new File("arquivos/repositorio_servico.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (ServicoDAO) o;
		} catch (Exception e) {
			repositorioLocal = new ServicoDAO();
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
	
	@Override
	public void salvarArquivo() throws IOException {
		if (instance == null) {
			return;
		}
		
		File out = new File("arquivos/repositorio_servico.dat");
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
	
}