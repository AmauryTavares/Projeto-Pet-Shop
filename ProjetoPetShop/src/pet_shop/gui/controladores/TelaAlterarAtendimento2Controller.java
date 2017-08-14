package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAlterarAtendimento2Controller implements Initializable {
	
	@FXML
	private Button btnSelecionar;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Label labelLogin;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private TableView<Funcionario> tbViewFuncionarios;
	
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
	
	public static Funcionario funcionarioSelecionado = null;
	public static boolean passou;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
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
		//gera a nova lista apenas com clientes
		for (Pessoa p : lista) {
			if (p instanceof Funcionario) {
				novaLista.add((Funcionario) p);
			}
		}
		
		tbViewFuncionarios.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void selecionar(){
		try{
			 // seleciona o funcionario
			funcionarioSelecionado = tbViewFuncionarios.getSelectionModel().getSelectedItem();
			for (Pessoa p : fachada.listarTudo()) {
				if (p instanceof Funcionario) {
					if (p.equals(funcionarioSelecionado)) {
						funcionarioSelecionado = (Funcionario) p;
					}
				}
			}
			//
			passou = true;
			funcoes.chamarTela("../TelaAlterarAtendimento3.fxml", "Sistema PetShop - Alteração de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void voltar() {
		try{
			funcoes.chamarTela("../TelaAlterarAtendimento1.fxml", "Sistema PetShop - Gerenciamento de Atendimento");
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
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema", "", e.getMessage());
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
			tbViewFuncionarios.getSelectionModel().select(TelaGenAtendimentosController.atendimentoAlterar.getFuncionario());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
		
		tbViewFuncionarios.getSelectionModel().select(0);
		passou = false;
	}

}
