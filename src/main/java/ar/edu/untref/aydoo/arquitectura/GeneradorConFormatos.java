package ar.edu.untref.aydoo.arquitectura;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.aydoo.constructores.FabricaDeItem;
import ar.edu.untref.aydoo.dominio.Item;

public class GeneradorConFormatos {

	private FabricaDeItem fabrica;
	
	public GeneradorConFormatos(FabricaDeItem formateador) {
		this.fabrica = formateador;
	}
	
	public List<Item> getItemsInstanciadosMD(List<String> itemsLeidos) {
		
		List<Item> itemsInstanciados = new ArrayList<Item>();
		for (String itemLeido : itemsLeidos) {
			Item itemInstanciado = fabrica.instanciarItemLeidoMD(itemLeido);
			if (itemInstanciado != null) {
				itemsInstanciados.add(itemInstanciado);
			}
		}
		return itemsInstanciados;
	}
	
}
