package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.negocio.beans.Consulta;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.beans.Venda;

public interface IFachada {
	
	public abstract void saveAgenda(Consulta agenda);
	public abstract Consulta findAgenda(long id);
	public abstract void updateAgenda(Consulta newAgenda, long id);
	public abstract void deleteAgenda(long id);
	public abstract ArrayList<Consulta> listarTodasAgendas();
	
	public abstract void saveAnimal(Animal animal);
	public abstract void updateAnimal(Animal animal, long id);
	public abstract void deleteAnimal(long id, ArrayList<Consulta> c) ;
	public abstract Animal findAnimal(long id) ;
	public abstract ArrayList<Animal> listarTodosAnimais();

	public abstract void saveAtendimento(Atendimento atendimento);
	public abstract void updateAtendimento(Atendimento atendimento, long id);
	public abstract void deleteAtendimento(long id);
	public abstract Atendimento findAtendimento(long id) ;
	public abstract ArrayList<Atendimento> listarTodosAtendimentos();

	public abstract void cadastrarCliente(Cliente c);
	public abstract void descadastrarCliente(long id);
	public abstract Cliente listarCliente(long id);
	public abstract ArrayList<Cliente> listarTudo() ;
	public abstract boolean existe(Cliente c);
	public abstract void excluirCliente(long id);
	public abstract void alterarCliente(Cliente novoCliente, long id);

	public abstract void cadastrarFuncionario(Funcionario f);
	public abstract void descadastrarFuncionario(long id);
	public abstract Funcionario listarFuncionario(long id);
	public abstract boolean existe(Funcionario f);
	public abstract void excluirFuncionario(long id);
	public abstract ArrayList<Funcionario> listarTudoFuncionario();
	public abstract void alteraFuncionario(Funcionario novoFuncionario, long id);

	public abstract void cadastrarProduto(Produto p);
	public abstract void descadastrarProduto(long id);
	public abstract Produto listarProduto(long id);
	public abstract boolean existe(Produto p);
	public abstract void excluirProduto(long id);
	public abstract ArrayList<Produto> listarTudoProduto();
	public abstract void alteraProduto(Produto novoProduto, long id);

	public abstract void saveServico(Servico servico);
	public abstract void updateServico(Servico servico, long id);
	public abstract void deleteServico(long id);
	public abstract Servico findServico(long id);
	public abstract ArrayList<Servico> listarTodosServicos();

	public abstract void saveVenda(Venda venda);
	public abstract void updateVenda(Venda venda, long id);
	public abstract void deleteVenda(long id);
	public abstract Venda findVenda(long id);
	public abstract ArrayList<Venda> listarTodasVendas();

}
