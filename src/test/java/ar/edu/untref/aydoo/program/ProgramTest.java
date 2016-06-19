package ar.edu.untref.aydoo.program;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.Program;

public class ProgramTest {

	@SuppressWarnings("static-access")
	@Test
	public void obtenerParametrosBasicos() throws Exception {
		
		String mode = "--mode=default";
		String modeEsperado = "DEFAULT";
		String archivoEntrada = "mipresentacion1.md";
		String archivoEntradaEsperado = "mipresentacion1.md";
		String args[] = {mode, archivoEntrada};
		Program program = new Program();
		
		program.getParametrosAplicacion(args);
		String modeObtenido = program.getMode();
		String archivoEntradaObtenido = program.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEntradaEsperado, archivoEntradaObtenido);
	}

}
