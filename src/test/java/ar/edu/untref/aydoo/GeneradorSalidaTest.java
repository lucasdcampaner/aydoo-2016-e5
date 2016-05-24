package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GeneradorSalidaTest {

	@Test
	public void generarListaDeSalidaParaSobreEscribirIndexOMostrarPorPantalla() {
		
		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		//Items de entrada
		ItemEntrada section1 = new Section("");
		ItemEntrada titulo1 = new Titulo("El titulo");
		ItemEntrada subtitulo1 = new SubTitulo("El subtitulo");
		section1.agregarElementoEnContenedor(titulo1);
		section1.agregarElementoEnContenedor(subtitulo1);
		ItemEntrada section2 = new Section("");
		ItemEntrada titulo2 = new Titulo("Solo un titulo");
		section2.agregarElementoEnContenedor(titulo2);
		ItemEntrada section3 = new Section("");
		ItemEntrada imagen = new Imagen("imagen.png");
		section3.agregarElementoEnContenedor(imagen);
		itemsEntrada.add(section1);
		itemsEntrada.add(section2);
		itemsEntrada.add(section3);
		//Items de salida
		List<String> itemsSalidaEsperada = new LinkedList<String>();
		itemsSalidaEsperada.add("<section>"
									+ "<h1>El titulo</h1>"
									+ "<h2>El subtitulo</h2>"
								+ "</section>");
		itemsSalidaEsperada.add("<section>"
		 							+ "<h1>Solo un titulo</h1>"
 								+ "</section>");
		itemsSalidaEsperada.add("<section>"
									+ "<img src=\"imagen.png\"/>"
								+ "</section>");

		//Generador de salida
		GeneradorSalida generadorSalida = new GeneradorSalida();
		Formateador formateadorHTML = new FormateadorHTML();
		
		List<String> itemsSalidaObtenida = generadorSalida.generarListaDeStringsSalida(itemsEntrada, formateadorHTML);
		
		for (int i = 0; i < itemsSalidaEsperada.size(); i++) {
			Assert.assertTrue(itemsSalidaEsperada.get(i).equals(itemsSalidaObtenida.get(i)));
		}
		
	}
	
	/**
	 * TODO ver si se puede mockear
	 */	
//	@Test
//	public void copiarArchivosDePlantillaEnCarpetaSalida() throws IOException {
//
//		String carpeta = "target/carpetaParaEjemploIntegrador";
//		String plantilla = "target/plantilla";
//		File carpetaSalida = new File(carpeta);
//		File plantillaOrigen = new File(plantilla);
//
//		GeneradorSalida generadorSalida = new GeneradorSalida();
//
//		generadorSalida.copiarArchivosDesdePlantilla(plantillaOrigen, carpetaSalida);
//	}

}
