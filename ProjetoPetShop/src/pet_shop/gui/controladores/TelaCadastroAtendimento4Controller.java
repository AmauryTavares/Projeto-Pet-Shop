package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Atendimento;

public class TelaCadastroAtendimento4Controller implements Initializable{
	
	@FXML
	private Label lblLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextArea txtAreaDiagnostico;

	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	@FXML
	public void cadastrarAction() {
		try {
			
			Atendimento a = new Atendimento(TelaCadastroAtendimento1Controller.animalSelecionado, TelaCadastroAtendimento2Controller.funcionarioSelecionado,
					TelaCadastroAtendimento3Controller.servicoSelecionado,	LocalDate.now(), txtAreaDiagnostico.getText()); 
					
			TelaGenAtendimentosController.listaAtendimentos.add(a);
			fachada.saveAtendimento(a);
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Atendimento cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaCadastroAtendimento5.fxml", "Sistema PetShop - Carrinho de Serviços");
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
			funcoes.chamarTela("../TelaCadastroAtendimento3.fxml", "Sistema PetShop - Cadastro de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
	}

}
