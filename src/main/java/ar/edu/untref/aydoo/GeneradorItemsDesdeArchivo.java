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

		Formateador formateadorHTML = new FormateadorHTML();
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML); 
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada(archivoEntrada);
		List<String> itemsLeidos = lectorDeArchivoDeEntrada.getListaItemsEntrada();
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);		
		List<Item> listaParaSalida = new LinkedList<Item>();

		Item itemContenedorActual = null;
		Item itemListaContenedorActual = null;

		for (Item item : itemsObtenidos) {
			if (item.isContieneItems()) {
				itemListaContenedorActual = null;
				/* Contenedor */
				listaParaSalida.add(item);
				itemContenedorActual = item;
			} else if (itemContenedorActual != null) {
				if (item.isEsContenidoPorUnItemLista()) {
					if (itemListaContenedorActual == null) {
						itemListaContenedorActual = new ItemListaContenedor("");
						itemContenedorActual.agregarElementoEnContenedor(itemListaContenedorActual);
					}
					itemListaContenedorActual.agregarElementoEnContenedor(item);
				} else {
					itemListaContenedorActual = null;
					/* Item dentro de un contenedor */
					itemContenedorActual.agregarElementoEnContenedor(item);
				}
			} else {
				/* Item fuera de contenedor */
				listaParaSalida.add(item);
			}
			
		}
			

		return listaParaSalida;
	}
}
