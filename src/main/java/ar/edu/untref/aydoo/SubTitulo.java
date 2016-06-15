package ar.edu.untref.aydoo;

public class SubTitulo extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item subTitulo = null;
		if (texto.startsWith("##")) {
			subTitulo = new Titulo(texto.substring(0, 3));
		}
		return subTitulo;
	}
	
	
	public SubTitulo(String texto) {
		super(texto, false, false);
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getSubTituloFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {
	}

}
