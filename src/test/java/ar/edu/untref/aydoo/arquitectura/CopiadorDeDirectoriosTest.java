package ar.edu.untref.aydoo.arquitectura;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CopiadorDeDirectoriosTest {
	
	@Test
	public void seCopiaDirectoriosEnLaCarpetaResources() throws IOException {
		
		File pathDesde = new File("src/test/resources/plantilla");
		File pathHasta = new File("src/test/resources/ejemplo");
		
		boolean copioCorrectamente = CopiadorDeDirectorios.copiarDirectorio(pathDesde.toPath(), pathHasta.toPath());
		
		Assert.assertTrue(copioCorrectamente);
	}

}
