package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
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
import pet_shop.negocio.beans.Venda;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaGenVendasController implements Initializable{
	
	@FXML
	private Label labelLogin;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Button btnAtualizar;
	
	@FXML
	private Button btnPesquisar;
	
	@FXML
	private Button btnInformacoes;
	
	@FXML
	private TextField txtFieldPesquisar;
	
	@FXML
	private Button btnExcluir;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private TableView<Venda> tbViewVendas;
	
	@FXML
	private TableColumn<Venda, String> tbColumnNomeCliente;
	
	@FXML
	private TableColumn<Venda, String> tbColumnNomeFun;
	
	@FXML
	private TableColumn<Venda, String> tbColumnQtdProduto;
	
	@FXML
	private TableColumn<Venda, String> tbColumnQtdServico;
	
	@FXML
	private TableColumn<Venda, String> tbColumnValor;
	
	@FXML
	private TableColumn<Venda, LocalDate> tbColumnData;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();
	
	public void atualizarTabela(List<Venda> lista) throws NadaEncontradoException {
		tbColumnNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		tbColumnNomeFun.setCellValueFactory(new PropertyValueFactory<>("nomeFun"));
		tbColumnQtdProduto.setCellValueFactory(cellData -> {       
           return new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getQtdProdutos()));
        });
		tbColumnQtdServico.setCellValueFactory(cellData -> {       
			return new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getAtendimentos().size()));
	    });
		tbColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
		tbColumnValor.setCellValueFactory(cellData -> 
	     Bindings.format("%,.2f", cellData.getValue().getValorTotal()));
				
		tbViewVendas.setItems(FXCollections.observableList(lista));

	}
	
	@FXML
	public void maisInformacoes(){
		try{
			Venda vendaInformacoes = tbViewVendas.getSelectionModel().getSelectedItem();
			vendaInformacoes.setId(procurarID());
			for (Venda v : fachada.listarTodasVendas()) {
				if (v.equals(vendaInformacoes)) {
					vendaInformacoes = v;
				}
			}
			funcoes.alerta(AlertType.INFORMATION, "Mais Informações", "Dados da venda: ", vendaInformacoes.toString());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void cadastrar(){
		try{
			funcoes.chamarTela("../TelaCadastroVendas1.fxml", "Sistema PetShop - Cadastro de Venda");	
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void excluir() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Excluir", "", "Deseja excluir essa venda?");
		
		if (resultado.get() == ButtonType.OK) {
			try{
				Venda vendaExcluir = tbViewVendas.getSelectionModel().getSelectedItem();
				vendaExcluir.setId(procurarID());
				fachada.deleteVenda(vendaExcluir);
				atualizarTabela(fachada.listarTodasVendas());
				tbViewVendas.getSelectionModel().select(0);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "O venda foi excluído com sucesso!");
			} catch (Exception e) {
				funcoes.alerta(AlertType.INFORMATION, "Ocorreu um problema!", "", e.getMessage());
			}
		}
	}
	
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Venda> lista =  fachada.listarTodasVendas();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getCliente().getNome().equals(tbViewVendas.getSelectionModel().getSelectedItem().getCliente().getNome())
						&& lista.get(i).getFuncionario().getNome().equals(tbViewVendas.getSelectionModel().getSelectedItem().getFuncionario().getNome())
						&& lista.get(i).getData().equals(tbViewVendas.getSelectionModel().getSelectedItem().getData())
						&& lista.get(i).getValorTotal() == tbViewVendas.getSelectionModel().getSelectedItem().getValorTotal()) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
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
			atualizarTabela(fachada.listarTodasVendas());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}
	
	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try{
				atualizarTabela(fachada.findVenda(txtFieldPesquisar.getText())); // procura pelo nome do cliente
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
			List<Venda> lista = fachada.listarTodasVendas();
			atualizarTabela(lista);
			if (lista.size() > 0) {
				tbViewVendas.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

	}

}
