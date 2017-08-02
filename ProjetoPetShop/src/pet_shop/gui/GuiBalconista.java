package pet_shop.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pet_shop.negocio.IFachada;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Servico;

public class GuiBalconista extends GuiDono{
	IFachada fachada = SistemaFachada.getInstance();

	@Override
	public void InicioSistema() throws IOException {
		System.out.println("\n* Bem vindo, " + GuiLogin.logado.getNome() + "! *\n");
		Scanner scanner = new Scanner(System.in);
		int opcao;
		boolean sair = false;
		while (sair == false) { // switch do menu inicial
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
						super.cadastrarCliente(scanner);
						break;

					case 2:
						super.alterarCliente(scanner);
						break;

					case 3:
						super.excluirCliente(scanner);
						break;

					case 4:
						super.listarTodosClientes();
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
					super.subMenuServicos();
					System.out.print("\nSelecione sua opção: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						super.cadastrarServico(scanner);
						break;

					case 2:
						super.alterarServico(scanner);
						break;

					case 3:
						super.excluirServico(scanner);
						break;

					case 4:
						super.listarTodosServicos();
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
					super.subMenuProdutos();
					System.out.print("\nSelecione sua opção: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						super.cadastrarProduto(scanner);
						break;

					case 2:
						super.alterarProduto(scanner);
						break;

					case 3:
						super.excluirProduto(scanner);
						break;

					case 4:
						super.listarTodosProdutos();
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
					super.subMenuAnimais();
					System.out.print("\nSelecione sua opção: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						super.cadastrarAnimal(scanner);
						break;

					case 2:
						super.alterarAnimal(scanner);
						break;

					case 3:
						super.excluirAnimal(scanner);
						break;

					case 4:
						super.listarTodosAnimais();
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
				while (sairLoop == false) { // switch do submenu de atendimentos
					super.subMenuAtendimentos();
					System.out.print("\nSelecione sua opção: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();
						super.cadastrarAtendimento(scanner, listaAtendimentos);
						break;

					case 2:
						super.alterarAtendimento(scanner);
						break;

					case 3:
						super.excluirAtendimento(scanner);
						break;

					case 4:
						super.listarTodosAtendimentos();
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
				ArrayList<Atendimento> arrayListVazia = new ArrayList<>();
				super.realizarVenda(scanner, arrayListVazia);
				break;

			case 7:

				sairLoop = false;
				while (sairLoop == false) { // switch do submenu de agendas
					super.subMenuAgenda();
					System.out.print("\nSelecione sua opção: ");
					opcao = scanner.nextInt();
					switch (opcao) {
					case 1:
						ArrayList<Servico> listaServicoAgendadoVazia = new ArrayList<>();
						boolean inicio = true;
						super.cadastrarAgenda(scanner, listaServicoAgendadoVazia, inicio);
						break;

					case 2:
						ArrayList<Servico> listaServicoAgendado = new ArrayList<>();
						boolean inicio2 = true;
						super.alterarAgenda(scanner, listaServicoAgendado, inicio2);
						break;

					case 3:
						super.excluirAgenda(scanner);
						break;

					case 4:
						super.listarTodasAgendas();
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

			case 8:
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
	
	@Override
	protected void menu() {
		System.out.println("#################################################");
		System.out.println("\t\tPainel Inicial");
		System.out.println("#################################################\n");
		System.out.println("1. Gerenciamento de Clientes");
		System.out.println("2. Gerenciamento de Serviços");
		System.out.println("3. Gerenciamento de Produtos");
		System.out.println("4. Gerenciamento de Animais");
		System.out.println("5. Gerenciamento de Atendimentos");
		System.out.println("6. Realizar Venda");
		System.out.println("7. Gerenciamento da Agenda");
		System.out.println("8. Sair");
	}
	
}
