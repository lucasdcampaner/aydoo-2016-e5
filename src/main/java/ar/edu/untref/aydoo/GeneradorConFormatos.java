package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class GeneradorConFormatos {

	private Formateador formateador;
	
	public GeneradorConFormatos(Formateador formateador) {
		this.formateador = formateador;
	}
	
	public List<Item> getItemsInstanciadosMD(List<String> itemsLeidos) {
		
		List<Item> itemsInstanciados = new ArrayList<Item>();
		for (String itemLeido : itemsLeidos) {
			Item itemInstanciado = formateador.instanciarItemLeidoMD(itemLeido);
			if (itemInstanciado != null) {
				itemsInstanciados.add(itemInstanciado);
			}
		}
		return itemsInstanciados;
	}
	
}
