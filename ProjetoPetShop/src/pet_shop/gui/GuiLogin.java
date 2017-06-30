package pet_shop.gui;

import java.io.IOException;
import java.time.LocalDate;
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

public class GuiLogin {
	static Funcionario logado = null;
	public void login() throws IOException {
		SistemaFachada fachada = SistemaFachada.getInstance();
		Scanner scanner = new Scanner(System.in);
		
		//Pré-cadastramento de funcionário, cliente, animal, serviço, produto, atendimento, venda.
		Funcionario f1 = new Funcionario("Amaury Tavares", "11111111111", "Rua A", "Bairro B", "35", "amaury@hotmail.com"
				, "9998855663", "amaury.tavares", "123456", 800.00, "Dono"); // usuario dono *teste
		
		Funcionario f2 = new Funcionario("Pedro nascimento", "00000000000", "Rua Sao Joao", "Bairro Novo", "20"
				, "pedro.nascimento@ufrpe.com", "00002222", "pedro.nascimento", "654321", 2000.00, "Médico");
		
		Funcionario f3 = new Funcionario("Isaque Ferreira", "99999999999", "Rua da Paz", "Bairro da Escuridão", "666"
				, "isaque.ferreira@ufrpe.com", "88111188", "isaque.ferreira", "555555", 1750.00, "Balconista");
		
		fachada.cadastrarFuncionario(f1);
		fachada.cadastrarFuncionario(f2);
		fachada.cadastrarFuncionario(f3);
		
		//clientes
		Cliente c1 = new Cliente("Karol Souza", "22222222222", "Rua Sao Jose", "Beira Rio", "10", "karol.souza@ufrpe.com", "87878989");
		Cliente c2 = new Cliente("Pedro Araujo", "12365479800", "Rua C", "Centro", "2", "pedro.araujo@ufrpe.com", "00003663");
		Cliente c3 = new Cliente("Gabi Arcajo", "33300011122", "Rua B", "Boa Vista", "666", "gabi.aracanjo@ufrpe.com", "00066654");
		
		fachada.cadastrarCliente(c1);
		fachada.cadastrarCliente(c2);
		fachada.cadastrarCliente(c3);
		
		//animais
		LocalDate d1 = LocalDate.of(2015, 7, 13);
		LocalDate d2 = LocalDate.of(2013, 2, 20);
		LocalDate d3 = LocalDate.of(2016, 12, 22);
		LocalDate d4 = LocalDate.of(2014, 6, 30);		
		
		Animal a[] = new Animal[4];
		a[0] = new Animal(c1, "Bob", 13.5, "Cachorro", "Labrador", d1);
		a[1] = new Animal(c1, "Leci", 15.0, "Cachorro", "Pit Bull", d2);
		a[2] = new Animal(c2, "Juca", 0.3, "Hamster", "Anão Chinês", d3);
		a[3] = new Animal(c3, "Tom", 3.0, "Gato", "Persa", d4);
		
		fachada.saveAnimal(a[0]);
		fachada.saveAnimal(a[1]);
		fachada.saveAnimal(a[2]);
		fachada.saveAnimal(a[3]);
		
		//serviços e produtos
		Servico s1 = new Servico("Tosa", 60.0, false);
		Servico s2 = new Servico("Banho", 80.0, false);
		Servico s3 = new Servico("Raio-X", 70.0, true);
		
		fachada.saveServico(s1);
		fachada.saveServico(s2);
		fachada.saveServico(s3);
		
		Produto p1 = new Produto("Shampoo", 13.50, 300);
		Produto p2 = new Produto("Ração Golden", 80.0, 170);
		Produto p3 = new Produto("Coleira", 22.0, 200);
		
		fachada.cadastrarProduto(p1);
		fachada.cadastrarProduto(p2);
		fachada.cadastrarProduto(p3);
		
		//atendimento
		Atendimento a1 = new Atendimento(a[1], f2, s3, LocalDate.now(), "Nenhum osso do paciente está danificado.");
		Atendimento a2 = new Atendimento(a[3], f3, s1, LocalDate.now(), "Animal foi tosado com sucesso.");
		
		fachada.saveAtendimento(a1);
		fachada.saveAtendimento(a2);
		
		//agenda
		LocalDate d5 = LocalDate.of(2017, 7, 28);
		ArrayList<Servico> servicos = new ArrayList<>();
		servicos.add(s1);
		servicos.add(s2);
		
		Agenda agenda = new Agenda(a[1], d5, servicos);
		fachada.saveAgenda(agenda);
		
		//venda
		ArrayList<Atendimento> atd = new ArrayList<>();
		atd.add(a2);
		ArrayList<Produto> p = new ArrayList<>();
		p.add(p2);
		p.add(p3);
		
		Venda v = new Venda(f3, atd, p, LocalDate.now());
		fachada.saveVenda(v);
		
		//login
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
