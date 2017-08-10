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

import pet_shop.DAO.IRepositorios.IRepositorioAtendimento;
import pet_shop.negocio.beans.Atendimento;

public class AtendimentoDAO extends RepositorioAbstrato<Atendimento> implements IRepositorioAtendimento, Serializable {

	private static final long serialVersionUID = 392420856491222323L;
	private static AtendimentoDAO instance;
	private static long proximoID = 0;
	
	private AtendimentoDAO() {
		super();
		if (this.list.size() > 0) {
			proximoID = this.list.get(this.list.size() - 1).getId();
		} else {
			proximoID = 1;
		}
	}
	
	public static AtendimentoDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Atendimento a) {
		if (!this.list.contains(a)) {
			a.setId(proximoID++);
			this.list.add(a);
		}
	}

	@Override
	public Atendimento procurar(long id) {
		Atendimento busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		return busca;
	}
	
	@Override
	public List<Atendimento> procurar(String nome) {
		List<Atendimento> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getAnimal().getDono().getNome().contains(nome)) {
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
	public boolean existe(Atendimento a) {
		if (this.list.contains(a)) {
			return true;
		}
		return false;
	}
	
	private static AtendimentoDAO lerArquivo() {
		AtendimentoDAO repositorioLocal = null;
		
		File in = new File("repositorio_atendimento.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (AtendimentoDAO) o;
		} catch (Exception e) {
			repositorioLocal = new AtendimentoDAO();
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
		
		File out = new File("repositorio_atendimento.dat");
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
