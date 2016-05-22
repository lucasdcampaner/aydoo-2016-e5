package ar.edu.untref.aydoo;

public class Section extends ItemEntrada {

	public Section(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return "";
	}	

	public String getInicioFormateado(Formateador formateador) {
		return formateador.getInicioSectionFormateado();
	}	

	public String getFinFormateado(Formateador formateador) {
		return formateador.getFinSectionFormateado();
	}		
	
}
