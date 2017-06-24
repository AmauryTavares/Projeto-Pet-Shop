package pet_shop.negocio;

import pet_shop.DAO.ClienteDAO;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.AgendaController;

public class ClienteController {
	
	private ClienteDAO repositorioClientes;
	private static ClienteController instance;
	
	private ClienteController() {
        this.repositorioClientes = ClienteDAO.getInstance(); 
    }
	
	public static ClienteController getInstance() {
		if(instance == null)
			instance = new ClienteController();
		
		return instance;
	}
	
	public void cadastrarCliente(Cliente c) {
	    if (c == null) {
	      //Exce��o
	    } else {
	      if (!this.existe(c)) {
	        this.repositorioClientes.cadastrarCliente(c);
	      } else {
	    	  System.out.println("Aqui ser� colocado a exce��o");
	      }
	    }
	}
	
	public void descadastrarCliente(long id){
		Cliente c = this.repositorioClientes.listarCliente(id);
		
		if(c != null ){
			this.repositorioClientes.excluirCliente(id);
			for(int i = 0; i < AgendaController.getInstance().listarTodasAgendas().size(); i++){
				AgendaController.getInstance().deleteAgenda(id);
			}
		}
		else
			System.out.println("Aqui ser� colocado a exce��o");
	}
	
	public Cliente listarCliente(long id){
		return this.repositorioClientes.listarCliente(id);
	}
	
	public boolean existe(Cliente c) {
	    return this.repositorioClientes.existe(c);
	}
	
	public void excluirCliente(long id){
		this.repositorioClientes.excluirCliente(id);
	}
	
	public void AlteraCliente(Cliente novoCliente) {
		Cliente c = this.repositorioClientes.listarCliente(novoCliente.getId());
		if( (c != null) && (novoCliente.getNome() != null) && (novoCliente.getCpf()!=null)) {
			this.repositorioClientes.alterarCliente(novoCliente);
		}
		else {
			System.out.println("Aqui ficar� a exce��o");
		}
	}
}
