package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Animal;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.beans.Servico;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenAtendimentosController implements Initializable{
	
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
	private TableView<Atendimento> tbViewAtendimentos;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnAnimal;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnFuncionario;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnServico;
	
	@FXML
	private TableColumn<Atendimento, LocalDate> tbColumnData;
	
	@FXML
	private TableColumn<Atendimento, String> tbColumnDiagnostico;
	
	public static Animal animalAlterar = null;
	public static Pessoa funcionarioAlterar = null;
	public static Servico servicoAlterar = null;
	public static Atendimento atendimentoAlterar = null;
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Atendimento> lista) throws NadaEncontradoException {
		tbColumnAnimal.setCellValueFactory(new PropertyValueFactory<>("nomeAnimal"));
		tbColumnFuncionario.setCellValueFactory(new PropertyValueFactory<>("nomeFuncionario"));
		tbColumnServico.setCellValueFactory(new PropertyValueFactory<>("nomeServico"));
		tbColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
		tbColumnDiagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
				
		tbViewAtendimentos.setItems(FXCollections.observableList(lista));

	}
	
	@FXML
	public void cadastrar(){
		try{
			funcoes.chamarTela("../TelaCadastroAtendimento1.fxml", "Sistema PetShop - Cadastro de Atendimento");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void alterar() throws NadaEncontradoException {

		atendimentoAlterar = tbViewAtendimentos.getSelectionModel().getSelectedItem();
		try{
			
			for (Animal a : fachada.listarTodosAnimais()) {				
				if (a.equals(tbViewAtendimentos.getSelectionModel().getSelectedItem().getAnimal())) {
					atendimentoAlterar.setAnimal(a);
					System.out.println("ola");		
				}
			}
			
			for (Pessoa p : fachada.listarTudo()) {		
				if(p instanceof Funcionario) {
					if (p.getNome().equals(tbViewAtendimentos.getSelectionModel().getSelectedItem().getFuncionario().getNome())) {
						atendimentoAlterar.setFuncionario((Funcionario) p);
						System.out.println("ola");		
					}
				}
			}
			
			for (Servico s : fachada.listarTodosServicos()) {				
				if (s.equals(tbViewAtendimentos.getSelectionModel().getSelectedItem().getServico())) {
					atendimentoAlterar.setServico(s);
					System.out.println("ola");		
				}
			}
			
		} catch (NadaEncontradoException e) {
			System.out.println(e.getMessage());
		}

		try{
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Atenção");
			dialog.setContentText("Deseja alterar o animal?");
			dialog.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
			
			Optional<ButtonType> resultado = dialog.showAndWait();
			
			if (resultado.get().equals(ButtonType.YES)) {
				funcoes.chamarTela("../TelaAlterarAtendimento1.fxml", "Sistema PetShop - Alteração de Atendimento");
			} else {
				
				Alert dialog1 = new Alert(AlertType.INFORMATION);
				dialog1.setTitle("Atenção");
				dialog1.setContentText("Deseja alterar o funcionário?");
				dialog1.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
				
				Optional<ButtonType> resultado1 = dialog.showAndWait();
				
				if (resultado1.get().equals(ButtonType.YES)) {
					funcoes.chamarTela("../TelaAlterarAtendimento2.fxml", "Sistema PetShop - Alteração de Atendimento");
				} else {
					
					Alert dialog2 = new Alert(AlertType.INFORMATION);
					dialog2.setTitle("Atenção");
					dialog2.setContentText("Deseja alterar o serviço?");
					dialog2.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
					
					Optional<ButtonType> resultado2 = dialog.showAndWait();
					
					if (resultado2.get().equals(ButtonType.YES)) {
						funcoes.chamarTela("../TelaAlterarAtendimento3.fxml", "Sistema PetShop - Alteração de Atendimento");
					} else {
						funcoes.chamarTela("../TelaAlterarAtendimento4.fxml", "Sistema PetShop - Alteração de Atendimento");
					}
					
				}
				
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluir() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Excluir", "", "Deseja excluir esse atendimento?");
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Atendimento atendimentoExcluir = tbViewAtendimentos.getSelectionModel().getSelectedItem();
				fachada.deleteAtendimento(atendimentoExcluir);
				atualizarTabela(fachada.listarTodosAtendimentos());
				tbViewAtendimentos.getSelectionModel().select(0);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "O atendimento foi excluído com sucesso!");
			} catch (Exception e) {
				funcoes.alerta(AlertType.INFORMATION, "Ocorreu um problema!", "", e.getMessage());
			}
		}
	}
	
	@FXML
	public void voltar() {
		try{
			funcoes.chamarTela("../TelaMenu.fxml", "Sistema PetShop - Painel Inicial");
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
		labelLogin.setText("Bem vindo(a), Administrador");
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
