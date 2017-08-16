package pet_shop.negocio.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venda implements Serializable{

	private static final long serialVersionUID = 5761235742575131970L;
	private long id;
	private Cliente cliente;
	private Funcionario funcionario;
	private List<Atendimento> atendimentos;
	private List<Produto> produtos;
	private LocalDate data;
	private double valorTotal;
	
	public Venda(Funcionario funcionario, Cliente clienteSelecionado, List<Atendimento> listaAtendimentos, List<Produto> listaProdutos, LocalDate data) {
		this.funcionario = funcionario;
		this.cliente = clienteSelecionado;
		this.atendimentos = listaAtendimentos;
		this.produtos = listaProdutos;
		this.data = data;
		this.valorTotal = valorAtendimentos() + valorProdutos();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void adicionarProduto(Produto p) {
		if (p != null) {
			this.produtos.add(p);
		}
	}
	
	public String getNomeCliente() {
		return this.cliente.getNome();
	}
	
	public String getNomeFun() {
		return this.funcionario.getNome();
	}
	
	public int getQtdProdutos(){
		int valor = 0;
		for (Produto p : produtos) {
			valor += p.getQtdEstoque();
		}
		return valor;
	}
	
	public void removerProduto(long id) {
		boolean achou = false;
		for (int i = 0; i < this.produtos.size() && achou == false; i++) {
			if (this.produtos.get(i).getId() == id) {
				this.produtos.remove(i);
				achou = true;
			}
		}
	}
	
	public void adicionarAtendimento(Atendimento s) {
		if (s != null) {
			this.atendimentos.add(s);
		}
	}
	
	public void removerAtendimento(long id) {
		boolean achou = false;
		for (int i = 0; i < this.atendimentos.size() && achou == false; i++) {
			if (this.atendimentos.get(i).getId() == id) {
				this.atendimentos.remove(i);
				achou = true;
			}
		}
	}
	
	private double valorAtendimentos() {
		double valorTotalServicos = 0;
		for (int i = 0; i < this.atendimentos.size(); i++) {
			valorTotalServicos += this.atendimentos.get(i).getServico().getPreco();
		}
		return valorTotalServicos;
	}
	
	private double valorProdutos() {
		double valorTotalProdutos = 0;
		for (int i = 0; i < this.produtos.size(); i++) {
			valorTotalProdutos += this.produtos.get(i).getPreco() * this.produtos.get(i).getQtdEstoque();
		}
		return valorTotalProdutos;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = "\nID: " + this.id + "\nData: " + this.data.format(fmt) + "\nNome do funcion�rio: " + this.funcionario.getNome() + "\nProduto(s): ";
		
		for (int i = 0; i < this.produtos.size(); i++) {
			text += String.format("\n%20s \tR$%.2f x%.2f", this.produtos.get(i).getNome(), this.produtos.get(i).getPreco(), this.produtos.get(i).getQtdEstoque());
		}
		
		text += "\nServi�o(s): ";
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			text += String.format("\n%22s \tR$%.2f", this.atendimentos.get(i).getServico().getNome(), this.atendimentos.get(i).getServico().getPreco());
		}
		
		text += "\n\nValor Total: " + String.format("          R$%.2f", this.valorTotal);
		
		return text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
