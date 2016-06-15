package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ItemListaTest {

	@Test
	public void seCreaItemListaEspecificadaRecuperandoSuNombre() {

		String contenido = "un item de una lista";
		Item itemLista = new ItemLista(contenido);

		String textoLista = itemLista.getTexto();

		Assert.assertEquals(contenido, textoLista);

	}

	@Test
	public void seObtieneTextoPrimerElementoEnFormatoHTMLParaUnaLista() {

		Item itemListaContenedor = new ItemListaContenedor("");
		Item itemLista = new ItemLista("un item de una lista");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);

		String itemListaEsperada = "<ul><li>un item de una lista</li></ul>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(itemListaEsperada, itemListaObtenidaFormatoHTML);

	}

	@Test
	public void seObtieneTextoPrimerySegundoElementoEnFormatoHTMLParaUnaLista() {

		Item itemListaContenedor = new ItemListaContenedor("");
		Item itemLista = new ItemLista("1er item de una lista");
		Item itemLista2 = new ItemLista("2do item de una lista");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);

		String itemListaEsperada = "<ul><li>1er item de una lista</li><li>2do item de una lista</li></ul>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(itemListaEsperada, itemListaObtenidaFormatoHTML);
	}

}
