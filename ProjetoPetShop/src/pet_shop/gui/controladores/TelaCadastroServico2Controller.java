package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	private CheckBox checkBoxSim;
	
	@FXML
	private CheckBox checkBoxNao;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrarAction() {
		try {
			
			boolean consulta = false;
			if(checkBoxSim.isSelected()) {
				consulta = true;
			}
			
			Servico s = new Servico(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), consulta, TelaCadastroServico1Controller.animalSelecionado);

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
	public void voltar() {
		try {
			funcoes.chamarTela("../TelaCadastroServico1.fxml", "Sistema PetShop - Cadastro de Serviço");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
