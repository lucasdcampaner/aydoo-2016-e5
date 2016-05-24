package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VisualizadorPorPantalla {

	private LinkedList<String> listaDeItems;

	public VisualizadorPorPantalla() {

		this.listaDeItems = new LinkedList<String>();
	}

	public void agregarItem(String item) {

		this.listaDeItems.add(item);

	}

	public List<String> mostrarItems() {
		
		String itemsAMostrar = "";

		List<String> itemsAVisualizar = new LinkedList<String>();

		Iterator<String> iteradorItemsEntrada = this.listaDeItems.iterator();
		while (iteradorItemsEntrada.hasNext()) {
			
			itemsAMostrar = iteradorItemsEntrada.next() + "\n";

			itemsAVisualizar.add(itemsAMostrar);

		}

		return itemsAVisualizar;
	}

}
