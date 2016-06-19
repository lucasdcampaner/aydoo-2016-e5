package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class Imagen extends Item {

	public Imagen(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateadoHTML() {

		String tagInicio = "<img src=\"";
		String tagFin = "\"/>";
		String imagenFormateado = tagInicio + super.getTexto() + tagFin;
		return imagenFormateado;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

	@Override
	public List<Item> getElementosEnContenedor() {
		return null;
	}
}
