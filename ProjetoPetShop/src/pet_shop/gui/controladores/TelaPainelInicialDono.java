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
import javafx.stage.Screen;
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
	
	@FXML
	public void genrenciamentoClientes() {
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenClientes.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Clientes");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void genrenciamentoAnimais() {
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenAnimais.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Animais");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
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
