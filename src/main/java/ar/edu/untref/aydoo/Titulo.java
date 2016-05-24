package ar.edu.untref.aydoo;

public class Titulo extends ItemEntrada {

	public Titulo(String contenido) {
		super(contenido);
	}

	public String getTextoFormateado(Formateador formateador) {
		return formateador.getTituloFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
	}

}
