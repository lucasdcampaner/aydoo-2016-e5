package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class GeneradorSalida {

	private final String lineaASobreEscribir = "[este-es-el-texto-a-reemplazar]";
	private final File plantilla = new File("target/plantilla");
	private String carpetaSalida;
	private FileWriter indexNuevo;
	private File indexHTML = new File("target/carpetaPara/index.html");
	Scanner scanner;

	public GeneradorSalida(String carpetaSalida) {
		this.carpetaSalida = carpetaSalida;
	}

	public void copiarArchivosDesdePlantilla() throws IOException {
		FileUtils.copyDirectory(this.plantilla, new File(this.carpetaSalida));
	}

	public void sobreEscribirLineaEnIndex(List<ItemEntrada> itemsEntrada, Formateador formateador) throws IOException {

		String stringSalida = generarStringSalida(itemsEntrada, formateador);
		scanner = new Scanner(indexHTML);
		String lineaLeida = "";
		
		crearArchivoIndexNuevoARenombrar();
		while (scanner.hasNextLine()) {
			lineaLeida = scanner.nextLine();
			if (lineaLeida.toUpperCase().trim().equals(lineaASobreEscribir.toUpperCase().trim())) {
				escribirArchivoIndexNuevoARenombrar(indexNuevo, stringSalida);
			} else {
				escribirArchivoIndexNuevoARenombrar(indexNuevo, lineaLeida);
			}			
		}
		cerrarArchivoIndexNuevoARenombrar();
		borrarIndexHTMLActual();
		renombrarArchivoIndexNuevo();
	}

	private void crearArchivoIndexNuevoARenombrar() throws IOException {
		indexNuevo = new FileWriter("target/carpetaPara/indexNuevo.html");
	}
	
	private void cerrarArchivoIndexNuevoARenombrar() throws IOException {
		indexNuevo.close();
	}

	private void borrarIndexHTMLActual() {
		indexHTML.delete();
	}

	private void escribirArchivoIndexNuevoARenombrar(FileWriter indexNuevo, String lineaAEscribir) throws IOException {
		indexNuevo.write(lineaAEscribir + "\n");
	}

	private void renombrarArchivoIndexNuevo(){
		File archivoARenombrar = new File("target/carpetaPara/indexNuevo.html");
		archivoARenombrar.renameTo(indexHTML);
	}
	
	public String generarStringSalida(List<ItemEntrada> itemsEntrada, Formateador formateador) {

		String stringSalida = "";

		for (ItemEntrada itemEntrada : itemsEntrada) {
			stringSalida = stringSalida + itemEntrada.getTextoFormateado(formateador);
		}

		return stringSalida;
	}

}
