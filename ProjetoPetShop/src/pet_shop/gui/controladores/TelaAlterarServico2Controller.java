package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Animal;
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
	private CheckBox checkBoxSim;
	
	@FXML
	private CheckBox checkBoxNao;

	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void alterarAction() {
		
		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Serviço", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				Animal a = null;
				if (TelaAlterarServico1Controller.passou == true) {
					a = TelaAlterarServico1Controller.animalSelecionado;
				} else {
					a = TelaGenServicosController.servicoAlterar.getAnimal();
				}
				
				boolean consulta = false;
				if(checkBoxSim.isSelected()) {
					consulta = true;
				}
				
				Servico s = new Servico(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), consulta, a);

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
			checkBoxSim.setSelected(true);
			checkBoxNao.setSelected(false);
		} else {
			checkBoxSim.setSelected(false);
			checkBoxNao.setSelected(true);
		}

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		atualizarValores();
	}

}
