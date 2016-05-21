package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTituloCualquiera() {
		
		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1> Titulo de prueba </h1>";
		
		String tituloObtenidoFormatoHTML = titulo.getContenidoFormatoHTML();
		
		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

	@Test
	public void testQueNoCompilaParaComprobarJenkins() {
		
		String lineaDeCodigoSinPuntoYComa = "LineaSinPuntoYComa"

	}

}
