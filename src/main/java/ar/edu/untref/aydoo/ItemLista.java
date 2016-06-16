package ar.edu.untref.aydoo;

public class ItemLista extends Item {

	@Override
	public Item instanciarConMD(String texto) {
		Item itemLista = null;
		if (texto.startsWith("* ")) {
			itemLista = new ItemLista(texto.substring(2, texto.length()));
		}
		return itemLista;
	}
	
	public ItemLista(String texto) {
		super(texto, false, true);
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		return formateador.getItemListaFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {}

}
