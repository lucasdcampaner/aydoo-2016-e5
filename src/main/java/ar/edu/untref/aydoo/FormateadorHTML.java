package ar.edu.untref.aydoo;

public class FormateadorHTML extends Formateador {

	@Override
	public String getTituloFormateado(String texto) {

		String tagInicio = "<h1>";
		String tagFin = "</h1>";
		
		String tituloFormateado = tagInicio + " " + texto +  " " + tagFin; 
		
		return tituloFormateado;
	}

	@Override
	public String getSubTituloFormateado(String texto) {
		// TODO Auto-generated method stub
		return null;
	}

}
