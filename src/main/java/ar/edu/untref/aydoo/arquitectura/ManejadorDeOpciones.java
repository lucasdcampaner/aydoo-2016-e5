package ar.edu.untref.aydoo.arquitectura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.untref.aydoo.excepciones.CaracteresInvalidosEx;
import ar.edu.untref.aydoo.excepciones.CombinacionParametrosEx;
import ar.edu.untref.aydoo.excepciones.ModoEjecucionEx;

public class ManejadorDeOpciones {

	private String mode = "";
	private String archivoEntrada = "";
	private String output = "";

	public ManejadorDeOpciones(String[] args) throws ModoEjecucionEx, CaracteresInvalidosEx, CombinacionParametrosEx {

		String parametroAEvaluar;

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				parametroAEvaluar = args[i].substring(0, 3).toUpperCase();
				switch (parametroAEvaluar) {
				case "--M":
					this.mode = args[i].toUpperCase().substring(7, args[i].length());
					validarMode(this.mode);
					break;
				case "--O":
					this.output = args[i];
					break;
				default:
					this.archivoEntrada = args[i];
					validarNombreArchivo(this.archivoEntrada);
					break;
				}
			}
		}
		validarCombinacionDeOpciones();
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

	public String getCarpetaSalida() throws CaracteresInvalidosEx {

		String carpetaSalida = "";

		if (output.isEmpty()) {
			carpetaSalida = archivoEntrada.substring(0, archivoEntrada.indexOf("."));
		} else {
			carpetaSalida = output.substring(9, output.length());
		}
		validarNombreArchivo(carpetaSalida);
		return carpetaSalida;
	}

	private void validarMode(String mode) throws ModoEjecucionEx {

		if (!mode.isEmpty()) {
			if ((mode.compareTo("DEFAULT") != 0) && (mode.compareTo("NO-OUTPUT") != 0)) {
				throw new ModoEjecucionEx();
			}
		}
	}

	private void validarNombreArchivo(String nombreArchivo) throws CaracteresInvalidosEx {

		List<Character> listaValidos = obtenerListaCaracteresValidos();
		String textoMin = nombreArchivo.toLowerCase();
		char[] partida = textoMin.toCharArray();
		Set<Character> listaTexto = new HashSet<Character>();
		for (char c : partida) {
			listaTexto.add(c);
		}
		if (!listaValidos.containsAll(listaTexto)) {
			throw new CaracteresInvalidosEx();
		}
	}

	private void validarCombinacionDeOpciones() throws CombinacionParametrosEx {

		if ((this.mode.compareTo("NO-OUTPUT") == 0) && (!this.output.isEmpty())) {
			throw new CombinacionParametrosEx();
		}
	}

	private List<Character> obtenerListaCaracteresValidos() {

		List<Character> listaValidos = new ArrayList<Character>();

		for(char letra = 'a'; letra <= 'z'; letra++) {
			listaValidos.add(letra);
			listaValidos.add(Character.toUpperCase(letra));
		}
		
		for(char digito = '0'; digito <= '9'; digito++) {
			listaValidos.add(digito);
		}

		listaValidos.add('-');
		listaValidos.add('_');
		listaValidos.add('.');

		return listaValidos;
	}

}