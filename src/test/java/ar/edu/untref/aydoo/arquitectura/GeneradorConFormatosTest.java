package ar.edu.untref.aydoo.arquitectura;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.arquitectura.FabricaDeItem;
import ar.edu.untref.aydoo.arquitectura.GeneradorConFormatos;
import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.ItemLista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.TextoPlano;
import ar.edu.untref.aydoo.dominio.Titulo;

public class GeneradorConFormatosTest {
	
	@Test
	public void seGeneraListaConInstanciasCorrectasDelEjemplo1() throws IOException {

		//Preparacion
		FabricaDeItem formateadorHTML = new FabricaDeItem(); 
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML);
		List<String> itemsLeidos = new ArrayList<String>();
		itemsLeidos.add("---");
		itemsLeidos.add("# El titulo");
		itemsLeidos.add("## El subtitulo");
		itemsLeidos.add("---");
		itemsLeidos.add("# Solo un titulo");
		itemsLeidos.add("---");
		itemsLeidos.add("solo texto sin nada mas");	
		
		//Invocacion
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);

		//Asserts
		Assert.assertEquals(7, itemsObtenidos.size());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(0).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(1).getClass());
		Assert.assertEquals(SubTitulo.class, itemsObtenidos.get(2).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(3).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(4).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(5).getClass());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(6).getClass());
	}

	@Test
	public void seGeneraListaConInstanciasCorrectasDelEjemploConBullets() throws IOException {

		//Preparacion
		FabricaDeItem formateadorHTML = new FabricaDeItem(); 
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML);
		List<String> itemsLeidos = new ArrayList<String>();
		itemsLeidos.add("---");
		itemsLeidos.add("# El titulo");
		itemsLeidos.add("## El subtitulo");
		itemsLeidos.add("---");
		itemsLeidos.add("# Solo un titulo");
		itemsLeidos.add("---");
		itemsLeidos.add("solo texto sin nada mas");
		itemsLeidos.add("---");
		itemsLeidos.add("* Un item de una lista");
		itemsLeidos.add("* Otro item");
		
		//Invocacion
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);

		//Asserts
		Assert.assertEquals(10, itemsObtenidos.size());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(0).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(1).getClass());
		Assert.assertEquals(SubTitulo.class, itemsObtenidos.get(2).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(3).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(4).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(5).getClass());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(6).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(7).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(8).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(9).getClass());	
	}

	@Test
	public void seGeneraListaConInstanciasCorrectasDelEjemploConEncabezadoSinSeccion() throws IOException {

		//Preparacion
		FabricaDeItem formateadorHTML = new FabricaDeItem(); 
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML);
		List<String> itemsLeidos = new ArrayList<String>();
		itemsLeidos.add("Encabezado");
		itemsLeidos.add("---");
		itemsLeidos.add("# El titulo");
		itemsLeidos.add("## El subtitulo");
		itemsLeidos.add("---");
		itemsLeidos.add("# Solo un titulo");
		itemsLeidos.add("---");
		itemsLeidos.add("solo texto sin nada mas");	
		
		//Invocacion
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);

		//Asserts
		Assert.assertEquals(8, itemsObtenidos.size());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(0).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(1).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(2).getClass());
		Assert.assertEquals(SubTitulo.class, itemsObtenidos.get(3).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(4).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(5).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(6).getClass());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(7).getClass());
	}	

	@Test
	public void seGeneraListaConInstanciasCorrectasDelEjemploConMultiplesBullets() throws IOException {

		//Preparacion
		FabricaDeItem formateadorHTML = new FabricaDeItem(); 
		GeneradorConFormatos generadorConFormatos = new GeneradorConFormatos(formateadorHTML);
		List<String> itemsLeidos = new ArrayList<String>();
		itemsLeidos.add("---");
		itemsLeidos.add("# El titulo");
		itemsLeidos.add("## El subtitulo");
		itemsLeidos.add("---");
		itemsLeidos.add("# Primera lista");
		itemsLeidos.add("* Uno");
		itemsLeidos.add("* Dos");
		itemsLeidos.add("---");
		itemsLeidos.add("# Solo un titulo");
		itemsLeidos.add("---");
		itemsLeidos.add("solo texto sin nada mas");
		itemsLeidos.add("---");
		itemsLeidos.add("# Segunda lista");
		itemsLeidos.add("* Tres");
		itemsLeidos.add("* Cuatro");
		itemsLeidos.add("* Cinco");
		itemsLeidos.add("---");
		itemsLeidos.add("* Seis");
		itemsLeidos.add("* Siete");	
		
		//Invocacion
		List<Item> itemsObtenidos = generadorConFormatos.getItemsInstanciadosMD(itemsLeidos);

		//Asserts
		Assert.assertEquals(19, itemsObtenidos.size());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(0).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(1).getClass());
		Assert.assertEquals(SubTitulo.class, itemsObtenidos.get(2).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(3).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(4).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(5).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(6).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(7).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(8).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(9).getClass());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(10).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(11).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(12).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(13).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(14).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(15).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(16).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(17).getClass());
		Assert.assertEquals(ItemLista.class, itemsObtenidos.get(18).getClass());		
	}
}
