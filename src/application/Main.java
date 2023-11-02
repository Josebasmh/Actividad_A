package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Clase donde se inicia la aplicación.
 */
public class Main extends Application{
	/**
	 * Se crea y configura el VBox con el fxml asociado y creamos una escena de 800x800.
	 * Se añade al stage y lo mostamos. Captura La excepción que se puede generar.
	 */
	public void start(Stage stage) {
		stage.setTitle("ENCUESTA"); 
		VBox root;
		try {
			root = (VBox)FXMLLoader.load(getClass().getResource("/fxml/Encuesta.fxml"));
			Scene scene = new Scene(root,800,800); 
			stage.setScene(scene);
			stage.setMinHeight(800);
			stage.setMinWidth(800);
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
