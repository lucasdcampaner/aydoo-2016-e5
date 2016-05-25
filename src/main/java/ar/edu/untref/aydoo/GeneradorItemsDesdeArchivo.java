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
	private String contenido;

	public GeneradorItemsDesdeArchivo() {
		this.archivoEntrada = null;
	}

	public boolean setArchivoEntrada(String archivoEntrada) throws FileNotFoundException {

		this.archivoEntrada = new FileReader(archivoEntrada);
		if (this.archivoEntrada != null) {
			return true;
		} else
			return false;

	}

	public List<ItemEntrada> getItemsEntrada(Formateador formateador) throws IOException {

		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		scanner = new Scanner(archivoEntrada);
		ItemEntrada itemEntrada;

		while (scanner.hasNextLine()) {
			itemEntrada = getTipoDeItem(scanner.nextLine());
			if (itemEntrada != null) {
				itemsEntrada.add(itemEntrada);
			}
		}

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

	public void setContenidoPrueba(String contenidoArchivo) {
		contenido = contenidoArchivo;

	}

	public List<ItemEntrada> getItemsEntradaPruebaSinFile(Formateador formateadorHTML) {
		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		// scanner = new Scanner(archivoEntrada);
		ItemEntrada itemEntrada = null;
		String[] coleccion = this.contenido.split("\n");
		for (int i = 0; i < coleccion.length; i++) {
			itemsEntrada.add(new Section(""));
			itemEntrada = getTipoDeItem(coleccion[i]);
			if (itemEntrada != null) {
				itemsEntrada.add(itemEntrada);
			}
		}
		return itemsEntrada;
	}

}
