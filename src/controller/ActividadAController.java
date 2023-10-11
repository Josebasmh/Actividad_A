package controller;



import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ActividadAController implements Initializable{

	/*
	 * Variable de clase para controlar que la insercción de datos es correcta.
	 * Se coloca aquí para que pueda utilizarse en distintos metodos.
	 */
	ArrayList<String> arrListCamposnulos = new ArrayList<String>();
	
	// Elementos del fxml
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
    
    // Metodo(fxml) para mostrar la información insertada
    @FXML
    public void mostrar(ActionEvent event) {
    	
		try {
			// Llamada a metodo auxiliar para leer datos y crear mensaje 
    		String mensaje=crearMensaje();
    		    		
    		// Llamada a metodo auxiliar para mostrar datos en pantalla 
    		mostrarDialogoInformacionSEncabezado(mensaje);
    		
    	}catch(NullPointerException e) {
    		String menErr ="";
    		Iterator<String> it = arrListCamposnulos.iterator();
    		while (it.hasNext()) {
    			String linea =it.next();
    			menErr = menErr + linea + "\n";
    		}
    		Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(menErr);
            alert.showAndWait();
    	}
    }
    
    // Metodo(fxml) para activar y desactivar la lista de deportes mediante un ActionListener de chbDeporte.
    @FXML
    public void activar(ActionEvent event) {
    	if (chbDeporte.isSelected()) {
    		lsvDeporte.setDisable(false);
    	}else {
    		lsvDeporte.setDisable(true);
    	}
    }
    
    // Metodo(fxml) para cerrar la ventana
    @FXML
    void cerrar(ActionEvent event) {
    	Node source=(Node) event.getSource();
    	Scene sce= source.getScene();
    	Stage sta= (Stage)sce.getWindow();
    	sta.close();
    }

    // Metodo para que al inicializar cargue el combobox de edad y la lista de deportes
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	cmbEdad.setItems( FXCollections.observableArrayList("Menores de 18", "Entre 18 y 30", "Entre 31 y 50", "Entre 51 y 70", "Mayores de 70"));
    	cmbEdad.getSelectionModel().select(0);
    	lsvDeporte.setItems(FXCollections.observableArrayList("Tenis", "Fútbol", "Baloncesto", "Natación", "Ciclismo", "Otro"));
    	// configurar la lista para selección multiple
    	lsvDeporte.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    // Metodo auxiliar que crea una ventana emergente de alerta para mostrar la información
    public void mostrarDialogoInformacionSEncabezado(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TUS DATOS");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    // Metodo auxiliar para recoger información de la ventana y devolver el mensaje con los datos ordenados
    public String crearMensaje() {
    	
    	// Recogida de datos
		String profesion = txtProfesion.getText();
		String hermanos = txtHermanos.getText();
		String edad = (String) cmbEdad.getValue();
		String sexo="";
		if (rdbHombre.isSelected()) {sexo=rdbHombre.getText();}else if(rdbMujer.isSelected()) {sexo=rdbMujer.getText();}else if(rdbOtro.isSelected()){sexo=rdbOtro.getText();}
		// Recoger datos de la lista de deportes mediante un arraylist
		String deportes="";
		if (chbDeporte.isSelected()) {
			ObservableList<String> arrListdeportes= lsvDeporte.getSelectionModel().getSelectedItems();
			Iterator itDep= arrListdeportes.iterator();
			while(itDep.hasNext()) {
				String dep=(String) itDep.next();
				deportes = deportes + "\t" + dep +"\n";
			}
		}
		int compras = (int) sldCompras.getValue();
		int television = (int) sldTelevision.getValue();
		int cine = (int) sldCine.getValue();
		
		// Comprobar que todos los datos están correctamente. Si no es así, saltara una Exceptcion que capturará el padre
		arrListCamposnulos.clear();
		if (profesion.equals("")) {
			arrListCamposnulos.add("Hay que rellenar el campo profesión");
		}
		if (hermanos.equals("")) {
			arrListCamposnulos.add("Hay que rellenar el campo Hermanos");
		}
		if (sexo.equals("")) {
			arrListCamposnulos.add("Hay que indicar con que género te identificas");
		}
		if (chbDeporte.isSelected() && deportes=="") {
			arrListCamposnulos.add("Hay que indicar los deportes que practicas");
		}
		if (arrListCamposnulos.isEmpty()==false) {
			throw new NullPointerException();
		}
		
		// Preparar el mensaje de la ventana
		String mensaje= "Profesión: " + profesion + 
				"\nNº Hermanos: " + hermanos + 
				"\nEdad: " + edad + 
				"\nSexo: " + sexo + 
				"\nDeportes que practicas: \n" +
				deportes + 
				"Grado de aficción a compras: " + compras +
				"\nGrado de aficción a televisión" + television +
				"\nGrado de aficción a ir al cine: " + cine;
		return mensaje;
    }
}
