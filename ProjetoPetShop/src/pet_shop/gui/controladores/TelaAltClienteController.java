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
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;


public class TelaAltClienteController implements Initializable {

	@FXML
	private Label labelLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtFieldNome;

	@FXML
	private TextField txtFieldCPF;

	@FXML
	private TextField txtFieldRua;

	@FXML
	private TextField txtFieldBairro;

	@FXML
	private TextField txtFieldCidade;

	@FXML
	private TextField txtFieldNCasa;

	@FXML
	private TextField txtFieldEmail;

	@FXML
	private TextField txtFieldTelefone;

	@FXML
	private ComboBox<String> cmBoxUF;

	SistemaFachada fachada = SistemaFachada.getInstance();

	@FXML
	public void alterar() {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Alterar Cliente");
		alert1.setContentText("Deseja salvar essas alterações?");
		Optional<ButtonType> resultado = alert1.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			try {
				Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNCasa.getText(), txtFieldBairro.getText(),
						txtFieldCidade.getText(), verificarSigla(cmBoxUF.getValue()));
				Cliente c = new Cliente(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
						txtFieldTelefone.getText());
				c.setId(procurarID());

				fachada.alterarCliente(c);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso!");
				alert.setContentText("Cliente alterado com sucesso!");
				alert.showAndWait();
				try {
					BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenClientes.fxml"));
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
	public void voltar() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenClientes.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Clientes");
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
				if (lista.get(i).equals(TelaGenClientesController.clienteAlterar)) {
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
		txtFieldNome.setText(TelaGenClientesController.clienteAlterar.getNome());
		txtFieldCPF.setText(TelaGenClientesController.clienteAlterar.getCpf());
		txtFieldRua.setText(TelaGenClientesController.clienteAlterar.getRua());
		txtFieldBairro.setText(TelaGenClientesController.clienteAlterar.getBairro());
		txtFieldCidade.setText(TelaGenClientesController.clienteAlterar.getCidade());
		txtFieldNCasa.setText(TelaGenClientesController.clienteAlterar.getNumCasa());
		txtFieldTelefone.setText(TelaGenClientesController.clienteAlterar.getTelefone());
		txtFieldEmail.setText(TelaGenClientesController.clienteAlterar.getEmail());
		cmBoxUF.getSelectionModel().select(verificar(TelaGenClientesController.clienteAlterar.getUf()).getSigla());
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
