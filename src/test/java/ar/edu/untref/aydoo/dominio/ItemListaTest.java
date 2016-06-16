package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;

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

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateadoHTML();

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

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateadoHTML();

		Assert.assertEquals(itemListaEsperada, itemListaObtenidaFormatoHTML);
	}

}
