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

import pet_shop.DAO.IRepositorios.IRepositorioAnimal;
import pet_shop.negocio.beans.Animal;

public class AnimalDAO extends RepositorioAbstrato<Animal> implements IRepositorioAnimal, Serializable{

	private static final long serialVersionUID = 7330642223297731236L;
	private static AnimalDAO instance;
	private static long proximoID;
	
	private AnimalDAO() {
		super();
	}
	
	public static AnimalDAO getInstance() {
		if (instance == null) {
			instance = lerArquivo();
		}
		return instance;
	}

	@Override
	public void cadastrar(Animal a) {
		if(!this.list.contains(a)) {
			if (this.list.size() > 0) {
				proximoID = this.list.get(this.list.size() - 1).getId() + 1;
			} else {
				proximoID = 1;
			}
			a.setId(proximoID);
			this.list.add(a);
		}
	}
	
	@Override
	public Animal procurar(long id) {
		Animal busca = null;
		
		int indice = procurarID(id);
		if(indice != this.list.size()) {
			busca = this.list.get(indice);
		}
		
		return busca;
	}
	
	@Override
	public List<Animal> procurar(String nome) {
		List<Animal> lista = new ArrayList<>();

		for (int i = 0; i < this.list.size(); i++) {
			if (this.list.get(i).getNome().contains(nome)) {
				lista.add(this.list.get(i));
			}	
		}
		
		return Collections.unmodifiableList(lista);
	}

	@Override
	public int procurarID(long id) { //procura pela reserva do cliente
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
	public boolean existe(Animal a) {
		if (this.list.contains(a)) {
			return true;
		}
		return false;
	}
	
	private static AnimalDAO lerArquivo(){
		AnimalDAO repositorioLocal = null;
		
		File input = new File("arquivos/repositorio_animal.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(input);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			repositorioLocal = (AnimalDAO) o;
		} catch (Exception e) {
			repositorioLocal = new AnimalDAO();
		} finally {
			if (ois != null) {
				try{
					ois.close();
				} catch (IOException e) {// silencia a exceção
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
		
		File output = new File("arquivos/repositorio_animal.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (!output.exists()) {
			output.createNewFile();
		}

		try{
			fos = new FileOutputStream(output);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try{
					oos.close();
				} catch (IOException e) {// silencia a exceção
				}
			}
		}
	}
	
}
