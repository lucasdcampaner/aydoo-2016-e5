package ar.edu.untref.aydoo;

public class TextoPlano extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item textoPlano = null;
		if (texto.startsWith("")) {
			textoPlano = new TextoPlano(texto);
		}
		return textoPlano;
	}
	
	public TextoPlano(String contenido) {
		super(contenido, false, false);
	}

	public String getTextoFormateado(Formateador formateador) {
		return formateador.getTextoPlanoFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

}
