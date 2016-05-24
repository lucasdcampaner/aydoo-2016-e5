package ar.edu.untref.aydoo;

public class Imagen extends ItemEntrada {

	public Imagen(String texto) {
		super(texto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getImagenFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub

	}

}
