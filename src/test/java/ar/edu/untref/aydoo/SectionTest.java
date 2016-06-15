package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	@Test
	public void seObtieneSectionVaciaEnFormatoHTML() {

		Item itemListaContenedor = new Seccion("");
		String sectionEsperada = "<section></section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void seObtieneDobleSectionVaciaEnFormatoHTML() {

		Item itemListaContenedor = new Seccion("");
		Item itemListaContenedor2 = new Seccion("");
		String sectionEsperada = "<section></section><section></section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);
		String itemListaObtenidaFormatoHTML2 = itemListaContenedor2.getTextoFormateado(formateadorHTML);

		String itemListaObtenidaFormatoHTMLfinal = itemListaObtenidaFormatoHTML + itemListaObtenidaFormatoHTML2;
		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTMLfinal);
	}

	@Test
	public void seObtieneUnTituloSoloEnUnaSectionEnFormatoHTML() {

		Item section = new Seccion("");
		Item titulo = new Titulo("El titulo");
		section.agregarElementoEnContenedor(titulo);
		String sectionConTituloEsperada = "<section><h1>El titulo</h1></section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String seccionConTituloObtenida = section.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionConTituloEsperada, seccionConTituloObtenida);
	}

	@Test
	public void seObtieneDobleTituloEnUnaSectionEnFormatoHTML() {

		Item itemListaContenedor = new Seccion("");
		Item itemLista = new Titulo("El titulo1");
		Item itemLista2 = new Titulo("El titulo2");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		String sectionEsperada = "<section><h1>El titulo1</h1><h1>El titulo2</h1></section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void seObtieneTituloYSubtituloEnUnaSectionEnFormatoHTML() {

		Item itemListaContenedor = new Seccion("");
		Item itemLista = new Titulo("El titulo1");
		Item itemLista2 = new SubTitulo("El subtitulo2");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		String sectionEsperada = "<section><h1>El titulo1</h1><h2>El subtitulo2</h2></section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void seVerificanTresSeccionesConDistintosItems() {

		Item section1 = new Seccion("");
		Item titulo1 = new Titulo("El titulo");
		Item subtitulo1 = new SubTitulo("El subtitulo");
		section1.agregarElementoEnContenedor(titulo1);
		section1.agregarElementoEnContenedor(subtitulo1);

		Item section2 = new Seccion("");
		Item titulo2 = new Titulo("Solo un titulo");
		section2.agregarElementoEnContenedor(titulo2);

		Item section3 = new Seccion("");
		Item imagen = new Imagen("imagen.png");
		section3.agregarElementoEnContenedor(imagen);

		String sectionesEsperada = "<section>" + "<h1>El titulo</h1>" + "<h2>El subtitulo</h2>" + "</section>"
				+ "<section>" + "<h1>Solo un titulo</h1>" + "</section>" + "<section>" + "<img src=\"imagen.png\"/>"
				+ "</section>";
		Formateador formateadorHTML = new FormateadorHTML();

		String sectionFormateada1 = section1.getTextoFormateado(formateadorHTML);
		String sectionFormateada2 = section2.getTextoFormateado(formateadorHTML);
		String sectionFormateada3 = section3.getTextoFormateado(formateadorHTML);
		String sectionesObtenidas = sectionFormateada1 + sectionFormateada2 + sectionFormateada3;

		Assert.assertEquals(sectionesEsperada, sectionesObtenidas);
	}

	@Test
	public void seObtieneUnElementoDeCadaTipoEnUnaSectionEnFormatoHTML() {

		Item itemListaContenedor = new Seccion("");
		Item itemLista = new Titulo("El titulo1");
		Item itemLista2 = new SubTitulo("El subtitulo2");
		Item itemLista3 = new Imagen("imagen.png");
		Item itemLista4 = new TextoPlano("linea sin nada en especial");
		Item itemLista5 = new ItemListaContenedor("");

		Item itemLista6 = new ItemLista("un item de una lista");
		itemLista5.agregarElementoEnContenedor(itemLista6);

		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		itemListaContenedor.agregarElementoEnContenedor(itemLista3);
		itemListaContenedor.agregarElementoEnContenedor(itemLista4);
		itemListaContenedor.agregarElementoEnContenedor(itemLista5);

		String sectionEsperada = "<section><h1>El titulo1</h1><h2>El subtitulo2</h2>" + "<img src=\"imagen.png\"/>"
				+ "linea sin nada en especial" + "<ul><li>un item de una lista</li></ul></section>";

		Formateador formateadorHTML = new FormateadorHTML();

		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

}
