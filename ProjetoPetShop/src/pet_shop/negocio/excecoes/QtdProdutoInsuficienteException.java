package pet_shop.negocio.excecoes;

public class QtdProdutoInsuficienteException extends Exception {

	private String nomeProduto;
	
	public QtdProdutoInsuficienteException(String nomeProduto) {
		super("Quantidade de " + nomeProduto + " insuficiente!");
		this.nomeProduto = nomeProduto;
	}
	
	public String getNomeProduto() {
		return this.nomeProduto;
	}

}
