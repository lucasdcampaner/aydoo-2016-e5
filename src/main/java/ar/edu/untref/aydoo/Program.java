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
		GeneradorItemsDesdeArchivo generadorItemsDesdeArchivo = new GeneradorItemsDesdeArchivo(archivoEntrada);
		List<Item> itemsEntrada = generadorItemsDesdeArchivo.getItemsEntrada();
		GeneradorSalida generadorSalida = new GeneradorSalida(carpetaSalida);

		switch (mode) {
		case modeDefault:
			generadorSalida.generarSalidaEnCarpeta(itemsEntrada);
			break;
		case noOutput:
			System.out.println(generadorSalida.generarStringSalidaHTML(itemsEntrada));
			break;
		default:
			generadorSalida.generarSalidaEnCarpeta(itemsEntrada);
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
