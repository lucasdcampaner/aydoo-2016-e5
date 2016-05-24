package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ItemListaTest {

	@Test
	public void seCreaItemListaEspecificadaRecuperandoSuNombre() {

		String contenido = "un item de una lista";
		ItemEntrada itemLista = new ItemLista(contenido);

		String textoLista = itemLista.getTexto();

		Assert.assertEquals(contenido, textoLista);

	}
	
	@Test
	public void seObtieneTextoPrimerElementoEnFormatoHTMLParaUnaLista() {

		ItemEntrada itemListaContenedor = new ItemListaContenedor("");
		ItemEntrada itemLista = new ItemLista("un item de una lista");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		
		String itemListaEsperada = "<ul><li>un item de una lista</li></ul>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		//Assert.assertEquals(itemListaEsperada, itemListaObtenidaFormatoHTML);
		
	}

}
