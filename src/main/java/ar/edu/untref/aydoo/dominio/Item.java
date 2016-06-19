package ar.edu.untref.aydoo.dominio;

import java.util.List;

public abstract class Item {

	private String texto;
	
	public Item(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public abstract String getTextoFormateadoHTML();

	public abstract void agregarElementoEnContenedor(Item item);

	public abstract List<Item> getElementosEnContenedor();
}