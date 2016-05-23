package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class VisualizadorPorPantallaTest {

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnTituloDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>";

		Formateador formateadorHTML = new FormateadorHTML();
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(tituloEsperado, tituloObtenidoFormatoHTML);
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnSubtituloDePrueba() {

		String subtituloEntrada = "Subtitulo de prueba";
		ItemEntrada subtitulo = new SubTitulo(subtituloEntrada);
		String subtituloEsperado = "<h2>Subtitulo de prueba</h2>";

		Formateador formateadorHTML = new FormateadorHTML();
		String subtituloObtenidoFormatoHTML = subtitulo.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(subtituloEsperado, subtituloObtenidoFormatoHTML);
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnTituloYUnSubtituloDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>";
		String subtituloEntrada = "Subtitulo de prueba";
		ItemEntrada subtitulo = new SubTitulo(subtituloEntrada);
		String subtituloEsperado = "<h2>Subtitulo de prueba</h2>";
		
		List<String> itemsEsperados = new LinkedList<String>();
		itemsEsperados.add(tituloEsperado);
		itemsEsperados.add(subtituloEsperado);

		Formateador formateadorHTML = new FormateadorHTML();
		VisualizadorPorPantalla items = new VisualizadorPorPantalla();
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);
		String subtituloObtenidoFormatoHTML = subtitulo.getTextoFormateado(formateadorHTML);
		
		items.agregarItem(tituloObtenidoFormatoHTML);
		items.agregarItem(subtituloObtenidoFormatoHTML);

		Assert.assertEquals(itemsEsperados, items.mostrarItems());
	}
}