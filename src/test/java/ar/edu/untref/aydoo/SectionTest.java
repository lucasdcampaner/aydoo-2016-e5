package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	@Test
	public void seObtieneSectionVaciaEnFormatoHTML() {

		ItemEntrada itemListaContenedor = new Section("");
				
		String sectionEsperada = "<section></section>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
		
	}

}
