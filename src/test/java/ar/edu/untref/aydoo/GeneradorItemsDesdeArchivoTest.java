package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GeneradorItemsDesdeArchivoTest {
	
//	@Test
//	public void seCreaListaDeItemsEntradaDelEjemploIntegrador() throws IOException {
//		String contenidoArchivo = "# Titulo 1" + "\n";
//		String archivoEntrada = "ejemploIntegrador.md";
//		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(archivoEntrada);
//		List<ItemEntrada> lista = new LinkedList<ItemEntrada>();
//		lista.add(new Section(""));
//		lista.add(new Titulo("Titulo 1"));
//		Formateador formateadorHTML = new FormateadorHTML();
//		generadorItemsDesdeArchivo = Mockito.mock(GeneradorItemsDesdeArchivo.class);
//		Mockito.when(generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML)).thenReturn(lista);
//		
//		//GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivoPasandoContenido(archivoEntrada,);
//		
//		//generadorItemsDesdeArchivo.(contenidoArchivo);
//		List<ItemEntrada> itemsEntradaEsperada = new LinkedList<ItemEntrada>();
//		itemsEntradaEsperada.add(new Section(""));
//		itemsEntradaEsperada.add(new Titulo("Titulo 1"));
//		// itemsEntradaEsperada.add(new SubTitulo("El Subtitulo"));
//		// itemsEntradaEsperada.add(new Section(""));
//		// itemsEntradaEsperada.add(new Titulo("Solo un titulo"));
//		// itemsEntradaEsperada.add(new Section(""));
//		// itemsEntradaEsperada.add(new TextoPlano("solo texto sin nada mas"));
//		//Formateador formateadorHTML = new FormateadorHTML();
//		String itemEsperado = "";
//		String itemEsperado1 = "Titulo 1";
//
//		// Aca estaria el mock
//		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo
//				.getItemsEntrada(formateadorHTML);
//
//		// for (int i = 0; i < itemsEntradaObtenida.size(); i++) {
//		Assert.assertEquals(itemEsperado, itemsEntradaObtenida.get(0).getTexto());
//		Assert.assertEquals(itemEsperado1, itemsEntradaObtenida.get(1).getTexto());
//	}

//	@Test
//	public void testDeEjemploIntegrador() throws IOException {
//		
//		String primerTextoFormateadoEsperado  = "<section>"
//		 											+ "<h1>El titulo</h1>"
//	 												+ "<h2>El subtitulo</h2>"
//												+ "</section>";
//		
//		String segundoTextoFormateadoEsperado = "<section>" 
//													+ "<h1>Solo un titulo</h1>"
//												+ "</section>";
//		String tercerTextoFormateadoEsperado =  "<section>"
//													+ "solo texto sin nada mas"
//												+ "</section>";
//		String cuartoTextoFormateadoEsperado =  "<section>"
//													+ "<ul>"
//														+ "<li>un item de una lista</li>"
//														+ "<li>otro item de una lista</li>"
//													+ "</ul>"													
//												+ "</section>";
//		
//		//mockear
//		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo("ejemploIntegrador.md");
//		Formateador formateadorHTML = new FormateadorHTML();
//		
//		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML);
//		String primerTextoFormateadoObtenido = itemsEntradaObtenida.get(0).getTextoFormateado(formateadorHTML);
//		String segundoTextoFormateadoObtenido = itemsEntradaObtenida.get(1).getTextoFormateado(formateadorHTML);
//		String terceroTextoFormateadoObtenido = itemsEntradaObtenida.get(2).getTextoFormateado(formateadorHTML);
//		String cuartoTextoFormateadoObtenido = itemsEntradaObtenida.get(3).getTextoFormateado(formateadorHTML);
//		
//		//Assert
//		Assert.assertEquals(primerTextoFormateadoEsperado.trim(), primerTextoFormateadoObtenido.trim());
//		Assert.assertEquals(segundoTextoFormateadoObtenido.trim(), segundoTextoFormateadoEsperado.trim());
//		Assert.assertEquals(terceroTextoFormateadoObtenido.trim(), tercerTextoFormateadoEsperado.trim());
//		Assert.assertEquals(cuartoTextoFormateadoObtenido.trim(), cuartoTextoFormateadoEsperado.trim());
//	}
	
}
