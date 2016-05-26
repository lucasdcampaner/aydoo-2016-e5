package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	//precondicion, no recibe espacios
	protected boolean validarNombreArchivo(String texto) {
		boolean retorno = false;

		try {
			List<Character> listaValidos = obtenerListaCaracteresValidos();

			String textoMin = texto.toLowerCase();

			char[] partida = textoMin.toCharArray();
			Set<Character> listaTexto = new HashSet<Character>();
			
			for (char c : partida) {
				listaTexto.add(c);
			}
			if (listaValidos.containsAll(listaTexto))
				retorno = true;
			else
				retorno = false;

		} catch (Exception e) {

		}

		return retorno;
	}

	private List<Character> obtenerListaCaracteresValidos() {
		List<Character> listaValidos = new ArrayList<Character>();
		listaValidos.add('a');
		listaValidos.add('m');
		listaValidos.add('y');
		listaValidos.add('b');
		listaValidos.add('n');
		listaValidos.add('z');
		listaValidos.add('c');
		listaValidos.add('o');
		listaValidos.add('0');
		listaValidos.add('d');
		listaValidos.add('p');
		listaValidos.add('1');
		listaValidos.add('e');
		listaValidos.add('q');
		listaValidos.add('2');
		listaValidos.add('f');
		listaValidos.add('r');
		listaValidos.add('3');
		listaValidos.add('g');
		listaValidos.add('s');
		listaValidos.add('4');
		listaValidos.add('h');
		listaValidos.add('t');
		listaValidos.add('5');
		listaValidos.add('i');
		listaValidos.add('u');
		listaValidos.add('6');
		listaValidos.add('j');
		listaValidos.add('v');
		listaValidos.add('7');
		listaValidos.add('k');
		listaValidos.add('w');
		listaValidos.add('8');
		listaValidos.add('l');
		listaValidos.add('x');
		listaValidos.add('9');
		listaValidos.add('-');
		listaValidos.add('_');
		return listaValidos;
	}

}
