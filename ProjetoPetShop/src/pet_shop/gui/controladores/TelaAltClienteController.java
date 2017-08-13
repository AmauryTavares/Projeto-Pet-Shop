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
import pet_shop.negocio.beans.Cliente;
import pet_shop.negocio.beans.Endereco;
import pet_shop.negocio.beans.EnumUF;
import pet_shop.negocio.beans.Pessoa;
import pet_shop.negocio.excecoes.NadaEncontradoException;


public class TelaAltClienteController implements Initializable {

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
	public void alterar() {
		
		Optional<ButtonType> resultado = funcoes.alerta(AlertType.CONFIRMATION, "Alterar Cliente", "", "Deseja salvar essas alterações?");
		if (resultado.get() == ButtonType.OK) {
			try {
				Endereco end = new Endereco(txtFieldRua.getText(), txtFieldNCasa.getText(), txtFieldBairro.getText(),
						txtFieldCidade.getText(), verificarSigla(cmBoxUF.getValue()));
				Cliente c = new Cliente(txtFieldNome.getText(), txtFieldCPF.getText(), end, txtFieldEmail.getText(),
						txtFieldTelefone.getText());
				c.setId(procurarID());

				fachada.alterarCliente(c);
				funcoes.alerta(AlertType.INFORMATION, "Sucesso!", "", "Cliente alterado com sucesso!");
				try {
					funcoes.chamarTela("../TelaGenClientes.fxml", "Sistema PetShop - Painel Inicial");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			} catch (Exception e) {
				funcoes.alerta(AlertType.ERROR, "Ocorreu um problema!", "", e.getMessage());
			}
		}
		
	}
	
	@FXML
	public void voltar() {
		try {
			funcoes.chamarTela("../TelaGenClientes.fxml", "Sistema PetShop - Gerenciamento de Clientes");
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
		txtFieldNome.setText(TelaGenClientesController.clienteAlterar.getNome());
		txtFieldCPF.setText(TelaGenClientesController.clienteAlterar.getCpf());
		txtFieldRua.setText(TelaGenClientesController.clienteAlterar.getRua());
		txtFieldBairro.setText(TelaGenClientesController.clienteAlterar.getBairro());
		txtFieldCidade.setText(TelaGenClientesController.clienteAlterar.getCidade());
		txtFieldNCasa.setText(TelaGenClientesController.clienteAlterar.getNumCasa());
		txtFieldTelefone.setText(TelaGenClientesController.clienteAlterar.getTelefone());
		txtFieldEmail.setText(TelaGenClientesController.clienteAlterar.getEmail());
		cmBoxUF.getSelectionModel().select(verificar(TelaGenClientesController.clienteAlterar.getUf()).getSigla());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> uf = new ArrayList<>();
		for (EnumUF ufCorrente : EnumUF.values()) {
			uf.add(ufCorrente.getSigla());
		}
		
		cmBoxUF.getItems().addAll(uf);
		atualizarValores();
		
	}

}
