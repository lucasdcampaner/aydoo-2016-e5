package ar.edu.untref.aydoo;

public class ManejadorDeOpciones {

	private String mode = "";
	private String archivoEntrada = "";
	private String output = "";

	//TODO
	/**
	 * Ver de tomar parametros sin el prefijo, ejemplo --mode=defaul, solo default.
	 */	
	
	public ManejadorDeOpciones(String[] args) {

		String parametroAEvaluar;

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				parametroAEvaluar = args[i].substring(0, 3).toUpperCase();
				switch (parametroAEvaluar) {
				case "--M":
					this.mode = args[i];
					break;
				case "--O":
					this.output = args[i];
					break;
				default:
					this.archivoEntrada = args[i];
					break;
				}
			}
		}
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

}
