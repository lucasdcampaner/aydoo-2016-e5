package ar.edu.untref.aydoo.dominio;

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
	public String getTextoFormateadoHTML() {
		
		String tagInicio = "<li>";
		String tagFin = "</li>";

		String imagenFormateado = tagInicio + super.getTexto() + tagFin;

		return imagenFormateado;
	}

	@Override
	public void agregarElementoEnContenedor(Item item) {}

}
