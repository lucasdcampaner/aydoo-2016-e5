package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemListaContenedor;

public class ItemListaContenedorTest {

	@Test
	public void seCreaItemListaEspecificadaRecuperandoSuNombre() {

		String contenido = "un item de una lista";
		Item itemLista = new ItemListaContenedor(contenido);

		String textoLista = itemLista.getTexto();

		Assert.assertEquals(contenido, textoLista);

	}

	@Test
	public void seObtieneVacioEnFormatoHTMLParaUnaLista() {

		Item itemListaContenedor = new ItemListaContenedor("");

		String itemListaEsperada = "<ul></ul>";

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateadoHTML();

		Assert.assertEquals(itemListaEsperada, itemListaObtenidaFormatoHTML);

	}
}
