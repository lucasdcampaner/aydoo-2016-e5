package ar.edu.untref.aydoo;

public abstract class ItemEntrada {

	private String texto;

	public ItemEntrada(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public abstract String getTextoFormateado(Formateador formateador);

	public abstract void agregarElementoEnContenedor(ItemEntrada item);

}