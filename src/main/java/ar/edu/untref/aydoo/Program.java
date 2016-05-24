package ar.edu.untref.aydoo;

public class Program {
	
	private static String mode;
	private static String archivoEntrada;
	private static String output;
	
	public static final void main(String args[]) {

		getParametrosAplicacion(args);
			
		System.out.println(mode);
		System.out.println(archivoEntrada);
		System.out.println(output);
		//TODO DO
		/**
		 * Si mode=default genero la carpeta con el mismo nombre de archivo de entrada.
		 * Si no se especifica mode el mode es default.
		 * Si output=carpeta genero la carpeta con el nombre especificado.
		 * Si mode=no-output imprimi por pantalla.
		 */
		
	}

	private static void getParametrosAplicacion(String[] args) {
		
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);	
		mode = manejadorDeOpciones.getMode();
		archivoEntrada = manejadorDeOpciones.getArchivoEntrada();
		output = manejadorDeOpciones.getOutput();
	}


}
