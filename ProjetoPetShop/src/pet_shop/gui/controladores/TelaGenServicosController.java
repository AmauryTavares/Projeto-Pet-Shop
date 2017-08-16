package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenServicosController implements Initializable {
	
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
	private TableView<Servico> tbViewServicos;
	
	@FXML
	private TableColumn<Servico, String> tbColumnNome;
	
	@FXML
	private TableColumn<Servico, String> tbColumnPreco;
	
	@FXML
	private TableColumn<Servico, String> tbColumnNecessitaConsulta;
	
	public static Servico servicoAlterar = null;
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
                genderAsString = "Não";
            }
           return new ReadOnlyStringWrapper(genderAsString);
        });
			
		tbViewServicos.setItems(FXCollections.observableList(lista));

	}
	
	@FXML
	public void cadastrar(){
		try{
			funcoes.chamarTela("../TelaCadastroServico2.fxml", "Sistema PetShop - Cadastro de Servico");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterar() throws NadaEncontradoException {

		servicoAlterar = tbViewServicos.getSelectionModel().getSelectedItem();

		try{
		
			funcoes.chamarTela("../TelaAlterarServico2.fxml", "Sistema PetShop - Alteração de Serviço");

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluir() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Excluir", "", "Deseja excluir esse serviço?");
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Servico servicoExcluir = tbViewServicos.getSelectionModel().getSelectedItem();
				fachada.deleteServico(servicoExcluir);
				atualizarTabela(fachada.listarTodosServicos());
				tbViewServicos.getSelectionModel().select(0);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "O serviço foi excluído com sucesso!");
			} catch (Exception e) {
				funcoes.alerta(AlertType.INFORMATION, "Ocorreu um problema!", "", e.getMessage());
			}
		}
	}
	
	@FXML
	public void voltar() {
		
		if(TelaLoginController.logado.getCargo().equals("Balconista")) {
			try{
				funcoes.chamarTela("../TelaMenuBalconista.fxml", "Sistema PetShop - Painel Inicial");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} else {
			try{
				funcoes.chamarTela("../TelaMenu.fxml", "Sistema PetShop - Painel Inicial");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
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
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		try {
			List<Servico> lista = fachada.listarTodosServicos();
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewServicos.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

		
	}

}
