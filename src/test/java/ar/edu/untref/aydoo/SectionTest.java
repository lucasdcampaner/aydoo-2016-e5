package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SectionTest {

	@Test
	public void seObtieneSectionVaciaEnFormatoHTML() {

		ItemEntrada itemListaContenedor = new Section("");

		String sectionEsperada = "<section></section>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);

	}

	@Test
	public void seObtieneUnTituloSoloEnUnaSectionEnFormatoHTML() {

		// ItemEntrada section = new Section("");
		// copiado de test de Item
		ItemEntrada itemListaContenedor = new Section("");
		ItemEntrada itemLista = new Titulo("El titulo");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);

		String sectionEsperada = "<section><h1>El titulo</h1></section>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void seObtieneDobleTituloEnUnaSectionEnFormatoHTML() {

		ItemEntrada itemListaContenedor = new Section("");
		ItemEntrada itemLista = new Titulo("El titulo1");
		ItemEntrada itemLista2 = new Titulo("El titulo2");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);

		String sectionEsperada = "<section><h1>El titulo1</h1><h1>El titulo2</h1></section>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void seObtieneTituloYSubtituloEnUnaSectionEnFormatoHTML() {

		ItemEntrada itemListaContenedor = new Section("");
		ItemEntrada itemLista = new Titulo("El titulo1");
		ItemEntrada itemLista2 = new SubTitulo("El subtitulo2");
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);

		String sectionEsperada = "<section><h1>El titulo1</h1><h2>El subtitulo2</h2></section>";

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = itemListaContenedor.getTextoFormateado(formateadorHTML);

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

	@Test
	public void test2MasCompleto() {

		Formateador formateadorHTML = new FormateadorHTML();
		String itemListaObtenidaFormatoHTML = "";

		ItemEntrada itemListaContenedor = new Section("");
		ItemEntrada itemLista = new Titulo("El titulo");
		ItemEntrada itemLista2 = new SubTitulo("El subtitulo");
		// <section>
		// <h1>El titulo</h1>
		// <h2>El subtitulo</h2>
		itemListaContenedor.agregarElementoEnContenedor(itemLista);
		itemListaContenedor.agregarElementoEnContenedor(itemLista2);
		// </section>
		itemListaObtenidaFormatoHTML += itemListaContenedor.getTextoFormateado(formateadorHTML);
		//System.out.print("1: ");		System.out.println(itemListaObtenidaFormatoHTML);
		// <section>
		// <h1>Solo un titulo</h1>
		// </section>
		itemListaContenedor = null;
		itemListaContenedor = new Section("");
		ItemEntrada itemLista3 = new Titulo("Solo un titulo");
		itemListaContenedor.agregarElementoEnContenedor(itemLista3);
		itemListaObtenidaFormatoHTML += itemListaContenedor.getTextoFormateado(formateadorHTML);
		//System.out.print("2: ");		System.out.println(itemListaObtenidaFormatoHTML);
		// <section>
		// <img src="imagen.png"/>
		// </section>
		itemListaContenedor = null;
		itemListaContenedor = new Section("");
		ItemEntrada itemLista4 = new Imagen("imagen.png");
		itemListaContenedor.agregarElementoEnContenedor(itemLista4);
		itemListaObtenidaFormatoHTML += itemListaContenedor.getTextoFormateado(formateadorHTML);
		//System.out.print("3: ");		System.out.println(itemListaObtenidaFormatoHTML);

		String sectionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section><section><h1>Solo un titulo</h1></section><section><img src=\"imagen.png\"/></section>";

		Assert.assertEquals(sectionEsperada, itemListaObtenidaFormatoHTML);
	}

}
