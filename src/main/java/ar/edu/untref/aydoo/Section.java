package ar.edu.untref.aydoo;

public class Section extends ItemEntrada {

	public Section(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateado(Formateador formateador, boolean inicioTag) {
		return formateador.getSectionFormateado(inicioTag);
	}



}
