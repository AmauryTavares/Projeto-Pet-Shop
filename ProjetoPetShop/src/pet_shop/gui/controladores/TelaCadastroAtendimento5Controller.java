package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaCadastroAtendimento5Controller implements Initializable{
	
	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnExcluir;
	
	@FXML
	private Button btnFinalizar;
	
	@FXML
	private Button btnCancelar;
	
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
	public void adicionar(){
		try{
			funcoes.chamarTela("../TelaCadastroAtendimento1.fxml", "Sistema PetShop - Cadastro de Atendimento");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	@FXML
	public void excluir() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Excluir", "", "Deseja excluir esse atendimento?");
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Atendimento selecionado = tbViewAtendimentos.getSelectionModel().getSelectedItem();
				for (int i = 0; i < TelaGenAtendimentosController.listaAtendimentos.size(); i++) {
					if (TelaGenAtendimentosController.listaAtendimentos.get(i).getAnimal().getNome().equals(selecionado.getAnimal().getNome())
							&& TelaGenAtendimentosController.listaAtendimentos.get(i).getAnimal().getDono().getNome().equals(selecionado.getAnimal().getDono().getNome())
							&& TelaGenAtendimentosController.listaAtendimentos.get(i).getFuncionario().getCpf().equals(selecionado.getFuncionario().getCpf())
							&& TelaGenAtendimentosController.listaAtendimentos.get(i).getServico().getNome().equals(selecionado.getServico().getNome())) {
						TelaGenAtendimentosController.listaAtendimentos.remove(i);
					}
				}
				atualizarTabela(TelaGenAtendimentosController.listaAtendimentos);
				tbViewAtendimentos.getSelectionModel().select(0);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "O atendimento foi excluído com sucesso!");
			} catch (Exception e) {
				funcoes.alerta(AlertType.INFORMATION, "Ocorreu um problema!", "", e.getMessage());
			}
		}
	}
	
	@FXML
	public void finalizar() {
		
		try{
			TelaGenAtendimentosController.possuiItens = true;
			funcoes.chamarTela("../TelaCadastroVendas1.fxml", "Sistema PetShop - Cadastro de Vendas");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void cancelar() {
		try{
			TelaGenAtendimentosController.listaAtendimentos = null;
			funcoes.chamarTela("../TelaGenAtendimentos.fxml", "Sistema PetShop - Painel Inicial");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelLogin.setText("Bem vindo(a), Administrador");
		try {
			List<Atendimento> lista = TelaGenAtendimentosController.listaAtendimentos;
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewAtendimentos.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

	}

}
