package ar.edu.untref.aydoo;

public class SubTitulo extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item subTitulo = null;
		if (texto.startsWith("##")) {
			subTitulo = new SubTitulo(texto.substring(3, texto.length()));
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


	@Override
	public String getTextoFormateadoHTML(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

}
