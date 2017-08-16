package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAlterarServico2Controller implements Initializable {
	
	@FXML
	private Label lblLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnAlterar;

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
	public void alterarAction() {
		
		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Serviço", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				
				boolean consulta = false;
				RadioButton checar = (RadioButton) Consulta.getSelectedToggle();
				if(checar.getText().equals("Sim")){
					consulta = true;
				}
				
				Servico s = new Servico(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), consulta);

				s.setId(procurarID());

				fachada.updateServico(s);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Serviço alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenServicos.fxml", "Sistema PetShop - Gerencimantedo de Serviços");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
			}
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
	
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Servico> lista =  fachada.listarTodosServicos();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenServicosController.servicoAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizarValores() {
		
		txtFieldNome.setText(TelaGenServicosController.servicoAlterar.getNome());
		txtFieldPreco.setText(String.valueOf(TelaGenServicosController.servicoAlterar.getPreco()));
		if(TelaGenServicosController.servicoAlterar.isConsulta()) {
			rdButtonSim.setSelected(true);
		} else {
			rdButtonNao.setSelected(true);
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		atualizarValores();
	}

}
