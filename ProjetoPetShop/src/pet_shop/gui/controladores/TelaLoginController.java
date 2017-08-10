package pet_shop.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pet_shop.Main;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class TelaLoginController implements Initializable{

	@FXML
	private BorderPane bPanePainel;
	
	@FXML
	private ImageView imgViewLogo;
	
	@FXML
	private TextField txtFieldLogin;
	
	@FXML
	private PasswordField passFieldSenha;
	
	@FXML
	private Button btnSair;
	
	@FXML
	private Button btnEntrar;
	
	@FXML
	private void login(ActionEvent e) throws IOException {
		if (txtFieldLogin.getText().equals("admin") && passFieldSenha.getText().equals("1234")) {
			try{
				BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaMenu.fxml"));
				Stage newStage = new Stage();
				Scene scene = new Scene(bPane);
				newStage.setScene(scene);
				Main.myStage.hide();
				Main main = new Main();
				newStage.setTitle("Sistema PetShop - Painel Inicial");
				main.start(newStage);
			} catch (Exception exc) {
				exc.printStackTrace();
			}			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Erro no login");
			alert.setContentText("Login ou senha incorreto!");
			alert.setTitle("Erro");
			alert.showAndWait();
			txtFieldLogin.setText("");
			passFieldSenha.setText("");
		}
	}
	
	@FXML
	private void sairSistema(ActionEvent e){
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
