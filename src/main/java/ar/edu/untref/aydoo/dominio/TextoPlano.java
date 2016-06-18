package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class TextoPlano extends Item {

	public TextoPlano(String contenido) {
		super(contenido, false, false);
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
		// TODO Auto-generated method stub
		return null;
	}
}
