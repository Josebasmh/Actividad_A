package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	public void start(Stage stage) {
		stage.setTitle("ENCUESTA"); 
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/Encuesta.fxml"));
			Scene scene = new Scene(root,400,400); 
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			System.out.println("La ventana no se abrió correctamente.");
			e.printStackTrace();
		}
	}
		public static void main(String[] args) {
			launch(args);
		}
}
