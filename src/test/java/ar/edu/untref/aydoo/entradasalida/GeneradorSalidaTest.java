package ar.edu.untref.aydoo.entradasalida;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Item;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Titulo;
import ar.edu.untref.aydoo.entradasalida.GeneradorSalida;

public class GeneradorSalidaTest {
	
	@Test
	public void generarStringSalidaParaEjemplo1() throws IOException {
		
		List<Item> itemsEntrada = new LinkedList<Item>();
		//Items de entrada
		Item section1 = new Seccion("");
		Item titulo1 = new Titulo("El titulo");
		Item subtitulo1 = new SubTitulo("El subtitulo");
		section1.agregarElementoEnContenedor(titulo1);
		section1.agregarElementoEnContenedor(subtitulo1);
		Item section2 = new Seccion("");
		Item titulo2 = new Titulo("Solo un titulo");
		section2.agregarElementoEnContenedor(titulo2);
		Item section3 = new Seccion("");
		Item imagen = new Imagen("imagen.png");
		section3.agregarElementoEnContenedor(imagen);
		itemsEntrada.add(section1);
		itemsEntrada.add(section2);
		itemsEntrada.add(section3);
		//Generador de salida
		String carpetaSalida = "ejemplo1";
		GeneradorSalida generadorSalida = new GeneradorSalida(carpetaSalida);
		String salidaPorPantallaEsperada = "<section>"
										 		+ "<h1>El titulo</h1>"
										 		+ "<h2>El subtitulo</h2>"
										 + "</section>"
										 + "<section>"
										 		+ "<h1>Solo un titulo</h1>"
								 		 + "</section>"
								 		 + "<section>"
								 				+ "<img src=\"imagen.png\"/>"
						 				 + "</section>";
		
		String salidaPorPantallaObtenida = generadorSalida.generarStringSalidaHTML(itemsEntrada);
		
		Assert.assertEquals(salidaPorPantallaEsperada, salidaPorPantallaObtenida);	
	}
}
