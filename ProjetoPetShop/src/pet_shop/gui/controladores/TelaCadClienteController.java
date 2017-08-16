package pet_shop.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
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

public class TelaCadClienteController implements Initializable {

	@FXML
	private Label labelLogin;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField txtFieldNome;

	@FXML
	private TextField txtFieldCPF;

	@FXML
	private TextField txtFieldRua;

	@FXML
	private TextField txtFieldBairro;

	@FXML
	private TextField txtFieldCidade;

	@FXML
	private TextField txtFieldNCasa;

	@FXML
	private TextField txtFieldEmail;

	@FXML
	private TextField txtFieldTelefone;

	@FXML
	private ComboBox<String> cmBoxUF;

	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrar()
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		try {
			
			Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNCasa.getText(), txtFieldBairro.getText(),
					txtFieldCidade.getText(), verificar(cmBoxUF.getValue()));
			Cliente c = new Cliente(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
					txtFieldTelefone.getText());

			fachada.cadastrarCliente(c);
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Cliente cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenClientes.fxml", "Sistema PetShop - Gerencimantedo de Clientes");
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		} catch (Exception e) {
			funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
		}
	}
	
	
	private EnumUF verificar(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getSigla().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}

	@FXML
	public void voltar() {
		try {
			funcoes.chamarTela("../TelaGenClientes.fxml", "Sistema PetShop - Gerencimantedo de Clientes");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		labelLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}
		
		cmBoxUF.getItems().addAll(uf);
		cmBoxUF.getSelectionModel().select(0);
	}

}
