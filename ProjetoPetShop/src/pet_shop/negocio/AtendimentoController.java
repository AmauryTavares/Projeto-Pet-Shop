package pet_shop.negocio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.AtendimentoDAO;
import pet_shop.DAO.IRepositorios.IRepositorioAtendimento;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.excecoes.AnimalInexistenteException;
import pet_shop.negocio.excecoes.AtendimentoCadastradoException;
import pet_shop.negocio.excecoes.AtendimentoInexistenteException;
import pet_shop.negocio.excecoes.DataInvalidaException;
import pet_shop.negocio.excecoes.FuncionarioInvalidoException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.ObservacaoInvalidaException;
import pet_shop.negocio.excecoes.ServicoInexistenteException;

public class AtendimentoController {
	
	private IRepositorioAtendimento atendimentoRepository;
	private static AtendimentoController instance;
	
	//Singleton
	private AtendimentoController() {
		this.atendimentoRepository = AtendimentoDAO.getInstance();
	}
	
	public static AtendimentoController getInstance() {
		if(instance == null) {
			instance = new AtendimentoController();
		}
		return instance;
	}
	
	public void saveAtendimento(Atendimento atendimento) throws AtendimentoCadastradoException, IllegalAccessException, AnimalInexistenteException, FuncionarioInvalidoException, ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException, IOException {
		
		if (atendimento != null) {
			if (!this.atendimentoRepository.existe(atendimento)) {
				if (atendimento.getAnimal() != null) {
					if (atendimento.getFuncionario() != null) {
						if (atendimento.getServico() != null) {
							if (atendimento.getData() != null) {
								Period p = Period.between(LocalDate.now(), atendimento.getData());
								//p.getDays() >= 0 && p.getMonths() >= 0 && p.getYears() >= 0
								if (!p.isNegative()) {
									if (atendimento.getDiagnostico() != null) {
										this.atendimentoRepository.cadastrar(atendimento);
										this.atendimentoRepository.salvarArquivo();
									} else {
										throw new ObservacaoInvalidaException();
									}
								} else {
									throw new DataInvalidaException();
								}
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new ServicoInexistenteException();
						}
					} else {
						throw new FuncionarioInvalidoException();
					}
				} else {
					throw new AnimalInexistenteException();
				}
			} else {
				throw new AtendimentoCadastradoException(atendimento.getServico().getNome(), atendimento.getAnimal().getNome(), atendimento.getData());
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
	}
	
	public void updateAtendimento(Atendimento atendimento) throws IllegalAccessException, AtendimentoInexistenteException, AnimalInexistenteException, FuncionarioInvalidoException, ServicoInexistenteException, DataInvalidaException, ObservacaoInvalidaException, IOException {
		
		if (atendimento != null) {
			AtendimentoDAO a1 = (AtendimentoDAO) this.atendimentoRepository;
			int indice = this.atendimentoRepository.procurarID(atendimento.getId());
			if (indice != a1.listar().size()) {
				if (atendimento.getAnimal() != null) {
					if (atendimento.getFuncionario() != null) {
						if (atendimento.getServico() != null) {
							if (atendimento.getData() != null) {
								Period p = Period.between(LocalDate.now(), atendimento.getData());
								if (!p.isNegative()) {
									if (atendimento.getDiagnostico() != null) {
										a1.alterar(atendimento, indice);
										this.atendimentoRepository.salvarArquivo();
									} else {
										throw new ObservacaoInvalidaException();
									}
								} else {
									throw new DataInvalidaException();
								}
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new ServicoInexistenteException();
						}
					} else {
						throw new FuncionarioInvalidoException();
					}
				} else {
					throw new AnimalInexistenteException();
				}
			} else {
				throw new AtendimentoInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
	}
	
	public void deleteAtendimento(Atendimento atendimento) throws IllegalAccessException, AtendimentoInexistenteException, IOException {
		
		if (atendimento != null) {
			if (this.atendimentoRepository.existe(atendimento)) {
				AtendimentoDAO a1 = (AtendimentoDAO) this.atendimentoRepository;
				a1.excluir(atendimento);
				this.atendimentoRepository.salvarArquivo();
			} else {
				throw new AtendimentoInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido");
		}
		
	}
	
	public List<Atendimento> findAtendimento(String nome) throws IllegalAccessException, NadaEncontradoException {
		
		List<Atendimento> lista = new ArrayList<>();
		if (nome != null) {
			if (this.atendimentoRepository.procurar(nome).size() > 0) {
				lista = this.atendimentoRepository.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
	}
	
	public List<Atendimento> listarTodosAtendimentos() throws NadaEncontradoException {
		
		List<Atendimento> lista = new ArrayList<>();
		AtendimentoDAO a1 = (AtendimentoDAO) this.atendimentoRepository;
		if (a1.listar().size() > 0) {
			lista = a1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		
		return lista;
	}
	
}
