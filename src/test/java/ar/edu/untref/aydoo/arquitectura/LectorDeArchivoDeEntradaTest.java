package ar.edu.untref.aydoo.arquitectura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.arquitectura.LectorDeArchivoDeEntrada;

public class LectorDeArchivoDeEntradaTest {

	@Test
	public void seCreaListaDeItemsEntradaDelEjemplo1() throws IOException {

		//Preparacion
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada("src/test/resources/ejemplo1.md");
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("---");
		itemsEsperados.add("# El titulo");
		itemsEsperados.add("## El subtitulo");
		itemsEsperados.add("---");
		itemsEsperados.add("# Solo un titulo");
		itemsEsperados.add("---");
		itemsEsperados.add("solo texto sin nada mas");		

		//Invocacion
		List<String> itemsObtenidos = lectorDeArchivoDeEntrada.getListaItemsLeidos(); 

		//Asserts
		for (int i = 0; i < itemsEsperados.size(); i++) {
			Assert.assertEquals(itemsEsperados.get(i), itemsObtenidos.get(i));
		}
	}

	@Test
	public void seCreaListaDeItemsEntradaDelEjemploConBullets() throws IOException {

		//Preparacion
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada("src/test/resources/ejemploConBullets.md");
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("---");
		itemsEsperados.add("# El titulo");
		itemsEsperados.add("## El subtitulo");
		itemsEsperados.add("---");
		itemsEsperados.add("# Solo un titulo");
		itemsEsperados.add("---");
		itemsEsperados.add("solo texto sin nada mas");
		itemsEsperados.add("---");
		itemsEsperados.add("* Un item de una lista");
		itemsEsperados.add("* Otro item");

		//Invocacion
		List<String> itemsObtenidos = lectorDeArchivoDeEntrada.getListaItemsLeidos(); 

		//Asserts
		for (int i = 0; i < itemsEsperados.size(); i++) {
			Assert.assertEquals(itemsEsperados.get(i), itemsObtenidos.get(i));
		}	
	}	
	
	@Test
	public void seCreaListaDeItemsEntradaDelEjemploConEncabezadoSinSeccion() throws IOException {

		//Preparacion
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada("src/test/resources/ejemploConEncabezadoSinSeccion.md");
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("Encabezado");
		itemsEsperados.add("---");
		itemsEsperados.add("# El titulo");
		itemsEsperados.add("## El subtitulo");
		itemsEsperados.add("---");
		itemsEsperados.add("# Solo un titulo");
		itemsEsperados.add("---");
		itemsEsperados.add("solo texto sin nada mas");
		
		//Invocacion
		List<String> itemsObtenidos = lectorDeArchivoDeEntrada.getListaItemsLeidos(); 

		//Asserts
		for (int i = 0; i < itemsEsperados.size(); i++) {
			Assert.assertEquals(itemsEsperados.get(i), itemsObtenidos.get(i));
		}
	}	
	
	@Test
	public void seCreaListaDeItemsEntradaDelEjemploConMultiplesBullets() throws IOException {

		//Preparacion
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada("src/test/resources/ejemploConMultiplesBullets.md");
		List<String> itemsEsperados = new ArrayList<String>();
		itemsEsperados.add("---");
		itemsEsperados.add("# El titulo");
		itemsEsperados.add("## El subtitulo");
		itemsEsperados.add("---");
		itemsEsperados.add("# Primera lista");
		itemsEsperados.add("* Uno");
		itemsEsperados.add("* Dos");
		itemsEsperados.add("---");
		itemsEsperados.add("# Solo un titulo");
		itemsEsperados.add("---");
		itemsEsperados.add("solo texto sin nada mas");
		itemsEsperados.add("---");
		itemsEsperados.add("# Segunda lista");
		itemsEsperados.add("* Tres");
		itemsEsperados.add("* Cuatro");
		itemsEsperados.add("* Cinco");
		itemsEsperados.add("---");
		itemsEsperados.add("* Seis");
		itemsEsperados.add("* Siete");
		
		//Invocacion
		List<String> itemsObtenidos = lectorDeArchivoDeEntrada.getListaItemsLeidos(); 

		//Asserts
		for (int i = 0; i < itemsEsperados.size(); i++) {
			Assert.assertEquals(itemsEsperados.get(i), itemsObtenidos.get(i));
		}
	}
}
