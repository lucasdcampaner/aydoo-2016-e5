package ar.edu.untref.aydoo;

public abstract class ItemEntrada {

	private String texto;
	private boolean contieneItems;
	
	public ItemEntrada(String texto, boolean contieneItems) {
		this.texto = texto;
		this.setContieneItems(contieneItems);
	}

	public String getTexto() {
		return texto;
	}

	public abstract String getTextoFormateado(Formateador formateador);

	public abstract void agregarElementoEnContenedor(ItemEntrada item);

	public boolean isContieneItems() {
		return contieneItems;
	}

	public void setContieneItems(boolean contieneItems) {
		this.contieneItems = contieneItems;
	}

}