package ar.edu.untref.aydoo;

import java.util.List;

import ar.edu.untref.aydoo.arquitectura.GeneradorSalida;
import ar.edu.untref.aydoo.arquitectura.LectorDeArchivoDeEntrada;
import ar.edu.untref.aydoo.arquitectura.ManejadorDeOpciones;
import ar.edu.untref.aydoo.constructores.FabricaDeItem;
import ar.edu.untref.aydoo.dominio.Item;

public class Program {

	private final static String modeDefault = "DEFAULT";
	private final static String noOutput = "NO-OUTPUT";

	private static String mode;
	private static String archivoEntrada;
	private static String carpetaSalida;

	public static final void main(String args[]) throws Exception {

		getParametrosAplicacion(args);
		LectorDeArchivoDeEntrada lectorDeArchivoDeEntrada = new LectorDeArchivoDeEntrada(archivoEntrada);
		List<String> itemsLeidos = lectorDeArchivoDeEntrada.getListaItemsLeidos();
		FabricaDeItem fabricaDeItem = new FabricaDeItem();
		List<Item> listaParaSalida = fabricaDeItem.crearItems(itemsLeidos);
		
		GeneradorSalida generadorSalida = new GeneradorSalida(carpetaSalida);

		switch (mode) {
		case modeDefault:
			generadorSalida.generarSalidaEnCarpeta(listaParaSalida);
			break;
		case noOutput:
			System.out.println(generadorSalida.generarStringSalidaHTML(listaParaSalida));
			break;
		default:
			generadorSalida.generarSalidaEnCarpeta(listaParaSalida);
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
