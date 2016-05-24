package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GeneradorSalidaTest {

	@Test
	public void generarListaDeSalidaParaSobreEscribirIndexOMostrarPorPantalla() {
		
		//Items de entrada
		List<ItemEntrada> itemsEntrada = new LinkedList<ItemEntrada>();
		itemsEntrada.add(new Section(""));
		itemsEntrada.add(new Titulo("El titulo"));
		itemsEntrada.add(new SubTitulo("El subtitulo"));
		itemsEntrada.add(new Section(""));
		itemsEntrada.add(new Titulo("Solo un titulo"));
		itemsEntrada.add(new Section(""));
		itemsEntrada.add(new TextoPlano("solo texto sin nada mas"));
		//Items de salida
		List<String> itemsSalidaEsperada = new LinkedList<String>();
		itemsSalidaEsperada.add("<section>");
		itemsSalidaEsperada.add("<h1>El titulo</h1>");
		itemsSalidaEsperada.add("<h2>El subtitulo</h2>");
		itemsSalidaEsperada.add("</section>");
		itemsSalidaEsperada.add("<section>");
		itemsSalidaEsperada.add("<h1>Solo un titulo</h1>");
		itemsSalidaEsperada.add("</section>");
		itemsSalidaEsperada.add("<section>");
		itemsSalidaEsperada.add("solo texto sin nada más");
		itemsSalidaEsperada.add("</section>");
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
