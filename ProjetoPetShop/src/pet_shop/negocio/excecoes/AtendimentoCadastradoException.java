package pet_shop.negocio.excecoes;

import java.time.LocalDate;

public class AtendimentoCadastradoException extends Exception{

	private String nomeServico;
	private String nomeAnimal;
	private LocalDate data;
	
	public AtendimentoCadastradoException(String nomeServico, String nomeAnimal, LocalDate data){
		super("O Atendimento do animal " + nomeAnimal + " no serviço " + nomeServico + " no dia " + data + " já está cadastrado!");
		this.nomeServico = nomeServico;
		this.nomeAnimal = nomeAnimal;
		this.data = data;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public LocalDate getData() {
		return data;
	}
	
}
