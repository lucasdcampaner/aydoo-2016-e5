package ar.edu.untref.aydoo.entradasalida;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.entradasalida.CopiadorDeDirectorios;

public class CopiadorDeDirectoriosTest {
	
	@Test
	public void seCopiaDirectoriosEnLaCarpetaResources() throws IOException {
		
		File pathDesde = new File("src/test/resources/plantilla");
		File pathHasta = new File("src/test/resources/ejemplo");
		
		boolean copioCorrectamente = CopiadorDeDirectorios.copiarDirectorio(pathDesde.toPath(), pathHasta.toPath());
		
		Assert.assertTrue(copioCorrectamente);
	}

}
