package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.negocio.beans.*;


public class SistemaFachada implements IFachada {
	
	private ConsultaController controleAgendas;
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
		
		this.controleAgendas = ConsultaController.getInstance();
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
	
	@Override
	public void saveAgenda(Consulta agenda) {
		controleAgendas.saveAgenda(agenda);
	}

	@Override
	public Consulta findAgenda(long id) {
		return controleAgendas.findAgenda(id);
	}

	@Override
	public void updateAgenda(Consulta newAgenda, long id) {
		controleAgendas.updateAgenda(newAgenda, id);
	}

	@Override
	public void deleteAgenda(long id) {
		controleAgendas.deleteAgenda(id);
	}

	@Override
	public ArrayList<Consulta> listarTodasAgendas() {
		return controleAgendas.listarTodasAgendas();
	}

	@Override
	public void saveAnimal(Animal animal) {
		controleAnimais.saveAnimal(animal);
	}

	@Override
	public void updateAnimal(Animal animal, long id) {
		controleAnimais.updateAnimal(animal, id);
	}

	@Override
	public void deleteAnimal(long id, ArrayList<Consulta> c) {
		controleAnimais.deleteAnimal(id, c);
	}

	@Override
	public Animal findAnimal(long id) {
		return controleAnimais.findAnimal(id);
	}

	@Override
	public ArrayList<Animal> listarTodosAnimais() {
		return controleAnimais.listarTodosAnimais();
	}

	@Override
	public void saveAtendimento(Atendimento atendimento) {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	@Override
	public void updateAtendimento(Atendimento atendimento, long id) {
		controleAtendimentos.updateAtendimento(atendimento, id);
	}

	@Override
	public void deleteAtendimento(long id) {
		controleAtendimentos.deleteAtendimento(id);
	}

	@Override
	public Atendimento findAtendimento(long id) {
		return controleAtendimentos.findAtendimento(id);
	}

	@Override
	public ArrayList<Atendimento> listarTodosAtendimentos() {
		return controleAtendimentos.listarTodosAtendimentos();
	}

	@Override
	public void cadastrarCliente(Cliente c) {
		controllerClientes.cadastrarCliente(c);
	}

	@Override
	public void descadastrarCliente(long id) {
		controllerClientes.descadastrarCliente(id);
	}

	@Override
	public Cliente listarCliente(long id) {
		return controllerClientes.listarCliente(id);
	}

	@Override
	public ArrayList<Cliente> listarTudo() {
		return controllerClientes.listarTudo();
	}

	@Override
	public boolean existe(Cliente c) {
		return controllerClientes.existe(c);
	}

	@Override
	public void excluirCliente(long id) {
		controllerClientes.excluirCliente(id);
	}

	@Override
	public void alterarCliente(Cliente novoCliente, long id) {
		controllerClientes.alterarCliente(novoCliente, id);
	}

	@Override
	public void cadastrarFuncionario(Funcionario f) {
		controllerFuncionario.cadastrarFuncionario(f);
	}

	@Override
	public void descadastrarFuncionario(long id) {
		controllerFuncionario.descadastrarFuncionario(id);
	}

	@Override
	public Funcionario listarFuncionario(long id) {
		return controllerFuncionario.listarFuncionario(id);
	}

	@Override
	public boolean existe(Funcionario f) {
		return controllerFuncionario.existe(f);
	}

	@Override
	public void excluirFuncionario(long id) {
		controllerFuncionario.excluirFuncionario(id);
	}

	@Override
	public ArrayList<Funcionario> listarTudoFuncionario() {
		return controllerFuncionario.listarTudoFuncionario();
	}

	@Override
	public void alteraFuncionario(Funcionario novoFuncionario, long id) {
		controllerFuncionario.alteraFuncionario(novoFuncionario, id);
	}

	@Override
	public void cadastrarProduto(Produto p) {
		controllerProdutos.cadastrarProduto(p);
	}

	@Override
	public void descadastrarProduto(long id) {
		controllerProdutos.descadastrarProduto(id);
	}

	@Override
	public Produto listarProduto(long id) {
		return controllerProdutos.listarProduto(id);
	}

	@Override
	public boolean existe(Produto p) {
		return controllerProdutos.existe(p);
	}

	@Override
	public void excluirProduto(long id) {
		controllerProdutos.excluirProduto(id);
	}

	@Override
	public ArrayList<Produto> listarTudoProduto() {
		return controllerProdutos.listarTudoProduto();
	}

	@Override
	public void alteraProduto(Produto novoProduto, long id) {
		controllerProdutos.alteraProduto(novoProduto, id);
	}

	@Override
	public void saveServico(Servico servico) {
		controllerServico.saveServico(servico);
	}

	@Override
	public void updateServico(Servico servico, long id) {
		controllerServico.updateServico(servico, id);
	}

	@Override
	public void deleteServico(long id) {
		controllerServico.deleteServico(id);
	}

	@Override
	public Servico findServico(long id) {
		return controllerServico.findServico(id);
	}

	@Override
	public ArrayList<Servico> listarTodosServicos() {
		return controllerServico.listarTodosServicos();
	}

	@Override
	public void saveVenda(Venda venda) {
		controllerVenda.saveVenda(venda);
	}

	@Override
	public void updateVenda(Venda venda, long id) {
		controllerVenda.updateVenda(venda, id);
	}

	@Override
	public void deleteVenda(long id) {
		controllerVenda.deleteVenda(id);
	}

	@Override
	public Venda findVenda(long id) {
		return controllerVenda.findVenda(id);
	}

	@Override
	public ArrayList<Venda> listarTodasVendas() {
		return controllerVenda.listarTodasVendas();
	}


}
