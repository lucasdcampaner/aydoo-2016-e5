package ar.edu.untref.aydoo;

public class ManejadorDeOpciones {

	private String mode = "";
	private String archivoEntrada = "";

	public ManejadorDeOpciones(String[] args) {

		String parametroAEvaluar;

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				parametroAEvaluar = args[i].substring(0, 3).toUpperCase();
				switch (parametroAEvaluar) {
				case "--M":
					this.mode = args[i];
					break;
				default:
					this.archivoEntrada = args[i]; 
					break;
				}
			}
		}
	}

	public String getMode() {
		return this.mode;
	}

	public String getArchivoEntrada() {
		return this.archivoEntrada;
	}

}
