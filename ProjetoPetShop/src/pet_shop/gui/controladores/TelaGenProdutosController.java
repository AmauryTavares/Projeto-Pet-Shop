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
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenProdutosController implements Initializable{
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Button btnAlterar;
	
	@FXML
	private Button btnExcluir;
	
	@FXML
	private TableView<Produto> tbViewProduto;
	
	@FXML
	private TableColumn<Produto, String> tbColumnNome;
	
	@FXML
	private TableColumn<Produto, Double> tbColumnPreco;
	
	@FXML
	private TableColumn<Produto, Double> tbColumnQtdEstoque;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private Label lblLogin;

	public static Produto produtoAlterar = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	
	public void atualizarTabela(List<Produto> lista) throws NadaEncontradoException {
		
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbColumnQtdEstoque.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		
		
		List<Produto> novaLista = new ArrayList<>();
		//gera a nova lista apenas com produto
		for (Produto p : lista) {
			novaLista.add(p);
		}
		
		tbViewProduto.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void cadastrarAction(){
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroProduto.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Cadastro de Produto");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterarAction() {
		produtoAlterar = tbViewProduto.getSelectionModel().getSelectedItem();
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaAlterarProduto.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Alteração de Produto");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluirAction() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Excluir");
		alert.setContentText("Deseja excluir esse produto?");
		Optional<ButtonType> resultado = alert.showAndWait();
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Produto produtoExcluir = tbViewProduto.getSelectionModel().getSelectedItem();
				fachada.excluirProduto(produtoExcluir);
				atualizarTabela(fachada.listarTudoProduto());
				tbViewProduto.getSelectionModel().select(0);
				Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Sucesso!");
				alert3.setContentText("O produto foi excluído com sucesso!");
				alert3.showAndWait();
			} catch (Exception e) {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Ocorreu um problema!");
				alert2.setContentText(e.getMessage());
				alert2.showAndWait();
			}
		}
	}
	
	@FXML
	public void voltarAction() {
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
			atualizarTabela(fachada.listarTudoProduto());
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
				atualizarTabela(fachada.listarProduto(txtFieldPesquisar.getText()));
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
			atualizarTabela(fachada.listarTudoProduto());
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
		
		tbViewProduto.getSelectionModel().select(0);

	}

}
