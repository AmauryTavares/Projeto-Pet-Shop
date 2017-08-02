package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.ConsultaDAO;
import pet_shop.DAO.IRepositorios.IRepositorioConsulta;
import pet_shop.negocio.beans.Consulta;

public class ConsultaController {
	
	private IRepositorioConsulta agendaRepository;
	private static ConsultaController instance;
	
	//Singleton
	private ConsultaController() {
		this.agendaRepository = ConsultaDAO.getInstance();
	}
	
	public static ConsultaController getInstance() {
		if(instance == null) {
			instance = new ConsultaController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAgenda(Consulta agenda) {
		
		if( (agenda != null) && (!this.agendaRepository.existe(agenda)) && (agenda.getAnimal() != null) 
				&& (agenda.getDataMarcada() != null) && (agenda.getServicos() != null) ) {
			
			this.agendaRepository.cadastrar(agenda);
		}
		
	}
	
	public Consulta findAgenda(long id) {
		if(id >= 0 && this.agendaRepository.existe(id)) {
			return this.agendaRepository.procurar(id);
		} else {
			return null;
		}
	}
	
	public void updateAgenda(Consulta newAgenda ,long id) {
		
		if (newAgenda != null) {			
			Consulta a = this.agendaRepository.procurar(id);
			
			if( (a != null) && (newAgenda.getAnimal() != null) 
					&& (newAgenda.getDataMarcada() != null) && (newAgenda.getServicos() != null) ) {
				
				this.agendaRepository.alterar(newAgenda, id);
			}			
		}
				
	}
	
	public void deleteAgenda(long id) {
		
		if(id >= 0 && this.agendaRepository.existe(id)) {
			this.agendaRepository.excluir(id);
		}
		
	}
	
	public void deleteAgendaReservada(long id) {
		
		if(id >= 0 && this.agendaRepository.existeReservada(id)) {
			int i = this.agendaRepository.procurarIDReservada(id);
			this.agendaRepository.excluirAgendaPorPosicao(i);
		}
		
	}
	
	public ArrayList<Consulta> listarTodasAgendas() {
		return this.agendaRepository.listarTudo();
	}
	

}
