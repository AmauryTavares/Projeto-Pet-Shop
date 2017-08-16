package pet_shop.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pet_shop.negocio.SistemaFachada;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
import pet_shop.negocio.beans.Funcionario;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;

public class TelaAltFuncionarioController implements Initializable {
	
	@FXML
	private Label lblLogin;
	
	@FXML
	private Button btnVoltar;
	
	@FXML
	private Button btnAlterar;
	
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
	private TextField txtFieldLogin;
	
	@FXML
	private TextField txtFieldSenha;

	@FXML
	private TextField txtFieldSalario;
	
	@FXML
	private ComboBox<String> cmBoxCargo;
	
	SistemaFachada fachada = SistemaFachada.getInstance();
	Funcoes funcoes = new Funcoes();

	@FXML
	public void alterarAction() {

		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Funcionario", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNumCasa.getText(), txtFieldBairro.getText(),
						txtFieldCidade.getText(), verificarSigla(cmBoxUF.getValue()));
				Funcionario f = new Funcionario(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
						txtFieldTelefone.getText(), txtFieldLogin.getText(), txtFieldSenha.getText(), Double.parseDouble(txtFieldSalario.getText()), cmBoxCargo.getValue());
				f.setId(procurarID());

				fachada.alterarCliente(f);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Funcionario alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenFuncionarios.fxml", "Sistema PetShop - Gerenciamento de Funcionários");
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
			funcoes.chamarTela("../TelaGenFuncionarios.fxml", "Sistema PetShop - Gerenciamento de Funcionários");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
		
	private int procurarID() throws NadaEncontradoException{
		int id = 0;
		try{
			List<Pessoa> lista =  fachada.listarTudo();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).equals(TelaGenFuncionariosController.funcionarioAlterar)) {
					id = (int) lista.get(i).getId();
				}
			}
		} catch (NadaEncontradoException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	private EnumUF verificar(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getNome().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}
	
	private EnumUF verificarSigla(String uf) {
		for (EnumUF ufCorrente : EnumUF.values()) {
			if (ufCorrente.getSigla().equals(uf)) {
				return ufCorrente;
			}
		}
		return EnumUF.AC; // valor padrao
	}

	public void atualizarValores() {
		txtFieldNome.setText(TelaGenFuncionariosController.funcionarioAlterar.getNome());
		txtFieldCPF.setText(TelaGenFuncionariosController.funcionarioAlterar.getCpf());
		txtFieldRua.setText(TelaGenFuncionariosController.funcionarioAlterar.getRua());
		txtFieldBairro.setText(TelaGenFuncionariosController.funcionarioAlterar.getBairro());
		txtFieldCidade.setText(TelaGenFuncionariosController.funcionarioAlterar.getCidade());
		txtFieldNumCasa.setText(TelaGenFuncionariosController.funcionarioAlterar.getNumCasa());
		txtFieldTelefone.setText(TelaGenFuncionariosController.funcionarioAlterar.getTelefone());
		txtFieldEmail.setText(TelaGenFuncionariosController.funcionarioAlterar.getEmail());
		cmBoxUF.getSelectionModel().select(verificar(TelaGenFuncionariosController.funcionarioAlterar.getUf()).getSigla());
		cmBoxCargo.getSelectionModel().select(TelaGenFuncionariosController.funcionarioAlterar.getCargo());
		txtFieldLogin.setText(TelaGenFuncionariosController.funcionarioAlterar.getLogin());
		txtFieldSenha.setText(TelaGenFuncionariosController.funcionarioAlterar.getSenha());
		txtFieldSalario.setText(String.valueOf(TelaGenFuncionariosController.funcionarioAlterar.getSalario()));		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		lblLogin.setText("Bem vindo(a), " + TelaLoginController.logado.getNome() + "!");
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}	
		
		cmBoxUF.getItems().addAll(uf);
		atualizarValores();
		
		List<String> cargo = new ArrayList<>();
		cargo.add("Dono");
		cargo.add("Médico");
		cargo.add("Balconista");
		
		cmBoxCargo.getItems().addAll(cargo);
			
	}

}
