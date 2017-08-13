package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pet_shop.Main;
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

	@FXML
	public void alterar() {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Alterar Animal");
		alert1.setContentText("Deseja salvar essas altera��es?");
		Optional<ButtonType> resultado = alert1.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso!");
				alert.setContentText("Animal alterado com sucesso!");
				alert.showAndWait();
				try {
					BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenAnimais.fxml"));
					Stage newStage = new Stage();
					Scene scene = new Scene(bPane);
					newStage.setScene(scene);
					Main.myStage.hide();
					Main main = new Main();
					newStage.setTitle("Sistema PetShop - Gerencimantedo de Animais");
					newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
					newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
					Main.myStage = newStage;
					main.start(newStage);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ocorreu um problema!");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
	}

	@FXML
	public void voltar() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroAnimal1.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Cadastro de Animal");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
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
		atualizarValores();
	}

}
