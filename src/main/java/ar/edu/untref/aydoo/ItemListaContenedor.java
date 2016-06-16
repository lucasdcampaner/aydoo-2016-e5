package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ItemListaContenedor extends Item {
	
	private ArrayList<Item> listaDeItems;
	
	
	@Override
	public Item instanciarConMD(String texto) {
		return null;
	}
	
	public ItemListaContenedor(String texto) {
		super(texto, true, false);
		this.listaDeItems = new ArrayList<>();
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		
		String inicioItemListaFormateada = "<ul>";
		String finItemListaFormateada = "</ul>";
		
		return inicioItemListaFormateada + getItemsListaEnHTML() + finItemListaFormateada;
	}

	private String getItemsListaEnHTML() {

		String itemsListaEnHTML = "";

		Formateador formateadorHTML = new FormateadorHTML();

		for (Item item : this.listaDeItems) {
			itemsListaEnHTML += item.getTextoFormateado(formateadorHTML);
		}
		return itemsListaEnHTML;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
		this.listaDeItems.add(item);
	}

	public ArrayList<Item> getElementosEnColeccion() {
		return this.listaDeItems;
	}
}