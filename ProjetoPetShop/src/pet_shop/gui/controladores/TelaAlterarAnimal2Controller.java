package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAlterarAnimal2Controller implements Initializable {

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
	public void alterar() {
		
		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Animal", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				Pessoa c = null;
				if (TelaAlterarAnimal1Controller.passou == true) {
					c = TelaAlterarAnimal1Controller.clienteSelecionado;
				} else {
					c = TelaGenAnimaisController.animalAlterar.getDono();
				}
				
				Animal a = new Animal(c, txtFieldNome.getText(), Double.parseDouble(txtFieldPeso.getText()), txtFieldEspecie.getText()
						,txtFieldRaca.getText(), datePickerData.getValue());

				a.setId(procurarID());

				fachada.updateAnimal(a);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Animal alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenAnimais.fxml", "Sistema PetShop - Gerencimantedo de Animais");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
			}
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
	
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Animal> lista =  fachada.listarTodosAnimais();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenAnimaisController.animalAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizarValores() {
		txtFieldNome.setText(TelaGenAnimaisController.animalAlterar.getNome());
		txtFieldPeso.setText(String.valueOf(TelaGenAnimaisController.animalAlterar.getPeso()));
		txtFieldEspecie.setText(TelaGenAnimaisController.animalAlterar.getEspecie());
		txtFieldRaca.setText(TelaGenAnimaisController.animalAlterar.getRaca());
		datePickerData.setValue(TelaGenAnimaisController.animalAlterar.getDataNascimento());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		atualizarValores();
	}

}
