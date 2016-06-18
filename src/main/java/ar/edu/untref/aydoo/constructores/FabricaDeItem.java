package ar.edu.untref.aydoo.constructores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Item;

public class FabricaDeItem {

	private ConstructorDeItem constructorDeItem;

	public FabricaDeItem() {

		ConstructorDeItem constructoTextoPlano = new ConstructorDeTextoPlano();
		ConstructorDeItem constructoDeSeccion = new ConstructorDeSeccion();
		ConstructorDeItem constructorDeTitulo = new ConstructorDeTitulo();
		ConstructorDeItem constructorDeItemLista = new ConstructorDeItemLista();
		ConstructorDeItem constructorDeItemListaContenedor = new ConstructorDeItemListaContenedor();

		constructoDeSeccion.encadenarCon(constructorDeItemListaContenedor);
		constructorDeItemListaContenedor.encadenarCon(constructorDeItemLista);
		constructorDeItemLista.encadenarCon(constructorDeTitulo);
		constructorDeTitulo.encadenarCon(constructoTextoPlano);

		constructorDeItem = constructoDeSeccion;
	}

	public List<Item> crearItems(List<String> itemsLeidos) {

		List<Item> listaParaSalida = new ArrayList<Item>();

		for (String itemLeido : itemsLeidos) {

			Item itemConstruido = constructorDeItem.construir(itemLeido);
			if (itemConstruido != null) {

				listaParaSalida.add(itemConstruido);
			}
		}

		return listaParaSalida;
	}

}
