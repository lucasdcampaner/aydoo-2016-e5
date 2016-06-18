package ar.edu.untref.aydoo.dominio;

import java.util.ArrayList;
import java.util.List;

public class ItemListaContenedor extends Item {

	private ArrayList<Item> listaDeItems;

	public ItemListaContenedor(String texto) {
		super(texto, true, false);
		this.listaDeItems = new ArrayList<>();
	}

	@Override
	public String getTextoFormateadoHTML() {

		String inicioItemListaFormateada = "<ul>";
		String finItemListaFormateada = "</ul>";

		return inicioItemListaFormateada + getItemsListaEnHTML() + finItemListaFormateada;
	}

	private String getItemsListaEnHTML() {

		String itemsListaEnHTML = "";

		for (Item item : this.listaDeItems) {
			itemsListaEnHTML += item.getTextoFormateadoHTML();
		}
		return itemsListaEnHTML;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
		this.listaDeItems.add(item);
	}

	@Override
	public List<Item> getElementosEnContenedor() {
		return this.listaDeItems;
	}
}