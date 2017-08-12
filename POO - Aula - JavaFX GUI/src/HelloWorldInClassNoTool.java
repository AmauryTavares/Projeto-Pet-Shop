import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorldInClassNoTool extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minha primeira tela");
        
        Button b1 = new Button("Bot�o OK");
        b1.setLayoutX(130);
        b1.setLayoutY(60);
        
        Label l1 = new Label ("Label do bot�o");
        l1.setLayoutX(30);
        l1.setLayoutY(60);
        
        BorderPane myPane = new BorderPane();
        Pane p2 = new Pane();
        
        myPane.setLeft(p2);
        myPane.setCenter(b1);
        
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        
        primaryStage.show();
    }

}
