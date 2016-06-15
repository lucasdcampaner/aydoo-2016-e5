package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LectorDeArchivoEntradaTest {

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
		List<String> itemsObtenidos = lectorDeArchivoDeEntrada.getListaItemsEntrada(); 

		//Asserts
		for (int i = 0; i < itemsEsperados.size(); i++) {
			Assert.assertEquals(itemsEsperados.get(i), itemsObtenidos.get(i));
		}
		
	}


}
