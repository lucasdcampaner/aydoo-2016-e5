package ar.edu.untref.aydoo;

public class TextoPlano extends ItemEntrada {


	public TextoPlano(String contenido) {
		super(contenido);
	}

	public String getTextoFormateado(Formateador formateador, boolean inicioTag) {
		return formateador.getTextoPlanoFormateado(this.getTexto());
	}

}
