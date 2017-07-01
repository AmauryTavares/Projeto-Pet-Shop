package pet_shop.gui;

import java.io.IOException;
import java.util.Scanner;

import pet_shop.negocio.SistemaFachada;

public class GuiMedico extends GuiDono{
	SistemaFachada fachada = SistemaFachada.getInstance();

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
			switch (opcao) {
			case 1:
				super.listarTodosClientes();
				break;

			case 2:
				super.listarTodosAnimais();
				break;

			case 3:
				super.listarTodosAtendimentos();
				break;

			case 4:
				super.listarTodasAgendas();
				break;

			case 5:
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
		System.out.println("1. Listar Clientes");
		System.out.println("2. Listar Animais");
		System.out.println("3. Listar Atendimentos");
		System.out.println("4. Listar Agendas");
		System.out.println("5. Sair");
	}
	
}
