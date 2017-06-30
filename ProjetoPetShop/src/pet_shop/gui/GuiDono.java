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
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.beans.Venda;

public class GuiDono {
	SistemaFachada fachada = SistemaFachada.getInstance();
	public void InicioSistema() throws IOException {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		boolean sair = false;
		while (sair == false) {   //switch do menu inicial
			menu();
			System.out.print("\nSelecione sua opção: ");
			opcao = scanner.nextInt();
			boolean sairLoop = false;
			switch (opcao) {
				case 1: 
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu cliente
						subMenuCliente();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;	
					
				case 2:
					
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu de serviços
						subMenuServicos();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;
					
				case 3: 
					
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu de produtos
						subMenuProdutos();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}					
					break;
					
				case 4: 
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu animais
						subMenuAnimais();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;	
					
				case 5:
					
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu de funcionarios
						subMenuFuncionarios();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}			
					break;
					
				case 6: 
					
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu de atendimentos
						subMenuAtendimentos();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;
					
				case 7:
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu vendas
						subMenuVendas();
						System.out.print("\nSelecione sua opção: ");
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;
					
				case 8:
					
					sairLoop = false;
					while (sairLoop == false) { // switch do submenu de agendas
						subMenuAgenda();
						System.out.print("\nSelecione sua opção: ");
						opcao = scanner.nextInt();
						switch (opcao) {
							case 1:
								cadastrarAgenda(scanner);
								break;
								
							case 2:
								alterarAgenda(scanner);
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
								System.out.println("\nOpção inexistente, tente novamente!\n");
								break;
						}
					}
					break;
					
				case 9: 
					System.out.println("\n*Sistema encerrado*\n");
					sair = true;
					break;
					
				default: 
					System.out.println("\nOpção inexistente, tente novamente!\n");
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
		System.out.println("2. Gerenciamento de Serviços");
		System.out.println("3. Gerenciamento de Produtos");
		System.out.println("4. Gerenciamento de Animais");
		System.out.println("5. Gerenciamento de Funcionários");
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
		System.out.println("\t     Gerenciamento de Serviços");
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
		System.out.println("\t     Gerenciamento de Funcionários");
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
			System.out.print("Número da casa: ");
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
		System.out.println("\tAlteração de Cliente\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Cliente> lista = fachada.listarTudo();
		Cliente alterarCliente = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Cliente c : lista) {  // lista todos os clientes do repositorio
				System.out.println(c);
			}
			
			System.out.println("\nDigite o id do cliente: ");
			long id = scanner.nextInt();
			
			alterarCliente = fachada.listarCliente(id);  
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarCliente != null) { // verifica se o cliente retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		String texto = null;
		
		if (voltar == false) {
			System.out.println("Nome atual: " + alterarCliente.getNome()); // Imprime o nome atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setNome(texto);
			}
		}
		
		
		if (voltar == false) {
			System.out.println("CPF atual: " + alterarCliente.getCpf()); // Imprime o cpf atual
			System.out.print("Novo CPF: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setCpf(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Rua atual: " + alterarCliente.getRua()); // Imprime o rua atual
			System.out.print("Nova rua: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setRua(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Bairro atual: " + alterarCliente.getBairro()); // Imprime o bairro atual
			System.out.print("Novo bairro: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setBairro(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Número da casa atual: " + alterarCliente.getNumCasa()); // Imprime o número da casa atual
			System.out.print("Novo número da casa: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setNumCasa(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Email atual: " + alterarCliente.getEmail()); // Imprime o email atual
			System.out.print("Novo email: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setEmail(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Telefone atual: " + alterarCliente.getTelefone()); // Imprime o telefone atual
			System.out.print("Novo telefone: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarCliente.setTelefone(texto);
			}
		}

		if (voltar == false) {
			fachada.AlterarCliente(alterarCliente);
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
			for (Cliente c : lista) {  // lista todos os clientes do repositorio
				System.out.println(c);
			}
			
			System.out.println("\nDigite o id do cliente: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirCliente = fachada.listarCliente(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirCliente != null) { // verifica se o cliente retornado existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta e sai do laço
						fachada.excluirCliente(id);
						System.out.println("\nCliente excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")){ // apenas sai do laço
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
		
		for (Cliente c : lista) {  // lista todos os clientes do repositorio
			System.out.println(c);
		}
		
		System.out.println("Pressione enter para continuar...");
		System.in.read();
	}
	
	private void cadastrarServico(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tCadastro de Serviços\t 0 - voltar");
		System.out.println("#################################################\n");
		
		boolean voltar = false;
		String nome = null;
		double preco = 0;
		boolean necessitaConsulta = false;
		char verificarConsulta;
		
		if(voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if(nome.equals("0")) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			System.out.print("Preço: ");
			preco = scanner.nextDouble();
			scanner.nextLine();
			if(preco == 0) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			System.out.print("Serviço necessita consulta [S/N]? ");
			verificarConsulta = scanner.nextLine().charAt(0);
			
			if(verificarConsulta == 'S' || verificarConsulta == 's') {
				necessitaConsulta = true;
			}
			if(verificarConsulta == 'N' || verificarConsulta == 'n') {
				necessitaConsulta = false;
			}
			
			if(verificarConsulta == '0') {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			Servico s = new Servico(nome, preco, necessitaConsulta);
			fachada.saveServico(s);
			System.out.println("\nServiço Cadastrado com sucesso!\n");
		}
		
	}
	
	private void alterarServico(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tAlteração de Serviço\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Servico> lista = fachada.listarTodosServicos();
		Servico alterarServico = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Servico s : lista) {  // lista todos os serviços do repositorio
				System.out.println(s);
			}
			
			System.out.println("\nDigite o id do serviço: ");
			long id = scanner.nextInt();
			
			alterarServico = fachada.findServico(id); 
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarServico != null) { // verifica se o servico retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		String texto = null;
		double preco = 0;
		
		if (voltar == false) {
			System.out.println("Nome atual: " + alterarServico.getNome()); // Imprime o nome atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarServico.setNome(texto);
			}
		}
		
		if(voltar == false) {
			System.out.println("Preço atual: " + alterarServico.getPreco()); //Imprime o preço atual
			System.out.print("Novo preço: ");
			texto = scanner.nextLine();
			
			if(texto.equals("0")) {
				voltar = true;
			} else if(!texto.equals("")) {
				preco = Double.parseDouble(texto);
				alterarServico.setPreco(preco);
			}
		}
		
		if(voltar == false) {
			System.out.println("Serviço atual necessita consulta? " + alterarServico.isConsulta()); //Imprime se o serviço atual necessita de consutla
			System.out.print("Novo serviço necessita consulta [S/N]? ");
			texto = scanner.nextLine();
			
			if(texto.equals("0")) {
				voltar = true;
			} else if(!texto.equals("")) {
				
				if(texto.charAt(0) == 'S' || texto.charAt(0) == 's') {
					alterarServico.setConsulta(true);
				}
				if(texto.charAt(0) == 'N' || texto.charAt(0) == 'n') {
					alterarServico.setConsulta(false);
				}
				
			}			
		}
		
		if (voltar == false) {
			fachada.updateServico(alterarServico);
			System.out.println("\nServiço Alterado com sucesso!\n");
		}
		
	}
	
	private void excluirServico(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\t\tExcluir Serviço\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Servico> lista = fachada.listarTodosServicos();
		Servico excluirServico = null;
		boolean sairLoop = false;
		
		while (sairLoop == false) {  
			for (Servico s : lista) {  // lista todos os serviços do repositorio
				System.out.println(s);
			}
			
			System.out.println("\nDigite o id do serviço: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirServico = fachada.findServico(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirServico != null) { // verifica se o serviço retornado existe
				
				boolean loop = false;
				while (loop == false) {					
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta e sai do laço
						fachada.deleteServico(id);
						System.out.println("\nServiço excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
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
		System.out.println("\t\tListar Serviços ");
		System.out.println("#################################################\n");
		
		ArrayList<Servico> lista = fachada.listarTodosServicos();
		
		for (Servico s : lista) {  // lista todos os servicos do repositorio
			System.out.println(s);
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
		
		if(voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
			nome = scanner.nextLine();
			if(nome.equals("0")) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			System.out.print("Preço: ");
			preco = scanner.nextDouble();
			scanner.nextLine();
			if(preco == 0) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			System.out.print("Quantidade no Estoque: ");
			qtdEstoque = scanner.nextDouble();
			scanner.nextLine();
			if(qtdEstoque == 0) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			Produto p = new Produto(nome, preco, qtdEstoque);
			fachada.cadastrarProduto(p);
			System.out.println("\nProduto Cadastrado com sucesso!\n");
		}
		
	}
	
	private void alterarProduto(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tAlteração de Produto\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Produto> lista = fachada.listarTudoProduto();
		Produto alterarProduto = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Produto p : lista) {  // lista todos os produtos do repositorio
				System.out.println(p);
			}
			
			System.out.println("\nDigite o id do produto: ");
			long id = scanner.nextInt();
			
			alterarProduto = fachada.listarProduto(id); 
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarProduto != null) { // verifica se o produto retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		String texto = null;
		double preco = 0;
		double qtdEstoque = 0;
		
		if (voltar == false) {
			System.out.println("Nome atual: " + alterarProduto.getNome()); // Imprime o nome atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarProduto.setNome(texto);
			}
		}
		
		if(voltar == false) {
			System.out.println("Preço atual: " + alterarProduto.getPreco()); //Imprime o preço atual
			System.out.print("Novo preço: ");
			texto = scanner.nextLine();
			
			if(texto.equals("0")) {
				voltar = true;
			} else if(!texto.equals("")) {
				preco = Double.parseDouble(texto);
				alterarProduto.setPreco(preco);
			}
		}
		
		if(voltar == false) {
			System.out.println("Quantidade em estoque atual: " + alterarProduto.getQtdEstoque()); //Imprime o preço atual
			System.out.print("Nova quantia em estoque: ");
			texto = scanner.nextLine();
			
			if(texto.equals("0")) {
				voltar = true;
			} else if(!texto.equals("")) {
				qtdEstoque = Double.parseDouble(texto);
				alterarProduto.setQtdEstoque(qtdEstoque);
			}
		}
		
		if (voltar == false) {
			fachada.AlteraProduto(alterarProduto);
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
			for (Produto p : lista) {  // lista todos os produtos do repositorio
				System.out.println(p);
			}
			
			System.out.println("\nDigite o id do produto: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirProduto = fachada.listarProduto(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirProduto != null) { // verifica se o produto retornado existe
				
				boolean loop = false;
				while (loop == false) {					
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta e sai do laço
						fachada.excluirProduto(id);
						System.out.println("\nProduto excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
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
		
		for (Produto p : lista) {  // lista todos os produtos do repositorio
			System.out.println(p);
		}
		
		System.out.println("Pressione enter para continuar...");
		System.in.read();
		
	}
	
	private void cadastrarFuncionario(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tCadastro de Funcionário\t 0 - voltar");
		System.out.println("#################################################\n");
		
		boolean voltar = false;
		String nome = null, cpf = null, rua = null, bairro = null, numCasa = null, email = null, telefone = null, login = null, senha = null, cargo = null;
		double salario = 0;
		
		if (voltar == false) {
			System.out.print("Nome: ");
			scanner.nextLine();
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
			System.out.print("Número da casa: ");
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
			System.out.print("Salário: ");
			salario = scanner.nextDouble();
			scanner.nextLine();
			if (salario == 0) {
				voltar = true;
			}
		}

		if (voltar == false) {
			Funcionario f = new Funcionario(nome, cpf, rua, bairro, numCasa, email, telefone, login, senha, salario, cargo);
			fachada.cadastrarFuncionario(f);
			System.out.println("\nFuncionário Cadastrado com sucesso!\n");
		}
		
	}
	
	private void alterarFuncionario(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tAlteração de Funcionário\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();
		Funcionario alterarFuncionario = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Funcionario f : lista) {  // lista todos os funcionarios do repositorio
				System.out.println(f);
			}
			
			System.out.println("\nDigite o id do funcionário: ");
			long id = scanner.nextInt();
			
			alterarFuncionario = fachada.listarFuncionario(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarFuncionario != null) { // verifica se o funcionario retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		String texto = null;
		
		if (voltar == false) {
			System.out.println("Nome atual: " + alterarFuncionario.getNome()); // Imprime o nome atual
			System.out.print("Novo nome: ");
			scanner.nextLine();
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setNome(texto);;
			}
		}
		
		
		if (voltar == false) {
			System.out.println("CPF atual: " + alterarFuncionario.getCpf()); // Imprime o cpf atual
			System.out.print("Novo CPF: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setCpf(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Rua atual: " + alterarFuncionario.getRua()); // Imprime o rua atual
			System.out.print("Nova rua: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setRua(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Bairro atual: " + alterarFuncionario.getBairro()); // Imprime o bairro atual
			System.out.print("Novo bairro: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setBairro(texto);;
			}
		}
		
		if (voltar == false) {
			System.out.println("Número da casa atual: " + alterarFuncionario.getNumCasa()); // Imprime o número da casa atual
			System.out.print("Novo número da casa: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setNumCasa(texto);;
			}
		}
		
		if (voltar == false) {
			System.out.println("Email atual: " + alterarFuncionario.getEmail()); // Imprime o email atual
			System.out.print("Novo email: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setEmail(texto);;
			}
		}
		
		if (voltar == false) {
			System.out.println("Telefone atual: " + alterarFuncionario.getTelefone()); // Imprime o telefone atual
			System.out.print("Novo telefone: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setTelefone(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Login atual: " + alterarFuncionario.getLogin()); // Imprime o login atual
			System.out.print("Novo login: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setLogin(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Senha atual: " + alterarFuncionario.getSenha()); // Imprime a senha atual
			System.out.print("Nova senha: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setSenha(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Cargo atual: " + alterarFuncionario.getCargo()); // Imprime o cargo atual
			System.out.print("Novo cargo: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setCargo(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Salário atual: " + alterarFuncionario.getSalario()); // Imprime o telefone atual
			System.out.print("Novo salário: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarFuncionario.setSalario(Double.parseDouble(texto));;
			}
		}

		if (voltar == false) {
			fachada.AlteraFuncionario(alterarFuncionario);
			System.out.println("\nFuncionário Alterado com sucesso!\n");
		}
		
	}
	
	private void excluirFuncionario(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\t\tExcluir Funcionário\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();
		Funcionario excluirFuncionario = null;
		boolean sairLoop = false;
		
		while (sairLoop == false) {  
			
			for (Funcionario f : lista) {  // lista todos os funcionarios do repositorio
				System.out.println(f);
			}
			
			System.out.println("\nDigite o id do funcionario: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirFuncionario = fachada.listarFuncionario(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirFuncionario != null) { // verifica se o funcionario retornado existe
				
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta e sai do laço
						fachada.excluirFuncionario(id);
						System.out.println("\nFuncionário excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
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
		System.out.println("\t\tListar Funcionários ");
		System.out.println("#################################################\n");
		
		ArrayList<Funcionario> lista = fachada.listarTudoFuncionario();
		
		for (Funcionario f : lista) {  // lista todos os funciona´rios do repositorio
			System.out.println(f);
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
		int dia = 0, mes = 0, ano = 0;
		String diagnostico = null;
		
		if(voltar == false) {
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			boolean sairLoop = false;
			
			while (sairLoop == false) {  
				for (Animal a : listaAnimal) {  // lista todos os animais do repositorio
					System.out.println(a);
				}
				
				System.out.println("\nDigite o id do animal: ");
				long id = scanner.nextInt();
				
				animal = fachada.findAnimal(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (animal != null) { // verifica se o animal retornado existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		if(voltar == false) {
			ArrayList<Funcionario> listaFuncionario = fachada.listarTudoFuncionario();
			boolean sairLoop = false;
			
			while (sairLoop == false) {  
				for (Funcionario f : listaFuncionario) {  // lista todos os funcionarios do repositorio
					System.out.println(f);
				}
				
				System.out.println("\nDigite o id do funcioário: ");
				long id = scanner.nextInt();
				
				funcionario = fachada.listarFuncionario(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (funcionario != null) { // verifica se o funcionario retornado existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		if(voltar == false) {
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			boolean sairLoop = false;
			
			while (sairLoop == false) {  
				for (Servico s : listaServico) {  // lista todos os servicos do repositorio
					System.out.println(s);
				}
				
				System.out.println("\nDigite o id do serviço: ");
				long id = scanner.nextInt();
				
				servico = fachada.findServico(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (servico != null) { // verifica se o serviço retornado existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		if (voltar == false) {
			System.out.print("Dia: ");
			dia = scanner.nextInt();
			scanner.nextLine();
			if (dia == 0) {
				voltar = true;
			}
		}
		
		if (voltar == false) {
			System.out.print("Mês: ");
			mes = scanner.nextInt();
			scanner.nextLine();
			if (mes == 0) {
				voltar = true;
			}
		}
		
		if (voltar == false) {
			System.out.print("Ano: ");
			ano = scanner.nextInt();
			scanner.nextLine();
			if (ano == 0) {
				voltar = true;
			}
			data = LocalDate.of(ano, mes, dia);
		}
		
		if (voltar == false) {
			System.out.print("Diagnóstico: ");
			diagnostico = scanner.nextLine();
			if (diagnostico.equals("0")) {
				voltar = true;
			}
		}
		
		if(voltar == false) {
			Atendimento a = new Atendimento(animal, funcionario, servico, data, diagnostico);
			fachada.saveAtendimento(a);
			listaAtendimentos.add(a); //****//
			System.out.println("\nAtendimento Cadastrado com sucesso!\n");
		}
		
		boolean loop = false; //****//
		while (loop == false) {
			System.out.println("\nDeseja adicionar mais um atendimento? (S/N): "); // confimação
			String verificar = null;
			verificar = scanner.nextLine();
			if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { 
				cadastrarAtendimento(scanner, listaAtendimentos);
				loop = true;
			} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
				loop = true;
			}
		}	
		
		realizarVenda(scanner, listaAtendimentos);
		
	}
	
	private void alterarAtendimento(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tAlteração de Atendimento\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Atendimento> lista = fachada.listarTodosAtendimentos();
		Atendimento alterarAtendimento = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Atendimento a : lista) {  // lista todos os atendimentos do repositorio
				System.out.println(a);
			}
			
			System.out.println("\nDigite o id do atendimento: ");
			long id = scanner.nextInt();
			
			alterarAtendimento = fachada.findAtendimento(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAtendimento != null) { // verifica se o atendimento retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		Animal animal = null;
		Funcionario funcionario = null;
		Servico servico = null;
		LocalDate data = null;
		int dia = 0, mes = 0, ano = 0;
		String diagnostico = null;
		
		if (voltar == false) {
			System.out.println("Animal atual: " + alterarAtendimento.getAnimal()); // Imprime o nome atual
			System.out.println("Novo animal: ");
			
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			sairLoop = false;
			
			while (sairLoop == false) {  
				for (Animal a : listaAnimal) {  // lista todos os animais do repositorio
					System.out.println(a);
				}
				
				System.out.println("\nDigite o id do animal: ");
				String identificador = scanner.nextLine();
				long id = Long.parseLong(identificador);
				
				animal = fachada.findAnimal(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if ((animal != null) && (!identificador.equals(""))) { // verifica se o animal retornado existe
					alterarAtendimento.setAnimal(animal);
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		
		if (voltar == false) {
			System.out.println("Funcionário atual: " + alterarAtendimento.getFuncionario()); // Imprime o cpf atual
			System.out.println("Novo Funcionário: ");
			
			ArrayList<Funcionario> listaFuncionario = fachada.listarTudoFuncionario();
			sairLoop = false;
			
			while (sairLoop == false) {  
				for (Funcionario f : listaFuncionario) {  // lista todos os funcionarios do repositorio
					System.out.println(f);
				}
				
				System.out.println("\nDigite o id do funcioário: ");
				String identificador = scanner.nextLine();
				long id = Long.parseLong(identificador);
				
				funcionario = fachada.listarFuncionario(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if ((funcionario != null) && (!identificador.equals(""))) { // verifica se o funcionario retornado existe
					alterarAtendimento.setFuncionario(funcionario);
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
			
		}
		
		if (voltar == false) {
			System.out.println("Serviço atual: " + alterarAtendimento.getServico()); // Imprime o serviço atual
			System.out.println("Nova Serviço: ");
			
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			sairLoop = false;
			
			while (sairLoop == false) {  
				for (Servico s : listaServico) {  // lista todos os servicos do repositorio
					System.out.println(s);
				}
				
				System.out.println("\nDigite o id do serviço: ");
				String identificador = scanner.nextLine();
				long id = Long.parseLong(identificador);
				
				servico = fachada.findServico(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if ((servico != null) && (!identificador.equals(""))) { // verifica se o serviço retornado existe
					alterarAtendimento.setServico(servico);
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
			
		}
		
		if (voltar == false) {
			System.out.println("Data atual: " + alterarAtendimento.getData()); // Imprime a data atual
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
				System.out.print("Mês: ");
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
			
			if((!day.equals("")) && (!month.equals("")) && (!year.equals(""))) {
				alterarAtendimento.setData(data);
			}
			
		}
		
		if (voltar == false) {
			System.out.println("Diagnóstico atual: " + alterarAtendimento.getObservacao()); // Imprime o número da casa atual
			System.out.print("Novo diagnóstico: ");
			diagnostico = scanner.nextLine();
			
			if (diagnostico.equals("0")) {
				voltar = true;
			} else if (!diagnostico.equals("")) {
				alterarAtendimento.setObservacao(diagnostico);
			}
		}

		if (voltar == false) {
			fachada.updateAtendimento(alterarAtendimento);
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
			
			for (Atendimento a : lista) {  // lista todos os atendimentos do repositorio
				System.out.println(a);
			}
			
			System.out.println("\nDigite o id do atendimento: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirAtendimento = fachada.findAtendimento(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirAtendimento != null) { // verifica se o atendimento retornado existe
				
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta e sai do laço
						fachada.deleteAtendimento(id);
						System.out.println("\nAtendimento excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
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
		
		for (Atendimento a : lista) {  // lista todos os atendimentos do repositorio
			System.out.println(a);
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
			for (Cliente c : lista) {  // lista todos os clientes do repositorio
				System.out.println(c);
			}
			
			System.out.print("\nDigite o id do cliente: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			dono = fachada.listarCliente(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
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
			System.out.print("Espécie: ");
			scanner.nextLine();
			especie = scanner.nextLine();
			if (especie.equals("0")) {
				voltar = true;
			}
		}
		
		if (voltar == false) {
			System.out.print("Raça: ");
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
		System.out.println("\tAlteração de Animal\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Cliente> lista = fachada.listarTudo();
		ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
		
		Animal alterarAnimal = null;
		boolean sairLoop = false;
		boolean voltar = false;
		boolean loop = false;
		
		while (sairLoop == false) {  
			for (Animal a : listaAnimal) {  // lista todos os animais do repositorio
				System.out.println(a);
			}
			
			System.out.print("\nDigite o id do animal: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			alterarAnimal = fachada.findAnimal(id);  
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAnimal != null) { // verifica se o animal retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		
		while (loop == false) {  
			Cliente dono = null;
			for (Cliente c : lista) {  // lista todos os clientes do repositorio
				System.out.println(c);
			}
			
			System.out.println("\nDono Atual: " + alterarAnimal.getDono().getNome());
			System.out.print("\nDigite o id do cliente: ");
			String texto = scanner.nextLine();
			
			if (!texto.equals("")) {
				dono = fachada.listarCliente(Long.parseLong(texto));
			}
				
			if (texto.equals('0')) { // verifica se a opção voltar foi acionada
				voltar = true;
				loop = true;
			} else if (texto.equals("")) {
				loop = true;
			} else if (dono != null) { // verifica se o cliente retornado existe
				alterarAnimal.setDono(dono);
				loop = true;								
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		String texto = null;
		
		if (voltar == false) {
			System.out.println("Nome atual: " + alterarAnimal.getNome()); // Imprime o nome atual
			System.out.print("Novo nome: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarAnimal.setNome(texto);
			}
		}
		
		
		if (voltar == false) {
			System.out.println("Peso atual: " + alterarAnimal.getPeso()); // Imprime o peso atual
			System.out.print("Novo peso: ");
			texto = scanner.nextLine();

			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarAnimal.setPeso(Double.parseDouble(texto.replace(',', '.')));
			}
		}
		
		if (voltar == false) {
			System.out.println("Espécie atual: " + alterarAnimal.getEspecie()); // Imprime a especie atual
			System.out.print("Nova espécie: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarAnimal.setEspecie(texto);
			}
		}
		
		if (voltar == false) {
			System.out.println("Raça atual: " + alterarAnimal.getRaca()); // Imprime a raça atual
			System.out.print("Novo raça: ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				alterarAnimal.setRaca(texto);
			}
		}
		
		if (voltar == false) {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Data de nascimento atual: " + alterarAnimal.getDataNascimento().format(fmt)); // Imprime a data de nascimento atual
			System.out.print("Novo data de nascimento(Ex: dd/mm/aaaa): ");
			texto = scanner.nextLine();
			
			if (texto.equals("0")) {
				voltar = true;
			} else if (!texto.equals("")) {
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				alterarAnimal.setDataNascimento(LocalDate.parse(texto, formato));
			}
		}

		if (voltar == false) {
			fachada.updateAnimal(alterarAnimal);
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
			for (Animal a : lista) {  // lista todos os animais do repositorio
				System.out.println(a);
			}
			
			System.out.print("\nDigite o id do animal: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirAnimal = fachada.findAnimal(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirAnimal != null) { // verifica se o animal retornado existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta e sai do laço
						fachada.deleteAnimal(id);
						System.out.println("\nAnimal excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")){ // apenas sai do laço
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
		
		for (Animal a : lista) {  // lista todos os animais do repositorio
			System.out.println(a);
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
		
		while (sairLoop == false) {  
			for (Produto p : lista) {  // lista todos os produtos do repositorio
				System.out.println(p);
			}
			System.out.println("\n* Digite '-1' para avançar * \n");
			System.out.print("\nDigite o id do produto: ");
			long id = scanner.nextInt();
			System.out.print("\nDigite a quantidade do produto: ");
			long qtd = scanner.nextInt();
			scanner.nextLine();
			
			produto = fachada.listarProduto(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} if (id == -1) {
				sairLoop = true;
			} else if (produto != null && qtd > 0 && qtd < produto.getQtdEstoque()) { // verifica se o produto retornado existe
					listaProdutos.add(produto);
					System.out.println("\nProduto adicionado!\n");
			} else {
				System.out.println("\nID inexistente ou estoque insuficiente, tente novamente!\n");
			}
		}
		

		if (voltar == false) {
			Venda venda = new Venda(GuiLogin.logado, listaAtendimentos, listaProdutos,  LocalDate.now());
			fachada.saveVenda(venda);
			System.out.println(venda);
			System.out.println("\nVenda Realizada com sucesso!\n");
		}
	}
	
	private void listarTodasVendas() throws IOException {
		System.out.println("#################################################");
		System.out.println("\t\tListar Vendas ");
		System.out.println("#################################################\n");
		
		ArrayList<Venda> lista = fachada.listarTodasVendas();
		
		for (Venda v : lista) {  // lista todas as vendas do repositorio
			System.out.println(v);
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
			for (Venda v : lista) {  // lista todos os animais do repositorio
				System.out.println(v);
			}
			
			System.out.print("\nDigite o id da venda: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirVenda = fachada.findVenda(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirVenda != null) { // verifica se a venda retornado existe
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.equals("s") || verificar.equals("S")) { // deleta e sai do laço
						fachada.deleteVenda(id);
						System.out.println("\nVenda excluído com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.equals("n") || verificar.equals("N")){ // apenas sai do laço
						loop = true;
					}
				}					
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
	}
	
	private void cadastrarAgenda(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tCadastro de Agendas\t 0 - voltar");
		System.out.println("#################################################\n");
		
		boolean voltar = false;
		
		Animal animal = null;
		LocalDate data = null;
		int dia = 0, mes = 0, ano = 0;
		ArrayList<Servico> listaServicoAgendado = new ArrayList<>();
		Servico servico = null;
		
		if(voltar == false) {
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			boolean sairLoop = false;
			
			while (sairLoop == false) {  
				for (Animal a : listaAnimal) {  // lista todos os animais do repositorio
					System.out.println(a);
				}
				
				System.out.println("\nDigite o id do animal: ");
				long id = scanner.nextInt();
				
				animal = fachada.findAnimal(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (animal != null) { // verifica se o animal retornado existe
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		if (voltar == false) {
			System.out.print("Dia: ");
			dia = scanner.nextInt();
			scanner.nextLine();
			if (dia == 0) {
				voltar = true;
			}
		}
		
		if (voltar == false) {
			System.out.print("Mês: ");
			mes = scanner.nextInt();
			scanner.nextLine();
			if (mes == 0) {
				voltar = true;
			}
		}
		
		if (voltar == false) {
			System.out.print("Ano: ");
			ano = scanner.nextInt();
			scanner.nextLine();
			if (ano == 0) {
				voltar = true;
			}
			data = LocalDate.of(ano, mes, dia);
		}
		
		if(voltar == false) {
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			boolean sairLoop = false;
			
			while (sairLoop == false) {  
				for (Servico s : listaServico) {  // lista todos os servicos do repositorio
					System.out.println(s);
				}
				
				System.out.println("\nDigite o id do serviço: ");
				long id = scanner.nextInt();
				
				servico = fachada.findServico(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (servico != null) { // verifica se o serviço retornado existe
					listaServicoAgendado.add(servico);
					
					System.out.println("\nDeseja adicionar mais um serviço? (S/N): "); // confimação
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { 
						System.out.println();
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
						sairLoop = true;
					}
					
				} else {
					System.out.println("\nID inexistente ou serviço nao necessita de uma consulta, tente novamente!\n");
				}
				
				
			}
		}
		
		if(voltar == false) {
			Agenda a = new Agenda(animal, data, listaServicoAgendado);
			fachada.saveAgenda(a);
			System.out.println("\nAgenda Cadastrada com sucesso!\n");
		}
		
	}
	
	private void alterarAgenda(Scanner scanner) {
		
		System.out.println("#################################################");
		System.out.println("\tAlteração de Agenda\t 0 - voltar");
		System.out.println("#################################################\n");
		
		ArrayList<Agenda> lista = fachada.listarTodasAgendas();
		Agenda alterarAgenda = null;
		boolean sairLoop = false;
		boolean voltar = false;
		
		while (sairLoop == false) {  
			for (Agenda a : lista) {  // lista todos as agendas do repositorio
				System.out.println(a);
			}
			
			System.out.println("\nDigite o id da agenda: ");
			long id = scanner.nextInt();
			
			alterarAgenda = fachada.findAgenda(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				voltar = true;
				sairLoop = true;
			} else if (alterarAgenda != null) { // verifica se a agenda retornado existe
				sairLoop = true;
			} else {
				System.out.println("\nID inexistente, tente novamente!\n");
			}
		}
		
		System.out.println("\n* Pressione 'Enter' para prosseguir um campo sem altera-lo *\n");
		
		Animal animal = null;
		LocalDate data = null;
		int dia = 0, mes = 0, ano = 0;
		ArrayList<Servico> listaServicoAgendado = new ArrayList<>();
		Servico servico = null;
		
		if (voltar == false) {
			System.out.println("Animal atual: " + alterarAgenda.getAnimal()); // Imprime o nome atual
			System.out.println("Novo animal: ");
			
			ArrayList<Animal> listaAnimal = fachada.listarTodosAnimais();
			sairLoop = false;
			
			while (sairLoop == false) {  
				for (Animal a : listaAnimal) {  // lista todos os animais do repositorio
					System.out.println(a);
				}
				
				System.out.println("\nDigite o id do animal: ");
				String identificador = scanner.nextLine();
				long id = Long.parseLong(identificador);
				
				animal = fachada.findAnimal(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if ((animal != null) && (!identificador.equals(""))) { // verifica se o animal retornado existe
					alterarAgenda.setAnimal(animal);
					sairLoop = true;
				} else {
					System.out.println("\nID inexistente, tente novamente!\n");
				}
			}
		}
		
		if (voltar == false) {
			System.out.println("Data atual: " + alterarAgenda.getDataMarcada()); // Imprime a data atual
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
				System.out.print("Mês: ");
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
			
			if((!day.equals("")) && (!month.equals("")) && (!year.equals(""))) {
				alterarAgenda.setDataMarcada(data);
			}
			
		}
		
		if(voltar == false) {
			System.out.println("Serviços atuais: " + alterarAgenda.getServicos());
			System.out.println("Novos serviços: ");
			
			ArrayList<Servico> listaServico = fachada.listarTodosServicos();
			sairLoop = false;
			
			while (sairLoop == false) {  
				for (Servico s : listaServico) {  // lista todos os servicos do repositorio
					System.out.println(s);
				}
				
				System.out.println("\nDigite o id do serviço: ");
				long id = scanner.nextInt();
				
				servico = fachada.findServico(id);
				
				if (id == 0) { // verifica se a opção voltar foi acionada
					voltar = true;
					sairLoop = true;
				} else if (servico != null) { // verifica se o serviço retornado existe
					listaServicoAgendado.add(servico);
					
					System.out.println("\nDeseja adicionar mais um serviço? (S/N): "); // confimação
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { 
						System.out.println();
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
						sairLoop = true;
					}
					
				} else {
					System.out.println("\nID inexistente ou serviço nao necessita de uma consulta, tente novamente!\n");
				}
			}			
		}
		
		if(voltar == false) {
			alterarAgenda.setServicos(listaServicoAgendado);
			fachada.updateAgenda(alterarAgenda);
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
			
			for (Agenda a : lista) {  // lista todos as agendas do repositorio
				System.out.println(a);
			}
			
			System.out.println("\nDigite o id da agenda: ");
			long id = scanner.nextInt();
			scanner.nextLine();
			
			excluirAgenda = fachada.findAgenda(id);
			
			if (id == 0) { // verifica se a opção voltar foi acionada
				sairLoop = true;
			} else if (excluirAgenda != null) { // verifica se o atendimento retornado existe
				
				boolean loop = false;
				while (loop == false) {
					System.out.println("\nConfimar (S/N): "); // confimação do delete
					String verificar = null;
					verificar = scanner.nextLine();
					if (verificar.charAt(0) == 'S' || verificar.charAt(0) == 's') { // deleta e sai do laço
						fachada.deleteAgenda(id);
						System.out.println("\nAgenda excluída com sucesso!\n");
						loop = true;
						sairLoop = true;
					} else if (verificar.charAt(0) == 'N' || verificar.charAt(0) == 'n'){ // apenas sai do laço
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
		
		for (Agenda a : lista) {  // lista todos as agendas do repositorio
			System.out.println(a);
		}
		
		System.out.println("Pressione enter para continuar...");
		System.in.read();
		
	}
	
}
