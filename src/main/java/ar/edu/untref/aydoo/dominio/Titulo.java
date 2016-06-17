package ar.edu.untref.aydoo.dominio;

public class Titulo extends Item {

	public Titulo(String contenido) {
		super(contenido, false, false);
	}

	@Override
	public Item instanciarConMD(String texto) {
		Item titulo = null;
		if (texto.startsWith("#")) {
			titulo = new Titulo(texto.substring(2, texto.length()));
		}
		return titulo;
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
}