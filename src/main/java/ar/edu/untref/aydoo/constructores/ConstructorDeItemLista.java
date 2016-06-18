package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;

public class ConstructorDeItemLista extends ConstructorDeItem {

	@Override
	public Item construir(String texto) {

		Item resultado = null;

		if (texto.startsWith("* ")) {

			resultado = new ItemLista(texto.substring(2, texto.length()));
			this.detenerConstruccion();
		} else {

			resultado = this.continuarConstruccion(texto);
		}

		return resultado;
	}
}
