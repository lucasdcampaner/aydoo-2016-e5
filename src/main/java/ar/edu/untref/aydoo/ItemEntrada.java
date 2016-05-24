package ar.edu.untref.aydoo;

public abstract class ItemEntrada {

	private String texto;

	/**
	 * 
	 * @param texto
	 *            se guarda sin el marcador de que es item, eso lo define el
	 *            objeto.
	 */

	public ItemEntrada(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public abstract String getTextoFormateado(Formateador formateador);

	public abstract void agregarElementoEnContenedor(ItemEntrada item);

}
