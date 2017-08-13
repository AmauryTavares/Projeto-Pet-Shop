package pet_shop.gui.controladores;

import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pet_shop.Main;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAltProdutosController {
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private TextField txtFieldNome;
	
	@FXML
	private TextField txtFieldPreco;
	
	@FXML
	private TextField txtFieldQtdEstoque;

	SistemaFachada fachada = SistemaFachada.getInstance();

	@FXML
	public void alterarAction() {
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Alterar Produto");
		alert1.setContentText("Deseja salvar essas alterações?");
		Optional<ButtonType> resultado = alert1.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			try {
				
				Produto p = new Produto(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), Double.parseDouble(txtFieldQtdEstoque.getText()));
				p.setId(procurarID());

				fachada.alterarProduto(p);;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Sucesso!");
				alert.setContentText("Produto alterado com sucesso!");
				alert.showAndWait();
				try {
					BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenProdutos.fxml"));
					Stage newStage = new Stage();
					Scene scene = new Scene(bPane);
					newStage.setScene(scene);
					Main.myStage.hide();
					Main main = new Main();
					newStage.setTitle("Sistema PetShop - Gerenciamneto de Produtos");
					newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
					newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
					Main.myStage = newStage;
					main.start(newStage);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Ocorreu um problema!");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		}
		
	}
	
	@FXML
	public void voltar() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenProdutos.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerenciamento de Produtos");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
		
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Pessoa> lista =  fachada.listarTudo();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenClientesController.clienteAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}

	public void atualizarValores() {
		
		txtFieldNome.setText(TelaGenProdutosController.produtoAlterar.getNome());
		txtFieldPreco.setText(String.valueOf(TelaGenProdutosController.produtoAlterar.getPreco()));
		txtFieldQtdEstoque.setText(String.valueOf(TelaGenProdutosController.produtoAlterar.getQtdEstoque()));
		
	}
	
}
