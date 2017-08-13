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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class TelaGenFuncionariosController implements Initializable{
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Button btnExcluir;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnAlterar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private TableView<Funcionario> tbViewFuncionario;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnNome;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnCPF;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnUF;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnRua;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnCidade;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnBairro;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnNumCasa;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnEmail;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnTelefone;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnLogin;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnSenha;
	
	@FXML
	private TableColumn<Funcionario, String> tbColumnCargo;
	
	@FXML
	private TableColumn<Funcionario, Double> tbColumnSalario;
	
	public static Funcionario funcionarioAlterar = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	
	public void atualizarTabela(List<Pessoa> lista) throws NadaEncontradoException {
		
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tbColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		tbColumnNumCasa.setCellValueFactory(new PropertyValueFactory<>("numCasa"));
		tbColumnRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
		tbColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		tbColumnUF.setCellValueFactory(new PropertyValueFactory<>("uf"));
		tbColumnCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		tbColumnLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
		tbColumnSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		tbColumnCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		tbColumnSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
		
		
		List<Funcionario> novaLista = new ArrayList<>();
		//gera a nova lista apenas com funcionarios
		for (Pessoa p : lista) {
			if (p instanceof Funcionario) {
				novaLista.add((Funcionario) p);
			}
		}
		
		tbViewFuncionario.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void cadastrarFuncionario(){
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroFuncionario.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Cadastro de Funcionario");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterarFuncionario() {
		funcionarioAlterar = tbViewFuncionario.getSelectionModel().getSelectedItem();
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaAlterarFuncionario.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Alteração de Funcionario");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluirFuncionario() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Excluir");
		alert.setContentText("Deseja excluir esse funcionario?");
		Optional<ButtonType> resultado = alert.showAndWait();
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Funcionario funcionarioExcluir = tbViewFuncionario.getSelectionModel().getSelectedItem();
				Endereco end = new Endereco(funcionarioExcluir.getRua(), funcionarioExcluir.getNumCasa(), funcionarioExcluir.getBairro(),
						funcionarioExcluir.getCidade(), verificar(funcionarioExcluir.getUf()));
				funcionarioExcluir.setEndereco(end);
				fachada.excluirCliente(funcionarioExcluir);
				atualizarTabela(fachada.listarTudo());
				tbViewFuncionario.getSelectionModel().select(0);
				Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Sucesso!");
				alert3.setContentText("O funcionário foi excluído com sucesso!");
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
	public void atualizarAction() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void pesquisarAction() throws IllegalAccessException, NadaEncontradoException {
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
		
		lblLogin.setText("Bem vindo(a), Administrador");
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
		tbViewFuncionario.getSelectionModel().select(0);
		
	}
	
}
