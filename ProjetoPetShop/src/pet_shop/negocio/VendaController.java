package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.VendaDAO;
import pet_shop.DAO.IRepositorios.IRepositorioVenda;
import pet_shop.negocio.beans.Venda;

public class VendaController 
{
	private IRepositorioVenda vendaRepository;
	private static VendaController instance;
	
	//Singleton
	private VendaController() {
		this.vendaRepository = VendaDAO.getInstance();
	}
	
	public static VendaController getInstance() {
		if(instance == null) {
			instance = new VendaController();
		}
		return instance;
	}
	public void saveVenda(Venda venda) 
	{		
		if( (venda != null) && (!this.vendaRepository.existe(venda))&& (venda.getValorTotal() >= 0) 
		&& (venda.getFuncionario() != null) && (venda.getData() != null) && (venda.getAtendimentos() != null) 
		&& (venda.getProdutos() != null)) 
		{			
			this.vendaRepository.cadastrar(venda);
		}
		
	}
	public void updateVenda(Venda venda, long id) 
	{
		if(venda != null) 
		{
			Venda a = this.vendaRepository.procurar(id);			
			if( (a != null) && (!this.vendaRepository.existe(venda))) 
			{
				this.vendaRepository.alterar(venda, id);
			}
		}
		
	}
	public void deleteVenda(long id) 
	{
	if(id > 0 && this.vendaRepository.existe(id)) 
	{
		this.vendaRepository.excluir(id);
	}
	
	}
	public Venda findVenda(long id) 
	{
		if(id >= 0 && this.vendaRepository.existe(id)) 
		{
			return this.vendaRepository.procurar(id);
		} else 
		{
			return null;
		}	
	}
	public ArrayList<Venda> listarTodasVendas() 
	{
		return this.vendaRepository.listarTudo();
	}
}
