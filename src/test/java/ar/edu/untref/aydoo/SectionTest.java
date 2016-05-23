package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	
	@Test
	public void seObtieneTextoInicioEnFormatoHTMLParaUnaSection() {
		
		ItemEntrada section = new Section("Comienza la seccion");
		String sectionInicioEsperada = "<section>";
		
		Formateador formateadorHTML = new FormateadorHTML();
		String sectionInicioObtenidaFormatoHTML = section.getInicioFormateado(formateadorHTML);
		
		Assert.assertEquals(sectionInicioEsperada, sectionInicioObtenidaFormatoHTML);
	}

	@Test
	public void seObtieneTextoFinEnFormatoHTMLParaUnaSection() {
		
		ItemEntrada section = new Section("Finaliza la seccion");
		String sectionFinEsperada = "</section>";
		
		Formateador formateadorHTML = new FormateadorHTML();
		String sectionFinObtenidaFormatoHTML = section.getFinFormateado(formateadorHTML);
		
		Assert.assertEquals(sectionFinEsperada, sectionFinObtenidaFormatoHTML);
	}	
	
}
