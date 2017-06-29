package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Servico;

public class ServicoDAO {

	private ArrayList<Servico> repositorioServico;
	private static ServicoDAO instance;
	
	private ServicoDAO() {
		this.repositorioServico = new ArrayList<>();
	}
	
	public static ServicoDAO getInstance() {
		if (instance == null) {
			instance = new ServicoDAO();
		}
		return instance;
	}
	
	public void cadastrarServico(Servico s) {
		this.repositorioServico.add(s);
	}
	
	public void alterarServico(Servico s) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioServico.size() && achou == false; i++) {
			if (this.repositorioServico.get(i).getId() == s.getId()) {
				this.repositorioServico.set(i, s);
				achou = true;
			}
		}
	}
	
	public void excluirServico(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioServico.size() && achou == false; i++) {
			if (this.repositorioServico.get(i).getId() == id) {
				this.repositorioServico.remove(i);
				achou = true;
			}
		}
	}
	
	public Servico listarServico(long id) {
		boolean achou = false;
		Servico busca = null;
		for (int i = 0; i < this.repositorioServico.size() && achou == false; i++) {
			if (this.repositorioServico.get(i).getId() == id) {
				busca = this.repositorioServico.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Servico> listarTudo() {
		return this.repositorioServico;
	}
	
	public boolean existe(Servico s) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioServico.size() && verificar ==false;i++) {
			if (s.equals(this.repositorioServico.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
public boolean existe(long id) {
		
		boolean existe = false;
		int i = 0;
		
		while((!existe) && (i < this.repositorioServico.size())) {
			
			if(id == this.repositorioServico.get(i).getId()) {
				existe = true;
			} else {
				i++;
			}
			
		}
		
		return existe;
		
	}
}