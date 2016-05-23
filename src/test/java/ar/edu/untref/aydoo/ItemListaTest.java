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
	
	@Test
	public void seObtieneTextoInicioEnFormatoHTMLParaUnaLista() {
		
		ItemEntrada itemLista = new ItemLista("un item de una lista");
		String itemListaInicioEsperada = "<ul>";
		
		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaInicioObtenidaFormatoHTML = itemLista.getInicioFormateado(formateadorHTML);
		
		Assert.assertEquals(itemListaInicioEsperada, itemListaInicioObtenidaFormatoHTML);
	}
	
	
}
