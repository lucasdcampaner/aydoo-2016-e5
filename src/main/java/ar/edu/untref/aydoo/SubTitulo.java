package ar.edu.untref.aydoo;

public class SubTitulo extends ItemEntrada {

	public SubTitulo(String texto) {
		super(texto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getSubTituloFormateado(this.getTexto());
	}

	@Override
	public String getInicioFormateado(Formateador formateadorHTML) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFinFormateado(Formateador formateadorHTML) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		
	}

}
