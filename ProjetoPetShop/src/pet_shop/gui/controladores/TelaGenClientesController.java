package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenClientesController implements Initializable{

	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Button btnAlterar;
	
	@FXML
	private Button btnExcluir;
	
	@FXML
	private TableView<Pessoa> tbViewClientes;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnNome;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnCPF;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnUF;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnRua;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnBairro;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnNCasa;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnEmail;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnTelefone;
	
	public void atualizarTabela() throws NadaEncontradoException {
		SistemaFachada fachada = SistemaFachada.getInstance();
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnBairro.setCellValueFactory(new PropertyValueFactory<>("enredereco.bairro"));
		tbColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tbColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbColumnNCasa.setCellValueFactory(new PropertyValueFactory<>("enrereco.numCasa"));
		tbColumnRua.setCellValueFactory(new PropertyValueFactory<>("endereco.rua"));
		tbColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		tbColumnUF.setCellValueFactory(new PropertyValueFactory<>("endereco.uf"));
		
		tbViewClientes.setItems(FXCollections.observableList(fachada.listarTudo()));
		//tbViewClientes.getColumns().addAll(tbColumnNome, tbColumnBairro, tbColumnCPF, tbColumnEmail, tbColumnNCasa, tbColumnRua, tbColumnTelefone, tbColumnUF);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), Administrador");
		try {
			atualizarTabela();
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}

}
