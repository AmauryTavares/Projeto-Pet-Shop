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

public class TelaPainelInicialMedico implements Initializable{

	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnGenAnimais;
	
	@FXML
	private Button btnGenAtendimentos;
	
	@FXML
	private Button btnSair;
	
	Funcoes funcoes = new Funcoes();
	
	@FXML
	public void genrenciamentoAnimais() {
		try{
			funcoes.chamarTela("../TelaGenAnimaisMedico.fxml", "Sistema PetShop - Gerenciamento de Animais");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void gerenciamentoAtendimentos() {
		try{
			funcoes.chamarTela("../TelaGenAtendimentosMedico.fxml", "Sistema PetShop - Gerenciamento de Atendimentos");
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
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome());	
	}
	
}
