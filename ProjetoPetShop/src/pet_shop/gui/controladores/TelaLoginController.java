package pet_shop.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Funcionario;
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
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	public static Funcionario logado;
	Funcoes funcoes = new Funcoes();
	
	@FXML
	private void login(ActionEvent e) throws IOException {
		if (txtFieldLogin.getText().equals("admin") && passFieldSenha.getText().equals("1234")) {
			try{
				logado = (Funcionario) fachada.listarTudo().get(1);
				funcoes.chamarTela("../TelaMenu.fxml", "Sistema PetShop - Painel Inicial");
			} catch (Exception exc) {
				exc.printStackTrace();
			}			
		} else {
			funcoes.alerta(AlertType.ERROR, "Erro", "Erro no login", "Login ou senha incorreto!");
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
