package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pet_shop.Main;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaCadastroAnimal1Controller implements Initializable{

	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnSelecionar;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private Button btnVoltar;
	
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
	private TableColumn<Pessoa, String> tbColumnCidade;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnBairro;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnNCasa;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnEmail;
	
	@FXML
	private TableColumn<Pessoa, String> tbColumnTelefone;
	
	public static Pessoa clienteSelecionado = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	
	public void atualizarTabela(List<Pessoa> lista) throws NadaEncontradoException {
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tbColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbColumnNCasa.setCellValueFactory(new PropertyValueFactory<>("numCasa"));
		tbColumnRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
		tbColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		tbColumnUF.setCellValueFactory(new PropertyValueFactory<>("uf"));
		tbColumnCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		
		List<Pessoa> novaLista = new ArrayList<>();
		//gera a nova lista apenas com clientes
		for (Pessoa p : lista) {
			if (p instanceof Cliente) {
				novaLista.add(p);
			}
		}
		
		tbViewClientes.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void selecionar(){
		try{
			 // seleciona o cliente
			clienteSelecionado = tbViewClientes.getSelectionModel().getSelectedItem();
			for (Pessoa p : fachada.listarTudo()) {
				if (p instanceof Cliente) {
					if (p.equals(clienteSelecionado)) {
						clienteSelecionado = (Cliente) p;
					}
				}
			}
			//
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroAnimal2.fxml"));
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
	
	@FXML
	public void voltar() {
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenAnimais.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Animais");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.listarCliente(txtFieldPesquisar.getText()));
			} catch (IllegalAccessException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			} catch (NadaEncontradoException e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Busca Incorreta");
			alert.setContentText("Digite algo antes de pesquisar");
			alert.showAndWait();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), Administrador");
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
		tbViewClientes.getSelectionModel().select(0);

	}

}
