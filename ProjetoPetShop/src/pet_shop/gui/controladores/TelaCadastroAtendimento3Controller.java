package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaCadastroAtendimento3Controller implements Initializable {
	
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
	private TableColumn<Servico, String> tbColumnNome;
	
	@FXML
	private TableColumn<Servico, String> tbColumnPreco;
	
	@FXML
	private TableColumn<Servico, String> tbColumnNecessitaConsulta;
	
	public static Servico servicoSelecionado = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Servico> lista) throws NadaEncontradoException {
		
		tbColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnPreco.setCellValueFactory(cellData -> 
	     Bindings.format("%,.2f", cellData.getValue().getPreco()));
		tbColumnNecessitaConsulta.setCellValueFactory(cellData -> {
            boolean gender = cellData.getValue().isConsulta();
            String genderAsString;
            if(gender == true) {
                genderAsString = "Sim";
            } else {
                genderAsString = "N�o";
            }
           return new ReadOnlyStringWrapper(genderAsString);
        });
		
		List<Servico> novaLista = new ArrayList<>();
		//gera a nova lista apenas com servi�os
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
			 // seleciona o servi�o
			servicoSelecionado = tbViewServicos.getSelectionModel().getSelectedItem();
			for (Servico s : fachada.listarTodosServicos()) {
				if (s instanceof Servico) {
					if (s.equals(servicoSelecionado)) {
						servicoSelecionado = s;
					}
				}
			}
			//
			funcoes.chamarTela("../TelaCadastroAtendimento4.fxml", "Sistema PetShop - Cadastro de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void voltar() {
		try{
			funcoes.chamarTela("../TelaCadastroAtendimento2.fxml", "Sistema PetShop - Gerenciamento de Atendimento");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabela(fachada.listarTodosServicos());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.findServico(txtFieldPesquisar.getText()));
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
			atualizarTabela(fachada.listarTodosServicos());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Lista vazia", "", e.getMessage());
		}
		
		tbViewServicos.getSelectionModel().select(0);

	}

}
