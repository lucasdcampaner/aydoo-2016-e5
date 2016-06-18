package ar.edu.untref.aydoo.constructores;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.TextoPlano;

public class ConstructorDeTextoPlano extends ConstructorDeItem {

	@Override
	public Item construir(String texto) {

		Item resultado = null;
		resultado = new TextoPlano(texto);
		this.detenerConstruccion();
		return resultado;
	}
}
