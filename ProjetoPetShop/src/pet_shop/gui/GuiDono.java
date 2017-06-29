package pet_shop.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Cliente;

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
		System.out.println("3. Gerenciamnto de Produtos");
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
}
