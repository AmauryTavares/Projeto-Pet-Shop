package pet_shop.negocio;

import java.util.List;

import pet_shop.negocio.beans.Consulta;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.beans.Venda;
import pet_shop.negocio.excecoes.AnimalCadastradoException;
import pet_shop.negocio.excecoes.AnimalInexistenteException;
import pet_shop.negocio.excecoes.AnimalInvalidoException;
import pet_shop.negocio.excecoes.AtendimentoCadastradoException;
import pet_shop.negocio.excecoes.AtendimentoInexistenteException;
import pet_shop.negocio.excecoes.AtendimentoInvalidoException;
import pet_shop.negocio.excecoes.CargoInvalidoException;
import pet_shop.negocio.excecoes.ClienteInvalidoException;
import pet_shop.negocio.excecoes.ConsultaCadastradaException;
import pet_shop.negocio.excecoes.ConsultaInexistenteException;
import pet_shop.negocio.excecoes.CpfInvalidoException;
import pet_shop.negocio.excecoes.DataInvalidaException;
import pet_shop.negocio.excecoes.DonoInvalidoException;
import pet_shop.negocio.excecoes.EmailInvalidoException;
import pet_shop.negocio.excecoes.EnderecoInvalidoException;
import pet_shop.negocio.excecoes.EspecieInvalidaException;
import pet_shop.negocio.excecoes.FuncionarioInvalidoException;
import pet_shop.negocio.excecoes.LoginInvalidoException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.ObservacaoInvalidaException;
import pet_shop.negocio.excecoes.PesoInvalidoException;
import pet_shop.negocio.excecoes.PessoaCadastradoException;
import pet_shop.negocio.excecoes.PessoaInexistenteException;
import pet_shop.negocio.excecoes.PrecoInvalidoException;
import pet_shop.negocio.excecoes.ProdutoCadastradoException;
import pet_shop.negocio.excecoes.ProdutoInexistenteException;
import pet_shop.negocio.excecoes.ProdutoInvalidoException;
import pet_shop.negocio.excecoes.QtdEstoqueInvalidoException;
import pet_shop.negocio.excecoes.RacaInvalidaException;
import pet_shop.negocio.excecoes.SenhaInvalidaException;
import pet_shop.negocio.excecoes.ServicoCadastradoException;
import pet_shop.negocio.excecoes.ServicoInexistenteException;
import pet_shop.negocio.excecoes.TelefoneInvalidoException;
import pet_shop.negocio.excecoes.VendaInexistenteException;

public interface IFachada {
	
	public abstract void saveAgenda(Consulta agenda) throws IllegalAccessException, AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException, ConsultaCadastradaException;
	public abstract List<Consulta> findAgenda(String nome) throws IllegalAccessException, NadaEncontradoException;
	public abstract void updateAgenda(Consulta newAgenda) throws IllegalAccessException, ConsultaInexistenteException, AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException;
	public abstract void deleteAgenda(Consulta agenda) throws IllegalAccessException, ConsultaInexistenteException;
	public abstract List<Consulta> listarTodasAgendas() throws NadaEncontradoException;
	
	public abstract void saveAnimal(Animal animal) throws AnimalCadastradoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException, NomeInvalidoException, PesoInvalidoException, RacaInvalidaException;
	public abstract void updateAnimal(Animal animal) throws RacaInvalidaException, PesoInvalidoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException, NomeInvalidoException, AnimalInexistenteException;
	public abstract void deleteAnimal(Animal animal) throws AnimalInexistenteException ;
	public abstract List<Animal> findAnimal(String nome) throws IllegalAccessException, NadaEncontradoException ;
	public abstract List<Animal> listarTodosAnimais() throws NadaEncontradoException;

	public abstract void saveAtendimento(Atendimento atendimento) throws AtendimentoCadastradoException, IllegalAccessException, AnimalInexistenteException, FuncionarioInvalidoException, ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException;
	public abstract void updateAtendimento(Atendimento atendimento) throws IllegalAccessException, AtendimentoInexistenteException, AnimalInexistenteException, FuncionarioInvalidoException, ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException;
	public abstract void deleteAtendimento(Atendimento atendimento) throws IllegalAccessException, AtendimentoInexistenteException;
	public abstract List<Atendimento> findAtendimento(String nome) throws IllegalAccessException, NadaEncontradoException ;
	public abstract List<Atendimento> listarTodosAtendimentos() throws NadaEncontradoException;

	public abstract void cadastrarCliente(Pessoa pessoa) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException;
	public abstract List<Pessoa> listarCliente(String nome) throws IllegalAccessException, NadaEncontradoException;
	public abstract List<Pessoa> listarTudo() throws NadaEncontradoException ;
	public abstract void excluirCliente(Pessoa pessoa) throws IllegalAccessException, PessoaInexistenteException;
	public abstract void alterarCliente(Pessoa novaPessoa) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException;

	public abstract void cadastrarProduto(Produto produto) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoCadastradoException;
	public abstract List<Produto> listarProduto(String nome) throws IllegalAccessException, NadaEncontradoException;
	public abstract void excluirProduto(Produto produto) throws IllegalAccessException, ProdutoInexistenteException;
	public abstract List<Produto> listarTudoProduto() throws NadaEncontradoException;
	public abstract void alterarProduto(Produto novoProduto) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoInexistenteException;

	public abstract void saveServico(Servico servico) throws IllegalAccessException, ServicoCadastradoException, PrecoInvalidoException, NomeInvalidoException, AnimalInvalidoException;
	public abstract void updateServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException, NomeInvalidoException, PrecoInvalidoException, AnimalInvalidoException;
	public abstract void deleteServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException;
	public abstract List<Servico> findServico(String nome) throws IllegalAccessException, NadaEncontradoException;
	public abstract List<Servico> listarTodosServicos() throws NadaEncontradoException;

	public abstract void saveVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException;
	public abstract void updateVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException;
	public abstract void deleteVenda(Venda venda) throws IllegalAccessException, VendaInexistenteException;
	public abstract List<Venda> findVenda(String nome) throws IllegalAccessException, NadaEncontradoException;
	public abstract List<Venda> listarTodasVendas() throws NadaEncontradoException;

}
