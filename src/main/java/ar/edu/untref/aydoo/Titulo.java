package ar.edu.untref.aydoo;

public class Titulo extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item titulo = null;
		if (texto.startsWith("#")) {
			titulo = new Titulo(texto.substring(2, texto.length()));
		}
		return titulo;
	}	
	
	@Override
	public String getTextoFormateadoHTML(String texto) {
		
		String tagInicio = "<h1>";
		String tagFin = "</h1>";

		String tituloFormateado = tagInicio + texto + tagFin;

		return tituloFormateado;
	}
	
	
	
	
	
	
	
	
	public Titulo(String contenido) {
		super(contenido, false, false);
	}

	public String getTextoFormateado(Formateador formateador) {
		return formateador.getTituloFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}
}
