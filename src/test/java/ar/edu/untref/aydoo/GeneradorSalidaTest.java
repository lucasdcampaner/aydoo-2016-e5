package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeneradorSalidaTest {
	
	@Test
	public void generarStringSalidaParaEjemplo1() throws IOException {
		
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
		//Generador de salida
		String carpetaSalida = "presentacion";
		GeneradorSalida generadorSalida = new GeneradorSalida(carpetaSalida);
		Formateador formateadorHTML = new FormateadorHTML();
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
		
		String salidaPorPantallaObtenida = generadorSalida.generarStringSalida(itemsEntrada, formateadorHTML);
		
		Assert.assertEquals(salidaPorPantallaEsperada, salidaPorPantallaObtenida);
	
	}
}
