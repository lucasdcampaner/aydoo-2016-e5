package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Program {

	private static String mode;
	private static String archivoEntrada;
	private static String output;

	public static final void main(String args[]) {

		getParametrosAplicacion(args);

		System.out.println(mode);
		System.out.println(archivoEntrada);
		System.out.println(output);
		// TODO DO
		/**
		 * Si mode=default genero la carpeta con el mismo nombre de archivo de
		 * entrada. Si no se especifica mode el mode es default. Si
		 * output=carpeta genero la carpeta con el nombre especificado. Si
		 * mode=no-output imprimi por pantalla.
		 */

	}

	private static void getParametrosAplicacion(String[] args) {

		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		mode = manejadorDeOpciones.getMode();
		archivoEntrada = manejadorDeOpciones.getArchivoEntrada();
		output = manejadorDeOpciones.getOutput();
	}

	protected boolean validarNombreArchivo(String texto) {
		// TODO Auto-generated method stub
		boolean retorno = false;

		try {
			// char [] validos = {'n','a','d','u'};
			List<Character> listaValidos = new ArrayList<Character>();
			listaValidos.add('n');
			listaValidos.add('a');
			listaValidos.add('d');
			listaValidos.add('u');

			String textoMin = texto.toLowerCase();

			char[] partida = textoMin.toCharArray();
			List<Character> listaTexto = new ArrayList<Character>();
			for (char c : partida) {
				listaTexto.add(c);
			}
			if (listaTexto.containsAll(listaValidos))
				retorno = true;
			else
				retorno = false;

		} catch (Exception e) {

		}

		return retorno;
	}

}
