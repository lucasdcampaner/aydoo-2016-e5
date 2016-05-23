package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VisualizadorPorPantallaTest {

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnTituloDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		//List<ItemEntrada> items = new LinkedList<ItemEntrada>();
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1> Titulo de prueba </h1>";

		Formateador formateadorHTML = new FormateadorHTML();
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);
		
		//items.add(titulo);

		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

}
