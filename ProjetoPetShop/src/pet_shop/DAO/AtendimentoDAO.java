package pet_shop.DAO;

import java.util.ArrayList;

import pet_shop.negocio.beans.Atendimento;

public class AtendimentoDAO {

	private ArrayList<Atendimento> repositorioAtendimento;
	private static AtendimentoDAO instance;
	
	private AtendimentoDAO() {
		this.repositorioAtendimento = new ArrayList<>();
	}
	
	public static AtendimentoDAO getInstance() {
		if (instance == null) {
			instance = new AtendimentoDAO();
		}
		return instance;
	}
	
	public void cadastrarAtendimento(Atendimento a) {
		this.repositorioAtendimento.add(a);
	}
	
	public void alterarAtendimento(Atendimento a, long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAtendimento.size() && achou == false; i++) {
			if (this.repositorioAtendimento.get(i).getId() == id) {
				this.repositorioAtendimento.get(i).setAnimal(a.getAnimal());
				this.repositorioAtendimento.get(i).setData(a.getData());
				this.repositorioAtendimento.get(i).setFuncionario(a.getFuncionario());
				this.repositorioAtendimento.get(i).setObservacao(a.getObservacao());
				this.repositorioAtendimento.get(i).setServico(a.getServico());
				achou = true;
			}
		}
	}
	
	public void excluirAtendimento(long id) {
		boolean achou = false;
		for (int i = 0; i < this.repositorioAtendimento.size() && achou == false; i++) {
			if (this.repositorioAtendimento.get(i).getId() == id) {
				this.repositorioAtendimento.remove(i);
				achou = true;
			}
		}
	}
	
	public Atendimento listarAtendimento(long id) {
		boolean achou = false;
		Atendimento busca = null;
		for (int i = 0; i < this.repositorioAtendimento.size() && achou == false; i++) {
			if (this.repositorioAtendimento.get(i).getId() == id) {
				busca = this.repositorioAtendimento.get(i);
				achou = true;
			}
		}
		return busca;
	}
	
	public ArrayList<Atendimento> listarTudo() {
		return this.repositorioAtendimento;
	}
	
	//método existe em overloading
	public boolean existe(Atendimento a) {
		boolean verificar = false;
		for (int i = 0; i < this.repositorioAtendimento.size() && verificar == false; i++) {
			if (a.equals(this.repositorioAtendimento.get(i))) {
				verificar = true;
			}
		}
		return verificar;
	}
	
	public boolean existe(long id) {
		
		boolean existe = false;
		int i = 0;
		
		while((!existe) && (i < this.repositorioAtendimento.size())) {
			
			if(id == this.repositorioAtendimento.get(i).getId()) {
				existe = true;
			} else {
				i++;
			}
			
		}
		
		return existe;
		
	}
}
