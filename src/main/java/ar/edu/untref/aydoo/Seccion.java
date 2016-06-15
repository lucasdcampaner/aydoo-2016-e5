package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class Seccion extends Item {

	private ArrayList<Item> listaDeItems;

	@Override
	public Item instanciarConMD(String texto) {
		Item seccion = null;
		if (texto.startsWith("---")) {
			seccion = new Seccion("");
		}
		return seccion;
	}	
	
	public Seccion(String texto) {
		super(texto, true, false);
		this.listaDeItems = new ArrayList<>();
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getInicioSectionFormateado() + getElementosContenidosEnFormato()
				+ formateador.getFinSectionFormateado();

	}

	public void agregarElementoEnContenedor(Item item) {
		this.listaDeItems.add(item);
	}

	private String getElementosContenidosEnFormato() {

		String elementosFormateados = "";

		Formateador formateadorHTML = new FormateadorHTML();

		for (Item itemEntrada : this.listaDeItems) {
			elementosFormateados += itemEntrada.getTextoFormateado(formateadorHTML);

		}

		return elementosFormateados;
	}

	public ArrayList<Item> getElementosEnContenedor() {
		return this.listaDeItems;
	}

}
