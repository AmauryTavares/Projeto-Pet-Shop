package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Produto> lista) throws NadaEncontradoException {
		
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
		tbColumnQtdEstoque.setCellValueFactory(new PropertyValueFactory<>("qtdEstoque"));
		
		
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
			funcoes.chamarTela("../TelaCadastroProduto.fxml", "Sistema PetShop - Cadastro de Produto");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterarAction() {
		produtoAlterar = tbViewProduto.getSelectionModel().getSelectedItem();
		try{
			funcoes.chamarTela("../TelaAlterarProduto.fxml", "Sistema PetShop - Altera��o de Produto");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluirAction() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Excluir", "", "Deseja excluir esse produto?");
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Produto produtoExcluir = tbViewProduto.getSelectionModel().getSelectedItem();
				fachada.excluirProduto(produtoExcluir);
				atualizarTabela(fachada.listarTudoProduto());
				tbViewProduto.getSelectionModel().select(0);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "O produto foi exclu�do com sucesso!");
			} catch (Exception e) {
				funcoes.alerta(AlertType.INFORMATION, "Ocorreu um problema!", "", e.getMessage());
			}
		}
	}
	
	@FXML
	public void voltarAction() {
		try{
			funcoes.chamarTela("../TelaMenu.fxml", "Sistema PetShop - Painel Inicial");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTudoProduto());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.listarProduto(txtFieldPesquisar.getText()));
			} catch (IllegalAccessException e) {
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
			} catch (NadaEncontradoException e) {
				funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
			}
		} else {
			funcoes.alerta(AlertType.ERROR, "Busca Incorreta", "", "Digite algo antes de pesquisar");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLogin.setText("Bem vindo(a), Administrador");
		try {
			atualizarTabela(fachada.listarTudoProduto());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
		
		tbViewProduto.getSelectionModel().select(0);

	}

}
