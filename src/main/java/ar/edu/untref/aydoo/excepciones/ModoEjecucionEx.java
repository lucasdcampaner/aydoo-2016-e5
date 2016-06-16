package ar.edu.untref.aydoo.excepciones;

public class ModoEjecucionEx extends Exception {

	private static final long serialVersionUID = 1L;

	private final static String mensaje = "No existe el mode ingresado.";

	public ModoEjecucionEx() {
		super(mensaje);
	}

}
