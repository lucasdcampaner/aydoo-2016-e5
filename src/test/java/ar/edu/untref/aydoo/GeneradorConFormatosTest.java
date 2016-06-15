package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GeneradorConFormatosTest {
		
	@Test
	public void seGeneraListaConFormatoHtmlDelEjemplo1() throws IOException {

		//Preparacion
		FormateadorHTML formateadorHTML = new FormateadorHTML(); 
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
		//Assert.assertEquals(itemsLeidos.get(1), itemsObtenidos.get(1).getTexto());
	}

}
