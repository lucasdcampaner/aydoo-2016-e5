package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GeneradorSalida {

	private File carpetaSalida; 
	
	public void copiarArchivosDesdePlantilla(File plantillaOrigen, File carpetaSalida) throws IOException {
		this.carpetaSalida = carpetaSalida;
		FileUtils.copyDirectory(plantillaOrigen, carpetaSalida);
	}
	
	public void sobreEscribirIndex(List<ItemEntrada> itemsEntrada, Formateador formateador) {
		generarListaDeStringsSalida(itemsEntrada, formateador);
	}
	
	public List<String> generarListaDeStringsSalida(List<ItemEntrada> itemsEntrada, Formateador formateador) {
		
		boolean inicioTag = true;
		List<String> listaDeStringsSalida = new LinkedList<String>();
		
		 for (ItemEntrada itemEntrada : itemsEntrada) {
			
			 listaDeStringsSalida.add(itemEntrada.getTextoFormateado(formateador,inicioTag));
			 inicioTag = !inicioTag;
		 }
		
		return listaDeStringsSalida;
	}

}
