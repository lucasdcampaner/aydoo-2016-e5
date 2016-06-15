package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorItemsDesdeArchivoTest {

	protected static final String encabezadoFormateadoEsperado = "Encabezado";

	protected static final String tituloFormateadoEsperado = "<section>" + "<h1>El titulo</h1>"
			+ "<h2>El subtitulo</h2>" + "</section>";
	protected static final String soloUnTituloFormateadoEsperado = "<section>" + "<h1>Solo un titulo</h1>"
			+ "</section>";
	protected static final String soloTextoFormateadoEsperado = "<section>" + "solo texto sin nada mas" + "</section>";

	protected static final String listaUnicaFormateadoEsperado = "<section>" + "<ul>" + "<li>Un item de una lista</li>"
			+ "<li>Otro item</li>" + "</ul>" + "</section>";
	protected static final String primeraListaFormateadoEsperado = "<section>" + "<h1>Primera lista</h1>" + "<ul>"
			+ "<li>Uno</li>" + "<li>Dos</li>" + "</ul>" + "</section>";

	protected static final String segundaListaFormateadoEsperado = "<section>" + "<h1>Segunda lista</h1>" + "<ul>"
			+ "<li>Tres</li>" + "<li>Cuatro</li>" + "<li>Cinco</li>" + "</ul>" + "</section>";

	protected static final String terceraListaFormateadoEsperado = "<section>" + "<ul>" + "<li>Seis</li>"
			+ "<li>Siete</li>" + "</ul>" + "</section>";

	@Test
	public void seCreaListaDeItemsEntradaDelEjemploIntegrador() throws IOException {

		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(
				"src/test/resources/ejemplo1.md");
		Formateador formateadorHTML = new FormateadorHTML();

		List<Item> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada();

		Assert.assertEquals(3, itemsEntradaObtenida.size());
		Assert.assertEquals(tituloFormateadoEsperado, itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloUnTituloFormateadoEsperado,
				itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloTextoFormateadoEsperado,
				itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML));

	}

	@Test
	public void seCreaListaDeItemsConEncabezadoSinSeccion() throws IOException {

		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(
				"src/test/resources/ejemploConEncabezadoSinSeccion.md");
		Formateador formateadorHTML = new FormateadorHTML();

		List<Item> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada();

		Assert.assertEquals(4, itemsEntradaObtenida.size());
		Assert.assertEquals(encabezadoFormateadoEsperado,
				itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(tituloFormateadoEsperado, itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloUnTituloFormateadoEsperado,
				itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloTextoFormateadoEsperado,
				itemsEntradaObtenida.get(3).getTextoFormateado(formateadorHTML));

	}

	@Test
	public void seCreaListaDeItemsConBullets() throws IOException {

		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(
				"src/test/resources/ejemploConBullets.md");
		Formateador formateadorHTML = new FormateadorHTML();

		List<Item> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada();

		Assert.assertEquals(4, itemsEntradaObtenida.size());

		Assert.assertEquals(tituloFormateadoEsperado, itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloUnTituloFormateadoEsperado,
				itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloTextoFormateadoEsperado,
				itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(listaUnicaFormateadoEsperado,
				itemsEntradaObtenida.get(3).getTextoFormateado(formateadorHTML));

	}

	@Test
	public void seCreanDosListasDeItemsConBullets() throws IOException {

		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(
				"src/test/resources/ejemploConMultiplesBullets.md");
		Formateador formateadorHTML = new FormateadorHTML();

		List<Item> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada();

		Assert.assertEquals(6, itemsEntradaObtenida.size());

		Assert.assertEquals(tituloFormateadoEsperado, itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(primeraListaFormateadoEsperado,
				itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloUnTituloFormateadoEsperado,
				itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(soloTextoFormateadoEsperado,
				itemsEntradaObtenida.get(3).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(segundaListaFormateadoEsperado,
				itemsEntradaObtenida.get(4).getTextoFormateado(formateadorHTML));
		Assert.assertEquals(terceraListaFormateadoEsperado,
				itemsEntradaObtenida.get(5).getTextoFormateado(formateadorHTML));

	}

}
