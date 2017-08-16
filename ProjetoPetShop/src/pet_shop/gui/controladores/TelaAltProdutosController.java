package pet_shop.gui.controladores;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Produto;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAltProdutosController implements Initializable{
	
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
	public void alterarAction() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Produto", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				
				Produto p = new Produto(txtFieldNome.getText(), Double.parseDouble(txtFieldPreco.getText()), Double.parseDouble(txtFieldQtdEstoque.getText()));
				p.setId(procurarID());

				fachada.alterarProduto(p);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Produto alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenProdutos.fxml", "Sistema PetShop - Gerenciamneto de Produtos");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
			}
		}
		
	}
	
	@FXML
	public void voltarAction() {
		try {
			funcoes.chamarTela("../TelaGenProdutos.fxml", "Sistema PetShop - Gerenciamento de Produtos");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
		
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Produto> lista =  fachada.listarTudoProduto();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenProdutosController.produtoAlterar)) {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		atualizarValores();	
	}
	
}
