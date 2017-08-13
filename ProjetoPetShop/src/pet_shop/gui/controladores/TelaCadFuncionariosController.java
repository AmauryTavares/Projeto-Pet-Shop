package pet_shop.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pet_shop.Main;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.excecoes.CargoInvalidoException;
import pet_shop.negocio.excecoes.CpfInvalidoException;
import pet_shop.negocio.excecoes.EmailInvalidoException;
import pet_shop.negocio.excecoes.EnderecoInvalidoException;
import pet_shop.negocio.excecoes.LoginInvalidoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PessoaCadastradoException;
import pet_shop.negocio.excecoes.PessoaInexistenteException;
import pet_shop.negocio.excecoes.SenhaInvalidaException;
import pet_shop.negocio.excecoes.TelefoneInvalidoException;

public class TelaCadFuncionariosController implements Initializable {
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private ComboBox<String> cmBoxUF;
	
	@FXML
	private TextField txtFieldNome;
	
	@FXML
	private TextField txtFieldCPF;
	
	@FXML
	private TextField txtFieldTelefone;
	
	@FXML
	private TextField txtFieldRua;
	
	@FXML
	private TextField txtFieldNumCasa;
	
	@FXML
	private TextField txtFieldBairro;
	
	@FXML
	private TextField txtFieldCidade;

	@FXML
	private TextField txtFieldEmail;

	@FXML
	private TextField txtFieldCargo;

	@FXML
	private TextField txtFieldLogin;
	
	@FXML
	private TextField txtFieldSenha;

	@FXML
	private TextField txtFieldSalario;
	
	SistemaFachada fachada = SistemaFachada.getInstance();

	@FXML
	public void cadastrarAction()
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		try {
			
			Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNumCasa.getText(), txtFieldBairro.getText(),
					txtFieldCidade.getText(), verificar(cmBoxUF.getValue()));
			Funcionario f = new Funcionario(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
					txtFieldTelefone.getText(), txtFieldLogin.getText(), txtFieldSenha.getText(), Double.parseDouble(txtFieldSalario.getText()), txtFieldCargo.getText());

			fachada.cadastrarCliente(f);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso!");
			alert.setContentText("Funcionario cadastrado com sucesso!");
			alert.showAndWait();
			try {
				BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenFuncionarios.fxml"));
				Stage newStage = new Stage();
				Scene scene = new Scene(bPane);
				newStage.setScene(scene);
				Main.myStage.hide();
				Main main = new Main();
				newStage.setTitle("Sistema PetShop - Gerencimantedo de Funcionarios");
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
	
	private EnumUF verificar(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getSigla().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}
	
	@FXML
	public void voltarAction() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenFuncionarios.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerencimantedo de Funcionarios");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}
		
		cmBoxUF.getItems().addAll(uf);
		cmBoxUF.getSelectionModel().select(0);
		
	}

}
