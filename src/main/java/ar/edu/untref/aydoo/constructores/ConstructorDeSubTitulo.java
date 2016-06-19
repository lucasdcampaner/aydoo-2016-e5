package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.SubTitulo;

public class ConstructorDeSubTitulo extends ConstructorDeItem {

	@Override
	public Item construir(String texto) {

		Item resultado = null;

		if (texto.startsWith("## ")) {

			resultado = new SubTitulo(texto.substring(3, texto.length()));
			this.detenerConstruccion();
		} else {

			resultado = this.continuarConstruccion(texto);
		}

		return resultado;
	}

}
