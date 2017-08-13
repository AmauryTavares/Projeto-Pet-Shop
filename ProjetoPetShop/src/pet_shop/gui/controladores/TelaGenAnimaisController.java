package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
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
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenAnimaisController implements Initializable{

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
	private TableView<Animal> tbViewAnimais;
	
	@FXML
	private TableColumn<Animal, String> tbColumnNome;
	
	@FXML
	private TableColumn<Animal, String> tbColumnDono;
	
	@FXML
	private TableColumn<Animal, String> tbColumnCPF;
	
	@FXML
	private TableColumn<Animal, Double> tbColumnPeso;
	
	@FXML
	private TableColumn<Animal, String> tbColumnEspecie;
	
	@FXML
	private TableColumn<Animal, String> tbColumnRaca;
	
	@FXML
	private TableColumn<Animal, LocalDate> tbColumnDataNascimento;
	
	public static Animal animalAlterar = null;
	public static Pessoa donoAlterar = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	
	public void atualizarTabela(List<Animal> lista) throws NadaEncontradoException {
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnDono.setCellValueFactory(new PropertyValueFactory<>("donoNome"));
		tbColumnEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
		tbColumnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
		tbColumnPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
		tbColumnRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
		tbColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
				
		tbViewAnimais.setItems(FXCollections.observableList(lista));

	}
	
	@FXML
	public void cadastrar(){
		try{
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaCadastroAnimal1.fxml"));
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
	public void alterar() throws NadaEncontradoException {

		animalAlterar = tbViewAnimais.getSelectionModel().getSelectedItem();
		try{
			for (Pessoa p : fachada.listarTudo()) {
				if (p instanceof Cliente) {
					if (p.getNome().equals(tbViewAnimais.getSelectionModel().getSelectedItem().getNome()) 
							&& p.getCpf().equals(tbViewAnimais.getSelectionModel().getSelectedItem().getCpf())) {
						animalAlterar.setDono(p);
						System.out.println("ola");
					}
				}
			}
		} catch (NadaEncontradoException e) {
			System.err.println(e.getMessage());
		}

		try{
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Atenção");
			dialog.setContentText("Deseja alterar o cliente?");
			dialog.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
			
			Optional<ButtonType> resultado = dialog.showAndWait();
			
			if (resultado.get().equals(ButtonType.YES)) {
				BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaAlterarAnimal1.fxml"));
				Stage newStage = new Stage();
				Scene scene = new Scene(bPane);
				newStage.setScene(scene);
				Main.myStage.hide();
				Main main = new Main();
				newStage.setTitle("Sistema PetShop - Alteração de Animal");
				newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
				newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
				Main.myStage = newStage;
				main.start(newStage);
			} else {
				BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaAlterarAnimal2.fxml"));
				Stage newStage = new Stage();
				Scene scene = new Scene(bPane);
				newStage.setScene(scene);
				Main.myStage.hide();
				Main main = new Main();
				newStage.setTitle("Sistema PetShop - Alteração de Animal");
				newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
				newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
				Main.myStage = newStage;
				main.start(newStage);
			}
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluir() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Excluir");
		alert.setContentText("Deseja excluir esse animal?");
		Optional<ButtonType> resultado = alert.showAndWait();
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Animal animalExcluir = tbViewAnimais.getSelectionModel().getSelectedItem();
				fachada.deleteAnimal(animalExcluir);
				atualizarTabela(fachada.listarTodosAnimais());
				tbViewAnimais.getSelectionModel().select(0);
				Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Sucesso!");
				alert3.setContentText("O animal foi excluído com sucesso!");
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
			atualizarTabela(fachada.listarTodosAnimais());
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
				atualizarTabela(fachada.findAnimal(txtFieldPesquisar.getText()));
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
			List<Animal> lista = fachada.listarTodosAnimais();
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewAnimais.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}

	}

}
