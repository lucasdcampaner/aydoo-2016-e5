package ar.edu.untref.aydoo.dominio;

import java.util.List;

import ar.edu.untref.aydoo.constructores.ConstructorDeTitulo;

public class Titulo extends Item {

	public Titulo(String contenido) {
		super(contenido, false, false);
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
		// TODO Auto-generated method stub
		return null;
	}

}
