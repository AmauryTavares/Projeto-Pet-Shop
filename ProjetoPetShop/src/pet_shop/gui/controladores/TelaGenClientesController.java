package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
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
	private Button btnAtualizar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private Button btnExcluir;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private TableView<Cliente> tbViewClientes;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnNome;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnCPF;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnUF;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnRua;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnCidade;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnBairro;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnNCasa;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnEmail;
	
	@FXML
	private TableColumn<Cliente, String> tbColumnTelefone;
	
	public static Cliente clienteAlterar = null;
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
		
		List<Cliente> novaLista = new ArrayList<>();
		//gera a nova lista apenas com clientes
		for (Pessoa p : lista) {
			if (p instanceof Cliente) {
				novaLista.add((Cliente) p);
			}
		}
		
		tbViewClientes.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void cadastrar(){
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroCliente.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Cadastro de Cliente");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterar() {
		clienteAlterar = tbViewClientes.getSelectionModel().getSelectedItem();
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaAlterarCliente.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Alteração de Cliente");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluir() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Excluir");
		alert.setContentText("Deseja excluir esse cliente?");
		Optional<ButtonType> resultado = alert.showAndWait();
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Cliente clienteExcluir = tbViewClientes.getSelectionModel().getSelectedItem();
				Endereco end = new Endereco(clienteExcluir.getRua(), clienteExcluir.getNumCasa(), clienteExcluir.getBairro(),
						clienteExcluir.getCidade(), verificar(clienteExcluir.getUf()));
				clienteExcluir.setEndereco(end);
				fachada.excluirCliente(clienteExcluir);
				atualizarTabela(fachada.listarTudo());
				tbViewClientes.getSelectionModel().select(0);
				Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Sucesso!");
				alert3.setContentText("O cliente foi excluído com sucesso!");
				alert3.showAndWait();
			} catch (Exception e) {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Ocorreu um problema!");
				alert2.setContentText(e.getMessage());
				alert2.showAndWait();
			}
		}
	}
	
	private EnumUF verificar(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getNome().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}
	
	@FXML
	public void voltar() {
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaMenu.fxml"));
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
