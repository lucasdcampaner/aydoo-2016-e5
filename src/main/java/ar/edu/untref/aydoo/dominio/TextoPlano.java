package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class TextoPlano extends Item {

	public TextoPlano(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateadoHTML() {
		return super.getTexto();
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

	@Override
	public List<Item> getElementosEnContenedor() {
		return null;
	}
}
