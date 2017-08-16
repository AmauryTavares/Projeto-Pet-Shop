package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Servico;

public class TelaCadastroServico2Controller implements Initializable {
	
	@FXML
	private Label lbllLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtFieldNome;

	@FXML
	private TextField txtFieldPreco;

	@FXML
	private RadioButton rdButtonSim;
	
	@FXML
	private RadioButton rdButtonNao;
	
	@FXML
	private ToggleGroup Consulta;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrarAction() {
		try {
			
			boolean consulta = false;
			RadioButton selectedRadioButton = (RadioButton) Consulta.getSelectedToggle();
			if(selectedRadioButton.getText().equals("Sim")) {
				consulta = true;
			}
			
			Servico s = new Servico(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), consulta);
			System.out.println(s);
			fachada.saveServico(s);
			
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Serviço cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenServicos.fxml", "Sistema PetShop - Gerencimantedo de Serviços");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} catch (Exception e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}

	@FXML
	public void voltarAction() {
		try {
			funcoes.chamarTela("../TelaCadastroServico1.fxml", "Sistema PetShop - Cadastro de Serviço");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbllLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
	}

}
