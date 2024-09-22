
import java.io.File;
import java.io.IOException;

public class Bloque1 {

	public static void main(String[] args) {

		// 1. Crea un directorio llamado "dam-accesodatos"
		File directorio = new File("src/dam-accesoDatosPruebaEjercicio");

		if (directorio.mkdir()) {
			System.out.println("1. Directorio 'acesso a datos' creado correctamente");
		} else {
			System.out.println("1. No se pudo crear directorio o ya existe");
		}

		// 2. Crea un fichero llamado "ejercicio1" dentro del directorio "dam-accesodatos"
		File f1 = new File(directorio, "ejercicio1.txt");
		try {
			if (f1.createNewFile()) {
				System.out.println("2. Fichero 'ejercicio1' creado correctamente.");
			} else {
				System.out.println("2. No se pudo crear el fichero 'ejercicio1' o ya existe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. Muestra por pantalla la longitud del fichero con nombre "ejercicio1"
		if (f1.exists()) {
			System.out.println("3. Longitud del fichero 'ejercicio1' es: " + f1.length() + " bytes.");
		} else {
			System.out.println("3. El fichero 'ejercicio1' no existe");
		}

		// 4. Crea un fichero llamado "ejercicio2" dentro del directorio "dam-accesodatos"
		File f2 = new File(directorio, "ejercicio2.txt");
		try {
			if (f2.createNewFile()) {
				System.out.println("4. Fichero 'ejercicio2' creado correctamente");
			} else {
				System.out.println("4. No se pudo crear el fichero 'ejercicio2' o ya existe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 5. Muestra todos los ficheros del directorio "dam-accesodatos"
		String[] ficheros = directorio.list();
		System.out.println("5. Ficheros existente en el directorio 'dam-accesodatos:'");
		if (ficheros != null && ficheros.length > 0) {	
			for (String fichero : ficheros) {
				System.out.println("->" + fichero);
			}
		} else {
			System.out.println("5. No hay ficheros que mostrar. El directorio 'dam-accesodatos' está vacío o no existe.");
		}

		// 6. Elimina el fichero llamado "ejercicio1"
		if (f1.delete()) {
			System.out.println("6. Fichero 'ejercicio1.txt' eliminado correctamente");
		} else {
			System.out.println("6. No se pudo eliminar el fichero 'ejercicio1.txt'");
		}

		// 7. Muestra todos los ficheros del directorio "dam-accesodatos"
		ficheros = directorio.list();
		System.out.println("7. Ficheros existente en el directorio 'dam-accesodatos'");		
		if (ficheros != null && ficheros.length > 0) {
			for (String fichero : ficheros) {
				System.out.println("-> " + fichero);
			}
		} else {
			System.out.println("7. No hay ficheros que mostrar. El directorio 'dam-accesodatos' esta vacio o no existe");
		}

		// 8. Elimina nuevamente el fichero llamado "ejercicio1"
		if (f1.exists()) {
			if (f1.delete()) {
				System.out.println("8. El fichero 'ejercicio1.txt' se ha eliminado correctamente");
			} else {
				System.out.println("8. No se pudo eliminar el fichero 'ejercicio1.txt'. ");
			}
		} else {
			System.out.println("8. El fichero 'ejercicio1' no existe");
		}

		// 9. Borrar directorio sin ficheros en su interior
		if (directorio.exists()) {
			if (directorio.delete()) {
				System.out.println("9. Se ha podido eliminar el directorio correctamente");
			} else {
				System.out.println("9. No se pudo eliminar el directorio, no esta vacío.");
			}
		} else {
			System.out.println("9. El directorio no existe");
		}

		// 10. Borrar directorio con ficheros en su interior
		borrarDirectorio(directorio);
	}
	
	public static void borrarDirectorio(File directorio) {
		File[] ficheros = directorio.listFiles();
		// Elimina los ficheros contenidos dentro del directorio de forma recursiva
		if (ficheros != null) { 
			for (File fichero : ficheros) {
				if (fichero.isDirectory()) {
					borrarDirectorio(fichero);
				} else {
					fichero.delete(); 
				}
			}
		}
		
		if (directorio.delete()) {
			System.out.println("10. Directorio '" + directorio.getName() + "' eliminado correctamente.");
		} else {
			System.out.println("10. No se pudo eliminar el directorio '" + directorio.getName() + "'.");
		}
	}
}