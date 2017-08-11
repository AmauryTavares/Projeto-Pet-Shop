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

import pet_shop.DAO.IRepositorios.IRepositorioConsulta;
import pet_shop.negocio.beans.Consulta;

public class ConsultaDAO extends RepositorioAbstrato<Consulta> implements IRepositorioConsulta, Serializable {

	private static final long serialVersionUID = -7506014228033153273L;
	private static ConsultaDAO instance;
	private static long proximoID;
	
	private ConsultaDAO() {
		super();		
	}
	
	public static ConsultaDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}
	
	@Override
	public void cadastrar(Consulta c) {
		if(!this.list.contains(c)) {
			if (this.list.size() > 0) {
				proximoID = this.list.get(this.list.size() - 1).getId() + 1;
			} else {
				proximoID = 1;
			}
			c.setId(proximoID);
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
			if (this.list.get(i).getAnimal().getDono().getNome().contains(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return Collections.unmodifiableList(lista);
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
		return i - 1;
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
		return Collections.unmodifiableList(lista);	
	}
	
	@Override
	public boolean existe(Consulta c) {
		if (this.list.contains(c)) {
			return true;
		}
		return false;
	}

	private static ConsultaDAO lerArquivo() {
		ConsultaDAO repositorioLocal = null;
		
		File in = new File("arquivos/repositorio_consulta.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (ConsultaDAO) o;
		} catch (Exception e) {
			repositorioLocal = new ConsultaDAO();
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
		
		File out = new File("arquivos/repositorio_consulta.dat");
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
