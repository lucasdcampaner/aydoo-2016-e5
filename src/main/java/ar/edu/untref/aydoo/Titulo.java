package ar.edu.untref.aydoo;

public class Titulo extends ItemEntrada {

	public Titulo(String contenido) {
		super(contenido);
	}

	public String getTextoFormateado(Formateador formateador, boolean inicioTag) {
		return formateador.getTituloFormateado(this.getTexto());
	}

}
