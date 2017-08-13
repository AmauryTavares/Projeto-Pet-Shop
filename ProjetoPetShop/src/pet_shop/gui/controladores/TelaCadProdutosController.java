package pet_shop.gui.controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrarAction()
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		try {
			
			Produto p = new Produto(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), Double.parseDouble(txtFieldQtdEstoque.getText()));

			fachada.cadastrarProduto(p);
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Produto cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenProdutos.fxml", "Sistema PetShop - Gerencimantedo de Produtos");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} catch (Exception e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}

	@FXML
	public void voltarAction() {
		try {
			funcoes.chamarTela("../TelaGenProdutos.fxml", "Sistema PetShop - Gerencimantedo de Produtos");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
