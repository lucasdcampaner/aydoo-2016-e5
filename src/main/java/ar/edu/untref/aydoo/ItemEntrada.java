package ar.edu.untref.aydoo;

public abstract class ItemEntrada {
	
	private String contenido;

	public ItemEntrada(String contenido) {
		this.contenido = contenido;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public abstract String getContenidoFormatoHTML();
	
}
