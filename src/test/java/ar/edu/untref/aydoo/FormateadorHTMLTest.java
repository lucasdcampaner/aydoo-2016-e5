package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class FormateadorHTMLTest {

	@Test
	public void obtenerItemsFormateados() {
		
		Formateador formateadorHTML = new FormateadorHTML();		
		ItemEntrada itemLista1 = new ItemLista("un item de una lista");
		ItemEntrada itemLista2 = new ItemLista( "otro item de una lista");
		ItemEntrada itemListaContenedor = new ItemListaContenedor("");
		itemListaContenedor.agregarElementoEnContenedor(itemLista1);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		String textoFormateadoEsperado = "<ul>"
											+ "<li>un item de una lista</li>"
											+ "<li>otro item de una lista</li>"
										+ "</ul>";													
								
		String textoFormateadoObtenido = itemListaContenedor.getTextoFormateado(formateadorHTML);
		
		Assert.assertEquals(textoFormateadoEsperado, textoFormateadoObtenido);
		
	}
	
}
