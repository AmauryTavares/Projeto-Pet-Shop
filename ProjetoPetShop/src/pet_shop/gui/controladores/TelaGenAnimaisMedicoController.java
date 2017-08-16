package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
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
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenAnimaisMedicoController implements Initializable {

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
	private TableView<Animal> tbViewAnimais;
	
	@FXML
	private TableColumn<Animal, String> tbColumnNome;
	
	@FXML
	private TableColumn<Animal, String> tbColumnDono;
	
	@FXML
	private TableColumn<Animal, String> tbColumnCPF;
	
	@FXML
	private TableColumn<Animal, String> tbColumnPeso;
	
	@FXML
	private TableColumn<Animal, String> tbColumnEspecie;
	
	@FXML
	private TableColumn<Animal, String> tbColumnRaca;
	
	@FXML
	private TableColumn<Animal, LocalDate> tbColumnDataNascimento;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Animal> lista) throws NadaEncontradoException {
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnDono.setCellValueFactory(new PropertyValueFactory<>("donoNome"));
		tbColumnEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
		tbColumnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
		tbColumnPeso.setCellValueFactory(cellData -> 
	     Bindings.format("%,.2f", cellData.getValue().getPeso()));
		tbColumnRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
		tbColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
				
		tbViewAnimais.setItems(FXCollections.observableList(lista));

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
			atualizarTabela(fachada.listarTodosAnimais());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.findAnimal(txtFieldPesquisar.getText()));
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
			List<Animal> lista = fachada.listarTodosAnimais();
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewAnimais.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

	}

}
	

