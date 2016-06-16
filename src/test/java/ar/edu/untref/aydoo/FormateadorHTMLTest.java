package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorHTMLTest {

	@Test
	public void obtenerItemsFormateados() {

		Item itemLista1 = new ItemLista("un item de una lista");
		Item itemLista2 = new ItemLista("otro item de una lista");
		Item itemListaContenedor = new ItemListaContenedor("");
		itemListaContenedor.agregarElementoEnContenedor(itemLista1);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		String textoFormateadoEsperado = "<ul>" + "<li>un item de una lista</li>" + "<li>otro item de una lista</li>"
				+ "</ul>";

		String textoFormateadoObtenido = itemListaContenedor.getTextoFormateadoHTML();

		Assert.assertEquals(textoFormateadoEsperado, textoFormateadoObtenido);

	}

	@Test
	public void obtenerItemsFormateadosDeUnaSectionConLista() {

		Item section1 = new Seccion("");
		Item itemLista1 = new ItemLista("un item de una lista");
		Item itemLista2 = new ItemLista("otro item de una lista");
		Item itemListaContenedor = new ItemListaContenedor("");
		section1.agregarElementoEnContenedor(itemListaContenedor);
		itemListaContenedor.agregarElementoEnContenedor(itemLista1);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		String textoFormateadoEsperado = "<section>" + "<ul>" + "<li>un item de una lista</li>"
				+ "<li>otro item de una lista</li>" + "</ul>" + "</section>";

		String textoFormateadoObtenido = section1.getTextoFormateadoHTML();

		Assert.assertEquals(textoFormateadoEsperado, textoFormateadoObtenido);

	}
}
