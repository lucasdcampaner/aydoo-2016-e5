package ar.edu.untref.aydoo.arquitectura;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Item;

public class GeneradorConFormatos {

	private ConstructoraDeItem formateador;
	
	public GeneradorConFormatos(ConstructoraDeItem formateador) {
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
