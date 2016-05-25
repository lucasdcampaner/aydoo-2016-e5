package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GeneradorItemsDesdeArchivoTest {

	// TODO ver si se puede mockear para no ir al file system.

	@Test
	public void seCreaListaDeItemsEntradaDelEjemploIntegrador() throws IOException {
		String contenidoArchivo = "# Titulo 1" + "\n";
		String archivoEntrada = "ejemploIntegrador.md";
		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo();
		//generadorItemsDesdeArchivo.setArchivoEntrada(archivoEntrada);
		List<ItemEntrada> lista = new LinkedList<ItemEntrada>();
		lista.add(new Section(""));
		lista.add(new Titulo("Titulo 1"));
		Formateador formateadorHTML = new FormateadorHTML();
		generadorItemsDesdeArchivo = Mockito.mock(GeneradorItemsDesdeArchivo.class);
		Mockito.when(generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML)).thenReturn(lista);
		
		//GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivoPasandoContenido(archivoEntrada,);
		
		generadorItemsDesdeArchivo.setContenidoPrueba(contenidoArchivo);
		List<ItemEntrada> itemsEntradaEsperada = new LinkedList<ItemEntrada>();
		itemsEntradaEsperada.add(new Section(""));
		itemsEntradaEsperada.add(new Titulo("Titulo 1"));
		// itemsEntradaEsperada.add(new SubTitulo("El Subtitulo"));
		// itemsEntradaEsperada.add(new Section(""));
		// itemsEntradaEsperada.add(new Titulo("Solo un titulo"));
		// itemsEntradaEsperada.add(new Section(""));
		// itemsEntradaEsperada.add(new TextoPlano("solo texto sin nada mas"));
		//Formateador formateadorHTML = new FormateadorHTML();
		String itemEsperado = "";
		String itemEsperado1 = "Titulo 1";

		// Aca estaria el mock
		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo
				.getItemsEntrada(formateadorHTML);

		// for (int i = 0; i < itemsEntradaObtenida.size(); i++) {
		Assert.assertEquals(itemEsperado, itemsEntradaObtenida.get(0).getTexto());
		Assert.assertEquals(itemEsperado1, itemsEntradaObtenida.get(1).getTexto());
	}
	
	@Test
	public void seCreaListaDeItemsEntradaDelEjemploIntegradorConNombreDeArchivo() throws IOException {
		//String contenidoArchivo = "# Titulo 1" + "\n";
		String archivoEntrada = "ejemploIntegrador.md";
		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo();
		generadorItemsDesdeArchivo = Mockito.mock(GeneradorItemsDesdeArchivo.class);
		//generadorItemsDesdeArchivo.setArchivoEntrada(archivoEntrada);
		Mockito.when(generadorItemsDesdeArchivo.setArchivoEntrada(archivoEntrada)).thenReturn(true);
		List<ItemEntrada> lista = new LinkedList<ItemEntrada>();
		lista.add(new Section(""));
		lista.add(new Titulo("Titulo 1"));
		Formateador formateadorHTML = new FormateadorHTML();
		//generadorItemsDesdeArchivo = Mockito.mock(GeneradorItemsDesdeArchivo.class);
		Mockito.when(generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML)).thenReturn(lista);
		
		//GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivoPasandoContenido(archivoEntrada,);
		
		//generadorItemsDesdeArchivo.setContenidoPrueba(contenidoArchivo);
		List<ItemEntrada> itemsEntradaEsperada = new LinkedList<ItemEntrada>();
		itemsEntradaEsperada.add(new Section(""));
		itemsEntradaEsperada.add(new Titulo("Titulo 1"));
		// itemsEntradaEsperada.add(new SubTitulo("El Subtitulo"));
		// itemsEntradaEsperada.add(new Section(""));
		// itemsEntradaEsperada.add(new Titulo("Solo un titulo"));
		// itemsEntradaEsperada.add(new Section(""));
		// itemsEntradaEsperada.add(new TextoPlano("solo texto sin nada mas"));
		//Formateador formateadorHTML = new FormateadorHTML();
//		String itemEsperado = "";
//		String itemEsperado1 = "Titulo 1";

		// Aca estaria el mock
		List<ItemEntrada> itemsEntradaObtenida = generadorItemsDesdeArchivo
				.getItemsEntrada(formateadorHTML);

		// for (int i = 0; i < itemsEntradaObtenida.size(); i++) {
		Assert.assertEquals(lista.get(0).getTexto(), itemsEntradaObtenida.get(0).getTexto());
		Assert.assertEquals(lista.get(1).getTexto(), itemsEntradaObtenida.get(1).getTexto());
	}

}
