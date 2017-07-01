package pet_shop.gui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Agenda;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.beans.Venda;

public class GuiDono {
	SistemaFachada fachada = SistemaFachada.getInstance();

	public void InicioSistema() throws IOException {
		System.out.println("\n* Bem vindo, " + GuiLogin.logado.getNome() + "! *\n");
		Scanner scanner = new Scanner(System.in);
		int opcao;
		boolean sair = false;
		while (sair == false) { // switch do menu inicial
			menu();
			System.out.print("\nSelecione sua op��o: ");
			opcao = scanner.nextInt();
			boolean sairLoop = false;
			switch (opcao) {
			case 1:
				sairLoop = false;
				while (sairLoop == false) { // switch do submenu cliente
					subMenuCliente();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						cadastrarCliente(scanner);
						break;

					case 2:
						alterarCliente(scanner);
						break;

					case 3:
						excluirCliente(scanner);
						break;

					case 4:
						listarTodosClientes();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 2:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de servi�os
					subMenuServicos();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						cadastrarServico(scanner);
						break;

					case 2:
						alterarServico(scanner);
						break;

					case 3:
						excluirServico(scanner);
						break;

					case 4:
						listarTodosServicos();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 3:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de produtos
					subMenuProdutos();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						cadastrarProduto(scanner);
						break;

					case 2:
						alterarProduto(scanner);
						break;

					case 3:
						excluirProduto(scanner);
						break;

					case 4:
						listarTodosProdutos();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 4:
				sairLoop = false;
				while (sairLoop == false) { // switch do submenu animais
					subMenuAnimais();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						cadastrarAnimal(scanner);
						break;

					case 2:
						alterarAnimal(scanner);
						break;

					case 3:
						excluirAnimal(scanner);
						break;

					case 4:
						listarTodosAnimais();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 5:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de funcionarios
					subMenuFuncionarios();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						cadastrarFuncionario(scanner);
						break;

					case 2:
						alterarFuncionario(scanner);
						break;

					case 3:
						excluirFuncionario(scanner);
						break;

					case 4:
						listarTodosFuncionarios();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 6:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de atendimentos
					subMenuAtendimentos();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();
						cadastrarAtendimento(scanner, listaAtendimentos);
						break;

					case 2:
						alterarAtendimento(scanner);
						break;

					case 3:
						excluirAtendimento(scanner);
						break;

					case 4:
						listarTodosAtendimentos();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 7:
				sairLoop = false;
				while (sairLoop == false) { // switch do submenu vendas
					subMenuVendas();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						ArrayList<Atendimento> arrayListVazia = new ArrayList<>();
						realizarVenda(scanner, arrayListVazia);
						break;

					case 2:
						excluirVenda(scanner);
						break;

					case 3:
						listarTodasVendas();
						break;

					case 4:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 8:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de agendas
					subMenuAgenda();
					System.out.print("\nSelecione sua op��o: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						ArrayList<Servico> listaServicoAgendadoVazia = new ArrayList<>();
						cadastrarAgenda(scanner, listaServicoAgendadoVazia);
						break;

					case 2:
						ArrayList<Servico> listaServicoAgendado = new ArrayList<>();
						alterarAgenda(scanner, listaServicoAgendado);
						break;

					case 3:
						excluirAgenda(scanner);
						break;

					case 4:
						listarTodasAgendas();
						break;

					case 5:
						sairLoop = true;
						break;

					default:
						System.out.println("\nOp��o inexistente, tente novamente!\n");
						break;
					}
				}
				break;

			case 9:
				System.out.println("\n*Sistema encerrado*\n");
				sair = true;
				break;

			default:
				System.out.println("\nOp��o inexistente, tente novamente!\n");
				break;
			}
		}
		scanner.close();
	}

	private void menu() {
		System.out.println("#################################################");
		System.out.println("\t\tPainel Inicial");
		System.out.println("#################################################\n");
		System.out.println("1. Gerenciamento de Clientes");
		System.out.println("2. Gerenciamento de Servi�os");
		System.out.println("3. Gerenciamento de Produtos");
		System.out.println("4. Gerenciamento de Animais");
		System.out.println("5. Gerenciamento de Funcion�rios");
		System.out.println("6. Gerenciamento de Atendimentos");
		System.out.println("7. Gerenciamento de Vendas");
		System.out.println("8. Gerenciamento da Agenda");
		System.out.println("9. Sair");
	}

	private void subMenuCliente() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Clientes");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuServicos() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Servi�os");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuProdutos() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Produtos");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuFuncionarios() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Funcion�rios");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuAtendimentos() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Atendimentos");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuAnimais() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Animais");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todos");
		System.out.println("5. Voltar");
	}

	private void subMenuVendas() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Vendas");
		System.out.println("#################################################\n");
		System.out.println("1. Realizar");
		System.out.println("2. Excluir");
		System.out.println("3. Listar Todos");
		System.out.println("4. Voltar");
	}

	private void subMenuAgenda() {
		System.out.println("#################################################");
		System.out.println("\t     Gerenciamento de Agendas");
		System.out.println("#################################################\n");
		System.out.println("1. Cadastrar");
		System.out.println("2. Alterar");
		System.out.println("3. Excluir");
		System.out.println("4. Listar Todas");
		System.out.println("5. Voltar");
	}

	private void cadastrarCliente(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\tCadastro de Cliente\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		String nome = null, cpf = null, rua = null, bairro = null, numCasa = null, email = null, telefone = null;

		if (voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if (nome.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("CPF: ");
			cpf = scanner.nextLine();
			if (cpf.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Rua: ");
			rua = scanner.nextLine();
			if (rua.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Bairro: ");
			bairro = scanner.nextLine();
			if (bairro.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("N�mero da casa: ");
			numCasa = scanner.nextLine();
			if (numCasa.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Email: ");
			email = scanner.nextLine();
			if (email.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Telefone: ");
			telefone = scanner.nextLine();
			if (telefone.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			Cliente c = new Cliente(nome, cpf, rua, bairro, numCasa, email, telefone);
			fachada.cadastrarCliente(c);
			System.out.println("\nCliente Cadastrado com sucesso!\n");
		}
	}

	private void alterarCliente(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\tAltera��o de Cliente\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Cliente> lista = fachada.listarTudo();
		Cliente alterarCliente = null;
		boolean sairLoop = false;
		boolean voltar = false;
		Cliente clienteAlterado = null;
		String nome = null;
		String cpf = null;
		String rua = null;
		String bairro = null;
		String numCasa = null;
		String email = null;
		String telefone = null;

		while (sairLoop == false) {
			for (Cliente c : lista) { // lista todos os clientes do repositorio
				System.out.println(c + "\n");
			}

			System.out.println("\nDigite o id do cliente: ");
			long id = scanner.nextInt();

			alterarCliente = fachada.listarCliente(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarCliente != null) { // verifica se o cliente
													// retornado existe
				nome = alterarCliente.getNome();
				cpf = alterarCliente.getCpf();
				rua = alterarCliente.getRua();
				bairro = alterarCliente.getBairro();
				numCasa = alterarCliente.getNumCasa();
				email = alterarCliente.getEmail();
				telefone = alterarCliente.getTelefone();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		String texto = null;

		if (voltar == false) {
			System.out.println("Nome atual: " + alterarCliente.getNome()); // Imprime
																			// o
																			// nome
																			// atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				nome = texto;
			}
		}

		if (voltar == false) {
			System.out.println("CPF atual: " + alterarCliente.getCpf()); // Imprime
																			// o
																			// cpf
																			// atual
			System.out.print("Novo CPF: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				cpf = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Rua atual: " + alterarCliente.getRua()); // Imprime
																			// o
																			// rua
																			// atual
			System.out.print("Nova rua: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				rua = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Bairro atual: " + alterarCliente.getBairro()); // Imprime
																				// o
																				// bairro
																				// atual
			System.out.print("Novo bairro: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				bairro = texto;
			}
		}

		if (voltar == false) {
			System.out.println("N�mero da casa atual: " + alterarCliente.getNumCasa()); // Imprime
																						// o
																						// n�mero
																						// da
																						// casa
																						// atual
			System.out.print("Novo n�mero da casa: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				numCasa = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Email atual: " + alterarCliente.getEmail()); // Imprime
																				// o
																				// email
																				// atual
			System.out.print("Novo email: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				email = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Telefone atual: " + alterarCliente.getTelefone()); // Imprime
																					// o
																					// telefone
																					// atual
			System.out.print("Novo telefone: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				telefone = texto;
			}
		}

		if (voltar == false) {
			clienteAlterado = new Cliente(nome, cpf, rua, bairro, numCasa, email, telefone);
			fachada.AlterarCliente(clienteAlterado, alterarCliente.getId());
			clienteAlterado = null;
			alterarCliente = null;
			System.out.println("\nCliente Alterado com sucesso!\n");
		}

	}

	private void excluirCliente(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\t\tExcluir Cliente\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Cliente> lista = fachada.listarTudo();
		Cliente excluirCliente = null;
		boolean sairLoop = false;

		while (sairLoop == false) {
			for (Cliente c : lista) { // lista todos os clientes do repositorio
				System.out.println(c + "\n");
			}

			System.out.println("\nDigite o id do cliente: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirCliente = fachada.listarCliente(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirCliente != null) { // verifica se o cliente
													// retornado existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta
																			// e
																			// sai
																			// do
																			// la�o
						fachada.excluirCliente(id);
						System.out.println("\nCliente exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")) { // apenas
																					// sai
																					// do
																					// la�o
						loop = true;
					}
				}
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
	}

	private void listarTodosClientes() throws IOException {
		System.out.println("#################################################");
		System.out.println("\t\tListar Clientes ");
		System.out.println("#################################################\n");

		ArrayList<Cliente> lista = fachada.listarTudo();

		for (Cliente c : lista) { // lista todos os clientes do repositorio
			System.out.println(c + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();
	}

	private void cadastrarServico(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tCadastro de Servi�os\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		String nome = null;
		double preco = 0;
		boolean necessitaConsulta = false;

		if (voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if (nome.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Pre�o: ");
			preco = scanner.nextDouble();
			scanner.nextLine();
			if (preco == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			boolean loop = false;
			while (loop == false) {
				System.out.print("Servi�o necessita consulta [S/N]? "); // confima��o
																		// do
																		// delete
				String verificar = null;
				verificar = scanner.nextLine();
				if (verificar.equals("s") || verificar.equals("S")) { // deleta
																		// e sai
																		// do
																		// la�o
					necessitaConsulta = true;
					loop = true;
				} else if (verificar.equals("n") || verificar.equals("N")) { // apenas
																				// sai
																				// do
																				// la�o
					necessitaConsulta = false;
					loop = true;
				}

				if (verificar.equals("0")) {
					voltar = true;
					loop = true;
				}
			}
		}
		if (voltar == false) {
			Servico s = new Servico(nome, preco, necessitaConsulta);
			fachada.saveServico(s);
			System.out.println("\nServi�o Cadastrado com sucesso!\n");
		}

	}

	private void alterarServico(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tAltera��o de Servi�o\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Servico> lista = fachada.listarTodosServicos();
		Servico alterarServico = null;
		boolean sairLoop = false;
		boolean voltar = false;
		String nome = null;
		boolean consulta = false;
		double preco = 0;
		Servico servicoAlterado = null;

		while (sairLoop == false) {
			for (Servico s : lista) { // lista todos os servi�os do repositorio
				System.out.println(s + "\n");
			}

			System.out.println("\nDigite o id do servi�o: ");
			long id = scanner.nextInt();

			alterarServico = fachada.findServico(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarServico != null) { // verifica se o servico
													// retornado existe
				nome = alterarServico.getNome();
				preco = alterarServico.getPreco();
				consulta = alterarServico.isConsulta();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		String texto = null;

		if (voltar == false) {
			System.out.println("Nome atual: " + alterarServico.getNome()); // Imprime
																			// o
																			// nome
																			// atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				nome = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Pre�o atual: R$" + String.format("%.2f", alterarServico.getPreco())); // Imprime
																										// o
																										// pre�o
																										// atual
			System.out.print("Novo pre�o: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				preco = Double.parseDouble(texto.replace(',', '.'));
			}
		}

		if (voltar == false) {
			String consultaTexto = (alterarServico.isConsulta()) ? "Sim" : "N�o";
			System.out.println("Servi�o atual necessita consulta? " + consultaTexto); // Imprime
																						// se
																						// o
																						// servi�o
																						// atual
																						// necessita
																						// de
																						// consutla

			boolean loop = false;
			while (loop == false) {
				System.out.print("Servi�o necessita consulta [S/N]? "); // confima��o
																		// do
																		// delete
				String verificar = null;
				verificar = scanner.nextLine();
				if (verificar.equals("s") || verificar.equals("S")) { // deleta
																		// e sai
																		// do
																		// la�o
					consulta = true;
					loop = true;
				} else if (verificar.equals("n") || verificar.equals("N")) { // apenas
																				// sai
																				// do
																				// la�o
					consulta = false;
					loop = true;
				}

				if (verificar.equals("0")) {
					voltar = true;
					loop = true;
				}
			}
		}

		if (voltar == false) {
			servicoAlterado = new Servico(nome, preco, consulta);
			fachada.updateServico(servicoAlterado, alterarServico.getId());
			servicoAlterado = null;
			alterarServico = null;
			System.out.println("\nServi�o Alterado com sucesso!\n");
		}

	}

	private void excluirServico(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\t\tExcluir Servi�o\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Servico> lista = fachada.listarTodosServicos();
		Servico excluirServico = null;
		boolean sairLoop = false;

		while (sairLoop == false) {
			for (Servico s : lista) { // lista todos os servi�os do repositorio
				System.out.println(s + "\n");
			}

			System.out.println("\nDigite o id do servi�o: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirServico = fachada.findServico(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirServico != null) { // verifica se o servi�o
													// retornado existe

				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();

					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta
																					// e
																					// sai
																					// do
																					// la�o
						fachada.deleteServico(id);
						System.out.println("\nServi�o exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						loop = true;
					}
				}

			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

	}

	private void listarTodosServicos() throws IOException {

		System.out.println("#################################################");
		System.out.println("\t\tListar Servi�os ");
		System.out.println("#################################################\n");

		ArrayList<Servico> lista = fachada.listarTodosServicos();

		for (Servico s : lista) { // lista todos os servicos do repositorio
			System.out.println(s + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();

	}

	private void cadastrarProduto(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tCadastro de Produtos\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		String nome = null;
		double preco = 0;
		double qtdEstoque = 0;

		if (voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if (nome.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Pre�o: ");
			preco = scanner.nextDouble();
			scanner.nextLine();
			if (preco == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Quantidade no Estoque: ");
			qtdEstoque = scanner.nextDouble();
			scanner.nextLine();
			if (qtdEstoque == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			Produto p = new Produto(nome, preco, qtdEstoque);
			fachada.cadastrarProduto(p);
			System.out.println("\nProduto Cadastrado com sucesso!\n");
		}

	}

	private void alterarProduto(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tAltera��o de Produto\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Produto> lista = fachada.listarTudoProduto();
		Produto alterarProduto = null;
		boolean sairLoop = false;
		boolean voltar = false;
		String nome = null;
		double preco = 0;
		double qtdEstoque = 0;
		Produto produtoAlterado = null;

		while (sairLoop == false) {
			for (Produto p : lista) { // lista todos os produtos do repositorio
				System.out.println(p + "\n");
			}

			System.out.println("\nDigite o id do produto: ");
			long id = scanner.nextInt();

			alterarProduto = fachada.listarProduto(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarProduto != null) { // verifica se o produto
													// retornado existe
				nome = alterarProduto.getNome();
				preco = alterarProduto.getPreco();
				qtdEstoque = alterarProduto.getQtdEstoque();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		String texto = null;

		if (voltar == false) {
			System.out.println("Nome atual: " + alterarProduto.getNome()); // Imprime
																			// o
																			// nome
																			// atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				nome = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Pre�o atual: R$" + String.format("%.2f", alterarProduto.getPreco())); // Imprime
																										// o
																										// pre�o
																										// atual
			System.out.print("Novo pre�o: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				preco = Double.parseDouble(texto.replace(',', '.'));
			}
		}

		if (voltar == false) {
			System.out.println("Quantidade em estoque atual: " + alterarProduto.getQtdEstoque()); // Imprime
																									// o
																									// pre�o
																									// atual
			System.out.print("Nova quantia em estoque: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				qtdEstoque = Double.parseDouble(texto.replace(',', '.'));
			}
		}

		if (voltar == false) {
			produtoAlterado = new Produto(nome, preco, qtdEstoque);
			fachada.AlteraProduto(produtoAlterado, alterarProduto.getId());
			produtoAlterado = null;
			alterarProduto = null;
			System.out.println("\nProduto Alterado com sucesso!\n");
		}

	}

	private void excluirProduto(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\t\tExcluir Produto\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Produto> lista = fachada.listarTudoProduto();
		Produto excluirProduto = null;
		boolean sairLoop = false;

		while (sairLoop == false) {
			for (Produto p : lista) { // lista todos os produtos do repositorio
				System.out.println(p + "\n");
			}

			System.out.println("\nDigite o id do produto: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirProduto = fachada.listarProduto(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirProduto != null) { // verifica se o produto
													// retornado existe

				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();

					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta
																					// e
																					// sai
																					// do
																					// la�o
						fachada.excluirProduto(id);
						System.out.println("\nProduto exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						loop = true;
					}
				}

			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

	}

	private void listarTodosProdutos() throws IOException {

		System.out.println("#################################################");
		System.out.println("\t\tListar Produtos ");
		System.out.println("#################################################\n");

		ArrayList<Produto> lista = fachada.listarTudoProduto();

		for (Produto p : lista) { // lista todos os produtos do repositorio
			System.out.println(p + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();

	}

	private void cadastrarFuncionario(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tCadastro de Funcion�rio\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		String nome = null, cpf = null, rua = null, bairro = null, numCasa = null, email = null, telefone = null,
				login = null, senha = null, cargo = null;
		double salario = 0;

		if (voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if (nome.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("CPF: ");
			cpf = scanner.nextLine();
			if (cpf.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Rua: ");
			rua = scanner.nextLine();
			if (rua.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Bairro: ");
			bairro = scanner.nextLine();
			if (bairro.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("N�mero da casa: ");
			numCasa = scanner.nextLine();
			if (numCasa.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Email: ");
			email = scanner.nextLine();
			if (email.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Telefone: ");
			telefone = scanner.nextLine();
			if (telefone.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Login: ");
			login = scanner.nextLine();
			if (login.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Senha: ");
			senha = scanner.nextLine();
			if (senha.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Cargo: ");
			cargo = scanner.nextLine();
			if (cargo.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Sal�rio: ");
			salario = scanner.nextDouble();
			scanner.nextLine();
			if (salario == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			Funcionario f = new Funcionario(nome, cpf, rua, bairro, numCasa, email, telefone, login, senha, salario,
					cargo);
			fachada.cadastrarFuncionario(f);
			System.out.println("\nFuncion�rio Cadastrado com sucesso!\n");
		}

	}

	private void alterarFuncionario(Scanner scanner) { /// *****////

		System.out.println("#################################################");
		System.out.println("\tAltera��o de Funcion�rio\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();
		Funcionario alterarFuncionario = null;
		boolean sairLoop = false;
		boolean voltar = false;
		String nome = null;
		String cpf = null;
		String rua = null;
		String bairro = null;
		String numCasa = null;
		String email = null;
		String telefone = null;
		String login = null;
		String senha = null;
		double salario = 0;
		String cargo = null;
		Funcionario funcionarioAlterado = null;

		while (sairLoop == false) {
			for (Funcionario f : lista) { // lista todos os funcionarios do
											// repositorio
				System.out.println(f + "\n");
			}

			System.out.println("\nDigite o id do funcion�rio: ");
			long id = scanner.nextInt();

			alterarFuncionario = fachada.listarFuncionario(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarFuncionario != null) { // verifica se o
														// funcionario retornado
														// existe
				nome = alterarFuncionario.getNome();
				cpf = alterarFuncionario.getCpf();
				rua = alterarFuncionario.getRua();
				bairro = alterarFuncionario.getBairro();
				numCasa = alterarFuncionario.getNumCasa();
				email = alterarFuncionario.getEmail();
				telefone = alterarFuncionario.getEmail();
				login = alterarFuncionario.getLogin();
				senha = alterarFuncionario.getSenha();
				salario = alterarFuncionario.getSalario();
				cargo = alterarFuncionario.getCargo();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		String texto = null;

		if (voltar == false) {
			System.out.println("Nome atual: " + alterarFuncionario.getNome()); // Imprime
																				// o
																				// nome
																				// atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				nome = texto;
			}
		}

		if (voltar == false) {
			System.out.println("CPF atual: " + alterarFuncionario.getCpf()); // Imprime
																				// o
																				// cpf
																				// atual
			System.out.print("Novo CPF: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				cpf = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Rua atual: " + alterarFuncionario.getRua()); // Imprime
																				// o
																				// rua
																				// atual
			System.out.print("Nova rua: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				rua = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Bairro atual: " + alterarFuncionario.getBairro()); // Imprime
																					// o
																					// bairro
																					// atual
			System.out.print("Novo bairro: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				bairro = texto;
			}
		}

		if (voltar == false) {
			System.out.println("N�mero da casa atual: " + alterarFuncionario.getNumCasa()); // Imprime
																							// o
																							// n�mero
																							// da
																							// casa
																							// atual
			System.out.print("Novo n�mero da casa: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				numCasa = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Email atual: " + alterarFuncionario.getEmail()); // Imprime
																					// o
																					// email
																					// atual
			System.out.print("Novo email: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				email = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Telefone atual: " + alterarFuncionario.getTelefone()); // Imprime
																						// o
																						// telefone
																						// atual
			System.out.print("Novo telefone: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				telefone = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Login atual: " + alterarFuncionario.getLogin()); // Imprime
																					// o
																					// login
																					// atual
			System.out.print("Novo login: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				login = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Senha atual: " + alterarFuncionario.getSenha()); // Imprime
																					// a
																					// senha
																					// atual
			System.out.print("Nova senha: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				senha = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Cargo atual: " + alterarFuncionario.getCargo()); // Imprime
																					// o
																					// cargo
																					// atual
			System.out.print("Novo cargo: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				cargo = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Sal�rio atual: R$" + String.format("%.2f", alterarFuncionario.getSalario())); // Imprime
																												// o
																												// telefone
																												// atual
			System.out.print("Novo sal�rio: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				salario = Double.parseDouble(texto.replace(',', '.'));
			}
		}

		if (voltar == false) {
			funcionarioAlterado = new Funcionario(nome, cpf, rua, bairro, numCasa, email, telefone, login, senha,
					salario, cargo);
			fachada.AlteraFuncionario(funcionarioAlterado, alterarFuncionario.getId());
			funcionarioAlterado = null;
			alterarFuncionario = null;
			System.out.println("\nFuncion�rio Alterado com sucesso!\n");
		}

	}

	private void excluirFuncionario(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\t\tExcluir Funcion�rio\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();
		Funcionario excluirFuncionario = null;
		boolean sairLoop = false;

		while (sairLoop == false) {

			for (Funcionario f : lista) { // lista todos os funcionarios do
											// repositorio
				System.out.println(f + "\n");
			}

			System.out.println("\nDigite o id do funcionario: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirFuncionario = fachada.listarFuncionario(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirFuncionario != null) { // verifica se o
														// funcionario retornado
														// existe

				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta
																					// e
																					// sai
																					// do
																					// la�o
						fachada.excluirFuncionario(id);
						System.out.println("\nFuncion�rio exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						loop = true;
					}
				}

			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}

		}

	}

	private void listarTodosFuncionarios() throws IOException {

		System.out.println("#################################################");
		System.out.println("\t\tListar Funcion�rios ");
		System.out.println("#################################################\n");

		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();

		for (Funcionario f : lista) { // lista todos os funciona�rios do
										// repositorio
			System.out.println(f + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();

	}

	private void cadastrarAtendimento(Scanner scanner, ArrayList<Atendimento> listaAtendimentos) {

		System.out.println("#################################################");
		System.out.println("\tCadastro de Atendimentos\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;

		Animal animal = null;
		Funcionario funcionario = null;
		Servico servico = null;
		LocalDate data = null;
		String diagnostico = null;

		if (voltar == false) {
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			boolean sairLoop = false;

			while (sairLoop == false) {
				for (Animal a : listaAnimal) { // lista todos os animais do
												// repositorio
					System.out.println(a + "\n");
				}

				System.out.println("\nDigite o id do animal: ");
				long id = scanner.nextInt();

				animal = fachada.findAnimal(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (animal != null) { // verifica se o animal retornado
												// existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			ArrayList<Funcionario> listaFuncionario = fachada.listarTudoFuncionario();
			boolean sairLoop = false;

			while (sairLoop == false) {
				for (Funcionario f : listaFuncionario) { // lista todos os
															// funcionarios do
															// repositorio
					System.out.println(f + "\n");
				}

				System.out.println("\nDigite o id do funcio�rio: ");
				long id = scanner.nextInt();

				funcionario = fachada.listarFuncionario(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (funcionario != null) { // verifica se o funcionario
													// retornado existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			boolean sairLoop = false;

			while (sairLoop == false) {
				for (Servico s : listaServico) { // lista todos os servicos do
													// repositorio
					System.out.println(s + "\n");
				}

				System.out.println("\nDigite o id do servi�o: ");
				long id = scanner.nextInt();
				scanner.nextLine();
				servico = fachada.findServico(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (servico != null) { // verifica se o servi�o retornado
												// existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		data = LocalDate.now();

		if (voltar == false) {
			if (servico.isConsulta()) {
				System.out.print("\nDiagn�stico: ");
				diagnostico = scanner.nextLine();
				if (diagnostico.equals("0")) {
					voltar = true;
				}
			} else {
				diagnostico = "Nenhuma observa��o";
			}

		}

		if (voltar == false) {
			Atendimento a = new Atendimento(animal, funcionario, servico, data, diagnostico);
			fachada.saveAtendimento(a);
			listaAtendimentos.add(a);
			System.out.println("\nAtendimento Cadastrado com sucesso!\n");
		}

		if (voltar == false) {
			boolean loop = false;
			while (loop == false) {
				System.out.println("\nDeseja adicionar mais um atendimento? (S/N): "); // confima��o
				String verificar = null;
				verificar = scanner.nextLine();
				if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') {
					cadastrarAtendimento(scanner, listaAtendimentos);
					loop = true;
				} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																						// sai
																						// do
																						// la�o
					realizarVenda(scanner, listaAtendimentos);
					loop = true;
				}
			}
		}
	}

	private void alterarAtendimento(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\tAltera��o de Atendimento\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Atendimento> lista = fachada.listarTodosAtendimentos();
		Atendimento alterarAtendimento = null;
		boolean sairLoop = false;
		boolean voltar = false;
		Animal animalAlt = null;
		Funcionario funcionarioAlt = null;
		Servico servicoAlt = null;
		LocalDate dataAlt = null;
		String diagnosticoAlt = null;
		Atendimento atendimentoAlterado = null;

		while (sairLoop == false) {
			for (Atendimento a : lista) { // lista todos os atendimentos do
											// repositorio
				System.out.println(a + "\n");
			}

			System.out.println("\nDigite o id do atendimento: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			alterarAtendimento = fachada.findAtendimento(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAtendimento != null) { // verifica se o
														// atendimento retornado
														// existe
				animalAlt = alterarAtendimento.getAnimal();
				funcionarioAlt = alterarAtendimento.getFuncionario();
				servicoAlt = alterarAtendimento.getServico();
				dataAlt = alterarAtendimento.getData();
				diagnosticoAlt = alterarAtendimento.getObservacao();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		Animal animal = null;
		Funcionario funcionario = null;
		Servico servico = null;
		String diagnostico = null;

		if (voltar == false) {
			System.out.println("Animal atual: \n" + alterarAtendimento.getAnimal() + "\n"); // Imprime
																							// o
																							// nome
																							// atual
			System.out.println("Novo animal: ");

			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			sairLoop = false;

			while (sairLoop == false) {
				for (Animal a : listaAnimal) { // lista todos os animais do
												// repositorio
					System.out.println(a + "\n");
				}

				System.out.println("\nDigite o id do animal: \n");
				String identificador = scanner.nextLine();
				long id = -1;
				if (!identificador.equals("")) {
					id = Long.parseLong(identificador);
				}

				animal = fachada.findAnimal(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (identificador.equals("")) {
					sairLoop = true;
				} else if ((animal != null) && (!identificador.equals(""))) { // verifica
																				// se
																				// o
																				// animal
																				// retornado
																				// existe
					animalAlt = animal;
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			System.out.println("Funcion�rio atual: \n" + alterarAtendimento.getFuncionario() + "\n"); // Imprime
																										// o
																										// cpf
																										// atual
			System.out.println("Novo Funcion�rio: \n");

			ArrayList<Funcionario> listaFuncionario = fachada.listarTudoFuncionario();
			sairLoop = false;

			while (sairLoop == false) {
				for (Funcionario f : listaFuncionario) { // lista todos os
															// funcionarios do
															// repositorio
					System.out.println(f + "\n");
				}

				System.out.println("\nDigite o id do funcion�rio: ");
				String identificador = scanner.nextLine();
				long id = -1;
				if (!identificador.equals("")) {
					id = Long.parseLong(identificador);
				}

				funcionario = fachada.listarFuncionario(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (identificador.equals("")) {
					sairLoop = true;
				} else if ((funcionario != null) && (!identificador.equals(""))) { // verifica
																					// se
																					// o
																					// funcionario
																					// retornado
																					// existe
					funcionarioAlt = funcionario;
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}

		}

		if (voltar == false) {
			System.out.println("Servi�o atual: \n" + alterarAtendimento.getServico() + "\n"); // Imprime
																								// o
																								// servi�o
																								// atual
			System.out.println("Nova Servi�o: \n");

			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			sairLoop = false;

			while (sairLoop == false) {
				for (Servico s : listaServico) { // lista todos os servicos do
													// repositorio
					System.out.println(s + "\n");
				}

				System.out.println("\nDigite o id do servi�o: ");
				String identificador = scanner.nextLine();
				long id = -1;
				if (!identificador.equals("")) {
					id = Long.parseLong(identificador);
				}

				servico = fachada.findServico(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (identificador.equals("")) {
					sairLoop = true;
				} else if ((servico != null) && (!identificador.equals(""))) { // verifica
																				// se
																				// o
																				// servi�o
																				// retornado
																				// existe
					servicoAlt = servico;
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}

		}

		if (voltar == false) {
			System.out.println("\nData atual: " + alterarAtendimento.getData()); // Imprime
																					// a
																					// data
																					// atual

			if (voltar == false) {
				System.out.print("Nova data (Ex DD/MM/AAAA): ");
				String dataModif = scanner.nextLine();
				if (dataModif.equals("0")) {
					voltar = true;
				} else if (!dataModif.equals("")) {
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					dataAlt = LocalDate.parse(dataModif, fmt);
				}
			}

		}

		if (voltar == false) {
			if (servicoAlt.isConsulta()) {
				System.out.println("Diagn�stico atual: " + alterarAtendimento.getObservacao()); // Imprime
																								// o
																								// n�mero
																								// da
																								// casa
																								// atual
				System.out.print("Novo diagn�stico: ");
				diagnostico = scanner.nextLine();

				if (diagnostico.equals("0")) {
					voltar = true;
				} else if (!diagnostico.equals("")) {
					diagnosticoAlt = diagnostico;
				}
			} else {
				diagnosticoAlt = "Nenhuma observa��o";
			}

		}

		if (voltar == false) {
			atendimentoAlterado = new Atendimento(animalAlt, funcionarioAlt, servicoAlt, dataAlt, diagnosticoAlt);
			fachada.updateAtendimento(atendimentoAlterado, alterarAtendimento.getId());
			atendimentoAlterado = null;
			alterarAtendimento = null;
			System.out.println("\nAtendimento Alterado com sucesso!\n");
		}

	}

	private void excluirAtendimento(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\t\tExcluir Atendimento\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Atendimento> lista = fachada.listarTodosAtendimentos();
		Atendimento excluirAtendimento = null;
		boolean sairLoop = false;

		while (sairLoop == false) {

			for (Atendimento a : lista) { // lista todos os atendimentos do
											// repositorio
				System.out.println(a + "\n");
			}

			System.out.println("\nDigite o id do atendimento: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirAtendimento = fachada.findAtendimento(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirAtendimento != null) { // verifica se o
														// atendimento retornado
														// existe

				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta
																					// e
																					// sai
																					// do
																					// la�o
						fachada.deleteAtendimento(id);
						System.out.println("\nAtendimento exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						loop = true;
					}
				}

			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}

		}

	}

	private void listarTodosAtendimentos() throws IOException {

		System.out.println("#################################################");
		System.out.println("\t\tListar Atendimentos ");
		System.out.println("#################################################\n");

		ArrayList<Atendimento> lista = fachada.listarTodosAtendimentos();

		for (Atendimento a : lista) { // lista todos os atendimentos do
										// repositorio
			System.out.println(a + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();

	}

	private void cadastrarAnimal(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\tCadastro de Animal\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		boolean sairLoop = false;
		String nome = null, especie = null, raca = null, data = null;
		double peso = 0;
		LocalDate dataNascimento = null;

		ArrayList<Cliente> lista = fachada.listarTudo();
		Cliente dono = null;

		while (sairLoop == false) {
			for (Cliente c : lista) { // lista todos os clientes do repositorio
				System.out.println(c + "\n");
			}

			System.out.print("\nDigite o id do cliente: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			dono = fachada.listarCliente(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (dono != null) { // verifica se o cliente retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.print("Nome: ");
			nome = scanner.nextLine();
			if (nome.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Peso: ");
			peso = scanner.nextDouble();
			if (peso == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Esp�cie: ");
			scanner.nextLine();
			especie = scanner.nextLine();
			if (especie.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Ra�a: ");
			raca = scanner.nextLine();
			if (raca.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			System.out.print("Data de nascimento(Ex: DD/MM/AAAA): ");
			data = scanner.nextLine();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataNascimento = LocalDate.parse(data, formato);
			if (data.equals("0")) {
				voltar = true;
			}
		}

		if (voltar == false) {
			Animal a = new Animal(dono, nome, peso, especie, raca, dataNascimento);
			fachada.saveAnimal(a);
			System.out.println("\nAnimal Cadastrado com sucesso!\n");
		}
	}

	private void alterarAnimal(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\tAltera��o de Animal\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Cliente> lista = fachada.listarTudo();
		ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();

		Animal alterarAnimal = null;
		boolean sairLoop = false;
		boolean voltar = false;
		boolean loop = false;
		Pessoa donoAlt = null;
		String nome = null;
		double peso = 0;
		String especie = null;
		String raca = null;
		LocalDate dataNascimentoAlt = null;
		Animal animalAlterado = null;

		while (sairLoop == false) {
			for (Animal a : listaAnimal) { // lista todos os animais do
											// repositorio
				System.out.println(a + "\n");
			}

			System.out.print("\nDigite o id do animal: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			alterarAnimal = fachada.findAnimal(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAnimal != null) { // verifica se o animal
												// retornado existe
				donoAlt = alterarAnimal.getDono();
				nome = alterarAnimal.getNome();
				peso = alterarAnimal.getPeso();
				especie = alterarAnimal.getEspecie();
				raca = alterarAnimal.getRaca();
				dataNascimentoAlt = alterarAnimal.getDataNascimento();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		while (loop == false) {
			Cliente dono = null;
			for (Cliente c : lista) { // lista todos os clientes do repositorio
				System.out.println(c + "\n");
			}

			System.out.println("\nDono Atual: " + alterarAnimal.getDono().getNome());
			System.out.print("\nDigite o id do cliente: ");
			String texto = scanner.nextLine();

			if (!texto.equals("")) {
				dono = fachada.listarCliente(Long.parseLong(texto));
			}

			if (texto.equals('0')) { // verifica se a op��o voltar foi acionada
				voltar = true;
				loop = true;
			} else if (texto.equals("")) {
				loop = true;
			} else if (dono != null) { // verifica se o cliente retornado existe
				donoAlt = dono;
				loop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		String texto = null;

		if (voltar == false) {
			System.out.println("Nome atual: " + alterarAnimal.getNome()); // Imprime
																			// o
																			// nome
																			// atual
			System.out.print("Novo nome: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				nome = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Peso atual: " + String.format("%.2f", alterarAnimal.getPeso()) + " kg"); // Imprime
																											// o
																											// peso
																											// atual
			System.out.print("Novo peso: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				peso = Double.parseDouble(texto.replace(',', '.'));
			}
		}

		if (voltar == false) {
			System.out.println("Esp�cie atual: " + alterarAnimal.getEspecie()); // Imprime
																				// a
																				// especie
																				// atual
			System.out.print("Nova esp�cie: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				especie = texto;
			}
		}

		if (voltar == false) {
			System.out.println("Ra�a atual: " + alterarAnimal.getRaca()); // Imprime
																			// a
																			// ra�a
																			// atual
			System.out.print("Novo ra�a: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				raca = texto;
			}
		}

		if (voltar == false) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Data de nascimento atual: " + alterarAnimal.getDataNascimento().format(fmt)); // Imprime
																												// a
																												// data
																												// de
																												// nascimento
																												// atual
			System.out.print("Novo data de nascimento(Ex: dd/mm/aaaa): ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				dataNascimentoAlt = LocalDate.parse(texto, formato);
			}
		}

		if (voltar == false) {
			animalAlterado = new Animal(donoAlt, nome, peso, especie, raca, dataNascimentoAlt);
			fachada.updateAnimal(animalAlterado, alterarAnimal.getId());
			animalAlterado = null;
			alterarAnimal = null;
			System.out.println("\nAnimal Alterado com sucesso!\n");
		}

	}

	private void excluirAnimal(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\t\tExcluir Animal\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Animal> lista = fachada.listarTodosAnimais();
		Animal excluirAnimal = null;
		boolean sairLoop = false;

		while (sairLoop == false) {
			for (Animal a : lista) { // lista todos os animais do repositorio
				System.out.println(a + "\n");
			}

			System.out.print("\nDigite o id do animal: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirAnimal = fachada.findAnimal(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirAnimal != null) { // verifica se o animal
												// retornado existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta
																			// e
																			// sai
																			// do
																			// la�o
						fachada.deleteAnimal(id);
						System.out.println("\nAnimal exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")) { // apenas
																					// sai
																					// do
																					// la�o
						loop = true;
					}
				}
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
	}

	private void listarTodosAnimais() throws IOException {
		System.out.println("#################################################");
		System.out.println("\t\tListar Animais ");
		System.out.println("#################################################\n");

		ArrayList<Animal> lista = fachada.listarTodosAnimais();

		for (Animal a : lista) { // lista todos os animais do repositorio
			System.out.println(a + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();
	}

	private void realizarVenda(Scanner scanner, ArrayList<Atendimento> listaAtendimentos) {
		System.out.println("#################################################");
		System.out.println("\t          Venda\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;
		boolean sairLoop = false;

		ArrayList<Produto> lista = fachada.listarTudoProduto();
		Produto produto = null;
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		double qtd = 0;

		while (sairLoop == false) {
			for (Produto p : lista) { // lista todos os produtos do repositorio
				System.out.println(p + "\n");
			}
			System.out.println("\n* Digite '-1' para avan�ar * \n");
			System.out.print("\nDigite o id do produto: ");
			long id = scanner.nextInt();

			if (id > 0) {
				System.out.print("\nDigite a quantidade do produto: ");
				qtd = scanner.nextInt();
			}
			scanner.nextLine();

			produto = fachada.listarProduto(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (id == -1) {
				sairLoop = true;
			} else if (produto != null && qtd > 0 && qtd < produto.getQtdEstoque()) { // verifica
																						// se
																						// o
																						// produto
																						// retornado
																						// existe

				for (int i = 1; i <= qtd; i++) { // adiciona a quantidade de
													// produtos pedida
					listaProdutos.add(produto);
				}

				System.out.println("\nProduto(s) adicionado(s)!\n");
			} else {
				System.out.println("\nID inexistente ou estoque insuficiente, tente novamente!\n");
			}
		}

		if (voltar == false && !listaAtendimentos.isEmpty() || !listaProdutos.isEmpty()) {
			Venda venda = new Venda(GuiLogin.logado, listaAtendimentos, listaProdutos, LocalDate.now());
			fachada.saveVenda(venda);
			System.out.println(venda);
			System.out.println("\nVenda Realizada com sucesso!\n");
		} else {
			System.out.println("\n* Venda n�o possui produtos ou servi�os! *\n");
		}
	}

	private void listarTodasVendas() throws IOException {
		System.out.println("#################################################");
		System.out.println("\t\tListar Vendas ");
		System.out.println("#################################################\n");

		ArrayList<Venda> lista = fachada.listarTodasVendas();

		for (Venda v : lista) { // lista todas as vendas do repositorio
			System.out.println(v + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();
	}

	private void excluirVenda(Scanner scanner) {
		System.out.println("#################################################");
		System.out.println("\t\tExcluir Venda\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Venda> lista = fachada.listarTodasVendas();
		Venda excluirVenda = null;
		boolean sairLoop = false;

		while (sairLoop == false) {
			for (Venda v : lista) { // lista todos os animais do repositorio
				System.out.println(v + "\n");
			}

			System.out.print("\nDigite o id da venda: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirVenda = fachada.findVenda(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirVenda != null) { // verifica se a venda retornado
												// existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta
																			// e
																			// sai
																			// do
																			// la�o
						fachada.deleteVenda(id);
						System.out.println("\nVenda exclu�do com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")) { // apenas
																					// sai
																					// do
																					// la�o
						loop = true;
					}
				}
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
	}

	private void cadastrarAgenda(Scanner scanner, ArrayList<Servico> listaServicoAgendado) {

		System.out.println("#################################################");
		System.out.println("\tCadastro de Agendas\t 0 - voltar");
		System.out.println("#################################################\n");

		boolean voltar = false;

		Animal animal = null;
		LocalDate data = null;
		Servico servico = null;

		if (voltar == false) {
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			boolean sairLoop = false;

			while (sairLoop == false) {
				for (Animal a : listaAnimal) { // lista todos os animais do
												// repositorio
					System.out.println(a + "\n");
				}

				System.out.println("\nDigite o id do animal: ");
				long id = scanner.nextInt();
				scanner.nextLine();

				animal = fachada.findAnimal(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (animal != null) { // verifica se o animal retornado
												// existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			boolean sairLoop = false;

			while (sairLoop == false) {
				System.out.println();
				for (Servico s : listaServico) { // lista todos os servicos do
													// repositorio
					System.out.println(s + "\n");
				}

				System.out.println("\nDigite o id do servi�o: ");
				long id = scanner.nextInt();
				scanner.nextLine();

				servico = fachada.findServico(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (servico != null) { // verifica se o servi�o retornado
												// existe
					listaServicoAgendado.add(servico);

					boolean loop = false;
					while (loop == false) {
						System.out.println("\nDeseja adicionar mais um servi�o? (S/N): "); 										
						String verificar = scanner.nextLine();
						if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { 															
							cadastrarAgenda(scanner, listaServicoAgendado);
							loop = true;
							sairLoop = true;
						} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { 
							
							if (voltar == false) {
								System.out.print("Data (Ex DD/MM/AAAA): ");
								String dataModif = scanner.nextLine();
								if (dataModif.equals("0")) {
									voltar = true;
								} else if (!dataModif.equals("")) {
									DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
									data = LocalDate.parse(dataModif, fmt);
								}
							}
							
							Agenda a = new Agenda(animal, data, listaServicoAgendado);
							fachada.saveAgenda(a);
							System.out.println("\nAgenda Cadastrada com sucesso!\n");
							sairLoop = true;
							loop = true;	
						}																			
					}
				} else {
					System.out.println("\nID inexistente ou servi�o nao necessita de uma consulta, tente novamente!\n");
				}

			}
		}

	}

	private void alterarAgenda(Scanner scanner, ArrayList<Servico> listaServicoAgendado) {

		System.out.println("#################################################");
		System.out.println("\tAltera��o de Agenda\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Agenda> lista = fachada.listarTodasAgendas();
		Agenda alterarAgenda = null;
		boolean sairLoop = false;
		boolean voltar = false;
		Animal animalAlt = null;
		LocalDate dataMarcadaAlt = null;
		ArrayList<Servico> servicosAlt = null;
		Agenda agendaAlterado = null;

		while (sairLoop == false) {
			for (Agenda a : lista) { // lista todos as agendas do repositorio
				System.out.println(a + "\n");
			}

			System.out.println("\nDigite o id da agenda: ");
			long id = scanner.nextInt();

			alterarAgenda = fachada.findAgenda(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAgenda != null) { // verifica se a agenda
												// retornado existe
				animalAlt = alterarAgenda.getAnimal();
				dataMarcadaAlt = alterarAgenda.getDataMarcada();
				servicosAlt = alterarAgenda.getServicos();
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}

		if (voltar == false) {
			System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		}

		Animal animal = null;
		LocalDate data = null;
		int dia = 0, mes = 0, ano = 0;
		Servico servico = null;

		if (voltar == false) {
			System.out.println("Animal atual: " + alterarAgenda.getAnimal()); // Imprime
																				// o
																				// nome
																				// atual
			System.out.println("Novo animal: ");

			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			sairLoop = false;

			while (sairLoop == false) {
				for (Animal a : listaAnimal) { // lista todos os animais do
												// repositorio
					System.out.println(a + "\n");
				}

				System.out.println("\nDigite o id do animal: ");
				String identificador = scanner.nextLine();
				long id = Long.parseLong(identificador);

				animal = fachada.findAnimal(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if ((animal != null) && (!identificador.equals(""))) { // verifica
																				// se
																				// o
																				// animal
																				// retornado
																				// existe
					animalAlt = animal;
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			System.out.println("Data atual: " + alterarAgenda.getDataMarcada()); // Imprime
																					// a
																					// data
																					// atual
			System.out.println("Nova Data: ");

			String day = null, month = null, year = null;

			if (voltar == false) {
				System.out.print("Dia: ");
				day = scanner.nextLine();
				dia = Integer.parseInt(day);
				if (dia == 0) {
					voltar = true;
				}
			}

			if (voltar == false) {
				System.out.print("M�s: ");
				month = scanner.nextLine();
				mes = Integer.parseInt(month);
				if (mes == 0) {
					voltar = true;
				}
			}

			if (voltar == false) {
				System.out.print("Ano: ");
				year = scanner.nextLine();
				ano = Integer.parseInt(year);
				if (ano == 0) {
					voltar = true;
				}
				data = LocalDate.of(ano, mes, dia);
			}

			if ((!day.equals("")) && (!month.equals("")) && (!year.equals(""))) {
				dataMarcadaAlt = data;
			}

		}

		if (voltar == false) {
			System.out.println("Servi�os atuais: " + alterarAgenda.getServicos());
			System.out.println("Novos servi�os: ");

			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			sairLoop = false;

			while (sairLoop == false) {
				for (Servico s : listaServico) { // lista todos os servicos do
													// repositorio
					System.out.println(s);
				}
				System.out.println("\n* Digite '-1' para avan�ar * \n");
				System.out.println("\nDigite o id do servi�o: ");
				long id = scanner.nextInt();

				servico = fachada.findServico(id);

				if (id == 0) { // verifica se a op��o voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (id == -1) {
					sairLoop = true;
				} else if (servico != null) { // verifica se o servi�o retornado
												// existe
					listaServicoAgendado.add(servico);

					System.out.println("\nDeseja adicionar mais um servi�o? (S/N): "); // confima��o
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') {
						alterarAgenda(scanner, listaServicoAgendado);
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						servicosAlt = listaServicoAgendado;
						sairLoop = true;
					}

				} else {
					System.out.println("\nID inexistente ou servi�o nao necessita de uma consulta, tente novamente!\n");
				}
			}
		}

		if (voltar == false) {
			agendaAlterado = new Agenda(animalAlt, dataMarcadaAlt, servicosAlt);
			fachada.updateAgenda(agendaAlterado, alterarAgenda.getId());
			agendaAlterado = null;
			alterarAgenda = null;
			System.out.println("\nAnimal Alterado com sucesso!\n");
		}

	}

	private void excluirAgenda(Scanner scanner) {

		System.out.println("#################################################");
		System.out.println("\t\tExcluir Agenda\t 0 - voltar");
		System.out.println("#################################################\n");

		ArrayList<Agenda> lista = fachada.listarTodasAgendas();
		Agenda excluirAgenda = null;
		boolean sairLoop = false;

		while (sairLoop == false) {

			for (Agenda a : lista) { // lista todos as agendas do repositorio
				System.out.println(a + "\n");
			}

			System.out.println("\nDigite o id da agenda: ");
			long id = scanner.nextInt();
			scanner.nextLine();

			excluirAgenda = fachada.findAgenda(id);

			if (id == 0) { // verifica se a op��o voltar foi acionada
				sairLoop = true;
			} else if (excluirAgenda != null) { // verifica se o atendimento
												// retornado existe

				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confima��o do
																// delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta
																					// e
																					// sai
																					// do
																					// la�o
						fachada.deleteAgenda(id);
						System.out.println("\nAgenda exclu�da com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n') { // apenas
																							// sai
																							// do
																							// la�o
						loop = true;
					}
				}

			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}

		}

	}

	private void listarTodasAgendas() throws IOException {

		System.out.println("#################################################");
		System.out.println("\t\tListar Agendas ");
		System.out.println("#################################################\n");

		ArrayList<Agenda> lista = fachada.listarTodasAgendas();

		for (Agenda a : lista) { // lista todos as agendas do repositorio
			System.out.println(a + "\n");
		}

		System.out.println("Pressione enter para continuar...");
		System.in.read();

	}

}
