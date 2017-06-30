package pet_shop.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Funcionario;

public class GuiLogin {
	static Funcionario logado = null;
	public void login() throws IOException {
		SistemaFachada fachada = SistemaFachada.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		Funcionario f = new Funcionario("Amaury Tavares", "11111111111", "Rua A", "Bairro B", "amaury@hotmail.com", "35"
				, "9998855663", "amaury.tavares", "123456", 800.00, "Dono"); // usuario dono *teste
		fachada.cadastrarFuncionario(f);
		
		boolean login = false;
		
		while (login == false) {
			System.out.println("#################################################");
			System.out.println("\t\t   Pet Shop");
			System.out.println("#################################################\n");
			
			System.out.print("Login: ");
			String loginCampo = scanner.nextLine();
			System.out.print("Senha: ");
			String senhaCampo = scanner.nextLine();
			
			ArrayList<Funcionario> listaFuncionarios = fachada.listarTudoFuncionario();
			boolean achou = false;
			
			for (int i = 0; i < listaFuncionarios.size() && achou == false; i++) {
				if (loginCampo.equalsIgnoreCase(listaFuncionarios.get(i).getLogin()) && senhaCampo.equals(listaFuncionarios.get(i).getSenha())) {
					logado = listaFuncionarios.get(i);
					login = true;
					achou = true;
				}
			}
			
			if (achou == false) {
				System.out.println("\nLogin ou senha incorreto, tente novamente!\n");
			}

		}
		
		if (logado.getCargo().equals("Dono")) {
			GuiDono guiDono = new GuiDono();
			guiDono.InicioSistema();
		}
		
		scanner.close();
	}
}
