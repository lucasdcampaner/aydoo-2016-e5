package ar.edu.untref.aydoo;

public class SubTitulo extends ItemEntrada {

	public SubTitulo(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateado(Formateador formateador, boolean inicioTag) {
		return formateador.getSubTituloFormateado(this.getTexto());
	}

}
