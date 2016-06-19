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
	 * Salida por pantalla 
	 */
	public String generarStringSalidaHTML(List<Item> itemsEntrada) {

		String stringSalida = "";
		
		for (Item itemEntrada : itemsEntrada) {
			stringSalida = stringSalida + itemEntrada.getTextoFormateadoHTML();
		}
		return stringSalida;
	}
	
	/**
	 * Salida en carpeta 
	 */
	public void generarSalidaEnCarpeta(List<Item> itemsEntrada) throws IOException {
	
		String pathJar = obtenerPathJar();
		File plantilla = new File(pathJar + "/plantilla");
		File carpetaSalida = new File(pathJar + "/" + this.nombreCarpetaSalida);
		
		CopiadorDeDirectorios.copiarDirectorio(plantilla.toPath(), carpetaSalida.toPath());
		sobreEscribirLineaEnIndex(itemsEntrada);
	}
	
	private String obtenerPathJar() {
		File jar = new File(System.getProperty("java.class.path"));
		File direccionJar = jar.getAbsoluteFile().getParentFile();
		String pathJar = direccionJar.toString();
		return pathJar;
	}	
	
	private void sobreEscribirLineaEnIndex(List<Item> itemsEntrada) throws IOException {

		String stringSalida = generarStringSalidaHTML(itemsEntrada);
		File indexHTML = new File(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/index.html");
		FileWriter indexNuevo = new FileWriter(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/indexNuevo.html");
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
		indexNuevo.close();
		indexHTML.delete();
		File archivoARenombrar = new File(obtenerPathJar() + "/" + this.nombreCarpetaSalida + "/indexNuevo.html");
		archivoARenombrar.renameTo(indexHTML);
	}

	private void escribirArchivoIndexNuevoARenombrar(FileWriter indexNuevo, String lineaAEscribir) throws IOException {
		indexNuevo.write(lineaAEscribir + "\n");
	}
}