package ar.edu.untref.aydoo;

public class TextoPlano extends Item {

	/**
	 * TODO Ver como controlar para futuros items que queden luego de texto plano.
	 */
	
	@Override
	public Item instanciarConMD(String texto) {
		Item textoPlano = null;
		if (!texto.startsWith("#")) {
			textoPlano = new TextoPlano(texto);
		}
		return textoPlano;
	}
		
	public TextoPlano(String contenido) {
		super(contenido, false, false);
	}

	public String getTextoFormateado(Formateador formateador) {
		return super.getTexto();
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

}
