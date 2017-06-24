package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.negocio.beans.*;


public class SistemaFachada {
	
	private AgendaController controleAgendas;
	private AnimalController controleAnimais;
	private AtendimentoController controleAtendimentos;
	private ClienteController controllerClientes;
	private FuncionarioController controllerFuncionario;
	private ProdutosController controllerProdutos;
	private ServicoContoller controllerServico;
	private VendaController controllerVenda;
	
	private static SistemaFachada instance;
	
	//Singleton
	private SistemaFachada() {
		
		this.controleAgendas = AgendaController.getInstance();
		this.controleAnimais = AnimalController.getInstance();
		this.controleAtendimentos = AtendimentoController.getInstance();
		this.controllerClientes = ClienteController.getInstance();
		this.controllerFuncionario = FuncionarioController.getInstance();
		this.controllerProdutos = ProdutosController.getInstance();
		this.controllerServico = ServicoContoller.getInstance();
		this.controllerVenda = VendaController.getInstance();
	}
	
	public static SistemaFachada getInstance() {
		if(instance == null) {
			instance = new SistemaFachada();
		}
		return instance;
	}

	/**
	 * @param agenda
	 * @see pet_shop.negocio.AgendaController#saveAgenda(pet_shop.negocio.beans.Agenda)
	 */
	public void saveAgenda(Agenda agenda) {
		controleAgendas.saveAgenda(agenda);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.AgendaController#findAgenda(long)
	 */
	public Agenda findAgenda(long id) {
		return controleAgendas.findAgenda(id);
	}

	/**
	 * @param newAgenda
	 * @see pet_shop.negocio.AgendaController#updateAgenda(pet_shop.negocio.beans.Agenda)
	 */
	public void updateAgenda(Agenda newAgenda) {
		controleAgendas.updateAgenda(newAgenda);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.AgendaController#deleteAgenda(long)
	 */
	public void deleteAgenda(long id) {
		controleAgendas.deleteAgenda(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.AgendaController#listarTodasAgendas()
	 */
	public ArrayList<Agenda> listarTodasAgendas() {
		return controleAgendas.listarTodasAgendas();
	}

	/**
	 * @param animal
	 * @see pet_shop.negocio.AnimalController#saveAnimal(pet_shop.negocio.beans.Animal)
	 */
	public void saveAnimal(Animal animal) {
		controleAnimais.saveAnimal(animal);
	}

	/**
	 * @param animal
	 * @see pet_shop.negocio.AnimalController#updateAnimal(pet_shop.negocio.beans.Animal)
	 */
	public void updateAnimal(Animal animal) {
		controleAnimais.updateAnimal(animal);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.AnimalController#deleteAnimal(long)
	 */
	public void deleteAnimal(long id) {
		controleAnimais.deleteAnimal(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.AnimalController#findAnimal(long)
	 */
	public Animal findAnimal(long id) {
		return controleAnimais.findAnimal(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.AnimalController#listarTodosAnimais()
	 */
	public ArrayList<Animal> listarTodosAnimais() {
		return controleAnimais.listarTodosAnimais();
	}

	/**
	 * @param atendimento
	 * @see pet_shop.negocio.AtendimentoController#saveAtendimento(pet_shop.negocio.beans.Atendimento)
	 */
	public void saveAtendimento(Atendimento atendimento) {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	/**
	 * @param atendimento
	 * @see pet_shop.negocio.AtendimentoController#updateAtendimento(pet_shop.negocio.beans.Atendimento)
	 */
	public void updateAtendimento(Atendimento atendimento) {
		controleAtendimentos.updateAtendimento(atendimento);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.AtendimentoController#deleteAtendimento(long)
	 */
	public void deleteAtendimento(long id) {
		controleAtendimentos.deleteAtendimento(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.AtendimentoController#findAtendimento(long)
	 */
	public Atendimento findAtendimento(long id) {
		return controleAtendimentos.findAtendimento(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.AtendimentoController#listarTodosAtendimentos()
	 */
	public ArrayList<Atendimento> listarTodosAtendimentos() {
		return controleAtendimentos.listarTodosAtendimentos();
	}

	/**
	 * @param c
	 * @see pet_shop.negocio.ClienteController#cadastrarCliente(pet_shop.negocio.beans.Cliente)
	 */
	public void cadastrarCliente(Cliente c) {
		controllerClientes.cadastrarCliente(c);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.ClienteController#descadastrarCliente(long)
	 */
	public void descadastrarCliente(long id) {
		controllerClientes.descadastrarCliente(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.ClienteController#listarCliente(long)
	 */
	public Cliente listarCliente(long id) {
		return controllerClientes.listarCliente(id);
	}

	/**
	 * @param c
	 * @return
	 * @see pet_shop.negocio.ClienteController#existe(pet_shop.negocio.beans.Cliente)
	 */
	public boolean existe(Cliente c) {
		return controllerClientes.existe(c);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.ClienteController#excluirCliente(long)
	 */
	public void excluirCliente(long id) {
		controllerClientes.excluirCliente(id);
	}

	/**
	 * @param novoCliente
	 * @see pet_shop.negocio.ClienteController#AlteraCliente(pet_shop.negocio.beans.Cliente)
	 */
	public void AlteraCliente(Cliente novoCliente) {
		controllerClientes.AlteraCliente(novoCliente);
	}

	/**
	 * @param f
	 * @see pet_shop.negocio.FuncionarioController#cadastrarFuncionario(pet_shop.negocio.beans.Funcionario)
	 */
	public void cadastrarFuncionario(Funcionario f) {
		controllerFuncionario.cadastrarFuncionario(f);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.FuncionarioController#descadastrarFuncionario(long)
	 */
	public void descadastrarFuncionario(long id) {
		controllerFuncionario.descadastrarFuncionario(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.FuncionarioController#listarFuncionario(long)
	 */
	public Funcionario listarFuncionario(long id) {
		return controllerFuncionario.listarFuncionario(id);
	}

	/**
	 * @param f
	 * @return
	 * @see pet_shop.negocio.FuncionarioController#existe(pet_shop.negocio.beans.Funcionario)
	 */
	public boolean existe(Funcionario f) {
		return controllerFuncionario.existe(f);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.FuncionarioController#excluirFuncionario(long)
	 */
	public void excluirFuncionario(long id) {
		controllerFuncionario.excluirFuncionario(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.FuncionarioController#listarTudoFuncionario()
	 */
	public ArrayList<Funcionario> listarTudoFuncionario() {
		return controllerFuncionario.listarTudoFuncionario();
	}

	/**
	 * @param novoFuncionario
	 * @see pet_shop.negocio.FuncionarioController#AlteraFuncionario(pet_shop.negocio.beans.Funcionario)
	 */
	public void AlteraFuncionario(Funcionario novoFuncionario) {
		controllerFuncionario.AlteraFuncionario(novoFuncionario);
	}

	/**
	 * @param p
	 * @see pet_shop.negocio.ProdutosController#cadastrarProduto(pet_shop.negocio.beans.Produto)
	 */
	public void cadastrarProduto(Produto p) {
		controllerProdutos.cadastrarProduto(p);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.ProdutosController#descadastrarProduto(long)
	 */
	public void descadastrarProduto(long id) {
		controllerProdutos.descadastrarProduto(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.ProdutosController#listarProduto(long)
	 */
	public Produto listarProduto(long id) {
		return controllerProdutos.listarProduto(id);
	}

	/**
	 * @param p
	 * @return
	 * @see pet_shop.negocio.ProdutosController#existe(pet_shop.negocio.beans.Produto)
	 */
	public boolean existe(Produto p) {
		return controllerProdutos.existe(p);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.ProdutosController#excluirProduto(long)
	 */
	public void excluirProduto(long id) {
		controllerProdutos.excluirProduto(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.ProdutosController#listarTudoProduto()
	 */
	public ArrayList<Produto> listarTudoProduto() {
		return controllerProdutos.listarTudoProduto();
	}

	/**
	 * @param novoProduto
	 * @see pet_shop.negocio.ProdutosController#AlteraProduto(pet_shop.negocio.beans.Produto)
	 */
	public void AlteraProduto(Produto novoProduto) {
		controllerProdutos.AlteraProduto(novoProduto);
	}

	/**
	 * @param servico
	 * @see pet_shop.negocio.ServicoContoller#saveServico(pet_shop.negocio.beans.Servico)
	 */
	public void saveServico(Servico servico) {
		controllerServico.saveServico(servico);
	}

	/**
	 * @param servico
	 * @see pet_shop.negocio.ServicoContoller#updateServico(pet_shop.negocio.beans.Servico)
	 */
	public void updateServico(Servico servico) {
		controllerServico.updateServico(servico);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.ServicoContoller#deleteServico(long)
	 */
	public void deleteServico(long id) {
		controllerServico.deleteServico(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.ServicoContoller#findServico(long)
	 */
	public Servico findServico(long id) {
		return controllerServico.findServico(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.ServicoContoller#listarTodosServicos()
	 */
	public ArrayList<Servico> listarTodosServicos() {
		return controllerServico.listarTodosServicos();
	}

	/**
	 * @param venda
	 * @see pet_shop.negocio.VendaController#saveVenda(pet_shop.negocio.beans.Venda)
	 */
	public void saveVenda(Venda venda) {
		controllerVenda.saveVenda(venda);
	}

	/**
	 * @param venda
	 * @see pet_shop.negocio.VendaController#updateServico(pet_shop.negocio.beans.Venda)
	 */
	public void updateServico(Venda venda) {
		controllerVenda.updateServico(venda);
	}

	/**
	 * @param id
	 * @see pet_shop.negocio.VendaController#deleteVenda(long)
	 */
	public void deleteVenda(long id) {
		controllerVenda.deleteVenda(id);
	}

	/**
	 * @param id
	 * @return
	 * @see pet_shop.negocio.VendaController#findVenda(long)
	 */
	public Venda findVenda(long id) {
		return controllerVenda.findVenda(id);
	}

	/**
	 * @return
	 * @see pet_shop.negocio.VendaController#listarTodasVendas()
	 */
	public ArrayList<Venda> listarTodasVendas() {
		return controllerVenda.listarTodasVendas();
	}

	
	
	//controle agendas
	
	

	

}
