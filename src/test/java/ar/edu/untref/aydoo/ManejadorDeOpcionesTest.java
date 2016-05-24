package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ManejadorDeOpcionesTest {
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoDefault() {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = {modeEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}
	
	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModoNoOutput() {

		String modeEsperado = "--MODE=NO-OUTPUT";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = {modeEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosConOutput() {

		String outputEsperado = "--OUTPUT=PRESENTACION1";
		String archivoEsperado = "MIPRESENTACION.MD";

		String[] args = {outputEsperado, archivoEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String outputObtenido = manejadorDeOpciones.getOutput();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();

		Assert.assertEquals(outputEsperado, outputObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);

	}	

	@Test
	public void obtenerOpcionesDesdeArrayDeArgumentosModeDefaultConOutput() {

		String modeEsperado = "--MODE=DEFAULT";
		String archivoEsperado = "MIPRESENTACION.MD";
		String outputEsperado = "--OUTPUT=PRESENTACION1";

		String[] args = {modeEsperado, archivoEsperado, outputEsperado};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);

		String modeObtenido = manejadorDeOpciones.getMode();
		String archivoObtenido = manejadorDeOpciones.getArchivoEntrada();
		String outputObtenido = manejadorDeOpciones.getOutput();

		Assert.assertEquals(modeEsperado, modeObtenido);
		Assert.assertEquals(archivoEsperado, archivoObtenido);
		Assert.assertEquals(outputEsperado, outputObtenido);

	}
	
	@Test(expected = ManejadorDeOpcionesException.class)
	public void combinacionConOutputYModoNoOutputArrojaExcepcion() throws ManejadorDeOpcionesException {

		String mode = "--MODE=NO-OUTPUT";
		String archivo = "MIPRESENTACION.MD";
		String output = "--OUTPUT=PRESENTACION1";

		String[] args = {mode, archivo, output};
		ManejadorDeOpciones manejadorDeOpciones = new ManejadorDeOpciones(args);
		manejadorDeOpciones.validarCombinacionDeOpciones();
		
	}
	
}
