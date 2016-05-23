package ar.edu.untref.aydoo;

public class ItemLista extends ItemEntrada {

	public ItemLista(String texto) {
		super(texto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		//return formateador.getItemListaFormateado(this.getTexto());
		return "";
	}

	public String getInicioFormateado(Formateador formateador) {
		return formateador.getInicioItemListaFormateado();
	}	

//	public String getFinFormateado(Formateador formateador) {
//		return formateador.getFinItemListaFormateado();
//	}		

}
