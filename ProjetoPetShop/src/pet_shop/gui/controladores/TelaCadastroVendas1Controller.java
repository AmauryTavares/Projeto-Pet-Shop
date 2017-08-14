package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaCadastroVendas1Controller implements Initializable{

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
	
	public static Cliente clienteSelecionado = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
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
	public void selecionar() {
		try{
			 // seleciona o animal
			clienteSelecionado = (Cliente) tbViewClientes.getSelectionModel().getSelectedItem();
			for (Pessoa a : fachada.listarTudo()) {
				if (a instanceof Cliente) {
					if (a.equals(clienteSelecionado)) {
						clienteSelecionado = (Cliente) a;
					}
				}
			}
			//
			funcoes.chamarTela("../TelaCadastroVendas2.fxml", "Sistema PetShop - Cadastro de Venda");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void voltar() {
		try{
			funcoes.chamarTela("../TelaGenVendas.fxml", "Sistema PetShop - Gerenciamento de Vendas");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.listarCliente(txtFieldPesquisar.getText()));
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
		labelLogin.setText("Bem vindo(a), Administrador");
		try {
			atualizarTabela(fachada.listarTudo());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
		
		tbViewClientes.getSelectionModel().select(0);

	}

}
