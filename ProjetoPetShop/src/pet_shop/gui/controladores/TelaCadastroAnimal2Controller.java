package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Animal;

public class TelaCadastroAnimal2Controller implements Initializable {

	@FXML
	private Label labelLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtFieldNome;

	@FXML
	private TextField txtFieldPeso;

	@FXML
	private TextField txtFieldEspecie;

	@FXML
	private TextField txtFieldRaca;

	@FXML
	private DatePicker datePickerData;

	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrar() {
		try {
			
			Animal a = new Animal(TelaCadastroAnimal1Controller.clienteSelecionado, txtFieldNome.getText(), Double.parseDouble(txtFieldPeso.getText()), txtFieldEspecie.getText()
					,txtFieldRaca.getText(), datePickerData.getValue());

			fachada.saveAnimal(a);
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Animal cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenAnimais.fxml", "Sistema PetShop - Gerencimantedo de Animais");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} catch (Exception e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}

	@FXML
	public void voltar() {
		try {
			funcoes.chamarTela("../TelaCadastroAnimal1.fxml", "Sistema PetShop - Cadastro de Animal");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
	}

}
