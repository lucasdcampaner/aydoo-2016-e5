package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManejadorDeOpciones {

	private String mode = "";
	private String archivoEntrada = "";
	private String output = "";

	public ManejadorDeOpciones(String[] args) {

		String parametroAEvaluar;

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				parametroAEvaluar = args[i].substring(0, 3).toUpperCase();
				switch (parametroAEvaluar) {
				case "--M":
					this.mode = args[i].toUpperCase().substring(7, args[i].length());
					break;
				case "--O":
					if (validarNombreArchivo(args[i].substring(9, args[i].length())))
						this.output = args[i].toUpperCase();
					else
						this.output = "Nombre de carpeta con caracter invalido!";
					break;
				default:
					if (validarNombreArchivo(args[i]))
						this.archivoEntrada = args[i];
					else
						this.archivoEntrada = "Nombre de archivo con caracter invalido!";
					break;
				}
			}
		}
	}

	public ManejadorDeOpciones() {

	}

	public void validarCombinacionDeOpciones() throws ManejadorDeOpcionesException {

		if (this.mode == "--MODE=NO-OUTPUT" && this.output != "") {
			throw new ManejadorDeOpcionesException();
		}
	}

	public String getMode() {
		return this.mode;
	}

	public String getArchivoEntrada() {
		return this.archivoEntrada;
	}

	public String getOutput() {
		return this.output;
	}

	// precondicion, no recibe espacios
	protected boolean validarNombreArchivo(String texto) {
		boolean retorno = false;

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
		listaValidos.add('.');
		return listaValidos;
	}

}
