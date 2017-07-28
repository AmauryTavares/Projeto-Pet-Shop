package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.ServicoDAO;
import pet_shop.DAO.IRepositorios.IRepositorioServico;
import pet_shop.negocio.beans.Servico;

public class ServicoContoller 
{

	private IRepositorioServico servicoRepository;
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
				&& (servico.getPreco() > 0)) {
			
			this.servicoRepository.cadastrar(servico);
		}
		
	}
	
	public void updateServico(Servico servico, long id) {
		
		if(servico != null) {
			Servico a = this.servicoRepository.procurar(id);
			
			if( (a != null) && (!this.servicoRepository.existe(servico)) && (servico.getNome() != null) 
					&& (servico.getPreco() > 0)) {
				
				this.servicoRepository.alterar(servico, id);
			}
		}
		
	}
	public void deleteServico(long id) {
		
		if(id >= 0 && this.servicoRepository.existe(id)) {
			this.servicoRepository.excluir(id);
		}
		
	}
	
	public Servico findServico(long id) {
		
		if(id >= 0 && this.servicoRepository.existe(id)) 
		{
			return this.servicoRepository.procurar(id);
			
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
