package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Atendimento;

public class TelaCadastroAtendimento4Controller implements Initializable{
	
	@FXML
	private Label lbllLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextArea txtAreaDiagnostico;

	@FXML
	private DatePicker dpData;

	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	@FXML
	public void cadastrarAction() {
		try {
			
			Atendimento a = new Atendimento(TelaCadastroAtendimento1Controller.animalSelecionado, TelaCadastroAtendimento2Controller.funcionarioSelecionado,
					TelaCadastroAtendimento3Controller.servicoSelecionado, dpData.getValue(), txtAreaDiagnostico.getText()); 
					
			fachada.saveAtendimento(a);;
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Atendimento cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenAtendimentos.fxml", "Sistema PetShop - Gerencimantedo de Atendimentos");
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
			funcoes.chamarTela("../TelaCadastroAtendimento3.fxml", "Sistema PetShop - Cadastro de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
