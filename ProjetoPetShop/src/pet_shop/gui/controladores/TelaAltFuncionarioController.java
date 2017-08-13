package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAltFuncionarioController implements Initializable {
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnAlterar;
	
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
	public void alterarAction() {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Alterar Funcionario");
		alert1.setContentText("Deseja salvar essas alterações?");
		Optional<ButtonType> resultado = alert1.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			try {
				Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNumCasa.getText(), txtFieldBairro.getText(),
						txtFieldCidade.getText(), verificarSigla(cmBoxUF.getValue()));
				Funcionario f = new Funcionario(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
						txtFieldTelefone.getText(), txtFieldLogin.getText(), txtFieldSenha.getText(), Double.parseDouble(txtFieldSalario.getText()), txtFieldCargo.getText());
				f.setId(procurarID());

				fachada.alterarCliente(f);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso!");
				alert.setContentText("Funcionario alterado com sucesso!");
				alert.showAndWait();
				try {
					BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenFuncionarios.fxml"));
					Stage newStage = new Stage();
					Scene scene = new Scene(bPane);
					newStage.setScene(scene);
					Main.myStage.hide();
					Main main = new Main();
					newStage.setTitle("Sistema PetShop - Painel Inicial");
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
	public void voltarAction() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenFuncionarios.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Funcionários");
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
			List<Pessoa> lista =  fachada.listarTudo();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenFuncionariosController.funcionarioAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	private EnumUF verificar(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getNome().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}
	
	private EnumUF verificarSigla(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getSigla().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}

	public void atualizarValores() {
		txtFieldNome.setText(TelaGenFuncionariosController.funcionarioAlterar.getNome());
		txtFieldCPF.setText(TelaGenFuncionariosController.funcionarioAlterar.getCpf());
		txtFieldRua.setText(TelaGenFuncionariosController.funcionarioAlterar.getRua());
		txtFieldBairro.setText(TelaGenFuncionariosController.funcionarioAlterar.getBairro());
		txtFieldCidade.setText(TelaGenFuncionariosController.funcionarioAlterar.getCidade());
		txtFieldNumCasa.setText(TelaGenFuncionariosController.funcionarioAlterar.getNumCasa());
		txtFieldTelefone.setText(TelaGenFuncionariosController.funcionarioAlterar.getTelefone());
		txtFieldEmail.setText(TelaGenFuncionariosController.funcionarioAlterar.getEmail());
		cmBoxUF.getSelectionModel().select(verificar(TelaGenFuncionariosController.funcionarioAlterar.getUf()).getSigla());
		txtFieldCargo.setText(TelaGenFuncionariosController.funcionarioAlterar.getCargo());
		txtFieldLogin.setText(TelaGenFuncionariosController.funcionarioAlterar.getLogin());
		txtFieldSenha.setText(TelaGenFuncionariosController.funcionarioAlterar.getSenha());
		txtFieldSalario.setText(String.valueOf(TelaGenFuncionariosController.funcionarioAlterar.getSalario()));		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}	
		
		cmBoxUF.getItems().addAll(uf);
		atualizarValores();
		
	}

}
