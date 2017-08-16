package pet_shop.gui.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
import pet_shop.negocio.beans.Funcionario;
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

public class TelaCadFuncionariosController implements Initializable {
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnCadastrar;
	
	@FXML
	private ComboBox<String> cmBoxUF;
	
	@FXML
	private TextField txtFieldNome;
	
	@FXML
	private TextField txtFieldCPF;
	
	@FXML
	private TextField txtFieldTelefone;
	
	@FXML
	private TextField txtFieldRua;
	
	@FXML
	private TextField txtFieldNumCasa;
	
	@FXML
	private TextField txtFieldBairro;
	
	@FXML
	private TextField txtFieldCidade;

	@FXML
	private TextField txtFieldEmail;

	@FXML
	private ComboBox<String> cmBoxCargo;

	@FXML
	private TextField txtFieldLogin;
	
	@FXML
	private PasswordField passFieldSenha;

	@FXML
	private TextField txtFieldSalario;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void cadastrarAction()
			throws IllegalAccessException, NomeInvalidoException, CpfInvalidoException, EmailInvalidoException,
			EnderecoInvalidoException, TelefoneInvalidoException, LoginInvalidoException, SenhaInvalidaException,
			CargoInvalidoException, PessoaInexistenteException, PessoaCadastradoException, IOException {
		try {
			
			Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNumCasa.getText(), txtFieldBairro.getText(),
					txtFieldCidade.getText(), verificar(cmBoxUF.getValue()));
			Funcionario f = new Funcionario(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
					txtFieldTelefone.getText(), txtFieldLogin.getText(), passFieldSenha.getText(), Double.parseDouble(txtFieldSalario.getText()), cmBoxCargo.getValue());

			fachada.cadastrarCliente(f);
			funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Funcionario cadastrado com sucesso!");
			try {
				funcoes.chamarTela("../TelaGenFuncionarios.fxml", "Sistema PetShop - Gerencimantedo de Funcionarios");
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
	public void voltarAction() {
		try {
			funcoes.chamarTela("../TelaGenFuncionarios.fxml", "Sistema PetShop - Gerencimantedo de Funcionarios");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}
		
		cmBoxUF.getItems().addAll(uf);
		cmBoxUF.getSelectionModel().select(0);
		
		List<String> cargo = new ArrayList<>();
		cargo.add("Dono");
		cargo.add("Médico");
		cargo.add("Balconista");
		
		cmBoxCargo.getItems().addAll(cargo);
		cmBoxCargo.getSelectionModel().select(0);
		
	}

}
