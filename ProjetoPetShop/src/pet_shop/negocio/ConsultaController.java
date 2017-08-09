package pet_shop.negocio;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.ConsultaDAO;
import pet_shop.DAO.IRepositorios.IRepositorioConsulta;
import pet_shop.negocio.beans.Consulta;
import pet_shop.negocio.excecoes.AnimalInexistenteException;
import pet_shop.negocio.excecoes.AtendimentoInexistenteException;
import pet_shop.negocio.excecoes.ConsultaCadastradaException;
import pet_shop.negocio.excecoes.ConsultaInexistenteException;
import pet_shop.negocio.excecoes.DataInvalidaException;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class ConsultaController {
	
	private IRepositorioConsulta agendaRepository;
	private static ConsultaController instance;
	
	//Singleton
	private ConsultaController() {
		this.agendaRepository = ConsultaDAO.getInstance();
	}
	
	public static ConsultaController getInstance() {
		if(instance == null) {
			instance = new ConsultaController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAgenda(Consulta agenda) throws IllegalAccessException, AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException, ConsultaCadastradaException, IOException {
		
		if (agenda != null) {
			if (!this.agendaRepository.existe(agenda)) {
				if (agenda.getAnimal() != null) {
					if (agenda.getAtendimento() != null) {
						if (agenda.getDataMarcada() != null) {
							Period p = Period.between(LocalDate.now(), agenda.getDataMarcada());
							if (p.getDays() >= 0 && p.getMonths() >= 0 && p.getYears() >= 0) {
								this.agendaRepository.cadastrar(agenda);
								this.agendaRepository.salvarArquivo();
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new DataInvalidaException();
						}
					} else {
						throw new AtendimentoInexistenteException();
					}
				} else {
					throw new AnimalInexistenteException();
				}
			} else {
				throw new ConsultaCadastradaException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
	}
	
	public List<Consulta> findAgenda(String nome) throws IllegalAccessException, NadaEncontradoException {
		
		List<Consulta> lista = new ArrayList<>();
		if (nome != null) {
			ConsultaDAO c1 = (ConsultaDAO) this.agendaRepository;
			if (c1.listar().size() > 0) {
				lista = c1.listar();
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
	}
	
	public void updateAgenda(Consulta newAgenda) throws IllegalAccessException, ConsultaInexistenteException, AnimalInexistenteException, AtendimentoInexistenteException, DataInvalidaException, IOException {
		
		if (newAgenda != null) {
			ConsultaDAO c1 = (ConsultaDAO) this.agendaRepository;
			int indice = this.agendaRepository.procurarID(newAgenda.getId());
			if (indice != c1.listar().size()) {
				if (newAgenda.getAnimal() != null) {
					if (newAgenda.getAtendimento() != null) {
						if (newAgenda.getDataMarcada() != null) {
							Period p = Period.between(LocalDate.now(), newAgenda.getDataMarcada());
							if (p.getDays() >= 0 && p.getMonths() >= 0 && p.getYears() >= 0) {
								c1.alterar(newAgenda);
								this.agendaRepository.salvarArquivo();
							} else {
								throw new DataInvalidaException();
							}
						} else {
							throw new DataInvalidaException();
						}
					} else {
						throw new AtendimentoInexistenteException();
					}
				} else {
					throw new AnimalInexistenteException();
				}
			} else {
				throw new ConsultaInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
			
	}
	
	public void deleteAgenda(Consulta consulta) throws IllegalAccessException, ConsultaInexistenteException, IOException {
		
		if (consulta != null) {
			if (this.agendaRepository.existe(consulta)) {
				ConsultaDAO c1 = (ConsultaDAO) this.agendaRepository;
				c1.excluir(consulta);
				this.agendaRepository.salvarArquivo();
			} else {
				throw new ConsultaInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
	}
	
	public List<Consulta> listarTodasAgendas() throws NadaEncontradoException {
		
		List<Consulta> lista = new ArrayList<>();
		ConsultaDAO c1 = (ConsultaDAO) this.agendaRepository;
		if (c1.listar().size() > 0) {
			lista = c1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		
		return lista;
	}
	
}
