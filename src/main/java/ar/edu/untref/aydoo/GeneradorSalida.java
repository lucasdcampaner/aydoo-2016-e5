package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GeneradorSalida {

	private final String lineaASobreEscribir = "[este-es-el-texto-a-reemplazar]";

	private String nombreCarpetaSalida;
	private Scanner scanner;

	public GeneradorSalida(String nombreCarpetaSalida) {
		this.nombreCarpetaSalida = nombreCarpetaSalida;
	}

	public String generarStringSalida(List<ItemEntrada> itemsEntrada, Formateador formateador) {

		String stringSalida = "";

		for (ItemEntrada itemEntrada : itemsEntrada) {
			stringSalida = stringSalida + itemEntrada.getTextoFormateado(formateador);
		}

		return stringSalida;
	}

	public void generarSalidaEnCarpeta(List<ItemEntrada> itemsEntrada, Formateador formateador) throws IOException {
		copiarArchivosDesdePlantilla();
		sobreEscribirLineaEnIndex(itemsEntrada, formateador);
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

		DirUtils.copy(plantilla.toPath(), carpetaSalida.toPath());
	}

	private void sobreEscribirLineaEnIndex(List<ItemEntrada> itemsEntrada, Formateador formateador) throws IOException {

		String stringSalida = generarStringSalida(itemsEntrada, formateador);
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