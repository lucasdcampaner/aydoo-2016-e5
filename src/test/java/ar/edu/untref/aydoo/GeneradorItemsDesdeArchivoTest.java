package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorItemsDesdeArchivoTest {

	@Test
	public void testDeEjemploIntegrador() throws IOException {
		
		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		//Items de entrada
		ItemEntrada section1 = new Section("");
		ItemEntrada titulo1 = new Titulo("El titulo");
		ItemEntrada subtitulo1 = new SubTitulo("El Subtitulo");
		section1.agregarElementoEnContenedor(titulo1);
		section1.agregarElementoEnContenedor(subtitulo1);
		ItemEntrada section2 = new Section("");
		ItemEntrada titulo2 = new Titulo("Solo un titulo");
		section2.agregarElementoEnContenedor(titulo2);
		ItemEntrada section3 = new Section("");
		ItemEntrada textoPlano = new TextoPlano("solo texto sin nada mas");
		section3.agregarElementoEnContenedor(textoPlano);
		itemsEntrada.add(section1);
		itemsEntrada.add(section2);
		itemsEntrada.add(section3);
		String primerTextoFormateadoEsperado  = "<section>"
		 											+ "<h1>El titulo</h1>"
	 												+ "<h2>El Subtitulo</h2>"
												+ "</section>";
		
		String segundoTextoFormateadoEsperado = "<section>" 
													+ "<h1>Solo un titulo</h1>"
												+ "</section>";
		String tercerTextoFormateadoEsperado =  "<section>"
													+ "solo texto sin nada mas"
												+ "</section>";
		//mockear
		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo("ejemploIntegrador.md");
		Formateador formateadorHTML = new FormateadorHTML();
		
		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML);
		String primerTextoFormateadoObtenido = itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML);
		String segundoTextoFormateadoObtenido = itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML);
		String terceroTextoFormateadoObtenido = itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML);
		
		//Assert
		Assert.assertEquals(primerTextoFormateadoEsperado, primerTextoFormateadoObtenido);
		Assert.assertEquals(segundoTextoFormateadoEsperado, segundoTextoFormateadoObtenido);
		Assert.assertEquals(tercerTextoFormateadoEsperado, terceroTextoFormateadoObtenido);
			
	}

}
