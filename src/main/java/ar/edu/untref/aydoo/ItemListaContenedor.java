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
		return formateador.getInicioItemListaContenedorFormateado() + getFormatoListoEnHTML()
				+ formateador.getFinItemListaContenedorFormateado();
	}

	private String getFormatoListoEnHTML() {
		String html = "";

		Formateador formateadorHTML = new FormateadorHTML();

		for (Item item : this.listaDeItems) {
			html += item.getTextoFormateado(formateadorHTML);
		}

		return html;
	}

	public String getInicioFormateado(Formateador formateador) {
		return formateador.getInicioItemListaContenedorFormateado();
	}

	public String getFinFormateado(Formateador formateador) {
		return formateador.getFinItemListaContenedorFormateado();
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
		this.listaDeItems.add(item);
	}

	public ArrayList<Item> getElementosEnColeccion() {
		return this.listaDeItems;
	}

	@Override
	public String getTextoFormateadoHTML(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

}