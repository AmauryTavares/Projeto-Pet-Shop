package pet_shop.negocio;

import java.io.IOException;
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
			AtendimentoInexistenteException, DataInvalidaException, ConsultaCadastradaException, IOException {
		controleAgendas.saveAgenda(agenda);
	}

	public List<Consulta> findAgenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controleAgendas.findAgenda(nome);
	}

	public void updateAgenda(Consulta newAgenda) throws IllegalAccessException, ConsultaInexistenteException,
			AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException, IOException {
		controleAgendas.updateAgenda(newAgenda);
	}

	public void deleteAgenda(Consulta consulta)
			throws IllegalAccessException, ConsultaInexistenteException, IOException {
		controleAgendas.deleteAgenda(consulta);
	}

	public List<Consulta> listarTodasAgendas() throws NadaEncontradoException {
		return controleAgendas.listarTodasAgendas();
	}

	public void saveAnimal(Animal animal)
			throws AnimalCadastradoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException,
			NomeInvalidoException, PesoInvalidoException, RacaInvalidaException, IOException {
		controleAnimais.saveAnimal(animal);
	}

	public void updateAnimal(Animal newAnimal)
			throws RacaInvalidaException, PesoInvalidoException, DonoInvalidoException, DataInvalidaException,
			EspecieInvalidaException, NomeInvalidoException, AnimalInexistenteException, IOException {
		controleAnimais.updateAnimal(newAnimal);
	}

	public void deleteAnimal(Animal animal) throws AnimalInexistenteException, IOException {
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
			DataInvalidaException, ObservacaoInvalidaException, IOException {
		controleAtendimentos.saveAtendimento(atendimento);
	}

	public void updateAtendimento(Atendimento atendimento) throws IllegalAccessException,
			AtendimentoInexistenteException, AnimalInexistenteException, FuncionarioInvalidoException,
			ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException, IOException {
		controleAtendimentos.updateAtendimento(atendimento);
	}

	public void deleteAtendimento(Atendimento atendimento)
			throws IllegalAccessException, AtendimentoInexistenteException, IOException {
		controleAtendimentos.deleteAtendimento(atendimento);
	}

	public List<Atendimento> findAtendimento(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controleAtendimentos.findAtendimento(nome);
	}

	public List<Atendimento> listarTodosAtendimentos() throws NadaEncontradoException {
		return controleAtendimentos.listarTodosAtendimentos();
	}

	public void cadastrarCliente(Pessoa p)
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		controllerClientes.cadastrarCliente(p);
	}

	public List<Pessoa> listarCliente(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerClientes.listarCliente(nome);
	}

	public List<Pessoa> listarTudo() throws NadaEncontradoException {
		return controllerClientes.listarTudo();
	}

	public void excluirCliente(Pessoa p) throws IllegalAccessException, PessoaInexistenteException, IOException {
		controllerClientes.excluirCliente(p);
	}

	public void alterarCliente(Pessoa p) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException,
			EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException,
			SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException, IOException {
		controllerClientes.alterarCliente(p);
	}

	public void cadastrarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException,
			PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoCadastradoException, IOException {
		controllerProdutos.cadastrarProduto(p);
	}

	public List<Produto> listarProduto(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerProdutos.listarProduto(nome);
	}

	public void excluirProduto(Produto p) throws IllegalAccessException, ProdutoInexistenteException, IOException {
		controllerProdutos.excluirProduto(p);
	}

	public List<Produto> listarTudoProduto() throws NadaEncontradoException {
		return controllerProdutos.listarTudoProduto();
	}

	public void alterarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException,
			QtdEstoqueInvalidoException, ProdutoInexistenteException, IOException {
		controllerProdutos.alterarProduto(p);
	}

	public void saveServico(Servico servico) throws IllegalAccessException, ServicoCadastradoException,
			PrecoInvalidoException, NomeInvalidoException, AnimalInvalidoException, IOException {
		controllerServico.saveServico(servico);
	}

	public void updateServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException,
			NomeInvalidoException, PrecoInvalidoException, AnimalInvalidoException, IOException {
		controllerServico.updateServico(servico);
	}

	public void deleteServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException, IOException {
		controllerServico.deleteServico(servico);
	}

	public List<Servico> findServico(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerServico.findServico(nome);
	}

	public List<Servico> listarTodosServicos() throws NadaEncontradoException {
		return controllerServico.listarTodosServicos();
	}

	public void saveVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException,
			FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException,
			PrecoInvalidoException, IOException {
		controllerVenda.saveVenda(venda);
	}

	public void updateVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException,
			FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException,
			PrecoInvalidoException, IOException {
		controllerVenda.updateVenda(venda);
	}

	public void deleteVenda(Venda venda) throws IllegalAccessException, VendaInexistenteException, IOException {
		controllerVenda.deleteVenda(venda);
	}

	public List<Venda> findVenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		return controllerVenda.findVenda(nome);
	}

	public List<Venda> listarTodasVendas() throws NadaEncontradoException {
		return controllerVenda.listarTodasVendas();
	}
	
	
}
