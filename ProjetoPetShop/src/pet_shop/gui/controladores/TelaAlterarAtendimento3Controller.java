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
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAlterarAtendimento3Controller implements Initializable {
	
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
	private TableView<Servico> tbViewServicos;
	
	@FXML
	private TableColumn<Animal, String> tbColumnNome;
	
	@FXML
	private TableColumn<Animal, String> tbColumnAnimal;
	
	@FXML
	private TableColumn<Animal, Double> tbColumnPreco;
	
	@FXML
	private TableColumn<Animal, Boolean> tbColumnNecessitaConsulta;
	
	public static Servico servicoSelecionado = null;
	public static boolean passou;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Servico> lista) throws NadaEncontradoException {
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnAnimal.setCellValueFactory(new PropertyValueFactory<>("animalNome"));
		tbColumnPreco.setCellValueFactory(new PropertyValueFactory<>("preço"));
		tbColumnNecessitaConsulta.setCellValueFactory(new PropertyValueFactory<>("necessitaConsulta"));
		
		List<Servico> novaLista = new ArrayList<>();
		//gera a nova lista apenas com serviços
		for (Servico s : lista) {
			if (s instanceof Servico) {
				novaLista.add(s);
			}
		}
		
		tbViewServicos.setItems(FXCollections.observableList(novaLista));

	}
	
	@FXML
	public void selecionar(){
		try{
			 // seleciona o serviço
			servicoSelecionado = tbViewServicos.getSelectionModel().getSelectedItem();
			for (Servico s : fachada.listarTodosServicos()) {
				if (s instanceof Servico) {
					if (s.equals(servicoSelecionado)) {
						servicoSelecionado = s;
					}
				}
			}
			//
			passou = true;
			funcoes.chamarTela("../TelaAlterarAtendimento4.fxml", "Sistema PetShop - Alteração de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void voltar() {
		try{
			funcoes.chamarTela("../TelaAlterarAtendimento2.fxml", "Sistema PetShop - Gerenciamento de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTodosServicos());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.findServico(txtFieldPesquisar.getText()));
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
			atualizarTabela(fachada.listarTodosServicos());
			tbViewServicos.getSelectionModel().select(TelaGenAtendimentosController.atendimentoAlterar.getServico());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
		
		tbViewServicos.getSelectionModel().select(0);
		passou = false;
	}

}
