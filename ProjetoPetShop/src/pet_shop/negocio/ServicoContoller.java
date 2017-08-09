package pet_shop.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.ServicoDAO;
import pet_shop.DAO.IRepositorios.IRepositorioServico;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.AnimalInvalidoException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PrecoInvalidoException;
import pet_shop.negocio.excecoes.ServicoCadastradoException;
import pet_shop.negocio.excecoes.ServicoInexistenteException;

public class ServicoContoller 
{

	private IRepositorioServico servicoRepository;
	private static ServicoContoller instance;
	
	//Singleton
	private ServicoContoller() {
		this.servicoRepository = ServicoDAO.getInstance();
	}
	
	public static ServicoContoller getInstance() {
		if(instance == null) {
			instance = new ServicoContoller();
		}
		return instance;
	}
	
	public void saveServico(Servico servico) throws IllegalAccessException, ServicoCadastradoException, PrecoInvalidoException, NomeInvalidoException, AnimalInvalidoException, IOException {
		
		if (servico != null) {
			if (!this.servicoRepository.existe(servico)) {
				if (servico.getNome() != null) {
					if (servico.getPreco() > 0) {
						if (servico.getAnimal() != null) {
							this.servicoRepository.cadastrar(servico);
							this.servicoRepository.salvarArquivo();
						} else {
							throw new AnimalInvalidoException();
						}
					} else {
						throw new PrecoInvalidoException();
					}
				} else {
					throw new NomeInvalidoException();
				}
			} else {
				throw new ServicoCadastradoException(servico.getNome());
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
	}
	
	public void updateServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException, NomeInvalidoException, PrecoInvalidoException, AnimalInvalidoException, IOException {
		
		if (servico != null) {
			ServicoDAO s1 = (ServicoDAO) this.servicoRepository;
			int indice = this.servicoRepository.procurarID(servico.getId());
			if (indice != s1.listar().size()) {
				if (servico.getNome() != null) {
					if (servico.getPreco() > 0) {
						if (servico.getAnimal() != null) {
							s1.alterar(servico);
							this.servicoRepository.salvarArquivo();
						} else {
							throw new AnimalInvalidoException();
						}
					} else {
						throw new PrecoInvalidoException();
					}
				} else {
					throw new NomeInvalidoException();
				}
			} else {
				throw new ServicoInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
	}
	public void deleteServico(Servico servico) throws IllegalAccessException, ServicoInexistenteException, IOException {
		
		if (servico != null) {
			if (this.servicoRepository.existe(servico)) {
				ServicoDAO s1 = (ServicoDAO) this.servicoRepository;
				s1.excluir(servico);
				this.servicoRepository.salvarArquivo();
			} else {
				throw new ServicoInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
	}
	
	public List<Servico> findServico(String nome) throws IllegalAccessException, NadaEncontradoException {
		
		List<Servico> lista = new ArrayList<>();
		
		if (nome != null) {
			if (this.servicoRepository.procurar(nome).size() > 0) {
				lista = this.servicoRepository.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
		
	}
	public List<Servico> listarTodosServicos() throws NadaEncontradoException {

		List<Servico> lista = new ArrayList<>();
		ServicoDAO s1 = (ServicoDAO) this.servicoRepository;
		
		if (s1.listar().size() > 0) {
			lista = s1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		
		return lista;
	}
}
