package ar.edu.untref.aydoo;

public class ItemLista extends ItemEntrada {

	public ItemLista(String texto) {

		super(texto);

	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		 return formateador.getItemListaFormateado(this.getTexto());
	}

//	public String getInicioFormateado(Formateador formateador) {
//		return formateador.getInicioItemListaFormateado();
//	}
//
//		public String getFinFormateado(Formateador formateador) {
//		return formateador.getFinItemListaFormateado();
//	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInicioFormateado(Formateador formateadorHTML) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFinFormateado(Formateador formateadorHTML) {
		// TODO Auto-generated method stub
		return null;
	}

}
