package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class GeneradorSalida {
	
	private final String lineaASobreEscribir = "[este-es-el-texto-a-reemplazar]";
	private final File plantilla = new File("target/plantilla");
	private String carpetaSalida;
	
	public GeneradorSalida(String carpetaSalida) {
		this.carpetaSalida = carpetaSalida;
	}
	
	public void copiarArchivosDesdePlantilla() throws IOException {
		FileUtils.copyDirectory(this.plantilla, new File(this.carpetaSalida));
	}
	
	public void sobreEscribirIndex(List<ItemEntrada> itemsEntrada, Formateador formateador) throws FileNotFoundException {
		
		String stringSalida = generarStringSalida(itemsEntrada, formateador);
		
		File archivoIndex = new File("target/carpetaPara/index.html");
		Scanner scanner = new Scanner(archivoIndex);
		
		String linealoca = "";
		while (scanner.hasNextLine()) {
			linealoca = scanner.nextLine().trim();
			if (linealoca.compareTo(lineaASobreEscribir) == 0){
				System.out.println("ACA");
			}
		}
		
	}
		
	public String generarStringSalida(List<ItemEntrada> itemsEntrada, Formateador formateador) {
		
		String stringSalida = "";
		
		 for (ItemEntrada itemEntrada : itemsEntrada) {
			 stringSalida = stringSalida + itemEntrada.getTextoFormateado(formateador);
		 }
		
		return stringSalida;
	}
	
}
