package pet_shop.negocio.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Venda {

	private static long proximoID = 1;
	
	private long id;
	private Funcionario funcionario;
	private ArrayList<Atendimento> atendimentos;
	private ArrayList<Produto> produtos;
	private LocalDate data;
	private double valorTotal;
	
	public Venda(Funcionario funcionario, ArrayList<Atendimento> atendimentos, ArrayList<Produto> produtos, LocalDate data) {
		this.id = proximoID;
		proximoID++;
		this.funcionario = funcionario;
		this.atendimentos = atendimentos;
		this.produtos = produtos;
		this.data = data;
		this.valorTotal = valorAtendimentos() + valorProdutos();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public ArrayList<Produto> getProdutos() {
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
	
	public void adicionarProduto(Produto p) {
		if (p != null) {
			this.produtos.add(p);
		}
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
			valorTotalProdutos += this.produtos.get(i).getPreco();
		}
		return valorTotalProdutos;
	}
	
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = "\nID: " + this.id + "\nData: " + this.data.format(fmt) + "\nNome do funcionário: " + this.funcionario.getNome() + "\nProduto(s): ";
		
		for (int i = 0; i < this.produtos.size(); i++) {
			text += String.format("\n%20s \tR$%.2f", this.produtos.get(i).getNome(), this.produtos.get(i).getPreco());
		}
		
		text += "\nServiço(s): ";
		
		for (int i = 0; i < this.atendimentos.size(); i++) {
			text += String.format("\n%20s \tR$%.2f", this.atendimentos.get(i).getServico().getNome(), this.atendimentos.get(i).getServico().getPreco());
		}
		
		text += "\n\nValor Total: R$" + String.format("%.2f", this.valorTotal);
		
		return text;
	}
	
}
