package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTituloDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		Item titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>";

		String tituloObtenidoFormatoHTML = titulo.getTextoFormateadoHTML();

		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

	@Test
	public void seCreaTituloyRecuperaTexto() {

		String contenido = "el titulo";
		Item titulo = new Titulo(contenido);

		String textoDelTitulo = titulo.getTexto();

		Assert.assertEquals(contenido, textoDelTitulo);
	}

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnTituloDePruebaVacio() {

		String tituloEntrada = "";
		Item titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1></h1>";

		String tituloObtenidoFormatoHTML = titulo.getTextoFormateadoHTML();

		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaDosTitulosDePrueba() {

		String contenido = "el titulo1";
		Item titulo = new Titulo(contenido);
		String contenido2 = "el titulo2";
		Item titulo2 = new Titulo(contenido2);

		String tituloObtenidoFormatoHTML = titulo.getTextoFormateadoHTML()
				+ titulo2.getTextoFormateadoHTML();
		String tituloEsperado = "<h1>el titulo1</h1><h1>el titulo2</h1>";
		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

}
