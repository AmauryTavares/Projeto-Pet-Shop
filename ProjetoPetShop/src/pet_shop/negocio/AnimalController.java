package pet_shop.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.AnimalDAO;
import pet_shop.DAO.IRepositorios.IRepositorioAnimal;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.excecoes.AnimalCadastradoException;
import pet_shop.negocio.excecoes.AnimalInexistenteException;
import pet_shop.negocio.excecoes.DataInvalidaException;
import pet_shop.negocio.excecoes.DonoInvalidoException;
import pet_shop.negocio.excecoes.EspecieInvalidaException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PesoInvalidoException;
import pet_shop.negocio.excecoes.RacaInvalidaException;

public class AnimalController {
	
	private IRepositorioAnimal animalRepository;
	private static AnimalController instance;
	
	//Singleton
	private AnimalController() {
		this.animalRepository = AnimalDAO.getInstance();
	}
	
	public static AnimalController getInstance() {
		if(instance == null) {
			instance = new AnimalController();
		}
		return instance;
	}
	
	//Controle dos métodos do repositório
	public void saveAnimal(Animal animal) throws AnimalCadastradoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException, NomeInvalidoException, PesoInvalidoException, RacaInvalidaException, IOException {
		if (animal != null) {
			if (!this.animalRepository.existe(animal)) {
				if (animal.getDono() != null) {
					if (animal.getDataNascimento() != null) {
						if (animal.getEspecie() != null) {
							if (animal.getNome() != null) {
								if (animal.getPeso() > 0) {
									if (animal.getRaca() != null) {
										this.animalRepository.cadastrar(animal);
										this.animalRepository.salvarArquivo();
									} else {
										throw new RacaInvalidaException();
									}
								} else {
									throw new PesoInvalidoException();
								}
							} else {
								throw new NomeInvalidoException();
							}
						} else {
							throw new EspecieInvalidaException();
						}
					} else {
						throw new DataInvalidaException();
					}
				} else {
					throw new DonoInvalidoException();
				}
			} else {
				throw new AnimalCadastradoException(animal.getNome());
			}
		} else {
			throw new IllegalArgumentException("Parâmetro inválido!");
		}
	}
	
	public void updateAnimal(Animal newAnimal) throws RacaInvalidaException, PesoInvalidoException, DonoInvalidoException, DataInvalidaException, EspecieInvalidaException, NomeInvalidoException, AnimalInexistenteException, IOException {
		
		if (newAnimal != null) {
			AnimalDAO t1 = (AnimalDAO) this.animalRepository;
			int indice = this.animalRepository.procurarID(newAnimal.getId());
			if (indice != t1.listar().size()) {
				if (newAnimal.getDono() != null) {
					if (newAnimal.getDataNascimento() != null) {
						if (newAnimal.getEspecie() != null) {
							if (newAnimal.getNome() != null) {
								if (newAnimal.getPeso() > 0) {
									if (newAnimal.getRaca() != null) {
										t1.alterar(newAnimal, indice);
										this.animalRepository.salvarArquivo();
									} else {
										throw new RacaInvalidaException();
									}
								} else {
									throw new PesoInvalidoException();
								}
							} else {
								throw new NomeInvalidoException();
							}
						} else {
							throw new EspecieInvalidaException();
						}
					} else {
						throw new DataInvalidaException();
					}
				} else {
					throw new DonoInvalidoException();
				}
			} else {
				throw new AnimalInexistenteException();
			}
		} else {
			throw new IllegalArgumentException("Parâmetro inválido!");
		}
	}
	
	public void deleteAnimal(Animal animal) throws AnimalInexistenteException, IOException {
		
		if (animal != null) {
			if (this.animalRepository.existe(animal)) {
				AnimalDAO t1 = (AnimalDAO) this.animalRepository;
				t1.excluir(animal);
				this.animalRepository.salvarArquivo();
			} else {
				throw new AnimalInexistenteException();
			}
		} else {
			throw new IllegalArgumentException("Parâmetro inválido!");
		}
		
	}
	
	public List<Animal> findAnimal(String nome) throws IllegalAccessException, NadaEncontradoException {
		
		List<Animal> lista = new ArrayList<>();
		if (nome != null) {
			if (this.animalRepository.procurar(nome).size() > 0) {
				lista = this.animalRepository.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Parâmetro inválido!");
		}
		
		return lista;
	}
	
	public List<Animal> listarTodosAnimais() throws NadaEncontradoException {
		List<Animal> lista = new ArrayList<>();
		AnimalDAO t1 = (AnimalDAO) this.animalRepository;
		if (t1.listar().size() > 0) {
			lista = t1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		return lista;
	}

}
