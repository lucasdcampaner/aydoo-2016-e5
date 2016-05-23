package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ItemListaTest {

	@Test
	public void seCreaItemListaEspecificadaRecuperandoSuNombre() {

		String contenido = "un item de una lista";
		ItemEntrada itemLista = new  ItemLista(contenido);

		String textoLista = itemLista.getTexto();

		Assert.assertEquals(contenido, textoLista);

	}
	
	
}
