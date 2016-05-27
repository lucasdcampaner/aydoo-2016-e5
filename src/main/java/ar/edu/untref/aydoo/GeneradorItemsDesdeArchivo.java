package ar.edu.untref.aydoo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GeneradorItemsDesdeArchivo {

	private FileReader archivoEntrada;
	private Scanner scanner;
	boolean crearListaContenedor = true;

	public GeneradorItemsDesdeArchivo(String archivoEntrada) throws FileNotFoundException {
		this.archivoEntrada = new FileReader(archivoEntrada);
	}

	public List<ItemEntrada> getItemsEntrada(Formateador formateador) throws IOException {

		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		scanner = new Scanner(archivoEntrada);

		ItemEntrada itemEntrada;
		ItemEntrada itemContenedorActual = null;
		ItemEntrada itemListaContenedorActual = null;
		
		while (scanner.hasNextLine()) {
			
			itemEntrada = getTipoDeItem(scanner.nextLine());

			if (itemEntrada.isContieneItems()) {
				
				itemListaContenedorActual = null;

				/* contenedor */
				itemsEntrada.add(itemEntrada);
				itemContenedorActual = itemEntrada;

			} else if (itemContenedorActual != null) { 
			
				if (itemEntrada.isEsContenidoPorUnItemLista()) {
					
					if (itemListaContenedorActual == null) {
						
						itemListaContenedorActual = new ItemListaContenedor("");
						itemContenedorActual.agregarElementoEnContenedor(itemListaContenedorActual);
					}
					
					itemListaContenedorActual.agregarElementoEnContenedor(itemEntrada);
					
				} else {
					
					itemListaContenedorActual = null;
					
					/* item dentro de un contenedor */
					itemContenedorActual.agregarElementoEnContenedor(itemEntrada);
				}
			
			} else {
				
				/* item fuera de contenedor */
				itemsEntrada.add(itemEntrada);
			}
		}
		
		
		scanner.close();
		return itemsEntrada;
	}

	private ItemEntrada getTipoDeItem(String linea) {

		ItemEntrada itemEntrada = null;
		String caracterizadorLinea = linea.substring(0, 2);
		String textoDesdePosicion2 = linea.substring(2);
		String textoDesdePosicion3 = linea.substring(3);
		
		switch (caracterizadorLinea) {
		case "# ":
			itemEntrada = new Titulo(textoDesdePosicion2);
			break;
		case "##":
			itemEntrada = new SubTitulo(textoDesdePosicion3);
			break;
		case "i:":
			itemEntrada = new Imagen(textoDesdePosicion3);
			break;
		case "* ":
			itemEntrada = new ItemLista(textoDesdePosicion2);
			break;
		case "--":
			itemEntrada = new Section("");
			break;
		default:
			itemEntrada = new TextoPlano(linea);
			break;
		}

		return itemEntrada;
	}

}
