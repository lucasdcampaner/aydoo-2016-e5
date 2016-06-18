package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class ItemLista extends Item {

	public ItemLista(String texto) {
		super(texto, false, true);
	}

	@Override
	public String getTextoFormateadoHTML() {

		String tagInicio = "<li>";
		String tagFin = "</li>";

		String imagenFormateado = tagInicio + super.getTexto() + tagFin;

		return imagenFormateado;
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
