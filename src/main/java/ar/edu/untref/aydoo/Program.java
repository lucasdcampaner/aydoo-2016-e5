package ar.edu.untref.aydoo;

import java.util.List;

public class Program {

	private final static String modeDefault = "DEFAULT";
	private final static String noOutput = "NO-OUTPUT";

	private static String mode;
	private static String archivoEntrada;
	private static String carpetaSalida;

	public static final void main(String args[]) throws Exception {

		getParametrosAplicacion(args);
		Formateador formateadorHTML = new FormateadorHTML();
		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(archivoEntrada);
		List<ItemEntrada> itemsEntrada = generadorItemsDesdeArchivo.getItemsEntrada(formateadorHTML);
		GeneradorSalida generadorSalida = new GeneradorSalida(carpetaSalida);

		switch (mode) {
		case modeDefault:
			generadorSalida.generarSalidaEnCarpeta(itemsEntrada, formateadorHTML);
			break;
		case noOutput:
			System.out.println(generadorSalida.generarStringSalida(itemsEntrada, formateadorHTML));
			break;
		default:
			generadorSalida.generarSalidaEnCarpeta(itemsEntrada, formateadorHTML);
			break;
		}
	}

	private static void getParametrosAplicacion(String[] args) throws Exception {

		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		mode = manejadorDeOpciones.getMode();
		archivoEntrada = manejadorDeOpciones.getArchivoEntrada();
		carpetaSalida = manejadorDeOpciones.getCarpetaSalida();
	}
}
