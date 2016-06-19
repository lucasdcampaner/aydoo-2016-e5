package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.SubTitulo;

public class SubTituloTest {

	
	@Test
	public void obtenerElementosDeContenedorRetornaNulo() {
		
		String texto = "## SubTitulo";

		Item subTitulo = new SubTitulo(texto);
		
		Assert.assertEquals(null, subTitulo.getElementosEnContenedor());
	}
	
	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnSubTituloDePrueba() {

		String subTituloEntrada = "SubTitulo de prueba";
		Item subTitulo = new SubTitulo(subTituloEntrada);
		String subTituloEsperado = "<h2>SubTitulo de prueba</h2>";

		String subTituloObtenidoFormatoHTML = subTitulo.getTextoFormateadoHTML();

		Assert.assertEquals(subTituloEsperado, subTituloObtenidoFormatoHTML);
	}

	@Test
	public void seCreaSubTituloyRecuperaTexto() {

		String contenido = "el SubTitulo";
		Item subTitulo = new SubTitulo(contenido);

		String textoDelTitulo = subTitulo.getTexto();

		Assert.assertEquals(contenido, textoDelTitulo);
	}

	@Test
	public void seObtieneContenidoEnFormatoHTMLParaUnSubTituloDePruebaVacio() {

		String subTituloEntrada = "";
		Item subTitulo = new SubTitulo(subTituloEntrada);
		String subTituloEsperado = "<h2></h2>";

		String subTituloObtenidoFormatoHTML = subTitulo.getTextoFormateadoHTML();

		Assert.assertEquals(subTituloEsperado, subTituloObtenidoFormatoHTML);
	}

}
