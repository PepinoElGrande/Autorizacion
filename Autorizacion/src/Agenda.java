import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda extends Contacto{
	 
	
	
	ArrayList <Contacto> agenda;
	
	public void addContact() {
		Scanner entrada = new Scanner(System.in);
		String nombre, apellido, direccion, telefono;
		System.out.println("Introduce el nombre: ");
		nombre = entrada.nextLine();
		System.out.println("Introduce el apellidos: ");
		apellido = entrada.nextLine();
		System.out.println("Introduce el direccion: ");
		direccion = entrada.nextLine();
		System.out.println("Introduce el telefono: ");
		telefono = entrada.nextLine();
		agenda.add(new Contacto(nombre, apellido, direccion, telefono));
		
		String ruta = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\agenda.txt"; 
		FileWriter fichero; 
		// generar e codigo MD5 con la info 
		try { fichero = new FileWriter(ruta, true); 
		BufferedWriter bw = new BufferedWriter(fichero); 
		bw.write("nombre :"+nombre + "\n"); bw.write("apellidos :"+apellido + "\n"); 
		bw.write("direccion :"+direccion + "\n"); 
		bw.write("telefono :"+telefono + "\n");
		bw.close(); fichero.close();
		} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		}
	}

	public void modificarContact(int indice) {
		String nombre, apellido, direccion, telefono;
		System.out.println("Introduce los datos que quieres modificar");
		System.out.println("1. Nombre: ");
		System.out.println("2. Apellido: ");
		System.out.println("3. Direccion: ");
		System.out.println("4. Telefono: ");
		System.out.println("5. Todo: ");
		Scanner entrada = new Scanner(System.in);
		
		nombre = agenda.get(indice).getNombre();
		apellido = agenda.get(indice).getApellido();
		direccion = agenda.get(indice).getDireccion();
		telefono = agenda.get(indice).getTelefono();
		
		
		
		Contacto aux = new Contacto(nombre, apellido, direccion, telefono);
		switch (entrada.nextInt()) {
		case 1:
			System.out.println("Introduce el nombre: ");
			nombre = entrada.nextLine();
		
			
			break;
		case 2:
			System.out.println("Introduce el apellidos: ");
			apellido = entrada.nextLine();
		
			break;

		case 3:
			System.out.println("Introduce el direccion: ");
			direccion = entrada.nextLine();
			
			break;

		case 4:
			System.out.println("Introduce el telefono: ");
			telefono = entrada.nextLine();
			
			break;

		case 5:
			System.out.println("Introduce el nombre: ");
			nombre = entrada.nextLine();
			System.out.println("Introduce el apellidos: ");
			apellido = entrada.nextLine();
			System.out.println("Introduce el direccion: ");
			direccion = entrada.nextLine();
			System.out.println("Introduce el telefono: ");
			telefono = entrada.nextLine();
			break;

		default:
			System.out.println("Opcion no válida");
			break;

		}
		aux.setNombre(nombre);
		aux.setApellido(apellido);
		aux.setDireccion(direccion);
		aux.setTelefono(telefono);
		agenda.set(indice, aux);

	}
	
	public int buscarContacto() {
	
		
		return -1;	
	}
	public void eliminarContact(int indice) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Estas seguro que quieres eliminar el contacto?");
		System.out.println("1. Si");
		System.out.println("Otro. No");
		if(entrada.nextInt() == 1) {
			agenda.remove(indice);	
		}
		



	}

	public void listarContacto() {
		
		
		for(int i = 0; i < this.agenda.size(); i++) {
			System.out.println("Nombre: " + agenda.get(i).getNombre());
			System.out.println("Apellido: " + agenda.get(i).getApellido());
			System.out.println("Direccion: " +agenda.get(i).getDireccion());
			System.out.println("Telefono: " + agenda.get(i).getTelefono());
		}
	

	}
	public Agenda() {
		agenda = new ArrayList<>();
	}
	
	public Agenda(String nombre, String apellido, String direccion, String telefono) {
		super(nombre, apellido, direccion, telefono);
		// TODO Auto-generated constructor stub
}
}