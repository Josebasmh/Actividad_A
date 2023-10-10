package controller;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ActividadAController implements Initializable{

	@FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private CheckBox chbDeporte;
    @FXML
    private ComboBox<String> cmbEdad;
    @FXML
    private ListView<String> lsvDeporte;
    @FXML
    private RadioButton rdbHombre;
    @FXML
    private RadioButton rdbMujer;
    @FXML
    private RadioButton rdbOtro;
    @FXML
    private ToggleGroup sexo;
    @FXML
    private Slider sldCine;
    @FXML
    private Slider sldCompras;
    @FXML
    private Slider sldTelevision;
    @FXML
    private TextField txtHermanos;
    @FXML
    private TextField txtProfesion;

    public void mostrar(ActionEvent event) {
    	try {
    		
    		// Recogida de datos
    		String profesion = txtProfesion.getText();
    		String hermanos = txtHermanos.getText();
    		String edad = (String) cmbEdad.getValue();
    		String sexo;
    		if (rdbHombre.isSelected()) {sexo=rdbHombre.getText();}else if(rdbMujer.isSelected()) {sexo=rdbMujer.getText();}else {sexo=rdbOtro.getText();}
    		ObservableList<String> deportes;
    		if (chbDeporte.isSelected()) {deportes= lsvDeporte.getSelectionModel().getSelectedItems();}else {deportes=null;}
    		int compras = (int) sldCompras.getValue();
    		int television = (int) sldTelevision.getValue();
    		int cine = (int) sldCine.getValue();
    		
    		// Sacar datos en pantalla mediante ventana(preparar el mensaje de la ventana antes)
    		String mensaje= "Profesión: " + profesion + 
    				"\nNº Hermanos: " + hermanos + 
    				"\nEdad: " + edad + 
    				"\nSexo: " + sexo + 
    				"\nDeportes que practicas: \n\t" +
    				deportes + 
    				"\nGrado de aficción a compras: " + compras +
    				"\nGrado de aficción a televisión" + television +
    				"\nGrado de aficción a ir al cine: " + cine;
    		mostrarDialogoInformacionSEncabezado(mensaje);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    // Metodo para que al inicializar cargue el combobox de edad y la lista de deportes
    public void initialize(URL arg0, ResourceBundle arg1) {
    	  
    	cmbEdad.setItems( FXCollections.observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"));
    	cmbEdad.getSelectionModel().select(0);
    	lsvDeporte.setItems(FXCollections.observableArrayList("Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro"));
    }
    
    public void mostrarDialogoInformacionSEncabezado(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TUS DATOS");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
