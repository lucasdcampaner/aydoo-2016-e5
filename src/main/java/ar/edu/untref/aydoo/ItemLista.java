package ar.edu.untref.aydoo;

public class ItemLista extends ItemEntrada {

	private boolean primero;

	public ItemLista(String texto) {

		super(texto);
		this.primero = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		// return formateador.getItemListaFormateado(this.getTexto());
		// itemLista.getInicioFormateado(formateadorHTML)
		String devolucion = "";
		if (this.primero) {
			devolucion += formateador.getInicioItemListaFormateado();
			this.primero = false;
		}
		else {
			
			devolucion += formateador.getInicioItemListaElementoFormateado();
			devolucion += formateador.getItemListaFormateado(this.getTexto());
		}

		return devolucion;
	}

	public String getInicioFormateado(Formateador formateador) {
		return formateador.getInicioItemListaFormateado();
	}

	public String getFinFormateado(Formateador formateador) {
		return formateador.getFinItemListaFormateado();
	}

	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		
	}

}
