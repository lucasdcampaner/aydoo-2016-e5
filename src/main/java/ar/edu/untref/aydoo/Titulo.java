package ar.edu.untref.aydoo;

public class Titulo extends ItemEntrada {

	public Titulo(String contenido) {
		super(contenido);
	}

	public String getTextoFormateado(Formateador formateador) {
		return formateador.getTituloFormateado(this.getTexto());
	}

	@Override
	public String getInicioFormateado(Formateador formateadorHTML) {
		return "";
	}

	@Override
	public String getFinFormateado(Formateador formateadorHTML) {
		return "";
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		
	}

}
