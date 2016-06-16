package ar.edu.untref.aydoo.dominio;

import java.util.ArrayList;

public class Seccion extends Item {

	private ArrayList<Item> listaDeItems;

	public Seccion(String texto) {
		super(texto, true, false);
		this.listaDeItems = new ArrayList<>();
	}

	@Override
	public Item instanciarConMD(String texto) {
		Item seccion = null;
		if (texto.startsWith("---")) {
			seccion = new Seccion("---");
		}
		return seccion;
	}

	@Override
	public String getTextoFormateadoHTML() {

		String inicioSeccionFormateada = "<section>";
		String finSeccionFormateada = "</section>";

		return inicioSeccionFormateada + getElementosContenidosEnFormato() + finSeccionFormateada;
	}

	public void agregarElementoEnContenedor(Item item) {
		this.listaDeItems.add(item);
	}

	private String getElementosContenidosEnFormato() {

		String elementosFormateados = "";

		for (Item itemEntrada : this.listaDeItems) {
			elementosFormateados += itemEntrada.getTextoFormateadoHTML();

		}
		return elementosFormateados;
	}

	public ArrayList<Item> getElementosEnContenedor() {
		return this.listaDeItems;
	}
}
