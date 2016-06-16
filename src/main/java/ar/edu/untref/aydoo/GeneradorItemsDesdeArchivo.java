package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GeneradorItemsDesdeArchivo {

	private String archivoEntrada;
	
	public GeneradorItemsDesdeArchivo(String archivoEntrada) {
		this.archivoEntrada = archivoEntrada;
	}
	
	public List<Item> getItemsEntrada() throws IOException {

		FormateadorHTML formateadorHTML = new FormateadorHTML();
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML); 
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada(archivoEntrada);
		List<String> itemsLeidos = lectorDeArchivoDeEntrada.getListaItemsEntrada();
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);		
		
		List<Item> listaParaSalida = formateadorHTML.crearListaParaSalidaHTML(itemsObtenidos);
		
			
		return listaParaSalida;
	}
}
