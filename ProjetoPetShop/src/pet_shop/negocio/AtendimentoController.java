package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.AtendimentoDAO;
import pet_shop.negocio.beans.Atendimento;

public class AtendimentoController {
	
	private AtendimentoDAO atendimentoRepository;
	private static AtendimentoController instance;
	
	//Singleton
	private AtendimentoController() {
		this.atendimentoRepository = AtendimentoDAO.getInstance();
	}
	
	public static AtendimentoController getInstance() {
		if(instance == null) {
			instance = new AtendimentoController();
		}
		return instance;
	}
	
	public void saveAtendimento(Atendimento atendimento) {
		
		if( (atendimento != null) && (!this.atendimentoRepository.existe(atendimento)) && (atendimento.getAnimal() != null) 
				&& (atendimento.getData() != null) && (atendimento.getFuncionario() != null) 
				&& (atendimento.getObservacao() != null) ) {
			
			this.atendimentoRepository.cadastrarAtendimento(atendimento);
		}
		
	}
	
	public void updateAtendimento(Atendimento atendimento, long id) {
		
		if(atendimento != null) {
			Atendimento a = this.atendimentoRepository.listarAtendimento(id);
			
			if( (a != null) && (atendimento.getAnimal() != null)  && (atendimento.getData() != null) 
					&& (atendimento.getFuncionario() != null) && (atendimento.getObservacao() != null) ) {
				
				this.atendimentoRepository.alterarAtendimento(atendimento, id);
			}
		}
		
	}
	
	public void deleteAtendimento(long id) {
		
		if(id >= 0 && this.atendimentoRepository.existe(id)) {
			this.atendimentoRepository.excluirAtendimento(id);
		}
		
	}
	
	public Atendimento findAtendimento(long id) {
		
		if(id >= 0 && this.atendimentoRepository.existe(id)) {
			return this.atendimentoRepository.listarAtendimento(id);
		} else {
			return null;
		}
		
	}
	
	public ArrayList<Atendimento> listarTodosAtendimentos() {
		return this.atendimentoRepository.listarTudo();
	}

}
