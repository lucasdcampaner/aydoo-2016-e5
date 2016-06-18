package ar.edu.untref.aydoo.dominio;

import java.util.List;

public class SubTitulo extends Item {

//	@Override
//	public Item instanciarConMD(String texto) {
//		Item subTitulo = null;
//		if (texto.startsWith("##")) {
//			subTitulo = new SubTitulo(texto.substring(3, texto.length()));
//		}
//		return subTitulo;
//	}

	public SubTitulo(String texto) {
		super(texto, false, false);
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
		// TODO Auto-generated method stub
		return null;
	}
}
