package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
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
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenAtendimentosMedicoController implements Initializable{

	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private TableView<Atendimento> tbViewAtendimentos;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnAnimal;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnFuncionario;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnCpf;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnNomeDono;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnServico;
	
	@FXML
	private TableColumn<Atendimento, LocalDate> tbColumnData;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnDiagnostico;
	
	
	public static List<Atendimento> listaAtendimentos = null;
	public static boolean possuiItens = false;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Atendimento> lista) throws NadaEncontradoException {
		tbColumnNomeDono.setCellValueFactory(new PropertyValueFactory<>("nomeDono"));
		tbColumnAnimal.setCellValueFactory(new PropertyValueFactory<>("nomeAnimal"));
		tbColumnFuncionario.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
		tbColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpfFuncionario"));
		tbColumnServico.setCellValueFactory(new PropertyValueFactory<>("nomeServico"));
		tbColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
		tbColumnDiagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
				
		tbViewAtendimentos.setItems(FXCollections.observableList(lista));

	}
	
	@FXML
	public void voltar() {
		
		try{
			funcoes.chamarTela("../TelaMenuMedico.fxml", "Sistema PetShop - Painel Inicial");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTodosAtendimentos());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.findAtendimento(txtFieldPesquisar.getText()));
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
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		try {
			List<Atendimento> lista = fachada.listarTodosAtendimentos();
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewAtendimentos.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

	}

}
