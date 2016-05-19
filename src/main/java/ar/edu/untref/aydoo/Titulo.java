package ar.edu.untref.aydoo;

public class Titulo extends ItemEntrada{

	private final String tagInicio = "<h1>";
	private final String tagFin = "</h1>";
	
	public Titulo(String contenido) {
		super(contenido);
	}

	@Override
	public String getContenidoFormatoHTML() {
		return tagInicio + " " + super.getContenido() +  " " + tagFin;
	}

}
