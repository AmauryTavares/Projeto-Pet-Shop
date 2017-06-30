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

	public void saveAgenda(Agenda agenda) {
		controleAgendas.saveAgenda(agenda);
	}

	public Agenda findAgenda(long id) {
		return controleAgendas.findAgenda(id);
	}

	public void updateAgenda(Agenda newAgenda) {
		controleAgendas.updateAgenda(newAgenda);
	}

	public void deleteAgenda(long id) {
		controleAgendas.deleteAgenda(id);
	}

	public ArrayList<Agenda> listarTodasAgendas() {
		return controleAgendas.listarTodasAgendas();
	}

	public void saveAnimal(Animal animal) {
		controleAnimais.saveAnimal(animal);
	}

	public void updateAnimal(Animal animal) {
		controleAnimais.updateAnimal(animal);
	}

	public void deleteAnimal(long id) {
		controleAnimais.deleteAnimal(id);
	}

	public Animal findAnimal(long id) {
		return controleAnimais.findAnimal(id);
	}

	public ArrayList<Animal> listarTodosAnimais() {
		return controleAnimais.listarTodosAnimais();
	}

	public void saveAtendimento(Atendimento atendimento) {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	public void updateAtendimento(Atendimento atendimento) {
		controleAtendimentos.updateAtendimento(atendimento);
	}

	public void deleteAtendimento(long id) {
		controleAtendimentos.deleteAtendimento(id);
	}

	public Atendimento findAtendimento(long id) {
		return controleAtendimentos.findAtendimento(id);
	}

	public ArrayList<Atendimento> listarTodosAtendimentos() {
		return controleAtendimentos.listarTodosAtendimentos();
	}

	public void cadastrarCliente(Cliente c) {
		controllerClientes.cadastrarCliente(c);
	}

	public void descadastrarCliente(long id) {
		controllerClientes.descadastrarCliente(id);
	}

	public Cliente listarCliente(long id) {
		return controllerClientes.listarCliente(id);
	}
	
	public ArrayList<Cliente> listarTudo() {
		return controllerClientes.listarTudo();
	}

	public boolean existe(Cliente c) {
		return controllerClientes.existe(c);
	}

	public void excluirCliente(long id) {
		controllerClientes.excluirCliente(id);
	}

	public void AlterarCliente(Cliente novoCliente) {
		controllerClientes.AlterarCliente(novoCliente);
	}

	public void cadastrarFuncionario(Funcionario f) {
		controllerFuncionario.cadastrarFuncionario(f);
	}

	public void descadastrarFuncionario(long id) {
		controllerFuncionario.descadastrarFuncionario(id);
	}

	public Funcionario listarFuncionario(long id) {
		return controllerFuncionario.listarFuncionario(id);
	}

	public boolean existe(Funcionario f) {
		return controllerFuncionario.existe(f);
	}

	public void excluirFuncionario(long id) {
		controllerFuncionario.excluirFuncionario(id);
	}

	public ArrayList<Funcionario> listarTudoFuncionario() {
		return controllerFuncionario.listarTudoFuncionario();
	}

	public void AlteraFuncionario(Funcionario novoFuncionario) {
		controllerFuncionario.AlteraFuncionario(novoFuncionario);
	}

	public void cadastrarProduto(Produto p) {
		controllerProdutos.cadastrarProduto(p);
	}

	public void descadastrarProduto(long id) {
		controllerProdutos.descadastrarProduto(id);
	}

	public Produto listarProduto(long id) {
		return controllerProdutos.listarProduto(id);
	}

	public boolean existe(Produto p) {
		return controllerProdutos.existe(p);
	}

	public void excluirProduto(long id) {
		controllerProdutos.excluirProduto(id);
	}

	public ArrayList<Produto> listarTudoProduto() {
		return controllerProdutos.listarTudoProduto();
	}

	public void AlteraProduto(Produto novoProduto) {
		controllerProdutos.AlteraProduto(novoProduto);
	}

	public void saveServico(Servico servico) {
		controllerServico.saveServico(servico);
	}

	public void updateServico(Servico servico) {
		controllerServico.updateServico(servico);
	}

	public void deleteServico(long id) {
		controllerServico.deleteServico(id);
	}

	public Servico findServico(long id) {
		return controllerServico.findServico(id);
	}

	public ArrayList<Servico> listarTodosServicos() {
		return controllerServico.listarTodosServicos();
	}

	public void saveVenda(Venda venda) {
		controllerVenda.saveVenda(venda);
	}

	public void updateVenda(Venda venda) {
		controllerVenda.updateVenda(venda);
	}

	public void deleteVenda(long id) {
		controllerVenda.deleteVenda(id);
	}

	public Venda findVenda(long id) {
		return controllerVenda.findVenda(id);
	}

	public ArrayList<Venda> listarTodasVendas() {
		return controllerVenda.listarTodasVendas();
	}


}
