package ar.edu.untref.aydoo;

public class ItemLista extends ItemEntrada {

	public ItemLista(String texto) {

		super(texto);

	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		 return formateador.getItemListaFormateado(this.getTexto());
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		
	}

}
