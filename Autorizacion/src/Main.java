import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generarMD5Ficheros();
		// log in
		Scanner entrada = new Scanner(System.in);
		String usuario, password, rol = "";
		System.out.println("Intoduce usuario");
		usuario = entrada.nextLine();
		System.out.println("Introduce contraseña");
		password = entrada.nextLine();
		// leo fichero usuarios

		// preguntar por la llave

		// descifrar

		final String nombre_archivo ="usuario.txt";
		Path rutaRelativa=Paths.get(nombre_archivo);
		System.out.println(rutaRelativa);
		Path rutaAbsoluta =rutaRelativa.toAbsolutePath();
		System.out.println(rutaAbsoluta);
		
		String ruta = ""+rutaAbsoluta;
//		String ruta="C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\usuario.txt";
		
		FileReader fichero;
		try {
			fichero = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fichero);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(";");
				if (usuario.equals(datos[0])) {
					if (password.equals(datos[1])) {
						rol = datos[2];
						break;
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// cifrar los usuarios

		// preguntas por la llave / contraseña
		// leo la agenda

		Agenda agenda = new Agenda();
		ruta = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\agenda.txt";

		try {
			fichero = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fichero);
			String linea = "";
			int i = 0;
			String nombre = "", apellidos = "", direccion = "", telefono = "";
			while ((linea = br.readLine()) != null) {
				if (i == 0) {
					nombre = linea;
					i++;
				} else if (i == 1) {
					apellidos = linea;
					i++;
				} else if (i == 2) {
					direccion = linea;
					i++;
				} else if (i == 3) {
					telefono = linea;
					agenda.agenda.add(new Contacto(nombre, apellidos, direccion, telefono));
					i = 0;
				}

				// registrarActividad
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// regitrarError();
		}

		// cifras la agenda

		Administrador admin = null;
		Gestor gestor = null;
		Asistente asistente = null;

		switch (rol) {
		case "admin":
			admin = new Administrador(agenda.agenda);
			System.out.println("el usuario es un admin");
			// escibir en traza admin usuario  log in ok como rol de admin
			break;
		case "gestor":
			gestor = new Gestor(agenda.agenda);
			System.out.println("el usuario es un gestor");
			break;
		case "asistente":
			asistente = new Asistente(agenda.agenda);
			break;
		default:
			System.out.println("USUARIO NO VALIDO");

			break;
		}

		// menu usuario
		System.out.println("1. Añadir contacto");
		System.out.println("2. Agregar usuario");
		System.out.println("3. Listar contacto");
		int opcion = entrada.nextInt();
		// registro todos los numeros
		String info = "";
		Date fecha;
		switch (opcion) {
		case 1:
			switch (rol) {
			case "admin":
				admin.addContact();
				break;
			case "asistente":
				System.out.println("No tienes permiso para agregar un contacto");
				break;
			case "gestor":
				gestor.addContact();
				break;
			}

			fecha = new Date();
			info = fecha + ";" + usuario + ";" + rol + ";addContact()";
			registrar("C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\actividad.txt", info);
			// registro el tipo de accion elegida
			break;
		
		case 2:
			System.out.println("CASO 2");
			switch (rol) {
			case "admin":
				admin.agregarUsuario();
				break;
			case "asistente":
				System.out.println("No tienes permiso para agregar un usuario");
				break;
			case "gestor":
				System.out.println("No tienes permiso para agregar un usuario");
				break;
			}
			break;
		
		case 3:
			switch (rol) {
			case "admin":
				admin.listarContacto();
				break;
			case "asistente":
				asistente.listarContacto();
				break;
			case "gestor":
				gestor.listarContacto();
				break;
			}
			
			fecha = new Date();
			info = fecha + ";" + usuario + ";" + rol + ";listarContacto()";
			registrar("C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\actividad.txt", info);
			//generarMD5(info);
			break;
		}
		
		
		//generarMD5Ficheros();

	}

	public static void registrarActividad(String info) {
		String ruta = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\actividad.txt";
		FileWriter fichero;
		try {
			fichero = new FileWriter(ruta, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(info + "\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void registrar(String ruta, String info) {

		FileWriter fichero;
		try {
			fichero = new FileWriter(ruta, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(info + "\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void generarMD5(String info) {
		String ruta = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\usuario.txt";
		FileWriter fichero;
		// generar e codigo MD5 con la info
		
		try {
			fichero = new FileWriter(ruta, true);
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write(info + "\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void generarMD5Ficheros() {
		
		String ruta = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\respaldo.txt";
		String ruta1 = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\usuarios.txt";
		String ruta2 = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\agenda.txt";
		String ruta3 = "C:\\Users\\PepinoElGrande\\Eclipse2\\Autorizacion\\errores.txt";
	}
	
}