package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {
	
	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTituloDePrueba() {
		
		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1> Titulo de prueba </h1>";
		
		Formateador formateadorHTML = new FormateadorHTML();
		String tituloObtenidoFormatoHTML = titulo.getContenidoFormateado(formateadorHTML);
		
		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

}
