package estudio_tarea_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorFicheroTexto {

	public static Scanner sc = new Scanner(System.in);

	public String solicitarRutaFichero() {
		System.out.println("Ruta del fichero: ");
		String ruta = sc.nextLine();

		System.out.println("Nombre del fichero: ");
		String nombreFichero = sc.nextLine();

		String rutaFichero = ruta + nombreFichero;

		return rutaFichero;

	}

	public void mostrarFicheroDeTexto(String rutaFicheroDeTexto) {

		File ficheroDeTexto = new File(rutaFicheroDeTexto);

		try (BufferedReader br = new BufferedReader(new FileReader(ficheroDeTexto))) {
			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero " + ficheroDeTexto.getName());
		}
	}

	public void escribirEnFicheroDeTexto(String rutaFicheroDeTexto) {

		File ficheroDeTexto = new File(rutaFicheroDeTexto);

		if (!ficheroDeTexto.exists()) {
			try {
				ficheroDeTexto.createNewFile();

				try (FileWriter fw = new FileWriter(ficheroDeTexto); BufferedWriter bw = new BufferedWriter(fw)) {
					String linea = "";

					while (!(linea = sc.nextLine()).contains("exit")) {

						bw.write(linea);
						bw.newLine();
					}
				} catch (Exception e) {

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero " + ficheroDeTexto.getName() + " ya  existe.");

		}
	}
}