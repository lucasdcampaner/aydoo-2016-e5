package ar.edu.untref.aydoo;

public class Titulo extends ItemEntrada{

	public Titulo(String contenido) {
		super(contenido);
	}

	public String getContenidoFormateado(Formateador formateador) {
		return formateador.getTituloFormateado(this.getTexto());
	}

}
