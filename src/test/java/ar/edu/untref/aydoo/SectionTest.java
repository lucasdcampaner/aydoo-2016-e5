package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	@Test
	public void seObtieneTextoInicioEnFormatoHTMLParaUnaSection() {

		ItemEntrada section = new Section("Comienza la seccion");
		String sectionInicioEsperada = "<section>";

		Formateador formateadorHTML = new FormateadorHTML();
		//TDD, similar lista en itel lista contenedor
		//String sectionInicioObtenidaFormatoHTML = section.getInicioFormateado(formateadorHTML);

		//Assert.assertEquals(sectionInicioEsperada, sectionInicioObtenidaFormatoHTML);
	}

}
