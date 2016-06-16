package ar.edu.untref.aydoo;

public class Imagen extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item imagen = null;
		if (texto.startsWith("i:")) {
			imagen = new Imagen(texto.substring(3, texto.length()));
		}
		return imagen;
	}
	
	public Imagen(String texto) {
		super(texto, false, false);
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		
		String tagInicio = "<img src=\"";
		String tagFin = "\"/>";

		String imagenFormateado = tagInicio + super.getTexto() + tagFin;

		return imagenFormateado;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {}
}
