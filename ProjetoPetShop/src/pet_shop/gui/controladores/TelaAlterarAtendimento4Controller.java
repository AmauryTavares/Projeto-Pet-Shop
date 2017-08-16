package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAlterarAtendimento4Controller implements Initializable {
	
	@FXML
	private Label lblLogin;

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
	public void alterarAction() {
		
		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Atendimento", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				Animal a = null;
				if (TelaAlterarAtendimento1Controller.passou == true) {
					a = TelaAlterarAtendimento1Controller.animalSelecionado;
				} else {
					a = TelaGenAtendimentosController.atendimentoAlterar.getAnimal();
				}
				
				Funcionario f = null;
				if (TelaAlterarAtendimento2Controller.passou == true) {
					f = TelaAlterarAtendimento2Controller.funcionarioSelecionado;
				} else {
					f = TelaGenAtendimentosController.atendimentoAlterar.getFuncionario();
				}
				
				Servico s = null;
				if (TelaAlterarAtendimento3Controller.passou == true) {
					s = TelaAlterarAtendimento3Controller.servicoSelecionado;
				} else {
					s = TelaGenAtendimentosController.atendimentoAlterar.getServico();
				}
				
				Atendimento atendimento = new Atendimento(a, f, s, dpData.getValue(), txtAreaDiagnostico.getText());

				atendimento.setId(procurarID());

				fachada.updateAtendimento(atendimento);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Atendimento alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenAtendimentos.fxml", "Sistema PetShop - Gerencimantedo de Atendimentos");
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
			funcoes.chamarTela("../TelaCadastroAtendimento3.fxml", "Sistema PetShop - Cadastro de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Atendimento> lista =  fachada.listarTodosAtendimentos();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenAtendimentosController.atendimentoAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizarValores() {
		dpData.setValue(TelaGenAtendimentosController.atendimentoAlterar.getData());
		txtAreaDiagnostico.setText(TelaGenAtendimentosController.atendimentoAlterar.getDiagnostico());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		atualizarValores();
	}

}
