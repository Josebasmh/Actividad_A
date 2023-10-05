package model;

public class Operaciones {

	// Variables de la clase
	private String profesion, edad, tipoDepartamento;
	private int hermanos, compras, television, cine;
	private char sexo;
	private boolean departamento;
	
	// Constructores
	public Operaciones(String prof ,int her, String ed, char sex, boolean dep, String tipoDep, int comp, int tele, int cine) {
		profesion = prof;
		edad = ed;
		sexo = sex;
		departamento = dep;
		tipoDepartamento = tipoDep;
		compras = comp;
		television = tele;
		this.cine = cine;
	}
	public Operaciones() {}
	
	// Metodos getter y setter
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getTipoDepartamento() {
		return tipoDepartamento;
	}
	public void setTipoDepartamento(String tipoDepartamento) {
		this.tipoDepartamento = tipoDepartamento;
	}
	public int getHermanos() {
		return hermanos;
	}
	public void setHermanos(int hermanos) {
		this.hermanos = hermanos;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public int getCompras() {
		return compras;
	}
	public void setCompras(int compras) {
		this.compras = compras;
	}
	public int getTelevision() {
		return television;
	}
	public void setTelevision(int television) {
		this.television = television;
	}
	public int getCine() {
		return cine;
	}
	public void setCine(int cine) {
		this.cine = cine;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public boolean isDepartamento() {
		return departamento;
	}
	public void setDepartamento(boolean departamento) {
		this.departamento = departamento;
	}
	
}
