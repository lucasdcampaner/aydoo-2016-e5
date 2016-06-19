package ar.edu.untref.aydoo.constructores;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;

public class ConstructorDeItemListaTest {

	@Test
	public void construirItemListaMD() {

		ConstructorDeItemLista constructorDeItemLista = new ConstructorDeItemLista();
		String ItemLista = "* Un item de una lista";
		Item itemEsperado = constructorDeItemLista.construir(ItemLista);

		Assert.assertEquals(ItemLista.class, itemEsperado.getClass());
	}

}
