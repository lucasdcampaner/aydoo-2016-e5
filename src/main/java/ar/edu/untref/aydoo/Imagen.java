package ar.edu.untref.aydoo;

public class Imagen extends ItemEntrada {

	public Imagen(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateado(Formateador formateador, boolean inicioTag) {
		return formateador.getImagenFormateado(this.getTexto());
	}

}
