package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GeneradorSalida {

	public void copiarArchivosDesdePlantilla(File plantillaOrigen, File carpetaSalida) throws IOException {
		FileUtils.copyDirectory(plantillaOrigen, carpetaSalida);
	}

}
