import java.util.Scanner;

public  class Contacto {

	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;

	

public Contacto() {
	
}

	public Contacto(String nombre, String apellido, String direccion, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}
}
