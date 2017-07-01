package pet_shop.negocio;

import java.util.ArrayList;

import pet_shop.DAO.ProdutoDAO;
import pet_shop.negocio.beans.Produto;

public class ProdutosController {
	
	private ProdutoDAO repositorioProdutos;
	private static ProdutosController instance;
	
	private ProdutosController() {
        this.repositorioProdutos = ProdutoDAO.getInstance(); 
    }
	
	public static ProdutosController getInstance() {
		if(instance == null)
			instance = new ProdutosController();
		
		return instance;
	}
	
	//Cadastro do produto
	public void cadastrarProduto(Produto p) {
	    if (p == null) {
	      //Exceção
	    } else {
	      if (!this.existe(p)) {
	        this.repositorioProdutos.cadastrarProduto(p);
	      } 
	    }
	}
	
	//Descadastra o produto do id repassado, depois de verificar a existência do produto
	public void descadastrarProduto(long id){
		Produto p = this.repositorioProdutos.listarProduto(id);
		if(p != null){
			this.repositorioProdutos.excluirProduto(id);
		}
	}
	
	//Lista produto de acordo com o id repassado
	public Produto listarProduto(long id){
		return this.repositorioProdutos.listarProduto(id);
	}
	
	//Verifica se o produto existe
	public boolean existe(Produto p) {
	    return this.repositorioProdutos.existe(p);
	}
	
	//Exclui o produto de acordo com o id repassado
	public void excluirProduto(long id){
		this.repositorioProdutos.excluirProduto(id);
	}

	//Listar todos os produtos
	public ArrayList<Produto> listarTudoProduto(){
		return this.repositorioProdutos.listarTudo();
	}
	
	public void AlteraProduto(Produto novoProduto, long id) {
		Produto p = this.repositorioProdutos.listarProduto(id);
		if( (p != null) && (novoProduto.getNome() != null)) {
			this.repositorioProdutos.alterarProduto(novoProduto, id);
		}
	}
}
