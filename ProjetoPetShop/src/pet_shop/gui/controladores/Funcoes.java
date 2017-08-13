package pet_shop.gui.controladores;

import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pet_shop.Main;

public class Funcoes {
	
	public void chamarTela(String caminhoTela, String Titulo) throws Exception {
		BorderPane bPane = FXMLLoader.load(getClass().getResource(caminhoTela));
		Stage newStage = new Stage();
		Scene scene = new Scene(bPane);
		newStage.setScene(scene);
		Main.myStage.hide();
		Main main = new Main();
		newStage.setTitle(Titulo);
		newStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
		newStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
		Main.myStage = newStage;
		main.start(newStage);
	}
	
	public Optional<ButtonType> alerta(AlertType alertType, String titulo, String cabecalho, String mensagem) {
		Alert alert = new Alert(alertType);
		alert.setTitle(titulo);
		alert.setHeaderText(cabecalho);
		alert.setContentText(mensagem);
		return alert.showAndWait();
	}
}
