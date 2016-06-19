package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;

public class ConstructorDeItemListaContenedor extends ConstructorDeItem {

	private ItemListaContenedor itemListaContenedorActual = null;

	/**
	 * Este metodo sobreescrito tiene las particularidades de los items
	 * (bullets). Para el primer bullet, crea el contenedor actual. El primero y
	 * los siguientes bullets, son agregados en el contenedor actual. El
	 * encargado de detener la construccion es el bullet normal, no el
	 * contenedor.
	 */
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

	/**
	 * Cuando un contenedor de items (bullets) se construye, debe nulearse el
	 * contenedor actual. Sino, todos los bullets se agregarian al mismo
	 * contenedor.
	 */
	@Override
	protected void itemConstruido() {

		this.itemListaContenedorActual = null;
	}
}
