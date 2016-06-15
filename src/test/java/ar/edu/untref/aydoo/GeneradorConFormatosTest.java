package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorConFormatosTest {
	
	@Test
	public void seGeneraListaConInstanciasCorrectasDelEjemplo1() throws IOException {

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
		Assert.assertEquals(7, itemsObtenidos.size());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(0).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(1).getClass());
		Assert.assertEquals(SubTitulo.class, itemsObtenidos.get(2).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(3).getClass());
		Assert.assertEquals(Titulo.class, itemsObtenidos.get(4).getClass());
		Assert.assertEquals(Seccion.class, itemsObtenidos.get(5).getClass());
		Assert.assertEquals(TextoPlano.class, itemsObtenidos.get(6).getClass());
	}

}
