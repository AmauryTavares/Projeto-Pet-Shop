package pet_shop;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
			Main.myStage.getIcons().add(new Image("file:src/pet_shop/img/paw_print.png"));
			primaryStage.show();
			
		} else {
			primaryStage.show();
		}
		
		
	}

}
