 package ar.edu.untref.aydoo.entradasalida;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import ar.edu.untref.aydoo.dominio.Item;

public class GeneradorSalida {

	private final String lineaASobreEscribir = "[este-es-el-texto-a-reemplazar]";

	private String nombreCarpetaSalida;
	private Scanner scanner;

	public GeneradorSalida(String nombreCarpetaSalida) {
		this.nombreCarpetaSalida = nombreCarpetaSalida;
	}

	/**
	 * Este metodo se utiliza para imprimir la salida por pantalla y para imprimirla en el archivo de salida. 
	 */
	
	public String generarStringSalidaHTML(List<Item> itemsEntrada) {

		String stringSalida = "";

		for (Item itemEntrada : itemsEntrada) {
			stringSalida = stringSalida + itemEntrada.getTextoFormateadoHTML();
		}

		return stringSalida;
	}
	
	public void generarSalidaEnCarpeta(List<Item> itemsEntrada) throws IOException {
		copiarArchivosDesdePlantilla();
		sobreEscribirLineaEnIndex(itemsEntrada);
	}

	private String obtenerPathJar() {
		File jar = new File(System.getProperty("java.class.path"));
		File direccionJar = jar.getAbsoluteFile().getParentFile();
		String pathJar = direccionJar.toString();
		return pathJar;
	}

	private File obtenerIndexHTML() {
		File indexHTML = new File(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/index.html");
		return indexHTML;
	}

	private void copiarArchivosDesdePlantilla() throws IOException {

		String pathJar = obtenerPathJar();
		File plantilla = new File(pathJar + "/plantilla");
		File carpetaSalida = new File(pathJar + "/" + this.nombreCarpetaSalida);

		CopiadorDeDirectorios.copiarDirectorio(plantilla.toPath(), carpetaSalida.toPath());
	}

	private void sobreEscribirLineaEnIndex(List<Item> itemsEntrada) throws IOException {

		String stringSalida = generarStringSalidaHTML(itemsEntrada);
		File indexHTML = obtenerIndexHTML();
		FileWriter indexNuevo = crearArchivoIndexNuevoARenombrar();
		scanner = new Scanner(indexHTML);
		String lineaLeida = "";

		while (scanner.hasNextLine()) {
			lineaLeida = scanner.nextLine();
			if (lineaLeida.toUpperCase().trim().equals(lineaASobreEscribir.toUpperCase().trim())) {
				escribirArchivoIndexNuevoARenombrar(indexNuevo, stringSalida);
			} else {
				escribirArchivoIndexNuevoARenombrar(indexNuevo, lineaLeida);
			}
		}
		cerrarArchivoIndexNuevoARenombrar(indexNuevo);
		borrarIndexHTMLActual(indexHTML);
		renombrarArchivoIndexNuevo(indexHTML);
	}

	private FileWriter crearArchivoIndexNuevoARenombrar() throws IOException {
		FileWriter indexNuevo = new FileWriter(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/indexNuevo.html");
		return indexNuevo;
	}

	private void cerrarArchivoIndexNuevoARenombrar(FileWriter indexNuevo) throws IOException {
		indexNuevo.close();
	}

	private void borrarIndexHTMLActual(File indexHTML) {
		indexHTML.delete();
	}

	private void escribirArchivoIndexNuevoARenombrar(FileWriter indexNuevo, String lineaAEscribir) throws IOException {
		indexNuevo.write(lineaAEscribir + "\n");
	}

	private void renombrarArchivoIndexNuevo(File indexHTML) {
		File archivoARenombrar = new File(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/indexNuevo.html");
		archivoARenombrar.renameTo(indexHTML);
	}
}