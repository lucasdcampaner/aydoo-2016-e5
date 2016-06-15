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

	/**
	 * Este metodo no nos gusta como esta. Tenemos 2 opciones:
	 * 1) Refactorizarlo y dividirlo en metodos privados
	 * 2) Usar algun tipo de patron que resuelva esta situacion, ejemplo investigar lo recomendado por el profesor.
	 */
	public List<Item> getItemsEntrada() throws IOException {

		List<Item> itemsEntrada = new LinkedList<Item>();
		scanner = new Scanner(archivoEntrada);
		Item itemEntrada;
		Item itemContenedorActual = null;
		Item itemListaContenedorActual = null;
		String lineaLeida = "";

		while (scanner.hasNextLine()) {
			lineaLeida = scanner.nextLine();
			if (!lineaLeida.isEmpty()) {
				itemEntrada = getTipoDeItem(lineaLeida);	
				lineaLeida = "";
				if (itemEntrada.isContieneItems()) {
					itemListaContenedorActual = null;
					/* Contenedor */
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
						/* Item dentro de un contenedor */
						itemContenedorActual.agregarElementoEnContenedor(itemEntrada);
					}
				} else {
					/* Item fuera de contenedor */
					itemsEntrada.add(itemEntrada);
				}
			}
		}
			
		scanner.close();
		return itemsEntrada;
	}

	private Item getTipoDeItem(String linea) {

		Item itemEntrada = null;
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
			itemEntrada = new Seccion("");
			break;
		default:
			itemEntrada = new TextoPlano(linea);
			break;
		}

		return itemEntrada;
	}

}
