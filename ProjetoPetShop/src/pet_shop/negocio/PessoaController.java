package pet_shop.negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pet_shop.DAO.PessoaDAO;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.CargoInvalidoException;
import pet_shop.negocio.excecoes.CpfInvalidoException;
import pet_shop.negocio.excecoes.EmailInvalidoException;
import pet_shop.negocio.excecoes.EnderecoInvalidoException;
import pet_shop.negocio.excecoes.LoginInvalidoException;
import pet_shop.negocio.excecoes.NadaEncontradoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PessoaCadastradoException;
import pet_shop.negocio.excecoes.PessoaInexistenteException;
import pet_shop.negocio.excecoes.SenhaInvalidaException;
import pet_shop.negocio.excecoes.TelefoneInvalidoException;

public class PessoaController {
	
	private PessoaDAO repositorioPessoa;
	private static PessoaController instance;
	
	private PessoaController() {
        this.repositorioPessoa = PessoaDAO.getInstance(); 
    }
	
	public static PessoaController getInstance() {
		if(instance == null)
			instance = new PessoaController();
		
		return instance;
	}
	
	public void cadastrarCliente(Pessoa p) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
	    
		if (p != null) {
			if (!this.repositorioPessoa.existe(p)) {
				if (p.getNome() != null && !p.getNome().trim().isEmpty() && p.getNome().matches("[a-zA-Z\\s]+")) {
					if (p.getCpf() != null && !p.getCpf().trim().isEmpty() && p.getCpf().matches("[0-9]+")) {
						if (p.getEmail() != null && !p.getEmail().trim().isEmpty()) {
							if (p.getEndereco() != null && p.getEndereco().getRua() != null && p.getEndereco().getBairro() != null 
									&& p.getEndereco().getCidade() != null && p.getEndereco().getNumCasa() != null 
									&& !p.getEndereco().getRua().trim().isEmpty() && p.getEndereco().getRua().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getBairro().trim().isEmpty() && p.getEndereco().getBairro().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getCidade().trim().isEmpty() && p.getEndereco().getCidade().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getNumCasa().trim().isEmpty()) {
								if (p.getTelefone() != null && !p.getTelefone().trim().isEmpty() && p.getTelefone().matches("[0-9]+")) {
									if (p instanceof Funcionario) {
										if (((Funcionario) p).getLogin() != null) {
											if (((Funcionario) p).getSenha() != null) {
												if (((Funcionario) p).getCargo() != null) {
													this.repositorioPessoa.cadastrar(p);
													this.repositorioPessoa.salvarArquivo();
												} else {
													throw new CargoInvalidoException();
												}
											} else {
												throw new SenhaInvalidaException();
											}
										} else {
											throw new LoginInvalidoException();
										}
									} else {
										this.repositorioPessoa.cadastrar(p);
										this.repositorioPessoa.salvarArquivo();
									}
								} else {
									throw new TelefoneInvalidoException();
								}
							} else {
								throw new EnderecoInvalidoException();
							}
						} else {
							throw new EmailInvalidoException();
						}
					} else {
						throw new CpfInvalidoException();
					}
				} else {
					throw new NomeInvalidoException();
				}
			} else {
				throw new PessoaCadastradoException(p.getNome(), p.getCpf());
			}
		} else {
			throw new IllegalAccessException("Par�metro inv�lido!");
		}
		
	}
	
	public List<Pessoa> listarCliente(String nome) throws IllegalAccessException, NadaEncontradoException{
		
		List<Pessoa> lista = new ArrayList<>();
		if (nome != null) {
			if (this.repositorioPessoa.procurar(nome).size() > 0) {
				lista = this.repositorioPessoa.procurar(nome);
			} else {
				throw new NadaEncontradoException();
			}
		} else {
			throw new IllegalAccessException("Par�metro inv�lido!");
		}
		
		return lista;
	}
	
	public List<Pessoa> listarTudo() throws NadaEncontradoException {
		
		List<Pessoa> lista = new ArrayList<>();
		PessoaDAO p1 = this.repositorioPessoa;
		if (p1.listar().size() > 0) {
			lista = p1.listar();
		} else {
			throw new NadaEncontradoException();
		}
		return lista;
	}
	
	public void excluirCliente(Pessoa p) throws IllegalAccessException, PessoaInexistenteException, IOException{

		if (p != null) {
			if (this.repositorioPessoa.existe(p)) {
				PessoaDAO p1 = this.repositorioPessoa;
				p1.excluir(p);
				this.repositorioPessoa.salvarArquivo();
			} else {
				throw new PessoaInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Par�metro inv�lido!");
		}
		
	}
	
	public void alterarCliente(Pessoa p) throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException, EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException, CargoInvalidoException, PessoaInexistenteException, IOException {
		if (p != null) {
			PessoaDAO p1 = this.repositorioPessoa;
			int indice = this.repositorioPessoa.procurarID(p.getId());
			if (indice != p1.listar().size()) {
				if (p.getNome() != null && !p.getNome().trim().isEmpty() && p.getNome().matches("[a-zA-Z\\s]+")) {
					if (p.getCpf() != null && !p.getCpf().trim().isEmpty() && p.getCpf().matches("[0-9]+")) {
						if (p.getEmail() != null && !p.getEmail().trim().isEmpty()) {
							if (p.getEndereco() != null && p.getEndereco().getRua() != null && p.getEndereco().getBairro() != null 
									&& p.getEndereco().getCidade() != null && p.getEndereco().getNumCasa() != null 
									&& !p.getEndereco().getRua().trim().isEmpty() && p.getEndereco().getRua().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getBairro().trim().isEmpty() && p.getEndereco().getBairro().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getCidade().trim().isEmpty() && p.getEndereco().getCidade().matches("[a-zA-Z\\s]+")
									&& !p.getEndereco().getNumCasa().trim().isEmpty()) {
								if (p.getTelefone() != null && !p.getTelefone().trim().isEmpty() && p.getTelefone().matches("[0-9]+")) {
									if (p instanceof Funcionario) {
										if (((Funcionario) p).getLogin() != null) {
											if (((Funcionario) p).getSenha() != null) {
												if (((Funcionario) p).getCargo() != null) {
													p1.alterar(p, indice);
													this.repositorioPessoa.salvarArquivo();
												} else {
													throw new CargoInvalidoException();
												}
											} else {
												throw new SenhaInvalidaException();
											}
										} else {
											throw new LoginInvalidoException();
										}
									} else {
										p1.alterar(p, indice);
										this.repositorioPessoa.salvarArquivo();
									}
								} else {
									throw new TelefoneInvalidoException();
								}
							} else {
								throw new EnderecoInvalidoException();
							}
						} else {
							throw new EmailInvalidoException();
						}
					} else {
						throw new CpfInvalidoException();
					}
				} else {
					throw new NomeInvalidoException();
				}
			} else {
				throw new PessoaInexistenteException();
			}
		} else {
			throw new IllegalAccessException("Par�metro inv�lido!");
		}
	}
}
