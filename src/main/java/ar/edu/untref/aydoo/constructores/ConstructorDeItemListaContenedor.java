package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;

public class ConstructorDeItemListaContenedor extends ConstructorDeItem {

	private ItemListaContenedor itemListaContenedorActual = null;

	@Override
	public Item construir(String texto) {

		Item resultado = null;

		if (texto.startsWith("* ")) {
			
			if (itemListaContenedorActual == null) {
				
				itemListaContenedorActual = new ItemListaContenedor("");
				resultado = itemListaContenedorActual;
			}
			
			Item item = this.continuarConstruccion(texto);
			itemListaContenedorActual.agregarElementoEnContenedor(item);
		
		} else {
			itemListaContenedorActual = null;
			resultado = this.continuarConstruccion(texto);
		}

		return resultado;
	}

	@Override
	protected void itemConstruido() {
		
		this.itemListaContenedorActual = null;
	}

}
