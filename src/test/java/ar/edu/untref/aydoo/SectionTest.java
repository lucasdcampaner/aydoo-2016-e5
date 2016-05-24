package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	@Test
	public void seObtieneInicioSectionFormatoHTML() {

		ItemEntrada section = new Section("");
		String inicioSectionEsperada = "<section>";
		Formateador formateadorHTML = new FormateadorHTML();
		
		String inicioSectionObtenida = section.getTextoFormateado(formateadorHTML, true);
		
		Assert.assertEquals(inicioSectionEsperada, inicioSectionObtenida);

	}

	@Test
	public void seObtieneFinSectionFormatoHTML() {

		ItemEntrada section = new Section("");
		String finSectionEsperada = "</section>";
		Formateador formateadorHTML = new FormateadorHTML();
		
		String finSectionObtenida = section.getTextoFormateado(formateadorHTML, false);
		
		Assert.assertEquals(finSectionEsperada, finSectionObtenida);

	}

}
