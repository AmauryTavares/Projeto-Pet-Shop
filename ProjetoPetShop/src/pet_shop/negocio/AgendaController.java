package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.AgendaDAO;
import pet_shop.negocio.beans.Agenda;

public class AgendaController {
	
	private AgendaDAO agendaRepository;
	private static AgendaController instance;
	
	//Singleton
	private AgendaController() {
		this.agendaRepository = AgendaDAO.getInstance();
	}
	
	public static AgendaController getInstance() {
		if(instance == null) {
			instance = new AgendaController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAgenda(Agenda agenda) {
		
		if( (agenda != null) && (!agendaRepository.existe(agenda.getId())) && (agenda.getAnimal() != null) 
				&& (agenda.getDataMarcada() != null) && (agenda.getServicos() != null) ) {
			
			this.agendaRepository.cadastrarAgenda(agenda);
		}
		
	}
	
	public Agenda findAgenda(long id) {
		if(id >= 0 && this.agendaRepository.existe(id)) {
			return this.agendaRepository.listarAgenda(id);
		} else {
			return null;
		}
	}
	
	public void updateAgenda(Agenda newAgenda) {
		
		if (newAgenda != null) {			
			Agenda a = this.agendaRepository.listarAgenda(newAgenda.getId());
			
			if( (a != null) && (newAgenda.getAnimal() != null) 
					&& (newAgenda.getDataMarcada() != null) && (newAgenda.getServicos() != null) ) {
				
				this.agendaRepository.alterarAgenda(newAgenda);
			}			
		}
				
	}
	
	public void deleteAgenda(long id) {
		
		if(id >= 0 && this.agendaRepository.existe(id)) {
			this.agendaRepository.excluirAgenda(id);
		}
		
	}
	
	public void deleteAgendaReservada(long id) {
		
		if(id >= 0 && this.agendaRepository.existeReservada(id)) {
			int i = this.agendaRepository.procurarIDReservada(id);
			this.agendaRepository.excluirAgendaPorPosicao(i);
		}
		
	}
	
	public ArrayList<Agenda> listarTodasAgendas() {
		return this.agendaRepository.listarTudo();
	}
	

}
