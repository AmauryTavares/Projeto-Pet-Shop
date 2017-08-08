package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.PessoaDAO;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.ConsultaController;

public class PessoaController {
	
	private PessoaDAO repositorioClientes;
	private static PessoaController instance;
	
	private PessoaController() {
        this.repositorioClientes = PessoaDAO.getInstance(); 
    }
	
	public static PessoaController getInstance() {
		if(instance == null)
			instance = new PessoaController();
		
		return instance;
	}
	
	public void cadastrarCliente(Cliente c) {
	    if (c == null) {
	      //Exceção
	    } else {
	      if (!this.existe(c)) {
	        this.repositorioClientes.cadastrar(c);
	      } 
	    }
	}
	
	public void descadastrarCliente(long id){
		Cliente c = this.repositorioClientes.procurar(id);
		
		if(c != null ){
			this.repositorioClientes.excluir(id);
			for(int i = 0; i < ConsultaController.getInstance().listarTodasAgendas().size(); i++){
				ConsultaController.getInstance().deleteAgendaReservada(id);
			}
		}
	}
	
	public Cliente listarCliente(long id){
		return this.repositorioClientes.procurar(id);
	}
	
	public ArrayList<Cliente> listarTudo() {
		return this.repositorioClientes.listarTudo();
	}
	
	public boolean existe(Cliente c) {
	    return this.repositorioClientes.existe(c);
	}
	
	public void excluirCliente(long id){
		this.repositorioClientes.excluir(id);
	}
	
	public void alterarCliente(Cliente novoCliente, long id) {
		Cliente c = this.repositorioClientes.procurar(id);
		if( (c != null) && (novoCliente.getNome() != null) && (novoCliente.getCpf()!=null)) {
			this.repositorioClientes.alterar(novoCliente, id);
		}
	}
}
