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
	public void seMuestraContenidoEnFormatoHTMLParaUnaImagenDePrueba() {

		String imagenEntrada = "imagenDePrueba.jpg";
		ItemEntrada imagen = new Imagen(imagenEntrada);
		String imagenEsperada = "<img src=\"imagenDePrueba.jpg\"/>";

		Formateador formateadorHTML = new FormateadorHTML();
		String imagenObtenidaFormatoHTML = imagen.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(imagenEsperada, imagenObtenidaFormatoHTML);
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnTituloYUnSubtituloDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>" + "\n";

		String subtituloEntrada = "Subtitulo de prueba";
		ItemEntrada subtitulo = new SubTitulo(subtituloEntrada);
		String subtituloEsperado = "<h2>Subtitulo de prueba</h2>" + "\n";

		List<String> itemsEsperados = new LinkedList<String>();
		itemsEsperados.add(tituloEsperado);
		itemsEsperados.add(subtituloEsperado);

		Formateador formateadorHTML = new FormateadorHTML();
		VisualizadorPorPantalla items = new VisualizadorPorPantalla();
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);
		String subtituloObtenidoFormatoHTML = subtitulo.getTextoFormateado(formateadorHTML);

		items.agregarItem(tituloObtenidoFormatoHTML);
		items.agregarItem(subtituloObtenidoFormatoHTML);

		System.out.println(items.mostrarItems());

		Assert.assertEquals(itemsEsperados, items.mostrarItems());
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnTituloUnSubtituloYUnaImagenDePrueba() {

		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>" + "\n";

		String subtituloEntrada = "Subtitulo de prueba";
		ItemEntrada subtitulo = new SubTitulo(subtituloEntrada);
		String subtituloEsperado = "<h2>Subtitulo de prueba</h2>" + "\n";

		String imagenEntrada = "imagenDePrueba.jpg";
		ItemEntrada imagen = new Imagen(imagenEntrada);
		String imagenEsperada = "<img src=\"imagenDePrueba.jpg\"/>" + "\n";

		List<String> itemsEsperados = new LinkedList<String>();
		itemsEsperados.add(tituloEsperado);
		itemsEsperados.add(subtituloEsperado);
		itemsEsperados.add(imagenEsperada);

		Formateador formateadorHTML = new FormateadorHTML();
		VisualizadorPorPantalla items = new VisualizadorPorPantalla();
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);
		String subtituloObtenidoFormatoHTML = subtitulo.getTextoFormateado(formateadorHTML);
		String imagenObtenidaFormatoHTML = imagen.getTextoFormateado(formateadorHTML);

		items.agregarItem(tituloObtenidoFormatoHTML);
		items.agregarItem(subtituloObtenidoFormatoHTML);
		items.agregarItem(imagenObtenidaFormatoHTML);

		System.out.println(items.mostrarItems());

		Assert.assertEquals(itemsEsperados, items.mostrarItems());
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnaSeccionDePrueba() {

		String inicioSection = "inicio section de prueba";
		Section section1 = new Section(inicioSection);
		String inicioSectionEsperada = "<section>" + "\n";

		String finSection = "fin section de prueba";
		Section section2 = new Section(finSection);
		String finSectionEsperada = "</section>" + "\n";

		List<String> itemsEsperados = new LinkedList<String>();
		itemsEsperados.add(inicioSectionEsperada);
		itemsEsperados.add(finSectionEsperada);

		Formateador formateadorHTML = new FormateadorHTML();
		VisualizadorPorPantalla items = new VisualizadorPorPantalla();
		String inicioSectionObtenidaFormatoHTML = section1.getInicioFormateado(formateadorHTML);
		String finSectionObtenidaFormatoHTML = section2.getFinFormateado(formateadorHTML);

		items.agregarItem(inicioSectionObtenidaFormatoHTML);
		items.agregarItem(finSectionObtenidaFormatoHTML);

		System.out.println(items.mostrarItems());

		Assert.assertEquals(itemsEsperados, items.mostrarItems());
	}

	@Test
	public void seMuestraContenidoEnFormatoHTMLParaUnaSeccionConContenidoDePrueba() {

		String inicioSection = "inicio section de prueba";
		Section section1 = new Section(inicioSection);
		String inicioSectionEsperada = "<section>" + "\n";

		String tituloEntrada = "Titulo de prueba";
		ItemEntrada titulo = new Titulo(tituloEntrada);
		String tituloEsperado = "<h1>Titulo de prueba</h1>" + "\n";

		String subtituloEntrada = "Subtitulo de prueba";
		ItemEntrada subtitulo = new SubTitulo(subtituloEntrada);
		String subtituloEsperado = "<h2>Subtitulo de prueba</h2>" + "\n";

		String finSection = "fin section de prueba";
		Section section2 = new Section(finSection);
		String finSectionEsperada = "</section>" + "\n";

		List<String> itemsEsperados = new LinkedList<String>();
		itemsEsperados.add(inicioSectionEsperada);
		itemsEsperados.add(tituloEsperado);
		itemsEsperados.add(subtituloEsperado);
		itemsEsperados.add(finSectionEsperada);

		Formateador formateadorHTML = new FormateadorHTML();
		VisualizadorPorPantalla items = new VisualizadorPorPantalla();
		String inicioSectionObtenidaFormatoHTML = section1.getInicioFormateado(formateadorHTML);
		String tituloObtenidoFormatoHTML = titulo.getTextoFormateado(formateadorHTML);
		String subtituloObtenidoFormatoHTML = subtitulo.getTextoFormateado(formateadorHTML);
		String finSectionObtenidaFormatoHTML = section2.getFinFormateado(formateadorHTML);

		items.agregarItem(inicioSectionObtenidaFormatoHTML);
		items.agregarItem(tituloObtenidoFormatoHTML);
		items.agregarItem(subtituloObtenidoFormatoHTML);
		items.agregarItem(finSectionObtenidaFormatoHTML);

		System.out.println(items.mostrarItems());

		Assert.assertEquals(itemsEsperados, items.mostrarItems());
	}
}