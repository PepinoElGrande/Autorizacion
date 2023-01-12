import java.util.ArrayList;

public class Asistente extends Agenda{
	
	String usuario;
	String password;
	String rol;
	ArrayList <Contacto> agenda;
	
	public Asistente(ArrayList<Contacto> agenda) {
		this.agenda = agenda;
	}
	
	@Override
	public void addContact() {
	System.out.println("No tienes permisos para añadir un contacto");
		
	}
	@Override
	public void modificarContact(int indice) {
		// TODO Auto-generated method stub
		System.out.println("No tienes permisos para modificar un contacto");
	}
	@Override
	public void eliminarContact(int indice) {
		// TODO Auto-generated method stub
		System.out.println("No tienes permisos para eliminar un contacto");
	}
	
	@Override
	public void listarContacto() {
				
		for(int i = 0; i < agenda.size(); i++) {
			System.out.println("Nombre: " + agenda.get(i).getNombre());
			System.out.println("Apellido: " + agenda.get(i).getApellido());
			System.out.println("Direccion: " +agenda.get(i).getDireccion());
			System.out.println("Telefono: " + agenda.get(i).getTelefono());
		}
	

	}

}
