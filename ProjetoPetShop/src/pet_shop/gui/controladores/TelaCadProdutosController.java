package pet_shop.gui.controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pet_shop.Main;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.excecoes.CargoInvalidoException;
import pet_shop.negocio.excecoes.CpfInvalidoException;
import pet_shop.negocio.excecoes.EmailInvalidoException;
import pet_shop.negocio.excecoes.EnderecoInvalidoException;
import pet_shop.negocio.excecoes.LoginInvalidoException;
import pet_shop.negocio.excecoes.NomeInvalidoException;
import pet_shop.negocio.excecoes.PessoaCadastradoException;
import pet_shop.negocio.excecoes.PessoaInexistenteException;
import pet_shop.negocio.excecoes.SenhaInvalidaException;
import pet_shop.negocio.excecoes.TelefoneInvalidoException;

public class TelaCadProdutosController {
	
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
	public void cadastrarAction()
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		try {
			
			Produto p = new Produto(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), Double.parseDouble(txtFieldQtdEstoque.getText()));

			fachada.cadastrarProduto(p);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso!");
			alert.setContentText("Produto cadastrado com sucesso!");
			alert.showAndWait();
			try {
				BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenProdutos.fxml"));
				Stage newStage = new Stage();
				Scene scene = new Scene(bPane);
				newStage.setScene(scene);
				Main.myStage.hide();
				Main main = new Main();
				newStage.setTitle("Sistema PetShop - Gerencimantedo de Produtos");
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

	@FXML
	public void voltarAction() {
		try {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("../TelaGenProdutos.fxml"));
			Stage newStage = new Stage();
			Scene scene = new Scene(bPane);
			newStage.setScene(scene);
			Main.myStage.hide();
			Main main = new Main();
			newStage.setTitle("Sistema PetShop - Gerencimantedo de Produtos");
			newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			Main.myStage = newStage;
			main.start(newStage);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
