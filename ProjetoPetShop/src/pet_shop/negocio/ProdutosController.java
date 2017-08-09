package pet_shop.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.ProdutoDAO;
import pet_shop.DAO.IRepositorios.IRepositorioProduto;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PrecoInvalidoException;
import pet_shop.negocio.excecoes.ProdutoCadastradoException;
import pet_shop.negocio.excecoes.ProdutoInexistenteException;
import pet_shop.negocio.excecoes.QtdEstoqueInvalidoException;

public class ProdutosController {
	
	private IRepositorioProduto repositorioProdutos;
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
	public void cadastrarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoCadastradoException, IOException {
	    if (p != null) {
	    	if (!this.repositorioProdutos.existe(p)) {
	    		if (p.getNome() != null) {
	    			if (p.getPreco() > 0) {
	    				if (p.getQtdEstoque() > 0) {
	    					this.repositorioProdutos.cadastrar(p);
	    					this.repositorioProdutos.salvarArquivo();
	    				} else {
	    					throw new QtdEstoqueInvalidoException();
	    				}
	    			} else {
	    				throw new PrecoInvalidoException();
	    			}
	    		} else {
	    			throw new NomeInvalidoException();
	    		}
	    	} else {
	    		throw new ProdutoCadastradoException(p.getNome());
	    	}
	    } else {
	    	throw new IllegalAccessException("Parâmetro inválido!");
	    }
	}
	
	//Lista produto de acordo com o nome repassado
	public List<Produto> listarProduto(String nome) throws IllegalAccessException, NadaEncontradoException{
		
		List<Produto> lista = new ArrayList<>();
		
		if (nome != null) {
			if (this.repositorioProdutos.procurar(nome).size() > 0) {
				lista = this.repositorioProdutos.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
	}
	

	public void excluirProduto(Produto p) throws IllegalAccessException, ProdutoInexistenteException, IOException{

		if (p != null) {
			if (this.repositorioProdutos.existe(p)) {
				ProdutoDAO p1 = (ProdutoDAO) this.repositorioProdutos;
				p1.excluir(p);
				this.repositorioProdutos.salvarArquivo();
			} else {
				throw new ProdutoInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
	}

	//Listar todos os produtos
	public List<Produto> listarTudoProduto() throws NadaEncontradoException{
		
		List<Produto> lista = new ArrayList<>();
		ProdutoDAO p1 = (ProdutoDAO) this.repositorioProdutos;
		if (p1.listar().size() > 0) {
			lista = p1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		return lista;
	}
	
	public void alterarProduto(Produto p) throws IllegalAccessException, NomeInvalidoException, PrecoInvalidoException, QtdEstoqueInvalidoException, ProdutoInexistenteException, IOException {
		
		if (p != null) {
			ProdutoDAO p1 = (ProdutoDAO) this.repositorioProdutos;
			int indice = this.repositorioProdutos.procurarID(p.getId());
	    	if (indice != p1.listar().size()) {
	    		if (p.getNome() != null) {
	    			if (p.getPreco() > 0) {
	    				if (p.getQtdEstoque() > 0) {
	    					p1.alterar(p);
	    					this.repositorioProdutos.salvarArquivo();
	    				} else {
	    					throw new QtdEstoqueInvalidoException();
	    				}
	    			} else {
	    				throw new PrecoInvalidoException();
	    			}
	    		} else {
	    			throw new NomeInvalidoException();
	    		}
	    	} else {
	    		throw new ProdutoInexistenteException();
	    	}
	    } else {
	    	throw new IllegalAccessException("Parâmetro inválido!");
	    }
		
	}
}
