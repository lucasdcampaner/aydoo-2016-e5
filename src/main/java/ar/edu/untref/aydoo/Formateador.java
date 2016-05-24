package ar.edu.untref.aydoo;

public abstract class Formateador {

	public abstract String getTituloFormateado(String texto);

	public abstract String getSubTituloFormateado(String texto);

	public abstract String getImagenFormateado(String texto);

	public abstract String getItemListaFormateado(String texto);

	public abstract String getInicioSectionFormateado();

	public abstract String getFinSectionFormateado();

	public abstract String getInicioItemListaFormateado();

	public abstract String getFinItemListaFormateado();

	public String getInicioItemListaElementoFormateado() {
		// TODO Auto-generated method stub
		return null;
	}

}
