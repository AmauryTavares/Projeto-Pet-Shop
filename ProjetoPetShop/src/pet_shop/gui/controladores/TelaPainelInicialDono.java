package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pet_shop.Main;

public class TelaPainelInicialDono implements Initializable{

	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnGenClientes;
	
	@FXML
	private Button btnGenServicos;
	
	@FXML
	private Button btnGenProdutos;
	
	@FXML
	private Button btnGenAnimais;
	
	@FXML
	private Button btnGenConsultas;
	
	@FXML
	private Button btnGenAtendimentos;
	
	@FXML
	private Button btnSair;
	
	@FXML
	private Button btnGenFuncionarios;
	
	@FXML
	private Button btnGenVendas;
	
	Funcoes funcoes = new Funcoes();
	
	@FXML
	public void genrenciamentoClientes() {
		try{
			funcoes.chamarTela("../TelaGenClientes.fxml", "Sistema PetShop - Gerenciamento de Clientes");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void genrenciamentoAnimais() {
		try{
			funcoes.chamarTela("../TelaGenAnimais.fxml", "Sistema PetShop - Gerenciamento de Animais");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void gerenciamentoFuncionarios() {
		try{
			funcoes.chamarTela("../TelaGenFuncionarios.fxml", "Sistema PetShop - Gerenciamento de Funcionários");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void gerenciamentoProdutos() {
		try{
			funcoes.chamarTela("../TelaGenProdutos.fxml", "Sistema PetShop - Gerenciamento de Produtos");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void gerenciamentoServicos() {
		try{
			funcoes.chamarTela("../TelaGenServicos.fxml", "Sistema PetShop - Gerenciamento de Servicos");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void gerenciamentoAtendimentos() {
		try{
			funcoes.chamarTela("../TelaGenAtendimentos.fxml", "Sistema PetShop - Gerenciamento de Atendimentos");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void voltarLogin() {
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaLogin.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Login");
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), Administrador");	
	}

}
