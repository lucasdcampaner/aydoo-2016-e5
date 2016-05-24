package ar.edu.untref.aydoo;

public class ItemLista extends ItemEntrada {

	public ItemLista(String texto) {
		super(texto);
	}

	@Override
	public String getTextoFormateado(Formateador formateador, boolean tagInicio) {
		return formateador.getItemListaFormateado(this.getTexto());
	}

}
