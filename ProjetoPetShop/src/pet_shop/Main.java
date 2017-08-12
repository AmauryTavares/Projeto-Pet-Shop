package pet_shop;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application{
	
	public static Stage myStage;
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		if (primaryStage.getScene() == null) {
			BorderPane bPane = FXMLLoader.load(getClass().getResource("gui/TelaLogin.fxml"));
			
			Scene scene = new Scene(bPane);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sistema PetShop - Login");
			Main.myStage = primaryStage;
			primaryStage.show();
			
			//Dica teste
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Dica");
			alert.setContentText("Login : admin\nSenha: 1234");
			alert.showAndWait();
			//
		} else {
			primaryStage.show();
		}
		
		
	}

}
