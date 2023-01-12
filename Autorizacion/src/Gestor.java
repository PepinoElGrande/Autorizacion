import java.util.ArrayList;

public class Gestor extends Agenda{

	String usuario;
	String password;
	String rol;
	
	ArrayList<Contacto> agenda;

	
	public Gestor(ArrayList<Contacto> agenda) {
		this.agenda = agenda;
	}
	

@Override
	public void eliminarContact(int indice) {
		// TODO Auto-generated method stub
		System.out.println("No tienes permisos para eliminar un contacto");
	}

	
	
}
