package pet_shop.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.VendaDAO;
import pet_shop.DAO.IRepositorios.IRepositorioVenda;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Venda;
import pet_shop.negocio.excecoes.AtendimentoInvalidoException;
import pet_shop.negocio.excecoes.ClienteInvalidoException;
import pet_shop.negocio.excecoes.DataInvalidaException;
import pet_shop.negocio.excecoes.FuncionarioInvalidoException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.PrecoInvalidoException;
import pet_shop.negocio.excecoes.ProdutoInvalidoException;
import pet_shop.negocio.excecoes.QtdProdutoInsuficienteException;
import pet_shop.negocio.excecoes.VendaInexistenteException;

public class VendaController {
	private IRepositorioVenda vendaRepository;
	private static VendaController instance;

	// Singleton
	private VendaController() {
		this.vendaRepository = VendaDAO.getInstance();
	}

	public static VendaController getInstance() {
		if (instance == null) {
			instance = new VendaController();
		}
		return instance;
	}

	public void saveVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException, IOException, NadaEncontradoException, QtdProdutoInsuficienteException {
		SistemaFachada fachada = SistemaFachada.getInstance();
		if (venda != null) {
			if (venda.getCliente() != null) {
				if (venda.getFuncionario() != null) {
					if (venda.getAtendimentos() != null) {
						if (venda.getProdutos() != null) {
							List<Produto> pLista = fachada.listarTudoProduto();
							for (Produto p : venda.getProdutos()) {
								for (Produto produtoLista : pLista) {
									if (p.getNome().equals(produtoLista.getNome()) 
											&& p.getQtdEstoque() > produtoLista.getQtdEstoque()) {
										throw new QtdProdutoInsuficienteException(p.getNome());
									}
								}
							}
							
							for (Produto p : venda.getProdutos()) {
								for (Produto produtoLista : pLista) {
									if (p.getNome().equals(produtoLista.getNome())) {
										produtoLista.setQtdEstoque(produtoLista.getQtdEstoque() - p.getQtdEstoque());
									}
								}
							}
							
							if (venda.getData() != null) {
								if (venda.getValorTotal() > 0) {
									this.vendaRepository.cadastrar(venda);
									this.vendaRepository.salvarArquivo();
								} else {
									throw new PrecoInvalidoException();
								}
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new ProdutoInvalidoException();
						}
					} else {
						throw new AtendimentoInvalidoException();
					}
				} else {
					throw new FuncionarioInvalidoException();
				}
			} else {
				throw new ClienteInvalidoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}

	}

	public void updateVenda(Venda venda) throws IllegalAccessException, ClienteInvalidoException, FuncionarioInvalidoException, AtendimentoInvalidoException, ProdutoInvalidoException, DataInvalidaException, PrecoInvalidoException, IOException {
		
		if (venda != null) {
			if (venda.getCliente() != null) {
				if (venda.getFuncionario() != null) {
					if (venda.getAtendimentos() != null) {
						if (venda.getProdutos() != null) {
							if (venda.getData() != null) {
								if (venda.getValorTotal() > 0) {
									VendaDAO v1 = (VendaDAO) this.vendaRepository;
									int indice = this.vendaRepository.procurarID(venda.getId());
									v1.alterar(venda, indice);
									this.vendaRepository.salvarArquivo();
								} else {
									throw new PrecoInvalidoException();
								}
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new ProdutoInvalidoException();
						}
					} else {
						throw new AtendimentoInvalidoException();
					}
				} else {
					throw new FuncionarioInvalidoException();
				}
			} else {
				throw new ClienteInvalidoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}

	}

	public void deleteVenda(Venda venda) throws IllegalAccessException, VendaInexistenteException, IOException {
		
		if (venda != null) {
			if (this.vendaRepository.existe(venda)) {
				VendaDAO v1 = (VendaDAO) this.vendaRepository;
				v1.excluir(venda);
				this.vendaRepository.salvarArquivo();
			} else {
				throw new VendaInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}

	}

	public List<Venda> findVenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		
		List<Venda> lista = new ArrayList<>();
		if (nome != null) {
			if (this.vendaRepository.procurar(nome).size() > 0) {
				lista = this.vendaRepository.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
	}

	public List<Venda> listarTodasVendas() throws NadaEncontradoException {

		List<Venda> lista = new ArrayList<>();
		VendaDAO v1 = (VendaDAO) this.vendaRepository;
		if (v1.listar().size() > 0) {
			lista = v1.listar();
		} else {
			throw new NadaEncontradoException();			
		}
		 
		return lista;
	}
}
