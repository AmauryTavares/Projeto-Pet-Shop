package pet_shop.gui.controladores;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Atendimento;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.beans.Venda;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaCadastroVendas2Controller implements Initializable {

	@FXML
	private Label labelLogin;

	@FXML
	private Label labelValor;

	@FXML
	private Button btnAdicionar;

	@FXML
	private Button btnFinalizar;

	@FXML
	private Button btnRemover;

	@FXML
	private TextField txtFieldPesquisar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnVoltar;

	@FXML
	private TableView<Produto> tbViewProdutosEstoque;

	@FXML
	private TableColumn<Produto, String> tbColumnNomeProdEstoque;

	@FXML
	private TableColumn<Produto, String> tbColumnPrecoProdEstoque;

	@FXML
	private TableColumn<Produto, String> tbColumnQtdEstoque;

	@FXML
	private TableView<Produto> tbViewProdutosCar;

	@FXML
	private TableColumn<Produto, String> tbColumnNomeProdCar;

	@FXML
	private TableColumn<Produto, String> tbColumnPrecoProdCar;

	@FXML
	private TableColumn<Produto, String> tbColumnQtdProdCar;

	List<Produto> listaProdutos = new ArrayList<>();
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	public void atualizarTabelaEstoque(List<Produto> lista) throws NadaEncontradoException {
		tbColumnNomeProdEstoque.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnPrecoProdEstoque.setCellValueFactory(cellData -> Bindings.format("%,.2f", cellData.getValue().getPreco()));
		tbColumnQtdEstoque.setCellValueFactory(cellData -> Bindings.format("%,.2f", cellData.getValue().getQtdEstoque()));
		tbViewProdutosEstoque.setItems(FXCollections.observableList(lista));

	}

	public void atualizarTabelaCar(List<Produto> lista) throws NadaEncontradoException {
		tbColumnNomeProdCar.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbColumnPrecoProdCar.setCellValueFactory(cellData -> Bindings.format("%,.2f", cellData.getValue().getPreco()));
		tbColumnQtdProdCar
				.setCellValueFactory(cellData -> Bindings.format("%,.2f", cellData.getValue().getQtdEstoque()));

		tbViewProdutosCar.setItems(FXCollections.observableList(lista));

	}

	@FXML
	public void adicionar() {
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Quantidade");
			dialog.setHeaderText("Digite a quantidade");
			dialog.setContentText("Quantidade: ");

			Optional<String> result = dialog.showAndWait();
			double qtd = 0;
			if (result.isPresent()) {
				qtd = Double.parseDouble(result.get());
				for (Produto p : fachada.listarTudoProduto()) {
					if (p.equals(tbViewProdutosEstoque.getSelectionModel().getSelectedItem())) {

						Produto produtoGenerico = new Produto(p.getNome(), p.getPreco(), qtd);
						listaProdutos.add(produtoGenerico);
						atualizarTabelaCar(listaProdutos);
						atualizarValor();
					}
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@FXML
	public void remover(){
		try{
			boolean parar = false;
			for (int i = 0; i < listaProdutos.size() && !parar; i++) {
				if (listaProdutos.get(i).equals(tbViewProdutosCar.getSelectionModel().getSelectedItem())) {
					listaProdutos.remove(listaProdutos.get(i));
					atualizarTabelaCar(listaProdutos);
					atualizarValor();
					parar = true;
				}
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	public void finalizar() {
		try {
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Atenção");
			dialog.setContentText("Deseja finalizar o venda?");
			dialog.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
			
			Optional<ButtonType> resultado = dialog.showAndWait();
			
			if (resultado.get().equals(ButtonType.YES)) {
				List<Atendimento> listaAtendimentos = new ArrayList<>();
				if (TelaGenAtendimentosController.possuiItens == true) {
					listaAtendimentos = TelaGenAtendimentosController.listaAtendimentos;
				}
				Venda venda = new Venda(TelaLoginController.logado, TelaCadastroVendas1Controller.clienteSelecionado, listaAtendimentos, listaProdutos, LocalDate.now());
				fachada.saveVenda(venda);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Venda realizada com sucesso!");
				funcoes.chamarTela("../TelaGenVendas.fxml", "Sistema PetShop - Gerenciamento de Vendas");
				TelaGenAtendimentosController.possuiItens = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarValor() {
		
		double valorTotal = 0;
		
		for (Produto p : listaProdutos) {
			valorTotal += p.getPreco() * p.getQtdEstoque();
		}
		
		if (TelaGenAtendimentosController.possuiItens == true) {
			for (Atendimento a : TelaGenAtendimentosController.listaAtendimentos) {
				valorTotal += a.getServico().getPreco();
			}
		}
		
		labelValor.setText(String.format("%,.2f", valorTotal));
		
	}

	@FXML
	public void voltar() {
		try {
			funcoes.chamarTela("../TelaCadastroVendas1.fxml", "Sistema PetShop - Cadastro de Venda");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	@FXML
	public void atualizarAcaoButton() throws NadaEncontradoException {
		try {
			atualizarTabelaEstoque(fachada.listarTudoProduto());
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}

	@FXML
	public void pesquisarAcaoButton() throws IllegalAccessException, NadaEncontradoException {
		if (!txtFieldPesquisar.getText().isEmpty()) {
			try {
				atualizarTabelaEstoque(fachada.listarProduto(txtFieldPesquisar.getText())); 												
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
			List<Produto> lista = fachada.listarTudoProduto();
			atualizarTabelaEstoque(lista);
			atualizarTabelaCar(listaProdutos);
			atualizarValor();
			if (lista.size() > 0) {
				tbViewProdutosEstoque.getSelectionModel().select(0);
			}
		} catch (NadaEncontradoException e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}

	}

}
