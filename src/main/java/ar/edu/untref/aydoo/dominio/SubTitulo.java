package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class SubTitulo extends Item {

	public SubTitulo(String texto) {
		super(texto);
	}

	public String getTextoFormateadoHTML() {

		String tagInicio = "<h2>";
		String tagFin = "</h2>";
		String subTituloFormateado = tagInicio + super.getTexto() + tagFin;
		return subTituloFormateado;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

	@Override
	public List<Item> getElementosEnContenedor() {
		return null;
	}
}
