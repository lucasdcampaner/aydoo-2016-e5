package ar.edu.untref.aydoo;

public class Imagen extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item imagen = null;
		if (texto.startsWith("i:")) {
			imagen = new Imagen(texto.substring(0, 3));
		}
		return imagen;
	}
	
	public Imagen(String texto) {
		super(texto, false, false);
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getImagenFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

	@Override
	public String getTextoFormateadoHTML(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

}
