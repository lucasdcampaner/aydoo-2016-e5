package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class Titulo extends Item {

	public Titulo(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateadoHTML() {

		String tagInicio = "<h1>";
		String tagFin = "</h1>";
		String tituloFormateado = tagInicio + super.getTexto() + tagFin;
		return tituloFormateado;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

	@Override
	public List<Item> getElementosEnContenedor() {
		return null;
	}
}
