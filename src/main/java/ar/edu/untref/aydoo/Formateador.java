package ar.edu.untref.aydoo;

public abstract class Formateador {

	public abstract String getSectionFormateado(boolean inicio);

	public abstract String getTituloFormateado(String texto);

	public abstract String getSubTituloFormateado(String texto);

	public abstract String getImagenFormateado(String texto);

	public abstract String getItemListaFormateado(String texto);

	public abstract String getTextoPlanoFormateado(String texto);
	
	public abstract String getInicioItemListaContenedorFormateado();

	public abstract String getFinItemListaContenedorFormateado();

	
}
