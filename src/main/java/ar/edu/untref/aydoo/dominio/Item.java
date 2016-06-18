package ar.edu.untref.aydoo.dominio;

import java.util.List;

public abstract class Item {

	private String texto;
	private boolean contieneItems;
	private boolean esContenidoPorUnItemLista;

	public Item(String texto, boolean contieneItems, boolean esContenidoPorUnItemLista) {
		this.texto = texto;
		this.setContieneItems(contieneItems);
		this.esContenidoPorUnItemLista = esContenidoPorUnItemLista;
	}

	public String getTexto() {
		return texto;
	}

	public abstract String getTextoFormateadoHTML();

	public abstract void agregarElementoEnContenedor(Item item);

	public abstract List<Item> getElementosEnContenedor();
	
	public boolean isContieneItems() {
		return contieneItems;
	}

	public void setContieneItems(boolean contieneItems) {
		this.contieneItems = contieneItems;
	}

	public boolean isEsContenidoPorUnItemLista() {
		return esContenidoPorUnItemLista;
	}

	public void setEsContenidoPorUnItem(boolean esContenidoPorUnItem) {
		this.esContenidoPorUnItemLista = esContenidoPorUnItem;
	}
}