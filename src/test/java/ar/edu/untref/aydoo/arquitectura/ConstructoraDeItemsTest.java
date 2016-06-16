package ar.edu.untref.aydoo.arquitectura;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.TextoPlano;
import ar.edu.untref.aydoo.dominio.Titulo;

public class ConstructoraDeItemsTest {

	@Test
	public void instanciarTituloMD() {
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String titulo = "# Titulo";
		Item itemEsperado = new Titulo(titulo);
		
		Item itemObtenido = contructoraDeItems.instanciarItemLeidoMD(titulo);
		
		Assert.assertEquals(itemEsperado.getClass(), itemObtenido.getClass());
	}
	
	@Test
	public void instanciarSubTituloMD() {
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String subTitulo = "## SubTitulo";
		Item itemEsperado = new SubTitulo(subTitulo);
		
		Item itemObtenido = contructoraDeItems.instanciarItemLeidoMD(subTitulo);
		
		Assert.assertEquals(itemEsperado.getClass(), itemObtenido.getClass());
	}
	
	@Test
	public void instanciarTextoPlanoMD() {
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String textoPlano = "Texto plano";
		Item itemEsperado = new TextoPlano(textoPlano);
		
		Item itemObtenido = contructoraDeItems.instanciarItemLeidoMD(textoPlano);
		
		Assert.assertEquals(itemEsperado.getClass(), itemObtenido.getClass());
	}
	
	@Test
	public void instanciarImagenMD() {
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String imagen = "i:imagen.jpg";
		Item itemEsperado = new Imagen(imagen);
		
		Item itemObtenido = contructoraDeItems.instanciarItemLeidoMD(imagen);
		
		Assert.assertEquals(itemEsperado.getClass(), itemObtenido.getClass());
	}
	
	@Test
	public void seCreaListaDeItemsParaSalidaDelEjemplo1() {		
		
		Item seccion1 = new Seccion("---");
		Item elTitulo = new Titulo("El titulo");
		Item elSubTitulo = new SubTitulo("El subtitulo");
		Item seccion2 = new Seccion("---");
		Item soloUnTitulo = new Titulo("Solo un titulo");
		Item seccion3 = new Seccion("---");
		Item soloTexto = new TextoPlano("solo texto sin nada mas");
		List<Item> itemsInstanciados = new ArrayList<Item>();
		itemsInstanciados.add(seccion1);
		itemsInstanciados.add(elTitulo);
		itemsInstanciados.add(elSubTitulo);
		itemsInstanciados.add(seccion2);
		itemsInstanciados.add(soloUnTitulo);
		itemsInstanciados.add(seccion3);
		itemsInstanciados.add(soloTexto);
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String primeraSeccionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section>";
		String segundaSeccionEsperada = "<section><h1>Solo un titulo</h1></section>";
		String terceraSeccionEsperada = "<section>solo texto sin nada mas</section>";

		List<Item> listaParaSalida = contructoraDeItems.crearListaParaSalidaHTML(itemsInstanciados);

		Assert.assertEquals(3, listaParaSalida.size());
		Assert.assertEquals(primeraSeccionEsperada, listaParaSalida.get(0).getTextoFormateadoHTML());
		Assert.assertEquals(segundaSeccionEsperada,listaParaSalida.get(1).getTextoFormateadoHTML());
		Assert.assertEquals(terceraSeccionEsperada,listaParaSalida.get(2).getTextoFormateadoHTML());
	}

	@Test
	public void seCreaListaDeItemsParaSalidaDelEjemploConEncabezadoSinSeccion()  {

		Item encabezado = new TextoPlano("Encabezado");
		Item seccion1 = new Seccion("---");
		Item elTitulo = new Titulo("El titulo");
		Item elSubTitulo = new SubTitulo("El subtitulo");
		Item seccion2 = new Seccion("---");
		Item soloUnTitulo = new Titulo("Solo un titulo");
		Item seccion3 = new Seccion("---");
		Item soloTexto = new TextoPlano("solo texto sin nada mas");
		List<Item> itemsInstanciados = new ArrayList<Item>();
		itemsInstanciados.add(encabezado);
		itemsInstanciados.add(seccion1);
		itemsInstanciados.add(elTitulo);
		itemsInstanciados.add(elSubTitulo);
		itemsInstanciados.add(seccion2);
		itemsInstanciados.add(soloUnTitulo);
		itemsInstanciados.add(seccion3);
		itemsInstanciados.add(soloTexto);
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String encabezadoSinSeccion = "Encabezado";
		String primeraSeccionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section>";
		String segundaSeccionEsperada = "<section><h1>Solo un titulo</h1></section>";
		String terceraSeccionEsperada = "<section>solo texto sin nada mas</section>";

		List<Item> listaParaSalida = contructoraDeItems.crearListaParaSalidaHTML(itemsInstanciados);

		Assert.assertEquals(4, listaParaSalida.size());
		Assert.assertEquals(encabezadoSinSeccion, listaParaSalida.get(0).getTextoFormateadoHTML());
		Assert.assertEquals(primeraSeccionEsperada, listaParaSalida.get(1).getTextoFormateadoHTML());
		Assert.assertEquals(segundaSeccionEsperada,listaParaSalida.get(2).getTextoFormateadoHTML());
		Assert.assertEquals(terceraSeccionEsperada,listaParaSalida.get(3).getTextoFormateadoHTML());
	}

	@Test
	public void seCreaListaDeItemsParaSalidaDelEjemploConBullets()  {

		Item seccion1 = new Seccion("---");
		Item elTitulo = new Titulo("El titulo");
		Item elSubTitulo = new SubTitulo("El subtitulo");
		Item seccion2 = new Seccion("---");
		Item soloUnTitulo = new Titulo("Solo un titulo");
		Item seccion3 = new Seccion("---");
		Item soloTexto = new TextoPlano("solo texto sin nada mas");
		Item seccion4 = new Seccion("---");
		Item unItemDeUnaLista = new ItemLista("Un item de una lista");
		Item otroItem = new ItemLista("Otro item");
		List<Item> itemsInstanciados = new ArrayList<Item>();
		itemsInstanciados.add(seccion1);
		itemsInstanciados.add(elTitulo);
		itemsInstanciados.add(elSubTitulo);
		itemsInstanciados.add(seccion2);
		itemsInstanciados.add(soloUnTitulo);
		itemsInstanciados.add(seccion3);
		itemsInstanciados.add(soloTexto);
		itemsInstanciados.add(seccion4);
		itemsInstanciados.add(unItemDeUnaLista);
		itemsInstanciados.add(otroItem);
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String primeraSeccionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section>";
		String segundaSeccionEsperada = "<section><h1>Solo un titulo</h1></section>";
		String terceraSeccionEsperada = "<section>solo texto sin nada mas</section>";
		String cuartaSeccionEsperada = "<section><ul><li>Un item de una lista</li><li>Otro item</li></ul></section>";

		List<Item> listaParaSalida = contructoraDeItems.crearListaParaSalidaHTML(itemsInstanciados);

		Assert.assertEquals(4, listaParaSalida.size());
		Assert.assertEquals(primeraSeccionEsperada, listaParaSalida.get(0).getTextoFormateadoHTML());
		Assert.assertEquals(segundaSeccionEsperada,listaParaSalida.get(1).getTextoFormateadoHTML());
		Assert.assertEquals(terceraSeccionEsperada,listaParaSalida.get(2).getTextoFormateadoHTML());
		Assert.assertEquals(cuartaSeccionEsperada,listaParaSalida.get(3).getTextoFormateadoHTML());
	}
	
	@Test
	public void seCreaListaDeItemsParaSalidaDelEjemploConMultiplesBullets()  {
		
		Item seccion1 = new Seccion("---");
		Item elTitulo = new Titulo("El titulo");
		Item elSubTitulo = new SubTitulo("El subtitulo");
		Item seccion2 = new Seccion("---");
		Item primeraLista = new Titulo("Primera lista");
		Item listaUno = new ItemLista("Uno");
		Item listaDos = new ItemLista("Dos");
		Item seccion3 = new Seccion("---");
		Item soloUntitulo = new Titulo("Solo un titulo");
		Item seccion4 = new Seccion("---");		
		Item soloTexto = new TextoPlano("solo texto sin nada mas");
		Item seccion5 = new Seccion("---");
		Item segundaLista = new Titulo("Segunda lista");
		Item listaTres = new ItemLista("Tres");
		Item listaCuatro = new ItemLista("Cuatro");
		Item listaCinco = new ItemLista("Cinco");
		Item seccion6 = new Seccion("---");
		Item listaSeis = new ItemLista("Seis");
		Item listaSiete = new ItemLista("Siete");
		List<Item> itemsInstanciados = new ArrayList<Item>();
		itemsInstanciados.add(seccion1);
		itemsInstanciados.add(elTitulo);
		itemsInstanciados.add(elSubTitulo);
		itemsInstanciados.add(seccion2);
		itemsInstanciados.add(primeraLista);
		itemsInstanciados.add(listaUno);
		itemsInstanciados.add(listaDos);
		itemsInstanciados.add(seccion3);
		itemsInstanciados.add(soloUntitulo);
		itemsInstanciados.add(seccion4);
		itemsInstanciados.add(soloTexto);
		itemsInstanciados.add(seccion5);
		itemsInstanciados.add(segundaLista);
		itemsInstanciados.add(listaTres);
		itemsInstanciados.add(listaCuatro);
		itemsInstanciados.add(listaCinco);
		itemsInstanciados.add(seccion6);
		itemsInstanciados.add(listaSeis);
		itemsInstanciados.add(listaSiete);
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String primeraSeccionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section>";
		String segundaSeccionEsperada = "<section><h1>Primera lista</h1><ul><li>Uno</li><li>Dos</li></ul></section>";
		String terceraSeccionEsperada = "<section><h1>Solo un titulo</h1></section>";
		String cuartaSeccionEsperada = "<section>solo texto sin nada mas</section>";
		String quintaSeccionEsperada = "<section><h1>Segunda lista</h1><ul><li>Tres</li><li>Cuatro</li><li>Cinco</li></ul></section>";
		String sextaSeccionEsperada = "<section><ul><li>Seis</li><li>Siete</li></ul></section>";

		List<Item> listaParaSalida = contructoraDeItems.crearListaParaSalidaHTML(itemsInstanciados);

		Assert.assertEquals(6, listaParaSalida.size());
		Assert.assertEquals(primeraSeccionEsperada, listaParaSalida.get(0).getTextoFormateadoHTML());
		Assert.assertEquals(segundaSeccionEsperada,listaParaSalida.get(1).getTextoFormateadoHTML());
		Assert.assertEquals(terceraSeccionEsperada,listaParaSalida.get(2).getTextoFormateadoHTML());
		Assert.assertEquals(cuartaSeccionEsperada,listaParaSalida.get(3).getTextoFormateadoHTML());
		Assert.assertEquals(quintaSeccionEsperada,listaParaSalida.get(4).getTextoFormateadoHTML());
		Assert.assertEquals(sextaSeccionEsperada,listaParaSalida.get(5).getTextoFormateadoHTML());
	}	

	@Test
	public void seCreaListaDeItemsParaSalidaDelEjemploConImagen()  {

		Item seccion1 = new Seccion("---");
		Item elTitulo = new Titulo("El titulo");
		Item elSubTitulo = new SubTitulo("El subtitulo");
		Item seccion2 = new Seccion("---");
		Item soloUnTitulo = new Titulo("Solo un titulo");
		Item seccion3 = new Seccion("---");
		Item soloTexto = new TextoPlano("solo texto sin nada mas");
		Item seccion4 = new Seccion("---");
		Item unItemDeUnaLista = new ItemLista("Un item de una lista");
		Item otroItem = new ItemLista("Otro item");
		Item seccion5 = new Seccion("---");
		Item imagen = new Imagen("/home/lucas/aydoo-2016-e5/src/test/resources/winteriscoming.jpg");
		List<Item> itemsInstanciados = new ArrayList<Item>();
		itemsInstanciados.add(seccion1);
		itemsInstanciados.add(elTitulo);
		itemsInstanciados.add(elSubTitulo);
		itemsInstanciados.add(seccion2);
		itemsInstanciados.add(soloUnTitulo);
		itemsInstanciados.add(seccion3);
		itemsInstanciados.add(soloTexto);
		itemsInstanciados.add(seccion4);
		itemsInstanciados.add(unItemDeUnaLista);
		itemsInstanciados.add(otroItem);
		itemsInstanciados.add(seccion5);
		itemsInstanciados.add(imagen);
		
		ConstructoraDeItems contructoraDeItems = new ConstructoraDeItems();
		String primeraSeccionEsperada = "<section><h1>El titulo</h1><h2>El subtitulo</h2></section>";
		String segundaSeccionEsperada = "<section><h1>Solo un titulo</h1></section>";
		String terceraSeccionEsperada = "<section>solo texto sin nada mas</section>";
		String cuartaSeccionEsperada = "<section><ul><li>Un item de una lista</li><li>Otro item</li></ul></section>";
		String quintaSeccionEsperada = "<section><img src=\"/home/lucas/aydoo-2016-e5/src/test/resources/winteriscoming.jpg\"/></section>";

		List<Item> listaParaSalida = contructoraDeItems.crearListaParaSalidaHTML(itemsInstanciados);

		Assert.assertEquals(5, listaParaSalida.size());
		Assert.assertEquals(primeraSeccionEsperada, listaParaSalida.get(0).getTextoFormateadoHTML());
		Assert.assertEquals(segundaSeccionEsperada,listaParaSalida.get(1).getTextoFormateadoHTML());
		Assert.assertEquals(terceraSeccionEsperada,listaParaSalida.get(2).getTextoFormateadoHTML());
		Assert.assertEquals(cuartaSeccionEsperada,listaParaSalida.get(3).getTextoFormateadoHTML());
		Assert.assertEquals(quintaSeccionEsperada,listaParaSalida.get(4).getTextoFormateadoHTML());
	}
}
