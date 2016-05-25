package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GeneradorSalida {
	
	public void copiarArchivosDesdePlantilla(File plantillaOrigen, File carpetaSalida) throws IOException {
		FileUtils.copyDirectory(plantillaOrigen, carpetaSalida);
	}
	
	public void sobreEscribirIndex(List<ItemEntrada> itemsEntrada, Formateador formateador) {
		generarListaDeStringsSalida(itemsEntrada, formateador);
	}
	
	public String imprimirPorPantalla(List<ItemEntrada> itemsEntrada, Formateador formateador) {
	
		List<String> listaParaImprimirPorPantalla = generarListaDeStringsSalida(itemsEntrada, formateador);
		String salidaPorPantalla = "";
		
		for (String stringSalida : listaParaImprimirPorPantalla) {
			salidaPorPantalla = salidaPorPantalla + stringSalida;
		}
		
		return salidaPorPantalla;
	}
	
	private List<String> generarListaDeStringsSalida(List<ItemEntrada> itemsEntrada, Formateador formateador) {
		
		List<String> listaDeStringsSalida = new LinkedList<String>();
		
		 for (ItemEntrada itemEntrada : itemsEntrada) {
			 listaDeStringsSalida.add(itemEntrada.getTextoFormateado(formateador));
		 }
		
		return listaDeStringsSalida;
	}

}
