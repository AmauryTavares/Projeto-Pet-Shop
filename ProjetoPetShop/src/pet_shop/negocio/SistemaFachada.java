package pet_shop.negocio;

import java.util.List;

import pet_shop.negocio.beans.*;
import pet_shop.negocio.excecoes.*;

public class SistemaFachada implements IFachada {
	
	private ConsultaController controleAgendas;
	private AnimalController controleAnimais;
	private AtendimentoController controleAtendimentos;
	private PessoaController controllerClientes;
	private ProdutosController controllerProdutos;
	private ServicoContoller controllerServico;
	private VendaController controllerVenda;
	
	private static SistemaFachada instance;
	
	//Singleton
	private SistemaFachada() {
		
		this.controleAgendas = ConsultaController.getInstance();
		this.controleAnimais = AnimalController.getInstance();
		this.controleAtendimentos = AtendimentoController.getInstance();
		this.controllerClientes = PessoaController.getInstance();
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

	public void saveAgenda(Consulta agenda) throws IllegalAccessException, AnimalInexistenteException,
			AtendimentoInexistenteException, DataInvalidaException, ConsultaCadastradaException {
		controleAgendas.saveAgenda(agenda);
	}

	public List<Consulta> findAgenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controleAgendas.findAgenda(nome);
	}

	public void updateAgenda(Consulta newAgenda) throws IllegalAccessException, ConsultaInexistenteException,
			AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException {
		controleAgendas.updateAgenda(newAgenda);
	}

	public void deleteAgenda(Consulta consulta) throws IllegalAccessException, ConsultaInexistenteException {
		controleAgendas.deleteAgenda(consulta);
	}

	public List<Consulta> listarTodasAgendas() throws NadaEncontradoException {
		return controleAgendas.listarTodasAgendas();
	}

	public void saveAnimal(Animal animal)
			throws AnimalCadastradoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException,
			NomeInvalidoException, PesoInvalidoException, RacaInvalidaException {
		controleAnimais.saveAnimal(animal);
	}

	public void updateAnimal(Animal newAnimal)
			throws RacaInvalidaException, PesoInvalidoException, DonoInvalidoException, DataInvalidaException,
			EspecieInvalidaException, NomeInvalidoException, AnimalInexistenteException {
		controleAnimais.updateAnimal(newAnimal);
	}

	public void deleteAnimal(Animal animal) throws AnimalInexistenteException {
		controleAnimais.deleteAnimal(animal);
	}

	public List<Animal> findAnimal(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controleAnimais.findAnimal(nome);
	}

	public List<Animal> listarTodosAnimais() throws NadaEncontradoException {
		return controleAnimais.listarTodosAnimais();
	}

	public void saveAtendimento(Atendimento atendimento) throws AtendimentoCadastradoException, IllegalAccessException,
			AnimalInexistenteException, FuncionarioInvalidoException, ServicoInexistenteException,
			DataInvalidaException, ObservacaoInvalidaException {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	public void updateAtendimento(Atendimento atendimento) throws IllegalAccessException,
			AtendimentoInexistenteException, AnimalInexistenteException, FuncionarioInvalidoException,
			ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException {
		controleAtendimentos.updateAtendimento(atendimento);
	}

	public void deleteAtendimento(Atendimento atendimento)
			throws IllegalAccessException, AtendimentoInexistenteException {
		controleAtendimentos.deleteAtendimento(atendimento);
	}

	public List<Atendimento> findAtendimento(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controleAtendimentos.findAtendimento(nome);
	}

	public List<Atendimento> listarTodosAtendimentos() throws NadaEncontradoException {
		return controleAtendimentos.listarTodosAtendimentos();
	}

	public void cadastrarCliente(Pessoa p) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException,
			EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException,
			SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException {
		controllerClientes.cadastrarCliente(p);
	}

	public List<Pessoa> listarCliente(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerClientes.listarCliente(nome);
	}

	public List<Pessoa> listarTudo() throws NadaEncontradoException {
		return controllerClientes.listarTudo();
	}

	public void excluirCliente(Pessoa p) throws IllegalAccessException, PessoaInexistenteException {
		controllerClientes.excluirCliente(p);
	}

	public void alterarCliente(Pessoa p) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException,
			EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException,
			SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException {
		controllerClientes.alterarCliente(p);
	}

	public void cadastrarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException,
			PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoCadastradoException {
		controllerProdutos.cadastrarProduto(p);
	}

	public List<Produto> listarProduto(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerProdutos.listarProduto(nome);
	}

	public void excluirProduto(Produto p) throws IllegalAccessException, ProdutoInexistenteException {
		controllerProdutos.excluirProduto(p);
	}

	public List<Produto> listarTudoProduto() throws NadaEncontradoException {
		return controllerProdutos.listarTudoProduto();
	}

	public void alterarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException,
			QtdEstoqueInvalidoException, ProdutoInexistenteException {
		controllerProdutos.alterarProduto(p);
	}

	public void saveServico(Servico servico) throws IllegalAccessException, ServicoCadastradoException,
			PrecoInvalidoException, NomeInvalidoException, AnimalInvalidoException {
		controllerServico.saveServico(servico);
	}

	public void updateServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException,
			NomeInvalidoException, PrecoInvalidoException, AnimalInvalidoException {
		controllerServico.updateServico(servico);
	}

	public void deleteServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException {
		controllerServico.deleteServico(servico);
	}

	public List<Servico> findServico(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerServico.findServico(nome);
	}

	public List<Servico> listarTodosServicos() throws NadaEncontradoException {
		return controllerServico.listarTodosServicos();
	}

	public void saveVenda(Venda venda)
			throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException,
			AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException {
		controllerVenda.saveVenda(venda);
	}

	public void updateVenda(Venda venda)
			throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException,
			AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException {
		controllerVenda.updateVenda(venda);
	}

	public void deleteVenda(Venda venda) throws IllegalAccessException, VendaInexistenteException {
		controllerVenda.deleteVenda(venda);
	}

	public List<Venda> findVenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerVenda.findVenda(nome);
	}

	public List<Venda> listarTodasVendas() throws NadaEncontradoException {
		return controllerVenda.listarTodasVendas();
	}

}
