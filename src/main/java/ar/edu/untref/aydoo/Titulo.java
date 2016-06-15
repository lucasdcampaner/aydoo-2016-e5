package ar.edu.untref.aydoo;

public class Titulo extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item titulo = null;
		if (texto.startsWith("# ")) {
			titulo = new Titulo(texto.substring(0, 2));
		}
		return titulo;
	}	
	
	public Titulo(String contenido) {
		super(contenido, false, false);
	}

	public String getTextoFormateado(Formateador formateador) {
		return formateador.getTituloFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}
}
