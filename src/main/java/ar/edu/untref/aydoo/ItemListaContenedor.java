package ar.edu.untref.aydoo;

import java.util.ArrayList;

public class ItemListaContenedor extends ItemEntrada {

	private ArrayList<ItemEntrada> listaDeItems;
	
	public ItemListaContenedor(String texto) {
		super(texto);
		this.listaDeItems = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextoFormateado(Formateador formateador) {
		// TODO Auto-generated method stub
		return null;
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
	
	@Override
	public void agregarElementoEnContenedor(ItemEntrada item) {
		// TODO Auto-generated method stub
		this.listaDeItems.add(item);	
	}
	public ArrayList<ItemEntrada> getElementosEnColeccion() {
		return this.listaDeItems;
	}
	

}
