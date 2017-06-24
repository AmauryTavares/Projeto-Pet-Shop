package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.ServicoDAO;
import pet_shop.negocio.beans.Servico;

public class ServicoContoller 
{

	private ServicoDAO servicoRepository;
	private static ServicoContoller instance;
	
	//Singleton
	private ServicoContoller() {
		this.servicoRepository = ServicoDAO.getInstance();
	}
	
	public static ServicoContoller getInstance() {
		if(instance == null) {
			instance = new ServicoContoller();
		}
		return instance;
	}
	
	public void saveServico(Servico servico) {
		
		if( (servico != null) && (!this.servicoRepository.existe(servico)) && (servico.getNome() != null) 
				&& (servico.getPreco() > 0) && (servico.isConsulta() != true)) {
			
			this.servicoRepository.cadastrarServico(servico);
		}
		
	}
	
	public void updateServico(Servico servico) {
		
		if(servico != null) {
			Servico a = this.servicoRepository.listarServico(servico.getId());
			
			if( (a != null) && (!this.servicoRepository.existe(servico)) && (servico.getNome() != null) 
					&& (servico.getPreco() > 0) && (servico.isConsulta() != true)) {
				
				this.servicoRepository.alterarServico(servico);
			}
		}
		
	}
	public void deleteServico(long id) {
		
		if(id >= 0 && this.servicoRepository.existe(id)) {
			this.servicoRepository.excluirServico(id);
		}
		
	}
	
	public Servico findServico(long id) {
		
		if(id >= 0 && this.servicoRepository.existe(id)) 
		{
			return this.servicoRepository.listarServico(id);
			
		}
		else 
		{
			return null;
		}
		
	}
	public ArrayList<Servico> listarTodosServicos() 
	{
	return this.servicoRepository.listarTudo();
	}
}
