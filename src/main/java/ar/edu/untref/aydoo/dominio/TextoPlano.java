package ar.edu.untref.aydoo.dominio;

public class TextoPlano extends Item {

	/**
	 * TODO Ver como controlar para futuros items que queden luego de texto
	 * plano. Como el ultimo item que comprueba es el titulo, con la condicion
	 * de que no empiece con # funciona.
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

	@Override
	public String getTextoFormateadoHTML() {
		return super.getTexto();
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}
}