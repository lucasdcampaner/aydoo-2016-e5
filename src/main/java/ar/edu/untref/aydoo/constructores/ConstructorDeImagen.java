package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;

public class ConstructorDeImagen extends ConstructorDeItem {

	@Override
	public Item construir(String texto) {

		Item resultado = null;

		if (texto.startsWith("i:")) {

			resultado = new Imagen(texto.substring(3, texto.length()));
			this.detenerConstruccion();
		} else {

			resultado = this.continuarConstruccion(texto);
		}

		return resultado;
	}
}
